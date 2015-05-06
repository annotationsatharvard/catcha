<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
<meta name="layout" content="public-layout-wide" />
<title>Home :: ${grailsApplication.config.af.shared.title}</title>
</head>
<body>
	<sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MANAGER">
		<g:render template="/shared/administration" plugin="af-security" /> 
		<g:render template="/secure/navigation" /> 
	</sec:ifAnyGranted>
	<sec:ifNotLoggedIn>
		<g:render template="/public/navigation" /> 
	</sec:ifNotLoggedIn>
	<sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MANAGER">
	</sec:ifAnyGranted>
	<sec:ifNotLoggedIn>
		<g:render template="/shared/banner" /> 
	</sec:ifNotLoggedIn>
	<g:render template="/shared/content" /> 
	<g:render template="/shared/footer" plugin="af-shared" /> 
	<g:render template="/shared/copyright" plugin="af-shared"  /> 
</body>
</html>
