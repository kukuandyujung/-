<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List</title>
<script type="text/javascript">
	fuction addItem(){
		document.getElementById("item").style.display="none"; 
		document.getElementById("todolist").setAttribute("style"); 
		
		
	}
	

</script>
</head>
<body>
	<h2>TO DO LIST</h2>
	<hr>
	
		<div>
		<input id="item" type="text" placeholder="오늘 할 일을 입력하세요">
		<%-- 입력 값을 가져오기 위한 input--%>
		<button type="button" onclick="addItem()">할 일 추가하기</button>
		</div>
		<h2><%= 3+3 %></h2> <%-- ><%= %> 은 사칙연산이나 간단한 변수의 출력 등을 사용할 수 있다. --%>
	<hr>
	<div>
	<span id="todolist"></span> 
	</div>
	
</body>
</html>