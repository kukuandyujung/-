<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css"> 
<!--   <link rel="stylesheet" href="/css/style.css">  / 혹은 ../-->
  <link rel="stylesheet" href="/css/notice_list.css">
</head>
<body>
<section>
    <h1>NOTICE</h1>
    <script type="text/javascript">
//     $(document).ready(function() {
//         $('#s_word').on("keyup", function(event) {
//           if (event.keyCode === 13) {
//             event.preventDefault(); // Prevent form submission
//             searchBtn();
//           }
//         });
//       });
    
    	function searchBtn(){
    		if($("#s_word").val().length<2){
    			alert("2글자 이상 입력하셔야 합니다.");
    			$("#s_word").focus();
    			return false;
    		}else{
    			alert("성공");
    			return false;
    		}
    	
    	}
    	
    </script>
    <div class="wrapper">
      <form action="/board/search" name="search" method="post">
        <select name="category" id="category">
          <option value="all">전체</option>
          <option value="btitle">제목</option>
          <option value="bcontent">내용</option>
        </select>

        <div class="title">
          <input type="text" name="s_word" id="s_word" size="16">
        </div>
  
        <button type="button" onclick="searchBtn()"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="15%">
        <col width="40%">
        <col width="15%">
        <col width="15%">
        <col width="15%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach var ="board" items="${list }">
      <tr>
        <td><span class="table-notice">${board.bno}</span></td>
        <td class="table-title">
        <c:forEach begin="1" end="${board.bindent }" step="1">
<!--         	<img src="/images/icon_reply.png"> -->
			👉
        </c:forEach>
	        <a href="boardView?bno=${board.bno}">${board.btitle}</a>
        </td>
        <td>${board.id}</td>
        <td>
        	<fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/>
        </td>
        <td>${board.bhit}</td>
      </tr>
      </c:forEach>
      
    </table>

    <ul class="page-num">
    	<!-- 첫 페이지 이동 -->
    	<c:if test="${page!=1 }">
      <a href= "/board/boardList?page=1"><li class="first"></li></a>
    	</c:if>
    	<c:if test="${page==1 }">
  			<li class="first"></li>
    	</c:if>
      <!-- 이전 페이지 이동 -->
      <c:if test="${page>1 }">
      <a href="/board/boardList?page=${page-1}"><li class="prev"></li></a>
      </c:if>
      <c:if test="${page==1 }">
      	<li class="prev"></li>
      </c:if>
      <!-- 페이지 리스트 -->
      <c:forEach begin="${startPage}" end="${endPage}" step="1" var="num">
      	<c:if test="${num != page }">
	      <a href="/board/boardList?page=${num}">      
	     	 <li class="num"><div>${num}</div></li>
	      </a>
      	</c:if>
      <c:if test="${num == page }">
      	<li class="num on"><div>${num}</div></li>
      </c:if>
      </c:forEach>
      <!-- 다음 페이지 이동 -->
      <c:if test="${page<maxPage }">
	     <a href="/board/boardList?page=${page+1}"><li class="next"></li></a> 
      </c:if>
      <c:if test="${page==maxPage }">
      	<li class="last">
      </c:if>
      <!-- 끝 페이지 이동 -->
      <c:if test="${page !=  maxPage }">
      <a href="/board/boardList?page=${maxPage }">
      <li class="last"></li>
      </a>
      </c:if>
      <c:if test="${page ==  maxPage }">
      <li class="last"></li>
      </a>
      </c:if>
      
    </ul>

    <a href="/board/boardWrite"><div class="write">쓰기</div></a>
  </section>

</body>
</html>