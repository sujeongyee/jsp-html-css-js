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
	
	<h3>choose</h3>
	
	<%-- <c:choose>
		<c:when test="${param.name =='홍길동'}">
			홍길동입니다.
		</c:when>
		<c:when test="${param.name == '이순신'}">
			이순신입니다.
		</c:when>
		<c:otherwise>
			둘 다 아닙니다.
		</c:otherwise>
	</c:choose> --%>
	
	<!-- choose문으로 age변수를 if ~else로 처리 -->
	
	<c:choose>
		<c:when test="${param.age >19}">
			${param.age}살 이시군요 성인 요금내세요!
		</c:when>
		<c:when test="${param.age < 13}">
			${param.age}살 이시군요 어린이 요금내세요!
		</c:when>
		<c:otherwise>
			 ${param.age}살 이시군요 청소년 요금내세요!
		</c:otherwise>
	</c:choose>



</body>
</html>