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
	request.setCharacterEncoding("UTF-8"); 
%>  		
<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<%--
		<jsp:forward	page	=	'<%= request.getParameter("forwardPage") %>'>
			<jsp:param	name	=	"tel"
						value	=	"034-1234-5678" />
		</jsp:forward>
		--%>
		
		<jsp:forward	page	=	"${param.forwardPage}" >
			<jsp:param	name	=	"tel"
						value	=	"034-1234-5678" />
		</jsp:forward>
		
	</body>	
</html>