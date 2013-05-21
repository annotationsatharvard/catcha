<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
<meta name="layout" content="example-layout" />
<title>Sign up :: ${grailsApplication.config.af.shared.title}</title>
</head>
<body>
	<g:render template="/public/navigation" /> 
	<div class="wrapper col2">
  <div id="featured_slide" >
   <div class="slider" style="border-top: 0px solid #DC143C;padding-top: 10px;" align="center">
   
   <g:render template="/public/signupForm" plugin="af-security"/>      
   
   </div>
   </div>
   </div> 
	<g:render template="/shared/signupTerms" /> 
	<g:render template="/shared/footer" plugin="af-shared" /> 
	<g:render template="/shared/copyright" plugin="af-shared"  /> 
</body>
</html>
