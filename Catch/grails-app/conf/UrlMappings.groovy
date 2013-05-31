class UrlMappings {

	static mappings = {
		"/info"  (view:'/index')
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
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
		"500"(view:'/error')
	}
}
