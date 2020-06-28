<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${boardNo}번 게시글 수정</h2>
	<form method="post">
	<input type="hidden" name="boardNo" value="${boardNo}"><!-- 수정하려는 글번호 도 넘긴다 -->
		<p>
			# 글번호: ${boardNo}<br>
			# 작성자: <input type="text" name="writer" value="${article.writer}">
			# 제목: <input type="text" name="title" value="${article.title}">
			# 내용: <textarea rows="3" name="content" >${article.content}"</textarea>
			<br>
			<input type="submit" value="전송">
		</p>
	</form>
	
	<a href="/db/board/list">글 목록보기</a>
	
</body>
</html>