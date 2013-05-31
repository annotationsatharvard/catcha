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