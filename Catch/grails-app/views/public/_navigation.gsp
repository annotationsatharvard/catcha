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
	        <li><g:link controller="secure" action="home"><span>Access</span></g:link></li>
	        <g:if test="${menuitem=='signup'}"><li class="active"><g:link controller="openid" action="auth"><span>Sign Up</span></g:link></li></g:if>
	        <g:else><li><g:link controller="main" action="signup"><span>Sign Up</span></g:link></li></g:else>
	        <%-- Node info --%> 
	        <g:if test="${menuitem=='nodeinfo'}"><li class="active"><g:link controller="public" action="nodeinfo"><span>Node</span></g:link></li></g:if>
	        <g:else><li><g:link controller="public" action="nodeinfo"><span>Node</span></g:link></li></g:else>
	        <%-- Credits --%> 
	        <g:if test="${menuitem=='credits'}"><li class="active"><g:link controller="public" action="credits"><span>Credits</span></g:link></li></g:if>
	        <g:else><li><g:link controller="public" action="credits"><span>Credits</span></g:link></li></g:else>
	        
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