class ApiLoggingFilters {

    def filters = {
        all(controller:'api', action:'*') {
            before = {
                log.info controllerName + "." + actionName + ": " + params
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
