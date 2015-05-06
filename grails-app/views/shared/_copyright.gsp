<div class="wrapper col5">
  <div id="copyright">
    <p class="fl_left">
    	<g:if test="${grailsApplication.config.af.shared.copyright.link}">
	    	Copyright &copy; <%= new Date().format("yyyy") %> - 
	    	<a href="${grailsApplication.config.af.shared.copyright.link}">
	    		<g:if test="${grailsApplication.config.af.shared.copyright.label}">
	    			${grailsApplication.config.af.shared.copyright.label}
	    		</g:if>
	    		<g:else>
	    			Undefined grailsApplication.config.af.shared.copyright.label
	    		</g:else>
	    	</a>
	    </g:if>
	    <g:else>
	    	Copyright &copy; <%= new Date().format("yyyy") %> - 
	    		<g:if test="${grailsApplication.config.af.shared.copyright.label}">
	    			${grailsApplication.config.af.shared.copyright.label}
	    		</g:if>
	    		<g:else>
	    			Undefined grailsApplication.config.af.shared.copyright.label
	    		</g:else>
	    </g:else>
    </p>
    <p class="fl_right" style="text-align: right">
    	<%-- 
    	Template by 
    	<a href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a>
    	modified by <a href="http://www.paolociccarese.info/" title="Dr. Paolo Ciccarese">Paolo</a>
    	<br/>
    	--%>
	    Powered by <a href="http://annotationframework.org/" title="Domeo Annotation Framework">Domeo</a> Technology    	
    </p>
    <br class="clear" />
  </div>
</div>