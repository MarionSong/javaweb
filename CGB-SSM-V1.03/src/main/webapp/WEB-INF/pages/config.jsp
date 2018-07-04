<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>小毛驴</title>
	</head>
	<body>
		<h1>配置管理页面</h1>
		<div >
			<table border="1" width="100%" cellpadding="1" cellspacing="0">
				<tr>
					<th>id</th>
					<th>name</th>
					<th>value</th>
					<th>createdTime</th>
					<th>modifiedTime</th>
				</tr>
				<c:forEach var = "item" items="${records}" >
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.value}</td>
						<td>${item.createdTime}</td>
						<td>${item.modifiedTime}</td>
					</tr>
				
				</c:forEach>
			</table>
			
		</div>
	</body>
</html>