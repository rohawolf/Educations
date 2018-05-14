<%@ page	contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>회원 정보 수정</title>
		<style type="text/css">
			.container {				
				border-radius: 5px;
				background-color: #f2f2f2;
				padding: 20px;
				margin: 50px auto;				
				width: 80%;
			}
			
			input[type=text],
			input[type=password] {
				width: 100%;
				padding: 12px 12px;
				margin: 8px 0;
				display: inline-block;
				border: 2px solid gray;
				border-radius: 4px;
				box-sizing: border-box;
			}
			.err_msg {
				color: red;
			}
		</style>
	</head>
	
	<body>
		<div class="container">
		<form	name="updateForm"
				method="POST"
				action="updateProc.do">
					
			<label for="id">아이디</label>
			<input	type="text" 
					id="id" 
					name="id" 
					size="25"
					readonly 
					value="${member.id}"/>
			<br><br>
												  
			<label for="pw">기존 패스워드</label>
			<input	type="password" 
					id="pw" 
					name="pw" 
					size="25"
					readonly 
					value="${member.pw}"/>
			<br><br>
			
			<label for="pw">신규 패스워드</label>
			<input	type="password" 
					id="new_pw" 
					name="new_pw" 
					size="25"
					maxlength="20" />
					<span class="err_msg">${pw_msg}</span>
			<br><br>
			
			<label for="pw">신규 패스워드 확인</label>
			<input	type="password" 
					id="new_pw2" 
					name="new_pw2" 
					size="25"
					maxlength="20" />
			<br><br>
			
			<label for="name">이름</label>
			<input	type="text" 
					id="name" 
					name="name" 
					size="25"
					readonly 
					value="${member.name}"/>
					<span class="err_msg">${name_msg}</span>
			<br><br>
			
			<label for="address">주소</label> 
			<input	type="text" 
					id="address" 
					name="address" 
					size="100"
					value="${member.address}"/>	
			<br><br>
			
			<label for="joindate">가입일</label> 
			<input	type="text" 
					id="joindate" 
					name="joindate" 
					size="100"
					readonly 
					value="${member.joindate}"/>	
			<br><br>
			
			<input type="submit" value="회원정보 수정">&nbsp;
			<input type="reset" value="취소">											
		</form>	
		</div>
	</body>	
</html>