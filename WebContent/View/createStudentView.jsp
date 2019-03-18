<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn.vectoricons.net/wp-content/themes/checkout-child/images/me-as-icon-with-glass-transparent.png" type="image/x-icon" />
<title>Thêm thí sinh mới</title>
<style>
a {
	text-decoration: none;
}

h1 {
	font-family:Tahoma;
}

a:hover {
	color: red;
}

table {
	border-collapse: collapse;
	width: 22%;
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
	<!-- 	<div class="create"> -->
	<form class="" action="<%=request.getContextPath()%>/CreateStudent" method="post">
		<table border='1'>
			<th colspan="2"><h1>Thêm thí sinh mới</h1></th>
			<tr>
				<td><label for="studentID">Mã sinh viên</label></td>
				<td><input type="text" id="studentID" name="studentID" value=""></td>
				<br />
			</tr>
			<tr>
				<td><label for="studentName">Họ và tên</label></td>
				<td><input type="text" id="studentName" name="studentName" value=""></td>
				<br />
			</tr>
			<tr>
				<td><label for="studentBirth">Ngày sinh</label></td>
				<td><input type="date" id="studentBirth" name="studentBirth" value=""></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Giới tính</label></td>
				<td><input type="radio" name="studentSex" value="1" id="male">
					<label for="male">Nam</label>
					<input type="radio" name="studentSex" value="0" id="female"> 
					<label for="female">Nữ</label></td>
				<br />
			</tr>
			<tr>
				<td><label for="studentPlaceCode">Quê quán</label></td>
				<td><select class="" name="studentPlaceCode" id="studentPlaceCode">
						<option value="">----Chọn tỉnh----</option>
						<c:forEach items="${listProvince}" var="province">
							<option value="${province.code}">${province.name}</option>
						</c:forEach>
				</select> <a href="<%=request.getContextPath()%>/View/createProvinceView.jsp" title="Thêm tỉnh mới">Thêm</a></td>
				<br />
			</tr>
			<tr>
				<td><label for="math">Điểm toán</label></td>
				<td><input type="text" id="math" name="math" value=""></td>
				<br />
			</tr>
			<tr>
				<td><label for="physical">Điểm lý</label></td>
				<td><input type="text" id="physical" name="physical" value=""></td>
				<br />
			</tr>
			<tr>
				<td><label for="chemistry">Điểm hóa</label></td>
				<td><input type="text" id="chemistry" name="chemistry" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Thêm">
					<a href="<%=request.getContextPath()%>/Home">Cancel</a>
			</tr>
		</table>
	</form>

	<!-- 	</div> -->
</body>
</html>