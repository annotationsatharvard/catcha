<div class="wrapper col1">
  <div id="header">
    <div class="fl_left bg_white" align="center">
     <g:render template="/shared/logo" />
      <div id="search">
      	<!--
        <form action="#" method="post">
          <fieldset>
            <legend>Site Search</legend>
            <input type="text" value="Search the site&hellip;"  onfocus="this.value=(this.value=='Search the site&hellip;')? '' : this.value ;" />
            <input type="submit" name="go" id="go" value="GO" />
          </fieldset>
        </form>
        -->
      </div>
    </div>
	<!-- Begin top navigation menu -->
	<div class="menu_nav">
	    <ul>
	        <li><g:link controller="main" action="index"><span>Home</span></g:link></li>
	        <%-- Search --%> 
	        <%--
	        <li><g:link controller="public" action="search"><span>Search</span></g:link></li>
	         --%>
	        <%-- Signup --%> 
	        <g:if test="${menuitem=='signup'}"><li class="active"><g:link controller="openid" action="auth"><span>Search</span></g:link></li></g:if>
	        <g:else><li><g:link controller="public" action="signup"><span>Search</span></g:link></li></g:else>
	        <%-- Node info --%> 
	        <g:if test="${menuitem=='nodeinfo'}"><li class="active"><g:link controller="public" action="nodeinfo"><span>Browse</span></g:link></li></g:if>
	        <g:else><li><g:link controller="public" action="nodeinfo"><span>Browse</span></g:link></li></g:else>
	        <%-- Credits --%> 
	        <g:if test="${menuitem=='credits'}"><li class="active"><g:link controller="public" action="credits"><span>Node</span></g:link></li></g:if>
	        <g:else><li><g:link controller="public" action="credits"><span>Node</span></g:link></li></g:else>
	        <li><g:link controller="logout" action="index"><img id="groupsSpinner" src="${resource(dir:'images/secure',file:'exit.png',plugin:'users-module')}" title="Logout" /></g:link></li>
	    </ul>
	</div>
	<!-- End top navigation menu -->
	<br class="clear" />
  </div>
</div>

<%-- 
<g:if test="${menuitem=='openid'}"><li class="active"><g:link controller="openid" action="linkAccount"><span>Open ID</span></g:link></li></g:if>
<g:else><li><g:link controller="openid" action="linkAccount"><span>Open ID</span></g:link></li></g:else>
--%>