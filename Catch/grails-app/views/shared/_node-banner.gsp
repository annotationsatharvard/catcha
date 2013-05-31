<div class="wrapper col2">
  <div id="featured_slide">
  <div class="slider" style="border-top: 0px solid #DC143C;padding-top: 10px;" align="center">
<div id='public-formbox'>
 <div>
        <table style="width: 900px;" class='public-formbox-inner'>
            <tr>
                <td class="public-formbox-title">
                    <table>
                        <tr>
                            <td align="left">${grailsApplication.config.af.shared.name} Node Info</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td align="left" style="text-align: justify; padding-left:20px;"> 
                            	<ul style="list-style-type: square;">
	                                <li>
	                                	This installation is running 
	                                	the <span style="font-weight: bold;"><g:meta name="app.fullname"/> <g:meta name="app.version"/> (build <g:meta name="app.build"/> - <g:meta name="app.date"/>)</span>.
	                                </li>
	                                <li>
	                                	The instance is administered by <span style="font-weight: bold;">
		                                <g:if test="${grailsApplication.config.af.node.administrator.name}">
		                                    ${grailsApplication.config.af.node.administrator.name}
		                                </g:if>
		                                <g:else>(anonymous)</g:else>
		                                at
		                                <g:if test="${grailsApplication.config.af.node.organization}">
		                                    ${grailsApplication.config.af.node.organization}.
		                                </g:if>
		                                <g:else>(not specified)</g:else>
		                            </li>
		                            <li>
		                                For enquiries please contact <span style="font-weight: bold;">
		                                <g:if test="${grailsApplication.config.af.node.administrator.email.display}">
		                                    ${grailsApplication.config.af.node.administrator.email.display}
		                                </g:if>
		                                <g:else>(not specified)</g:else>
		                            </li>
                                </ul>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
</div>
</div>
</div>