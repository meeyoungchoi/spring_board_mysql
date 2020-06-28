<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 등록</h2>
	
	<form method="post"><!--  url요청 그대로 다시 컨트롤러한테 요청을 보내겠다 -->
		<p>
			#작성자: <input type="text" name="writer"><br>
			#제목: <input type="text" name="title"><br>
			# 내용: <input rows="3" name="content"><br>
			<input type="submit" value="등록">
		</p>
	
	</form>
	
	
</body>
</html>