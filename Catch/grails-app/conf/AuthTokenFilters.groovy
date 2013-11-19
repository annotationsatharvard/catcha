import com.nimbusds.jose.JWSObject
import org.mindinformatics.ann.framework.module.security.systems.SystemApi

import java.text.ParseException

class AuthTokenFilters {

    def filters = {
        all(controller: 'annotator', action: '*') {
            before = {
                println "controller: " + controllerName + ", action: " + actionName
                request.headerNames.each {
                    println "HEADER " + it
                }
                def token = request.getHeader("x-annotator-auth-token")
                if (!token) {
                    response.status = 401
                    render ("You are not authorized to access annotations without a valid token")
                    return false
                }
                else {
                    try {

                        //header: {"alg":"HS256","cty":"text\/plain","typ":"JWS"}
                        //payload: {"consumerKey":"openannotation","issuedAt":"2013-08-31T06:34:42-0400","userId":"jmiranda","jti":"0f4ce532-dbb3-4715-8601-d3fc34d9b460","ttl":86400,"iat":1377988482}

                        JWSObject jwsObject = JWSObject.parse(token)
                        println "header: " + jwsObject.header
                        println "payload: " + jwsObject.payload
                        println "state: " + jwsObject.state
                        println "signature: " + jwsObject.signature

                        // 1. Make sure an API exists with this name
                        def consumerKey = jwsObject.payload.toJSONObject().consumerKey
                        println "consumerKey: " + consumerKey
                        def systemApi = SystemApi.findByApikey(consumerKey)
                        if (!systemApi) {
                            //throw new Exception("There's no consumer registered with consumerKey: " + consumerKey)
                            response.status = 401
                            render ("You are not authorized to access annotations without a valid consumer key " + consumerKey)
                            return false
                        }

                        // 2. Make sure the user is valid

                        // 3. Make sure there's an issue time and that the token has not expired
                        //def now = new Date()


                    } catch (ParseException e ){
                        //throw new Exception("Error parsing JSON web token: " + e.message)
                        response.status = 401
                        render ("You are not authorized to access annotations without a valid token.  Could not parse token " + token + ": " + e.message + ".")
                        return false

                    }
                }


            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
