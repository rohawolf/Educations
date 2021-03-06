<%@ page	contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>		    		
<!DOCTYPE html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<title>회원정보 삭제</title>
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
			<form	name="deleteForm" 
					method="post"
					action="delete.do">
			
				<label for="id">아이디</label>
				<input	type="text" 
						id="id" 
						name="id" 
						size="25"
						maxlength="20" 
						value="${param.id}" />
				<span class="err_msg">${id_msg}</span><br><br>
													  
				<label for="pw">패스워드</label>
				<input	type="password" 
						id="pw" 
						name="pw" 
						size="25"
						maxlength="20" />
				<span class="err_msg">${pw_msg}</span><br><br>
					
				<div class="buttons">		
					<input type="reset"	value="취소">			
					<input type="submit" value="회원정보 삭제">						
				</div>			
			</form>
		</div>		
	</body>	
</html>