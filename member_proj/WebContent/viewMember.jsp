<%@ page	contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>

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
				border: 1px solid #ccc;
				border-radius: 4px;
				box-sizing: border-box;
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
		</style>
	</head>
	
	<body>
		<div class="container">			
			<label for="id">아이디</label>
			<input	type="text" 
					id="id" 
					name="id" 
					size="25"
					readonly 
					value="${param.id}"/>
			<br><br>
												  
			<label for="pw">패스워드</label>
			<input	type="text" 
					id="pw" 
					name="pw" 
					size="25"
					readonly 
					value="${param.pw}"/>
			<br><br>
			
			<label for="name">이름</label>
			<input	type="text" 
					id="name" 
					name="name" 
					size="25"
					readonly 
					value="${param.name}"/>
			<br><br>
			
			<label for="address">주소</label> 
			<input	type="text" 
					id="address" 
					name="address" 
					size="100"
					readonly 
					value="${param.address}"/>	
			<br><br>											
			
		</div>
	</body>
	
</html>