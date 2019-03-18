<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn.vectoricons.net/wp-content/themes/checkout-child/images/me-as-icon-with-glass-transparent.png" type="image/x-icon" />
<title>Danh sách thí sinh thi Đại học</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
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