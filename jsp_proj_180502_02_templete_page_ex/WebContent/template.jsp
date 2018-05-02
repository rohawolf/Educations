<%@ page	contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>
    		
<%-- 

directive						default			description
=============================================================================================================
contentType	 					text/html	 	Define JSP page content Type
import											Define which Java classes would be imported in JSP page
session							true 			Define whether using session or not
buffer											define size of buffer, when "none", buffer is not used.
autoFlush						true 			Define whether using autoFlush or not when buffer is full
info											infomations of JSP page
errorPage										define error page when error occurs in JSP page
isErrorPage						false			define this page is error page or not
pageEncoding									define charactor Encoding.
isELIgnored						false			define whether using EL or not
deferredSyntaxAllowedAsLiteral	false			define whether #{ is recognized as string or not
trimDirectiveWhitespaces		false			define whether whitespace trimming or not
IsThreadSafe					true			define whether this page is thread safe or not

--%>
<%
	String center = request.getParameter("page") != null ?
					request.getParameter("page") : "newitem";
	request.setAttribute("center", center + ".jsp");
%>    		    		
<!DOCTYPE html>

<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Templete Test</title>
		<style type="text/css">
			#header, #footer {
				width : 100%;
				height: 100px;							
			}
			#header > p {
				padding : 0 100px 0 0;
			}			
			#content {
				padding : 0 100px 0 100px;
				height : 600px;
				display : flex;
			}
			#left {
				width : 20%;				
			}
			#center {
				width : 80%;
				background : yellow;
			}
			#content :after {
				clear : both;
			}				
		</style>
	</head>	
	<body>
		<div id="header">
			<jsp:include page="top.jsp" />
		</div>
		
		<div id="content">
		
			<div id="left">
				<jsp:include page="left.jsp" />
			</div>
			
			<div id="center">
				<jsp:include page='${center}' />
			</div>
						
		</div>
		
		<div id="footer">
			<jsp:include page="bottom.jsp" />
		</div>
	</body>	
</html>