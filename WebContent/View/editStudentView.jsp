<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn.vectoricons.net/wp-content/themes/checkout-child/images/me-as-icon-with-glass-transparent.png" type="image/x-icon" />
<title>Update thông tin thí sinh</title>
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
	<form class="" action="<%=request.getContextPath()%>/EditStudent" method="post">
		<table border='1'>
			<th colspan="2"><h1>Sửa thông tin</h1></th>
			<tr>
				<td><label for="studentID">Mã sinh viên</label></td>
				<td><input type="text" name="studentID" value="${student.id}"></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Họ và tên</label></td>
				<td><input type="text" name="studentName" value="${student.name}"></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Ngày sinh</label></td>
				<td><input type="date" name="studentBirth" value="${student.birth}"></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Giới tính</label></td>
				<td><input type="radio" name="studentSex" value="1" id="male" <c:if test="${student.sex == 1}">checked</c:if>>
					<label for="male">Nam</label>
					<input type="radio" name="studentSex" value="0" id="female" <c:if test="${student.sex == 0}">checked</c:if>> 
					<label for="female">Nữ</label></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Quê quán</label></td>
				<td><select class="" name="studentPlaceCode">
						<option value="${student.place.code}">${student.place.name}</option>
						<c:forEach items="${listProvince}" var="province">
							<c:if test="${province.code != student.place.code}">
								<option value="${province.code}">${province.name}</option>
							</c:if>
						</c:forEach>
				</select> <a href="<%=request.getContextPath()%>/View/createProvinceView.jsp" title="Thêm tỉnh mới">Thêm</a></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Điểm toán</label></td>
				<td><input type="text" name="math" value="${student.math}"></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Điểm lý</label></td>
				<td><input type="text" name="physical" value="${student.physical}"></td>
				<br />
			</tr>
			<tr>
				<td><label for="">Điểm hóa</label></td>
				<td><input type="text" name="chemistry" value="${student.chemistry}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"> 
				<a href="<%=request.getContextPath()%>/Home">Cancel</a>
			</tr>
		</table>
	</form>

	<!-- 	</div> -->
</body>
</html>