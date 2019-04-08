<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn.vectoricons.net/wp-content/themes/checkout-child/images/me-as-icon-with-glass-transparent.png" type="image/x-icon" />
<title>Thêm thí sinh mới</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

</head>
<body>
	<!-- 	<div class="create"> -->
	<form class="" action="<%=request.getContextPath()%>/CreateStudent" method="post">
		<table border='1' style="width:22%">
			<th colspan="2"><h1>Thêm thí sinh mới</h1></th>
			<tr>
				<td><label for="studentID">Mã sinh viên</label></td>
				<td><input type="text" id="studentID" name="studentID" value=""></td>
				
			</tr>
			<tr>
				<td><label for="studentName">Họ và tên</label></td>
				<td><input type="text" id="studentName" name="studentName" value=""></td>
				
			</tr>
			<tr>
				<td><label for="studentBirth">Ngày sinh</label></td>
				<td><input type="date" id="studentBirth" name="studentBirth" value=""></td>
				
			</tr>
			<tr>
				<td><label for="">Giới tính</label></td>
				<td><input type="radio" name="studentSex" value="1" id="male">
					<label for="male">Nam</label>
					<input type="radio" name="studentSex" value="0" id="female"> 
					<label for="female">Nữ</label></td>
				
			</tr>
			<tr>
				<td><label for="studentPlaceCode">Quê quán</label></td>
				<td><select class="" name="studentPlaceCode" id="studentPlaceCode">
						<option value="">----Chọn tỉnh----</option>
						<c:forEach items="${listProvince}" var="province">
							<option value="${province.code}">${province.name}</option>
						</c:forEach>
				</select> <a href="<%=request.getContextPath()%>/View/createProvinceView.jsp" title="Thêm tỉnh mới"><i class="far fa-plus-square"></i></a></td>
				
			</tr>
			<tr>
				<td><label for="math">Điểm toán</label></td>
				<td><input type="text" id="math" name="math" value=""></td>
				
			</tr>
			<tr>
				<td><label for="physical">Điểm lý</label></td>
				<td><input type="text" id="physical" name="physical" value=""></td>
				
			</tr>
			<tr>
				<td><label for="chemistry">Điểm hóa</label></td>
				<td><input type="text" id="chemistry" name="chemistry" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Lưu">
					<a href="<%=request.getContextPath()%>/Home">Hủy</a>
			</tr>
		</table>
	</form>

	<!-- 	</div> -->
</body>
</html>