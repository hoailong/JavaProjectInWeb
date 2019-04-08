<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsRLbUSDcmvWi_FEG57LHikgus97diPwgKjGwG9QGPtvL-QbAN" type="image/x-icon" />
<title>In thông tin sinh viên</title>
<style>
	.printStd {
		margin:0 auto;
		width:600px;
		border:1px solid #ccc;
		padding:20px 50px;
	}
	
	.printStd h2{
		text-align:center;
	}
	
	.printStd #idSpan{
		margin-left:80px;
	}
	
	.printStd span{
		font-size:20px;
		line-height:30px;
	}
	
	.inforStdTbl {
		margin:0 auto;
		border-collapse: collapse;
		width:100%;
		text-align:center;
	}
	
	.inforStdTbl td,{
		width:33%:
	}
</style>
</head>
<body onload="window.print()">
	<div class="printStd">
		<h2>GIẤY CHỨNG NHẬN KẾT QUẢ THI</h2>

		<span>Họ và tên: <b>${student.name}</b></span><span id="idSpan">Mã thí sinh: <b>${student.id}</b></span>
		<br/>
		<span>Sinh ngày: ${student.birth}</span>
		<br/>
		<span>Giới tính:
			<c:choose>
				<c:when test="${student.gender == 1}">Nam</c:when>
				<c:otherwise>Nữ</c:otherwise>
			</c:choose>
		</span>
		<br/>
		<span>Nơi sinh: ${student.place.name}</span>
		<br/>
		<span><b>Đạt kết quả kì thi đại học:</b></span>
		</br>
		<table class="inforStdTbl" border="1">
			<tr>
				<th width="33%">Toán</th>
				<th width="33%">Vật Lý</th>
				<th width="34%">Hóa Học</th>
			</tr>
			<tr>
				<td><b>${student.math}</b></td>
				<td><b>${student.physical}</b></td>
				<td><b>${student.chemistry}</b></td>
			</tr>
		</table>
	</div>
</body>
</html>