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
		<title>Attribute Test</title>
	</head>	
	<body>
		<h2>영역과 속성 테스트</h2>
		<%
			request.setCharacterEncoding("UTF-8");
			String name	= 	request.getParameter("name") != null ?
							request.getParameter("name") : "";
			String id	= 	request.getParameter("id") != null ?
							request.getParameter("id") : "";
							
			if (!name.equals("") && !id.equals("")) {
				application.setAttribute("name", name);
				application.setAttribute("id", id);
			}		
		%>
		<h3><%= name %>님 반갑습니다.<br /><%= name %>님의 아이디는 <%= id %>입니다.</h3>
		<form	action	=	"attributeTest2.jsp"
				method	=	"POST">
			<table>
				<tr>
					<td	colspan	=	"2">Session 영역에 저장할 내용들</td>
				</tr>
				<tr>
					<td>e-mail</td>
					<td>
						<input	type	=	"text"
								name	=	"email">
					</td>
				</tr>
				<tr>
					<td>address</td>
					<td>
						<input	type	=	"text"
								name	=	"address">
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input	type	=	"text"
								name	=	"tel">
					</td>
				</tr>
				<tr>
					<td	colspan	=	"2">
						<input	type	=	"submit"
								name	=	"전송">
					</td>
				</tr>			
			</table>
		</form>
	</body>
	
</html>