<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//application 객체는 session 과 사용방법이 동일합니다.
	
	int count = 0;
	
	// 누적하는 기능
	if(application.getAttribute("count")!=null) {
		count = (int)application.getAttribute("count");

	}
	count++;
	
	application.setAttribute("count", count);

	int total = (int)application.getAttribute("count");

	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	결과 : <%=total%>

</body>
</html>