<%@page import="java.util.Random"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//실행될때마다 랜덤한 로또번호를 저장하고 출력해주는 프로그램코드를 작성해보세요.
  //방법은 자유 1~45 6개
  HashSet<Integer> hs = new HashSet<>();
  Random ran = new Random();
  while(hs.size() < 6){
		hs.add((ran.nextInt(45)+1));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	랜덤 로또 번호 : <%=hs.toString()%>
	
	<%
	for(int a: hs){%>
		<%=a%>
	<%}
	%>

</body>
</html>