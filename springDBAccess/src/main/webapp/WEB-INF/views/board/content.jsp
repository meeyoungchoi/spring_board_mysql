<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${boardNo}번 게시물 내용</h1>
	
	<form action="/db/board/selectOne">
		<p>
			#글번호: ${boardNo}<br>
		    #작성자: ${article.writer}<br>
		    #글제목: ${article.title}<br>
		    <!--  사용자가 볼수만 있게 처리 -->
			#글내용: <textarea rows="3" readonly="readonly">${article.content}</textarea><br>
					
			<a href="/db/board/list">글 목록보기</a>&nbsp;
			<a href="/db/board/modify?boardNo=${boardNo}">글 수정하기</a>&nbsp;
					
		</p>
	</form>
	
	
</body>
</html>