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

	<h3>1~100까지 홀수의 합</h3>
	<%-- <%
		int sum = 0;
	
		for(int i = 1 ; i<=100 ; i+=2){
			sum+=i;
		}
	
	
	%>
	
	결과 : <%= sum %> --%>
	
	
	<c:set var = "sum" value = "0"/> 
	<c:forEach var = "i" begin = "1" end = "100" step = "2">
		<c:set var = "sum" value = "${sum+i}"/>
	</c:forEach>
	
	결과 : ${sum} 
	
	
	<hr/>
	<h3>구구단 3단</h3>
	
	<c:forEach var = "i" begin = "1" end="9"> 
	 3 x ${i} = ${3*i} <br/>
	</c:forEach>
	
	<hr/>
	<h3 style="color :#b8dafc ">2~9단까지 구구단 출력</h3>	
	<hr/>
	<c:forEach var = "i" begin = "2" end = "9">
		
		<h3 style="color : #f598a9">${i}단을 출력하겠어요!</h3>	
		<c:forEach var = "j" begin = "1" end = "9">
		
		${i} x ${j} = ${i*j} <br/>
		
		</c:forEach>	
		<hr/>
	</c:forEach>
	
	<hr/>
	
	<%
	//배열을 선언
	int[] arr = new int[] {1,2,3,4,5};
	
	for(int a :arr){
		out.println(a);
	}	
	%>
	<br/>
	<c:set var = "arr" value = "<%= new int[] {1,2,3,4,5} %>"/>
	
	<!--  varStatus는 a 변수의 상태값을 사용할 수 있는 변수 -->
	<c:forEach var = "a" items = "${arr}" varStatus="s">
		
		<!-- ${a} -->
		${s.toString()}<br/>
		인덱스번호 : ${s.index}<br/>
		숫자번호 : ${s.count}<br/>
		값 : ${a}<br/>
		
	</c:forEach>
	
	
	
</body>
</html>