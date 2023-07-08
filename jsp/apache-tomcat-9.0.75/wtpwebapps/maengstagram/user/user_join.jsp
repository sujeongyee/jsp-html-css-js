<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>

   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>Welcome to MyWorld</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
 
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
   
   <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>
   <style>
   .abc {
      position: sticky;
      top: 0px;
      width: 100%; 
      z-index: 10;
   }
   </style>
    
    
</head>
<body>
	<!-- header -->
	<div class="brand">Maengstagram</div>        
    <div class="address-bar"></div>
    
    <nav class="navbar navbar-default abc" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong"></a>
            </div>
           
           
            
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->

<section>
	<div align = "center"> <!-- 글자 가운데로 -->
		
		<h3>회원 가입 !</h3>
		<hr/>
		

		
		<form action = "joinForm.user" method="post">
			
				
					아 이 디 :
					<input type = "text" name = "id" placeholder="아이디를 입력하세요" required="required" pattern = "\w{4,}" ">
					
					<br/>
					비밀번호:
					<input type = "password" name = "pw"  required="required" style="width:175px;" pattern="\w{4,}">
					<br/>
					닉 네 임 :
					<input type = "text" name = "name" placeholder= "닉네임을 입력하세요" style="width:175px;">
					<br/>
					
					소개하기:
					<input type = "text" name = "intro" placeholder="상태 메시지를 입력하세요" style="width:180px;">
					<br/>
					<br/>
					프로필 사진 불러오기  ↓           <br/><br/>
					<div align="center">
					<input type="file" name="photo" value="프로필사진">
					<br/>
					</div>
			
			<div style = "color: red;">${msg}</div>
			<br/>
			<input type = "submit" value = "가입">
			<input type = "reset" value = "정보초기화">
				
		</form>	
		
		

		
	</div>

</section>


<%@ include file = "../include/footer.jsp"%>