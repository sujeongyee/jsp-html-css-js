<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] arr = request.getCookies();
	String id = "";
	
	
	out.println(arr[0].getValue());
	
	if(arr!=null){		
		for(Cookie c: arr){
			String name = c.getName();
			String i = c.getValue();
			out.println(i);
			if(name.equals("user_id")){
				id = i;
			}			
		}		
	}	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>결과페이지</h3>
	<%--
	user_id쿠키를 확인해서 "xxx님 환영합니다"를 출력
		
	 --%>
	
	<h2><%=id%>님 환영합니다!</h2>
	
	
</body>
</html>