<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "send_ex02.jsp" method = "post">
		아이디:<input type = "text" name = "id"><br>
		이름: <input type ="text" name = "name"><br>
		<input type = "submit" value = "리다이렉트"><br>
	</form>
	
	<% 
		out.print("<h1>안녕!<h1>");
	%>
	
	PrintWriter out = resp.getWriter();
	out.println("hello world");


</body>
</html>