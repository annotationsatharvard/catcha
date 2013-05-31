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
 <div id="topnav">
      <ul>
        <li><a class="active" href="index.html">Home</a>
        </li>
        <li><a href="style-demo.html">Share</a>
          <ul>
            <li><a href="#">Upload annotation</a></li>
          </ul>
        </li>
        <li><a href="full-width.html">View</a>
          <ul>
            <li><a href="#">Search annotation</a></li>
            <li><a href="#">Browse annotation</a></li>
          </ul>
        </li>
        <li class="last"><a href="#">About</a>
         <ul>
            <li><a href="#">Node info</a></li>
            <li><a href="#">Credits</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <br class="clear" />
  </div>
</div>

<%-- 
<g:if test="${menuitem=='openid'}"><li class="active"><g:link controller="openid" action="linkAccount"><span>Open ID</span></g:link></li></g:if>
<g:else><li><g:link controller="openid" action="linkAccount"><span>Open ID</span></g:link></li></g:else>
--%>