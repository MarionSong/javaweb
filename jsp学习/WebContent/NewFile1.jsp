<%@page import="java.util.Date"%>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title> </title>
	</head>
	<body>
		<h1>jsp指令</h1>
		<h2>import属性</h2>
		<%=new Date().toLocaleString()%>
		<h2>session属性</h2>
		<%
		session.setAttribute("", ""); 
		
		%>
	</body>
</html>