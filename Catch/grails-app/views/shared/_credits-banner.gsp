<div class="wrapper col2">
  <div id="featured_slide">
  <div class="slider" style="border-top: 0px solid #DC143C;padding-top: 10px;" align="center">
<div id='public-formbox'>
    <div>
        <g:if test='${flash.message}'><div class='login_message'>${flash.message}</div></g:if>
        <form method="post" >
            <table style="width: 900px;" class='public-formbox-inner'>
                <tr>
                    <td class="public-formbox-title">
                        <table>
                            <tr>
                                <td align="left">${grailsApplication.config.af.shared.title} v. <g:meta name="app.version"/> </td>
                                <td align="right" class="openid-loginbox-useopenid"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" colspan="2" style="padding: 10px; line-height: 20px;">
                    	<p style="text-align: justify; line-height: 20px;">
                    		${grailsApplication.config.af.shared.name} has been partially funded by a grant from Harvard Library Labs awarded to Paolo Ciccarese, Phil Desenne and Martin Schreiner.
                    		${grailsApplication.config.af.shared.name} is build also reusing technologies developed by Paolo Ciccarese for the
                    		<a href="http://annotationframework.org">Domeo Annotation Web Toolkit</a> project at Massachusetts General Hospital. 
                    	</p>
                    </td>
                </tr>            
            </table>
        </form>
    </div>
</div>
</div>
</div>
</div>