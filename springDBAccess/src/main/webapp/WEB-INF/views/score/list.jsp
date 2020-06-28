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
	<h1>학생들의 전체 성적 조회</h1>
	
	<c:forEach var="stu" items="${slist}" ><!-- 번호를 부여하기 위해 사용 -->
		<p>
			# 학번: ${stu.stuId} , 이름: ${stu.stuName} , 국어:${stu.kor},
			영어: ${stu.eng} , 수학:  ${stu.math} , 총점: ${stu.total} ,
			평균: ${stu.average}
			<a href="/db/score/delete?stuNum=${stu.stuId}">삭제</a><!-- get으로 학번을 컨트롤러로 날리겠다 -->
		</p>
		
		
	</c:forEach>
	
	<a href="/db/score/register">다른 점수 등록하기</a>
	
	
	<!-- const: 상수(변하지 않는값) -->
	<!-- === => 타입까지 동등비교 -->
	<script type="text/javascript">
		const msg = "${msg}"
		console.log(msg);
		if (msg === "delSuccess") {
			alert("점수 삭제 완료!");
		}
		
	
	</script>
	
	
	
</body>
</html>