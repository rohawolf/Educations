<%@ page	contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>전체 회원 현황</title>
		<style type="text/css">
			* { font-size: 9pt;}
			table {
				width: 75%;
				margin: 10px auto;
				border: 1px solid gray;
			}
		</style>	
	</head>
	
	<body>
		<table id="members">
		
			<colgroup>
				<col width="5%">
				<col width="12%">
				<col width="12%">
				<col width="15%">
				<col width="25%">
				<col width="16%">
				<col width="15%">
			</colgroup>
			
			<thead>
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>패스워드</td>
				<td>이름</td>
				<td>주소</td>
				<td>가입일</td>
				<td>메뉴</td>
			</tr>
			</thead>
			
			<tbody>
			<c:forEach var="member" items="${members}" varStatus="idx">
			<tr>
				<td>${idx.count}</td>
				<td>${member.id}</td>
				<td>${member.pw}</td>
				<td>${member.name}</td>
				<td>${member.address}</td>
				<td>
					<fmt:formatDate value="${member.joindate}" 
								    type="date"
								    pattern="yyyy년  M월 d일" />		
				</td>
				<td>
					<input type="button" value="수정" />&nbsp;
					<input type="button" value="삭제" />				
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</body>
	
</html>