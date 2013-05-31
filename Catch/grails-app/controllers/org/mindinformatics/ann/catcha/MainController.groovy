package org.mindinformatics.ann.catcha

class MainController {

	def index = {
		render (view: "/public/home", model:['menuitem':'home'])
	}
	def signup = {
		render (view: "/public/signup", model:['menuitem':'signup'])
	}
	def node = {
		render (view: "/public/node", model:['menuitem':'node'])
	}
	def credits = {
		render (view: "/public/credits", model:['menuitem':'credits'])
	}
}
