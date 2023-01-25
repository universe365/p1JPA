<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
</head>
<body>

	<div align="center" style="margin:3rem;">
		<form action="addController" method="post">
		
		name:		<input type="text" name="name" placeholder="name"/><br>
		username:	<input type="text" name="username" placeholder="name"/><br>
		password:	<input type="password" name="password" placeholder="password"/><br>
		address:		<input type="text" name="address" placeholder="address"/><br>
		email:		<input type="text" name="email" placeholder="email"/><br>
		<input type="submit" value="add"/>
		
	</form>
	</div>
	
	<div align="center">
		<a href="home.jsp">HOME</a>
	</div>
</body>
</html>