package org.mindinformatics.ann.catcha

class MainController {

	def index = {
		render (view: "/public/home")
	}
	
	def signup = {
		println 'signup'
		render (view: "/public/signup")
	}
}
