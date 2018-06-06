<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
	<style>
		p{border:1px solid red; }
	</style>
</head>
<body>
	
	<p>用户名:<%=request.getAttribute("name") %></p>
	<p>邮箱:<%=request.getAttribute("email") %></p>
	
	
</body>
</html>