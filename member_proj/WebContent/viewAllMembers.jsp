<%@ page	contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>전체 회원 현황</title>
		<style type="text/css">
			* { font-size: 9pt;}
			#members {
				width: 80%;
			}
		</style>	
	</head>
	
	<body>
		<table id="members">
		
			<colgroup>
				<col width="3%">
				<col width="12%">
				<col width="15%">
				<col width="15%">
				<col width="30%">
				<col width="10%">
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
			
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>패스워드</td>
				<td>이름</td>
				<td>주소</td>
				<td>가입일</td>
				<td>
					<input type="button" value="수정" />&nbsp;
					<input type="button" value="삭제" />				
				</td>
			</tr>
			
			</tbody>
		</table>
	</body>
	
</html>