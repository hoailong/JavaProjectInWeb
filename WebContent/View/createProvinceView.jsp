<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn.vectoricons.net/wp-content/themes/checkout-child/images/me-as-icon-with-glass-transparent.png" type="image/x-icon" />
<title>Thêm tỉnh mới</title>
<style>
a {
	text-decoration: none;
}

a:hover {
	color: red;
}

h1 {
	font-family:Tahoma;
}

table {
	border-collapse: collapse;
	width: 20%;
	margin: 0 auto;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<form class="" action="<%=request.getContextPath()%>/CreateProvince" method="post">
		<table border='1'>
			<th colspan="2"><h1>Thêm Tỉnh Mới</h1></th>
			<tr>
				<td><label for="provinceCode">Mã tỉnh</label></td>
				<td><input type="text" id="provinceCode" name="provinceCode" value=""></td>
				<br />
			</tr>
			<tr>
				<td><label for="provinceName">Tên</label></td>
				<td><input type="text" id="provinceName" name="provinceName" value=""></td>
				<br />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Thêm">
					<a href="<%=request.getContextPath()%>/Home">Cancel</a>
			</tr>
		</table>
	</form>

</body>
</html>