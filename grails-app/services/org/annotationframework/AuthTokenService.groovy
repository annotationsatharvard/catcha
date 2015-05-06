package org.annotationframework

import com.nimbusds.jose.JOSEException
import com.nimbusds.jose.JOSEObjectType
import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.JWSHeader
import com.nimbusds.jose.JWSObject
import com.nimbusds.jose.JWSSigner
import com.nimbusds.jose.JWSVerifier
import com.nimbusds.jose.Payload
import com.nimbusds.jose.crypto.MACSigner
import com.nimbusds.jose.crypto.MACVerifier
import com.nimbusds.jwt.JWTClaimsSet
import org.apache.commons.lang.math.NumberUtils
import org.mindinformatics.ann.framework.module.security.systems.SystemApi

import java.text.ParseException
import java.text.SimpleDateFormat

class AuthTokenService {


    static simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ")

    def generateAuthToken(String consumerKey, String userId, Date issuedAt, Integer ttl) {

        // Given a user instance
        // Compose the JWT claims set
        JWTClaimsSet jwtClaims = new JWTClaimsSet();
        jwtClaims.setIssueTime(issuedAt);
        jwtClaims.setJWTID(UUID.randomUUID().toString());
        jwtClaims.setCustomClaim("userId", userId);
        jwtClaims.setCustomClaim("consumerKey", consumerKey);
        jwtClaims.setCustomClaim("issuedAt", issuedAt.format("yyyy-MM-dd'T'hh:mm:ssZ")); // e.g. 2013-08-30T22:23:30+00:00
        jwtClaims.setCustomClaim("ttl", ttl);
        // jwtClaims.setCustomClaim("email", user.email);

        // Create JWS header with HS256 algorithm
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        header.setContentType("text/plain");
        header.setType(JOSEObjectType.JWS)

        // Used to debug issue with commons-codec library
        //System.out.println(Base64.class.getProtectionDomain().getCodeSource().getLocation());

        // Create JWS object
        JWSObject jwsObject = new JWSObject(header, new Payload(jwtClaims.toJSONObject()));

        SystemApi systemApi = SystemApi.findByApikey(consumerKey)
        if (!systemApi?.secretKey) {
            throw new IllegalArgumentException("System API must have a valid secret key in order to sign token. Please email your system admistrator to retrieve your secret key.");
        }

        try {
            // Create HMAC signer
            String secretKey = systemApi?.secretKey?:systemApi?.apikey
            JWSSigner signer = new MACSigner(secretKey?.getBytes());
            jwsObject.sign(signer);
        } catch (JOSEException e) {
            println("Error signing JWT: " + e.getMessage());
            throw new IllegalArgumentException("Unable to sign token due to error: " + e.message, e);
        }

        // Serialise to JWT compact form
        return jwsObject.serialize();

    }


    def validateAuthToken(String token) {
        return validateAuthToken(token, true)
    }

    def validateAuthToken(String token, boolean verify) {

        JWSObject jwsObject
        // Annotator token format
        //header: {"alg":"HS256","cty":"text\/plain","typ":"JWS"}
        //payload: {"consumerKey":"openannotation","issuedAt":"2013-08-31T06:34:42-0400","userId":"jmiranda","jti":"0f4ce532-dbb3-4715-8601-d3fc34d9b460","ttl":86400,"iat":1377988482}
        //payload: {"iat": 1396290995, "d": {"issuedAt": "2014-03-31T14:36:35.017866-4:00", "consumerKey": "cbdf435b-a609-4126-b58a-589c40075075", "userId": "", "ttl": 86400}, "v": 0}

        try {

            jwsObject = JWSObject.parse(token)
            println "header: " + jwsObject.header
            println "payload: " + jwsObject.payload
            println "state: " + jwsObject.state
            println "signature: " + jwsObject.signature
        }
        catch (ParseException e){
            log.error("Error parsing JSON web token ${token}: " + e.message, e)
            throw e;
        }
        catch (NoSuchMethodError e) {
            log.error("No such method error while parsing JSON web token ${token}: " + e.message, e)
            throw e;
        }
        catch (RuntimeException e) {
            log.error("Fatal runtime error while parsing JSON web token ${token}: " + e.message, e)
            throw e;
        }

        // Make sure a system API exists for this consumer key
        def payload = jwsObject.payload.toJSONObject()
        def consumerKey = payload?.consumerKey?:payload?.d?.consumerKey

        println "consumerKey: " + consumerKey
        println "issuedAt: " + payload?.issuedAt
        println "ttl: " + payload?.ttl

        log.info "Checking to see if API key ${consumerKey} exists?"
        SystemApi systemApi = SystemApi.findByApikey(consumerKey)
        if (!systemApi) {
            log.info("System API key ${consumerKey} does not exist")
            //throw new Exception("There's no consumer registered with consumerKey: " + consumerKey)
            log.error("Unable to find registered system with consumer key " + consumerKey)
            throw new IllegalArgumentException("Unable to locate a registered consumer with API key '" + consumerKey + "'." );
        }
        else {
            log.info("System API key ${consumerKey} exists")
        }

        if (!systemApi.enabled) {
            throw new IllegalArgumentException("System API with key " + consumerKey + " is currently disabled.");
        }

        // Make sure the user is valid
        // We have no way to authorize/authenticate the user so we'll just ignore this for now.

        // Make sure there's an issue time and that the token has not expired
        // Should implement this validation, but it's not really critical at the moment
        log.info "Validating token ${token}"
        if (verify) {
            try {
                Date now = new Date();
                Integer ttl = payload?.ttl ?: 86400;
                if (!payload?.issuedAt) {
                    throw new IllegalArgumentException("Payload is missing valid 'issuedAt' claim. See annotatorjs docs for more details (http://docs.annotatorjs.org/en/latest/authentication.html).")
                }
                //Date issuedAt = Date.parse(payload?.issuedAt, "yyyy-MM-dd'T'hh:mm:ssZ")
                Date issuedAt = simpleDateFormat.parse(payload?.issuedAt)
                use(groovy.time.TimeCategory) {
                    Date expiryDate = issuedAt + ttl.seconds
                    if (issuedAt.after(now)) {
                        throw new IllegalArgumentException("Token is not valid yet")
                    }
                    if (expiryDate.before(now)) {
                        throw new IllegalArgumentException("Token expired on " + expiryDate)
                    }
                }

            } catch (ParseException e) {
                throw new IllegalArgumentException("Error occurred while parsing 'issuedAt' claim. See annotatorjs docs for more details (http://docs.annotatorjs.org/en/latest/authentication.html).")
            }
        }

        // Verify signature
        log.info "Verifying token signature"
        try {

            JWSVerifier verifier = new MACVerifier(systemApi?.secretKey?.getBytes());
            log.info ("jwsObject.verify(): " + jwsObject.verify(verifier))

            return jwsObject.verify(verifier);
        } catch (JOSEException e) {
            log.error("Unable to verify signature: " + e.getMessage(), e);
            throw new IllegalArgumentException("Unable to verify signature for API key " + consumerKey + ":" + e.message, e);
        }

        return false;

    }
}
