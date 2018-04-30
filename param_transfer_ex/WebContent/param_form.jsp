<%@ page contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<!-- <meta name="Generator" content="XpressEngine">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<title>인자 전송(get) 예시</title>
<script>
	function toKor(param) {
		//var param1 = document.all["param1"];
		var url = "action.do?param1=";
		var agent = navigator.userAgent.toLowerCase();
		
		if ( (navigator.appName == 'Netscape' && agent.indexOf('trident') != -1) 
			|| (agent.indexOf("msie") != -1)) 
		{ // IE일 경우
			    
			// url += param; 	
			url += escape(encodeURIComponent(param));
			// url += param; 	
		} else { // IE이외의 브라우저

			url += param; 		
		}
		
		alert(url);
		location.href = url; // 페이지 이동
	}
</script>
</head>
<body>
	
	전송-1 : <a href="action.do?param1=한글">인자전송(get)-1</a><br>
	전송-2 : <a id="param1" href="javascript:toKor('한글')">인자전송(get)-2</a>
</body>
</html>