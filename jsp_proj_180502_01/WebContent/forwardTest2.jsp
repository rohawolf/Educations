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
deferredSyntaxAllowedAsLiteral	false			define whether #{ is recognized as string or not
trimDirectiveWhitespaces		false			define whether whitespace trimming or not
IsThreadSafe					true			define whether this page is thread safe or not

--%>
    		    		
<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>Forward된 페이지 (forwardTest2.jsp)</title>
	</head>
	
	<body>
		<table>
			<%--
			<tr>
				<td>이름</td>
				<td><%= request.getParameter("name") %></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%= request.getParameter("age") %></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%= request.getParameter("address") %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%= request.getParameter("tel") %></td>
			</tr>
			--%>
			 
			<tr>
				<td>이름</td>
				<td>${param.name}</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${param.age}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${param.address}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${param.tel}</td>
			</tr>
			
		</table>
	</body>	
</html>