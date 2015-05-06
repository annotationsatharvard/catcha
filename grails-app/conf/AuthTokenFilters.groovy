import com.nimbusds.jose.JWSObject
import org.mindinformatics.ann.framework.module.security.systems.SystemApi

import java.text.ParseException

class AuthTokenFilters {

    def authTokenService

    def filters = {


        annotator(controller: 'annotator', action: '*') {
            before = {

                // Always allow requests for token to pass through since the alternative
                // means that you would need to have a token to generate a token
                if (actionName == "token" || actionName == "index") {
                    return true
                }

                def token = request.getHeader("x-annotator-auth-token")
                if (!token) {
                    response.status = 401
                    render ("You are not authorized to access annotations without a valid token. Please include an 'x-annotator-auth-token' request header. See AnnotatorJs documentation for more details (http://docs.annotatorjs.org/en/latest/authentication.html).")
                    return false
                }
                else {
                    try {
                        return authTokenService.validateAuthToken(token)

                    } catch (IllegalArgumentException e) {
                        response.status = 401
                        render ("You are not authorized to access annotations: " + e.message)
                        return false
                    }
                    catch (ParseException e){
                        println("Error parsing JSON web token ${token}: " + e.message)
                        log.error("Error parsing JSON web token ${token}: " + e.message, e)
                        //throw new Exception("Error parsing JSON web token: " + e.message)
                        response.status = 401
                        render ("Error parsing JSON web token ${token}: " + e.message)
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
                        //render ("You are not authorized to access annotations without a valid token.  Could not parse token " + token + " due to error: " + e.message + ".")
                        return false
                    }
                    catch (Exception e) {
                        println("An uncaught exception occurred while parsing JSON web token ${token}: " + e.message)
                        log.error("An uncaught exception occurred while parsing JSON web token ${token}: " + e.message, e)
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
