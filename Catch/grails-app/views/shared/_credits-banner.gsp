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
	border: 1px #ddd solid;
	background: #fff;
	height: 140px;
}

.public-formbox-inner table {
	border: 0px;
}

td.public-formbox-title {
	
	background: #FFCC00;
	border-bottom: 1px #cc3300 solid;
	
	/* IE10 Consumer Preview */ 
	background-image: -ms-linear-gradient(bottom, #FFFFFF 0%, #DDDDDD 100%);
	
	/* Mozilla Firefox */ 
	background-image: -moz-linear-gradient(bottom, #FFFFFF 0%, #DDDDDD 100%);
	
	/* Opera */ 
	background-image: -o-linear-gradient(bottom, #FFFFFF 0%, #DDDDDD 100%);
	
	/* Webkit (Safari/Chrome 10) */ 
	background-image: -webkit-gradient(linear, left bottom, left top, color-stop(0, #FFFFFF), color-stop(1, #DDDDDD));
	
	/* Webkit (Chrome 11+) */ 
	background-image: -webkit-linear-gradient(bottom, #FFFFFF 0%, #DDDDDD 100%);
	
	/* W3C Markup, IE10 Release Preview */ 
	background-image: linear-gradient(to top, #FFFFFF 0%, #DDDDDD 100%);
	
	border-bottom: 1px #ddd solid;
	
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
	//border: 0;
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