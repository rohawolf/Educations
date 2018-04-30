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
isELIgnored	false								define whether using EL or not
deferredSyntaxAllowedAsLiteral	false			define whether "#{" is recognized as string or not
trimDirectiveWhitespaces		false			define whether whitespace trimming or not
IsThreadSafe					true			define whether this page is thread safe or not

--%>
<%!
	// Declaration - Java SE version ( not Java EE version! )
	// request.setCharacterEncoding("utf-8");	// (x)
	
	// JSE code, JEE code (x) : use variables / methods
	// Java code (model : VO, util..)
	// MVC pattern -> JSP : View Only!
	// so, Declaration in JSP page -> Java SE code in src 
%>
<%
	// JEE code : scriptlet
	// => JSTL, taglib of some frameworks
	// (for, if,..), variables, (not functions, methods -> Declaration)
	
	request.setCharacterEncoding("utf-8");
	out.println("abcd123한글<br>");

%>    		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<!-- expression : means "print" -->
		<!-- return only one value ! 	-->
		<%-- <%= 123 + "4567"; // (x) => do not use ";" --%> 
		<%= 123 + "4567" %> <br />
		<%= Math.abs(-3) %> <br />
		<%--JSP expression => EL(Expression Language) !--%>
		${123}
	</body>
	
</html>