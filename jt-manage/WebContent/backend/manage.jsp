<%@page pageEncoding="utf-8"  %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>后台管理页面</title>
		<meta charset="utf-8"/>
		<style type="text/css">
		</style>
	</head>
	<!-- frameset组织页面结构 -->
	<frameset rows="14%, 86%" frameborder="0" framespacing="0">
		<frame src="${pageContext.request.contextPath }/backend/_top.jsp" noresize="noresize"/>
		<frameset cols="14%, 86%" frameborder="0" framespacing="0">
			<frame src="${pageContext.request.contextPath }/backend/_left.jsp" noresize="noresize"/>
			<frame src="${pageContext.request.contextPath }/backend/_right.jsp" name="rightFrame"  noresize="noresize"/>
		</frameset>
	</frameset>
	<body>
	</body>
</html>