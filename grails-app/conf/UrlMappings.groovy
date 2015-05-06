class UrlMappings {

	static mappings = {
		"/info"  (view:'/info')
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/api/$action/$id?"{
            controller = 'annotator'
        }

		"/login/auth" {
			controller = 'openId'
			action = 'auth'
		 }
		 "/login/openIdCreateAccount" {
			controller = 'openId'
			action = 'createAccount'
		 }
		 "/" {
			 controller = 'main'
			 action = 'index'
		 }

        // Error URL Mappings
        "401"(controller: 'error', action: 'unauthorized')
        "403"(controller: 'error', action: 'forbidden')
        "404"(controller: 'error', action: 'notFound')
        "405"(controller: 'error', action: 'methodNotAllowed')
        "500"(controller: 'error', action: 'serverError')
        //"500"(view:'/error')

    }
}
