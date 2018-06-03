<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Login Page</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css" />
	</head>
	<body>
		 <form action="../LoginServlet" method="post">
        <table>
            <tr>
                <td class="alignRight">
                    Username: 
                </td>
                <td>
                    <input type="text" name="username" />
                </td>
            </tr>
            <tr>
                <td class="alignRight">
                    Password: 
                </td>
                <td>
                    <input type="password" name="password" />
                </td>
            </tr>
        </table>
        <input type="submit" value="Log In" class="submit" />
    </form>
	</body>
</html>