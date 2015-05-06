<div class="wrapper col1">
  	<div id="header">
    	<div class="fl_left bg_white" align="center">
     		<g:render template="/shared/logo" />
    	</div>
		<!-- Begin top navigation menu -->
		<div class="menu_nav">
		    <ul>
		    	<g:if test="${menuitem=='home'}"><li class="active"><g:link controller="main" action="index"><span>Home</span></g:link></li></g:if>
		    	<g:else><li><g:link controller="main" action="index"><span>Home</span></g:link></li></g:else>
		        <g:if test="${menuitem=='access'}"><li class="active"><g:link controller="secure" action="home"><span>Access</span></g:link></li></g:if>
		        <g:else><li><g:link controller="secure" action="home"><span>Access</span></g:link></li></g:else>
		        <g:if test="${menuitem=='signup'}"><li class="active"><g:link controller="openid" action="auth"><span>Sign Up</span></g:link></li></g:if>
		        <g:else><li><g:link controller="main" action="signup"><span>Sign Up</span></g:link></li></g:else>
		        <g:if test="${menuitem=='node'}"><li class="active"><g:link controller="public" action="node"><span>Node</span></g:link></li></g:if>
		        <g:else><li><g:link controller="main" action="node"><span>Node</span></g:link></li></g:else>
		        <g:if test="${menuitem=='credits'}"><li class="active"><g:link controller="public" action="credits"><span>Credits</span></g:link></li></g:if>
		        <g:else><li><g:link controller="main" action="credits"><span>Credits</span></g:link></li></g:else>
		    </ul>
		</div>
		<!-- End top navigation menu -->
		<br class="clear" />
  	</div>
</div>