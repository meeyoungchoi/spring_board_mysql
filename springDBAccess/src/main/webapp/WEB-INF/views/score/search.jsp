<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개별 점수 조회</h1>
	
	<%--
		- /selectOne 요청을 토애 해당 학번을 가진 학생의 성적 정보를 조회하여
		search-result.jsp에 해당 정보를 화면에 출력
	
	 --%>
	
	
	
	<form action="/db/score/selectOne">
		<p>
			# 조회할 학번:<input type="text" name="stuNum" size="5">
			<input type="submit" value="확인">
		</p>
	</form>
	
	<%-- 해당 학번에 일치하는 학생 정보가 없는 경우 "학번 정보가 없습니다" --%>
	<p style="color:red;">${msg}</p>
	<script type="text/javascript">
		const msg = ${msg};
		console.log(msg);
		if (msg === "selectFail") {
			alert("학번 정보가 없습니다.");ㅣ
		}
	
	</script>
	



</body>
</html>