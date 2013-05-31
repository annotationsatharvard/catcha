<style>
div.public-formbox {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	background: #fff;
	padding: 15px;
}

.public-formbox-inner {
	width: 450px;
	border: 3px #FFCC00 solid;
	background: #fff;
	height: 140px;
}

.public-formbox-inner table {
	border: 0px;
}

td.public-formbox-title {
	
	background: #FFCC00;
	border-bottom: 1px #cc3300 solid;
	color: #000;
	padding: 0;
	padding-left: 10px;
	padding-right: 10px;
	height: 18px;
	padding-top: 10px;
	height: 20px;
}

td.public-formbox-title table {
	width: 100%;
	font-size: 16px;
	border: 0;
}

table.public-formbox-inner  td {
	border: 0;
}
</style>
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
                    	<p style="text-align: justify; line-height: 20px;">${grailsApplication.config.af.shared.name} is a software product developed as part of the
                    	project ${grailsApplication.config.af.shared.logo.title} that has been partially funded by a grant from Harvard Library Labs.
                    	${grailsApplication.config.af.shared.name} is build on the technologies developed for the
                    	<a href="http://annotationframework.org">Domeo Annotation Webtoolkit</a> project. </p>
                    </td>
                </tr>
               
            </table>
        </form>
    </div>
</div>
</div>
</div>
</div>