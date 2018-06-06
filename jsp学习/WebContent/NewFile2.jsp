<%@ page pageEncoding="utf-8" errorPage="/error.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title> </title>
	</head>
	<body>
		<!-- errorPage属性：指定友好错误提示页面，如果当前jsp页面抛出异常
		将会跳转到指定的友好错误提示页面，而不是响应500页面
		 -->
		<%	
			int i=1/0;
		%>
	</body>
</html>