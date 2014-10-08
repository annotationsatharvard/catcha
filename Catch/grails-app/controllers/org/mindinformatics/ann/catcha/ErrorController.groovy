package org.mindinformatics.ann.catcha

import grails.converters.JSON

class ErrorController {

    def badRequest() {
        render([error: [code: 400, message: "Bad request"]] as JSON)
    }

    def unauthorized() {
        render([error: [code: 401, message: "Unauthorized user"]] as JSON)
    }

    def forbidden() {
        render([error: [code: 403, message: "Forbidden"]] as JSON)
    }

    def notFound() {
        //def result = [success:false, message: "Page not found" ]
        //render result as GSON
        render([error: [code: 404, message: "Resource not found"]] as JSON)
    }

    def methodNotAllowed() {
        render([error: [code: 405, message: "Method not allowed", method: request.method]] as JSON)
    }

    def serverError() {
        log.warn("Uncaught exception: " + request?.exception?.message, request?.exception);
        render([error: [code: 500, message: request?.exception?.message, exception: request?.exception?.cause?.class?.name]] as JSON)
    }

    def serviceUnavailable() {
        render([error: [code: 503, message: "Service unavailable"]] as JSON)
    }


}