<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 한명의 점수 조회</h1>
	
	<p>조회한 학번: ${stu}</p><br>
	이름: <p>${stu.stuName}</p><br>
	점수:<p>국어: ${stu.kor} 영어: ${stu.eng} 수학: ${stu.math} </p><br>
	점수:<p>총점: ${stu.total} 평균: ${stu.average}  </p><br>
	
	<a href="/db/score/list">점수 전체 조회</a>
	<a href="/db/score/search">점수 개별 조회</a>
</body>
</html>