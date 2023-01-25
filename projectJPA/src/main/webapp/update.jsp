<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center" style="margin:3rem;">
		<form action="updateController" method="post">
			id:<input type="text" id="id" name="id"> <br>
			name:<input type="text" id="name" name="name"> <br>
			username:<input type="text" id="username" name="username"> <br>
			password:<input type="password" id="password" name="password"> <br>
			phone:<input type="text" id="phone" name="phone"> <br>
			email:<input type="text" id="email" name="email"> <br>
			<input type="submit" value="更新">			
		</form>
	</div>

	<div align="center">
		<a href="home.jsp">HOME</a>
	</div>
</body>
</html>