<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"

	import="Model.member"
	import="Dao.memberDao"
	import="java.util.List"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	
	table tr td{ border:1px solid #0094ff;}
	table{
		width:600px; 
		min-height:25px; 
		line-height:25px; 
		text-align:center;
		border-collapse: collapse;}  

</style>
<title>Insert title here</title>
</head>
<body>

	<div align="center" style="margin:3rem;">
	
		<table>
			<tr><td>ID<td>Name<td>Username<td>Password<td>Phone<td>Email
			<%
			
			List<Object> list = new memberDao().queryAll();
			member m=null;
			if(list!=null){
				
				for(int i=0; i<list.size(); i++){
					m = (member)list.get(i);
					
					out.println("<tr><td>"+m.getId()+"</td>"+
								"<td>"+m.getName()+"</td>"+
								"<td>"+m.getUsername()+"</td>"+
								"<td>"+m.getPassword()+"</td>"+
								"<td>"+m.getPhone()+"</td>"+
								"<td>"+m.getEmail()+"</td></tr>"
					);
					
				}
				
			}
			
			
			%>
		</table>	
	</div>

	<div align="center">
		<a href="home.jsp">HOME</a>
	</div>
</body>
</html>