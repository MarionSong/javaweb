<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title> </title>
	</head>
	<body>
		<h1>jsp表达式</h1>
		<%String name="张飞"; %>
		<%="hello jsp" %>
		<%=name %>
		<%=111+2 %>
		<br/>
		<h1>脚本片段</h1>
		<%for(int i=0;i<10;i++){
			out.write("wo<br/>");
		}		
		%>
		<% for(int i=0;i<5;i++){ %>
			Hello jsp<br/>
		<%} %>		
	</body>
</html>