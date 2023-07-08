<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");

	double cm = Double.parseDouble(request.getParameter("cm"));
	double kg = Double.parseDouble(request.getParameter("kg"));
	double bmi = kg / (cm/100 *cm/100);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	이름 : <%=name%><br/>
	키 : <%=cm%> cm<br/>
	몸무게 : <%= kg %> kg<br/>
	bmi지수 : <%=bmi%> <br/>

	 
		<%if(bmi>=25){%>
			<b>과체중<b/>
		<%}else if (bmi <=18){%>
			<b>저체중<b/>
		<% }else{%>
			<b>정상<b/>
		<%}%>
	    <br/>
		
		<%if(bmi>=25){
			out.println("과체중");
		}else if (bmi <=18){
			out.println("저체중");
		}else{
			out.println("정상");
		}%>
		
		
</body>
</html>