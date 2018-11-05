<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Danh bạ điện thoại</h1>
	<form action="SearchAccount" method="GET">
		Nhập tên thuê bao: <input type="text" name="txtUser" value=""><br>
		Nhập số điện thoại: <input type="text" name="txtPhone" value=""><br>
		Địa chỉ: <input type="text" name="txtAddress" value=""><br>
		<input type="submit" name="submit" value="Search">
	</form>
</body>
</html>