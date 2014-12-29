import com.nimbusds.jose.JWSObject
import org.mindinformatics.ann.framework.module.security.systems.SystemApi

import java.text.ParseException

class AuthTokenFilters {

    def filters = {

        annotator(controller: 'annotator', action: '*') {
            before = {

                // Always allow requests for token to pass through since the alternative
                // means that you would need to have a token to generate a token
                if (actionName == "token") {
                    return true
                }

                def token = request.getHeader("x-annotator-auth-token")
                if (!token) {
                    response.status = 401
                    render ("You are not authorized to access annotations without a valid token")
                    return false
                }
                else {
                    try {

                        // Annotator token format
                        //header: {"alg":"HS256","cty":"text\/plain","typ":"JWS"}
                        //payload: {"consumerKey":"openannotation","issuedAt":"2013-08-31T06:34:42-0400","userId":"jmiranda","jti":"0f4ce532-dbb3-4715-8601-d3fc34d9b460","ttl":86400,"iat":1377988482}

                        //
                        //payload: {"iat": 1396290995, "d": {"issuedAt": "2014-03-31T14:36:35.017866-4:00", "consumerKey": "cbdf435b-a609-4126-b58a-589c40075075", "userId": "", "ttl": 86400}, "v": 0}

                        JWSObject jwsObject = JWSObject.parse(token)
                        println "header: " + jwsObject.header
                        println "payload: " + jwsObject.payload
                        println "state: " + jwsObject.state
                        println "signature: " + jwsObject.signature

                        // 1. Make sure an API exists with this name
                        def payload = jwsObject.payload.toJSONObject()
                        def consumerKey = payload?.consumerKey?:payload?.d?.consumerKey
                        println "consumerKey: " + consumerKey
                        def systemApi = SystemApi.findByApikey(consumerKey)
                        if (!systemApi) {
                            //throw new Exception("There's no consumer registered with consumerKey: " + consumerKey)
                            response.status = 401
                            render ("You are not authorized to access annotations without a valid consumer key " + consumerKey)
                            return false
                        }

                        // 2. Make sure the user is valid
                        // We have no way to authorize/authenticate the user so we'll just ignore this for now.

                        // 3. Make sure there's an issue time and that the token has not expired
                        // Should implement this validation, but it's not really critical at the moment

                    }
                    catch (ParseException e){
                        println("Error parsing JSON web token ${token}: " + e.message)
                        log.error("Error parsing JSON web token ${token}: " + e.message, e)
                        //throw new Exception("Error parsing JSON web token: " + e.message)
                        //response.status = 401
                        //render ("You are not authorized to access annotations without a valid token.  Could not parse token " + token + " due to error: " + e.message + ".")
                        response.status = 401
                        return false
                    }
                    catch (NoSuchMethodError e) {
                        println("No such method error while parsing JSON web token ${token}: " + e.message)
                        log.error("No such method error while parsing JSON web token ${token}: " + e.message, e)
                        response.status = 401
                        return false
                    }
                    catch (RuntimeException e) {
                        println("Fatal runtime error while parsing JSON web token ${token}: " + e.message)
                        log.error("Fatal runtime error while parsing JSON web token ${token}: " + e.message, e)
                        response.status = 401
                        //throw new Exception("Error parsing JSON web token: " + e.message)
                        //response.status = 401
                        //render ("You are not authorized to access annotations without a valid token.  Could not parse token " + token + " due to error: " + e.message + ".")
                        return false
                    }
                }
                return true
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
