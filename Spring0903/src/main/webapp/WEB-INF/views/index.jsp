<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매인 페이지입니다.</title>
<script>
	document.getElementById("result").style.display="none";
	
	function signUp(){
		alert("회원 가입을 하시겠습니까");
		document.getElementById("sign").style.display="none";
		document.getElementById("rname").innerHTML=document.form1.name.value;
		document.getElementById("remail").innerHTML=document.form1.email.value;
		document.getElementById("result").setAttribute("style", "display: block; background-color:pink;");
	
		
	}
</script>
</head>
<body>
 	<h2>회원 가입</h2>
 	<hr>
 	<div id="sign">
 		<form name="form1">
 			<h3>이름</h3><br>	
 			<input type="text" name="name" size="30"><br>
 			<hr>
 			<h3>이메일</h3>
 			<input type="email" name="email" size="30"><br>
 			<button type="button" onclick="signUp()">가입하기</button>
 		</form>
 	</div>
 	<div id="result" class="result">
 		<h3>가입 정보</h3>
 		<hr>
 		이름: <span id="rname"></span><br>
 		이메일: <span id="remail"></span><br>
 	</div>
</body>
</html>