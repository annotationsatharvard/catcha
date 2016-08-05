package org.annotationframework

import grails.buildtestdata.mixin.Build
import grails.test.mixin.*
import org.junit.*
import org.mindinformatics.ann.framework.module.security.systems.SystemApi

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AuthTokenService)
@Build([SystemApi])
@Mock([SystemApi])
class AuthTokenServiceTests {


    @Test
    void generateToken_shouldGenerateAndVerifyToken() {
        SystemApi.build(name: "openannotation", apikey: "0cbfa370-b73c-4e3a-ae46-582df284b7c3", secretKey: "{shared key}", enabled:true)
        def actualToken = service.generateAuthToken("0cbfa370-b73c-4e3a-ae46-582df284b7c3", "jmiranda", new Date(), 86400)
        assertTrue service.validateAuthToken(actualToken)
    }

    @Test
    void validateAuthToken() {
        //assertTrue service.validateAuthToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEyMzQ1Njc4OTAsIm5hbWUiOiJKb2huIERvZSIsImFkbWluIjp0cnVlfQ.eoaDVGTClRdfxUZXiPs3f8FmJDkDE_VCQFXqKxpLsts")
        SystemApi.build(apikey: "0cbfa370-b73c-4e3a-ae46-582df284b7c3", secretKey: "{shared key}", enabled:true)
        assertTrue service.validateAuthToken("eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjBjYmZhMzcwLWI3M2MtNGUzYS1hZTQ2LTU4MmRmMjg0YjdjMyIsImlzc3VlZEF0IjoiMjAxNC0wOC0yOFQwMzoyNToyOC0wNDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiI5ZWVkNjdhZC04ZmExLTRiYTItOWExOS1jOGY3YTBhZDUzNTAiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MDkyNTM5Mjh9.LOoRN_xJeV4QEL22puG3eA65wX5qsTHmb_a7RKnmJEA", false)
    }

    @Test
    void generateAuthToken() {
        SystemApi.build(apikey: "consumer-key", secretKey: "super-secret-key-shh" , enabled: true)
        String authToken = service.generateAuthToken("consumer-key", "user-id", new Date(), 86400)
        println "authToken: " + authToken
        assertTrue service.validateAuthToken(authToken)
    }

    @Test
    void generateAuthToken_defaultSecretKey() {
        SystemApi.build(apikey: "consumer-key", secretKey: "consumer-key", enabled: true )
        String authToken = service.generateAuthToken("consumer-key", "user-id", new Date(), 86400)
        println "authToken: " + authToken
        assertTrue service.validateAuthToken(authToken)
    }

    @Test
    void generateAuthToken_emptySecretKey() {
        SystemApi.build(apikey: "consumer-key", secretKey: "", enabled: true )
        shouldFail(IllegalArgumentException) {
            service.generateAuthToken("consumer-key", "user-id", new Date(), 86400)
        }
    }

    @Test
    void generateAuthToken_nullSecretKey() {
        SystemApi.build(apikey: "consumer-key", secretKey: null, enabled: true)
        shouldFail(IllegalArgumentException) {
            service.generateAuthToken("consumer-key", "user-id", new Date(), 86400)
        }
    }

    @Ignore // disabled feature
    void generateAuthToken_shouldFailWithExpiryError() {
        SystemApi.build(apikey: "consumer-key", secretKey: "super-secret-key-shh", enabled: true )
        String authToken = service.generateAuthToken("consumer-key", "user-id", new Date()-2, 86400)
        println "authToken: " + authToken
        def message = shouldFail(IllegalArgumentException) {
            service.validateAuthToken(authToken)
        }
        println message
        assert message.startsWith("Token expired on ")
    }

    @Ignore // disabled feature
    void generateAuthToken_shouldFailWithIssuedAtError() {
        SystemApi.build(apikey: "consumer-key", secretKey: "super-secret-key-shh", enabled: true)
        String authToken = service.generateAuthToken("consumer-key", "user-id", new Date()+1, 86400)
        println "authToken: " + authToken
        def message = shouldFail(IllegalArgumentException) {
            service.validateAuthToken(authToken)
        }
        println message
        assertEquals "Token is not valid yet", message
    }

}
