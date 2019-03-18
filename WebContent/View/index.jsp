<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn.vectoricons.net/wp-content/themes/checkout-child/images/me-as-icon-with-glass-transparent.png" type="image/x-icon" />
<title>Danh sách thí sinh thi Đại học</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.wrapper {
	border: 2px solid green;
	box-shadow: 0px 0px 15px 10px  #5cd65c;
	margin:40px 10%;
	overflow-y: scroll;
	text-align: center;
	max-height: 700px;
}

a {
	color: blue;
	text-decoration: none;
}

a:hover {
	color: red;
}

h1 {
	font-family:Tahoma;
	color: green;
	padding: 20px;
}

table {
	border-collapse: collapse;
	width: 90%;
	margin: 0 auto;
	margin-bottom: 20px;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

tr:hover {
	background-color: #ccebff;
}

th {
	background-color: #4CAF50;
	color: white;
}

#findStudent {
	margin: 10px;
}

#findStudent input, select {
	margin-right: 30px;
	border:1px solid blue;
	height:30px;
	border-radius: 10px;
}

#findStudent input[type=submit] {
	background-color: #3385ff;
	color: white;
	border: none;
	padding:0 20px;
}

#findStudent input[type=submit]:hover {
	background-color: blue;
}
.create {
	margin-bottom:15px;
}

.create a {
	color:white;
	background:orange;
	padding:10px;
	border-radius: 30px;
}

.create a:hover {
	background:#ff8000;
}
</style>
</head>
<body>
	<div class="wrapper">
		<a href="<%=request.getContextPath()%>/Home"><h1>Danh sách thí sinh dự thi Đại Học</h1></a>
		<div id="findStudent">
			<form method="GET" action="<%=request.getContextPath()%>/searchStudent">
				<label for="idSearch" name="" placeholder="Nhập mã sinh viên">Mã sinh viên:</label> 
				<input type="text" name="idSearch" id="idSearch" value="${idSearch}"> 
				<label for="placeSearch" name="">Quê quán:</label> 
				<select class="" name="placeSearch" id="placeSearch">
<%-- 				<c:if test="${empty placeSearch}">
					<option value="">----Chọn tỉnh----</option>
				</c:if>
				<c:if test="${not empty placeSearch}">
					<option value="">${placeSearch}</option>
				</c:if> --%>
				<option value="">----Chọn tỉnh----</option>
					<c:forEach items="${listProvince}" var="province">
						<option value="${province.code}">${province.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Tìm kiếm"/>
			</form>

		</div>
		<table border="1">
			<tr>	
				<th>STT</th>
				<th>Mã sinh viên</th>
				<th>Họ và tên</th>
				<th>Ngày sinh</th>
				<th>Giới tính</th>
				<th>Quê quán</th>
				<th>Toán</th>
				<th>Lý</th>
				<th>Hóa</th>
				<th>Menu</th>
			</tr>
			<c:forEach items="${listStudent}" var="student">
				<tr>
					<td></td>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.birth}</td>
					<td><c:choose>
							<c:when test="${student.sex == 1}">Nam</c:when>
							<c:otherwise>Nữ</c:otherwise>
						</c:choose></td>
					<td>${student.place.name}</td>
					<td>${student.math}</td>
					<td>${student.physical}</td>
					<td>${student.chemistry}</td>
					<td><a href="editStudent?id=${student.id}">Edit</a> | <a href="deleteStudent?id=${student.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<%-- 			<tr><td colspan="9"><a href="<%=request.getContextPath()%>/View/test.jsp" href="createStudent" >Create new</a></td></tr> --%>
		</table>
		<div class="create">
			<a href="createStudent">CREATE NEW</a>
		</div>
	</div>
</body>
</html>