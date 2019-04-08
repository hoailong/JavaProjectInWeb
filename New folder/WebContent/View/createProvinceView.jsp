<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn.vectoricons.net/wp-content/themes/checkout-child/images/me-as-icon-with-glass-transparent.png" type="image/x-icon" />
<title>Thêm tỉnh mới</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

</head>
<body>
	<form class="" action="<%=request.getContextPath()%>/CreateProvince" method="post">
		<table border='1' style="width:20%">
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
				<td colspan="2"><input type="submit" value="Lưu">
					<a href="<%=request.getContextPath()%>/Home">Hủy</a>
			</tr>
		</table>
	</form>

</body>
</html>