<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 체크하기</title>
	</head>
	<body>
		<script type="text/javascript">
			if("${l_Result}" == 1){
				alert("로그인이 되었습니다.");
				location.href="index";
			}else{
				alert("아이디 혹은 패스워드가 불일치.");
				location.href="login";
			}
		</script>
	</body>
</html>