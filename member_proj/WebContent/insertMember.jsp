<%@ page	contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>
	    		
<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>회원 가입</title>
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
			
			input[type=text]:focus,
			input[type=password]:focus {				
				border: 2px solid lightblue;				
			}
			
			input[type=submit],
			input[type=reset] {
				width : 200px;
				background-color: #4CAF50;
				color: white;
				padding: 14px 20px;
				margin: 8px 8px 0 8px;
				border: none;
				border-radius: 4px;
				cursor: pointer;
			}
			
			input[type=submit]:hover,
			input[type=reset]:hover {
				background-color: #45a049;
			}
			.err_msg {
				color: red;
			}
			
		</style>
	</head>
	
	<body>
		<div class="container">
			<form	name="join" 
					method="POST"
					action="join.do">
			
				<label for="id">아이디</label><span class="err_msg">${id_msg}</span>
				<input	type="text" 
						id="id" 
						name="id" 
						size="25"
						maxlength="20" 
						value="${member.id}" />
				<span>알파벳으로 시작하여 숫자포함 8 ~ 20 자 내로 작성하십시오.</span><br><br>
													  
				<label for="pw">패스워드</label><span class="err_msg">${pw_msg}</span>
				<input	type="password" 
						id="pw" 
						name="pw" 
						size="25"
						maxlength="20"
						value="${member.pw}" />
				<span> 대문자, 특수문자를 포함하여 8 ~ 20자 내로 작성하십시오.</span><br><br>
				
				<label for="name">이름</label><span class="err_msg">${name_msg}</span>
				<input	type="text" 
						id="name" 
						name="name" 
						size="25"
						maxlength="50"
						value="${member.name}" />
				<br><br>
			
				<label for="address">주소</label> 
				<input	type="text" 
						id="address" 
						name="address" 
						size="100"
						maxlength="300"
						value="${member.address}" />
				<br><br>			
				<div class="buttons">		
					<input type="reset"	value="취소">			
					<input type="submit" value="가입">						
				</div>			
			</form>
		</div>		
	</body>	
</html>