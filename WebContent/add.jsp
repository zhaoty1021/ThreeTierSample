<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" method="post">
		学号：<input type="text" name="unumber"><br/>
		名字：<input type="text" name="uname"><br/>
		<input type="submit" value="增加">
	</form>
</body>
</html>