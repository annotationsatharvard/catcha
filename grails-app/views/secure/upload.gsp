<!doctype html>
<%@ page import="org.mindinformatics.ann.framework.module.security.users.User" %>
<%@ page import="org.mindinformatics.ann.framework.module.security.users.UserRole" %>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
<meta name="layout" content="public-layout-wide" />
<title>Upload :: ${grailsApplication.config.af.shared.title}</title>
<style>
.bar {
    height: 18px;
    background: green;
}
</style>
</head>
<body>
	<g:render template="/shared/administration" plugin="af-security" /> 
	<g:render template="/secure/navigation" /> 
	<g:render template="/secure/upload-banner" /> 
	<g:render template="/uploads/upload-content"  plugin="af-persistence"/> 
	<g:render template="/shared/copyright" plugin="af-shared" /> 
</body>
</html>
