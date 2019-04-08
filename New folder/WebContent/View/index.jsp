<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsRLbUSDcmvWi_FEG57LHikgus97diPwgKjGwG9QGPtvL-QbAN" type="image/x-icon" />
<title>Danh sách thí sinh thi Đại học</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/custom.js"></script>
</head>
<body>
	<!-- Hiện thị thông báo khi forward đến trang /Home -->
	<c:if test="${not empty msg || not empty msg1}">
 		<script>
			//$(function() {
				//$("#dialogMess p").text(${msg});
				//$("#dialogMess").dialog();
			//});
		alert("${msg1}${msg}");
		window.location.href="<%=request.getContextPath()%>";
		</script>	
	</c:if>
	<!--End Hiện thị thông báo khi forward đến trang /Home -->
	<div class="tab">
	  <a href="<%=request.getContextPath()%>/Home"><button class="active btnhome"><h2><i class="fas fa-home"></i>Home</h2></button></a>
	  <button class="btnabout"><h2><i class="fas fa-info-circle"></i>About</h2></button>
	</div>
	<div class="wrapper">
		<!-- Form nội dung -->
		<div class="content">
			<a href="<%=request.getContextPath()%>/Home"><h1>Danh sách thí sinh dự thi Đại Học</h1></a>
			<div id="findStudent">
				<form method="GET" action="<%=request.getContextPath()%>/searchStudent">
					<label for="idStdSearch" name="" ><i class="far fa-id-card"></i>Mã thí sinh:</label> 
					<input onchange="this.form.submit()" type="number" name="idStdSearch" id="idStdSearch" value="${idStdSearch}"> 
					<label for="namePlaceSearch" name=""><i class="fas fa-map-marker-alt"></i>Quê quán:</label> 
					<select onchange="this.form.submit()" class="" name="namePlaceSearch" id="namePlaceSearch">
						<c:if test="${not empty namePlaceSearch}">
							<option value="${namePlaceSearch}">${namePlaceSearch}</option>
						</c:if> 
							<option value="">----Tất cả----</option>
							<c:forEach items="${listProvince}" var="province">
								<option value="${province.name}">${province.name}</option>
							</c:forEach>
					</select>
					<span class="addPrv" title="Chỉnh sửa danh sách tỉnh"><i class="fas fa-edit"></i></span>
					<button class="btn btnSearch"><i class="fas fa-search"></i>Tìm Kiếm</button>
				</form>
	
			</div>
			<table id="tblShow" border="1">
				<tr>	
					<th>STT</th>
					<th>Mã thí sinh</th>
					<th>Họ và tên</th>
					<th>Ngày sinh</th>
					<th>Giới tính</th>
					<th>Quê quán</th>
					<th>Toán</th>
					<th>Lý</th>
					<th>Hóa</th>
					<th class="hideTd">ID Tỉnh</th>
				</tr>
				<%!int i = 1; %> 
				<c:forEach items="${listStudent}" var="student">
					<tr class="stdTr">
						<td><% out.print(i);i++; %></td>
						<td>${student.id}</td>
						<td>${student.name}</td>
						<td>${student.birth}</td>
						<td><c:choose>
								<c:when test="${student.gender == 1}">Nam</c:when>
								<c:otherwise>Nữ</c:otherwise>
							</c:choose>
						</td>
						<td>${student.place.name}</td>
						<td>${student.math}</td>
						<td>${student.physical}</td>
						<td>${student.chemistry}</td>
						<td class="hideTd">${student.place.id}</td>
						
						 <%-- Thêm 2 nút sửa và xóa mỗi tr
						 <td><a href="<%=request.getContextPath()%>/editStudent?id=${student.id}">
								<button class="btn btnEdit"><i class="fas fa-edit" aria-hidden="true"></i>Sửa</button>
							</a> | 
							<a href="<%=request.getContextPath()%>/DeleteStudent?id=${student.id}">
								<button class="btn btnDelete"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button>
							</a>
							<!-- <button class="btn btnDelete" id="btnDel"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button> -->
							</td> --%>
							
					</tr>
				</c:forEach>
				<tr>
					<td colspan="9" style="text-align:right">
						<form id="pageFrm" action="<%=request.getContextPath()%>/Home" method="post">
							<c:if test="${page > 1}"><a style="color:#000" href="<%=request.getContextPath()%>/Home?page=${page-1}&count=${count}" title="Trang trước"><i class="fas fa-backward"></i></a></c:if>
							<label for="page">Trang</label>
							<input onchange="this.form.submit()" style="width:25px" type="number" min="1" max="${totalPage}" value="${page}" id="page" name="page"/>
							/ ${totalPage}
							<c:if test="${page < totalPage}"><a style="color:#000" href="<%=request.getContextPath()%>/Home?page=${page+1}&count=${count}"title="Trang sau"><i style="margin-left:5px" class="fas fa-forward"></i></a></c:if>
							<select onchange="this.form.submit()" name="count" id="count" style="width:50px">
								<option value="${count}">${count}</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="15">15</option>
								<option value="20">20</option>
								<option value="30">30</option>
							</select>
							Tổng: <span>${record}</span>
						</form>
					</td>
				</tr>
				<%i = 1; %>
			</table>
			<button id="btnAdd">
				<i class="fas fa-plus-circle"></i>Thêm Mới
			</button>
		</div>
		<!-- End Form nội dung -->
		
		<!-- Form giới thiệu -->
		<div class="about">
			<h1>Chương trình quản lý thí sinh dự thi Đại học</h1>
			<h3>(Sản phẩm bài tập lớn môn <b>Lập Trình Java</b>)</h3>
			<br/>
			<div class="infor">
				<table class="tblAbout" >
						<tr>
							<td width="40%">Thầy giáo bộ môn:</td>
							<td width="60%"><b>Nguyễn Trọng Phúc</b></td>
						</tr>
						<tr>
							<td rowspan="3">Những người thực hiện:</td>
							<td><b>Phan Văn Hoài (171203470)</b></td>
						</tr>
						<tr>
							<td><b>Phạm Nhật Nam (171200791)</b></td>
						</tr>
						<tr>
							<td><b>Lê Sơn Tùng (171210160)</b></td>
						</tr>
						<tr>
							<td>Lớp:</td>
							<td><b>Công nghệ thông tin 1 - k58</b></td>
						</tr>
						<tr>
							<td>Trường:</td>
							<td><b>Đại học Giao Thông Vận Tải Hà Nội</b></td>
						</tr>
						<tr>
							<td>Chi tiết sản phẩm:</td>
							<td><a style="color:blue" href="<%=request.getContextPath()%>/#"><b>StudentManagement.doc</b></a></td>
						</tr>
				</table>
			</div>
		</div>
		<!-- End Form giới thiệu -->
	</div>
	
	<!-- Form tạo thí sinh mới -->
	<div class="createStd">
		<form class="createStdFrm" action="<%=request.getContextPath()%>/CreateStudent" method="post">
			<table border='1'>
				<th colspan="2"><h1>Thêm thí sinh mới</h1></th>
				<tr>
					<td><label for="studentID">Mã thí sinh (*)</label></td>
					<td><input type="number" min="10000" id="studentID" name="studentID" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="studentName">Họ và tên</label></td>
					<td><input type="text" id="studentName" name="studentName" value="" required="required"  onkeyup="validateInputSpecialChar('studentName')" onkeypress="validateInputSpecialChar('studentName')"></td>
					
				</tr>
				<tr>
					<td><label for="studentBirth">Ngày sinh</label></td>
					<td><input type="date" id="studentBirth" name="studentBirth" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="">Giới tính</label></td>
					<td><input type="radio" name="studentGender" value="1" id="male" checked>
						<label for="male">Nam</label>
						<input type="radio" name="studentGender" value="0" id="female"> 
						<label for="female">Nữ</label></td>
					
				</tr>
				<tr>
					<td><label for="studentPlaceId">Quê quán</label></td>
					<td><select class="" name="studentPlaceId" id="studentPlaceId" required="required">
							<option value="">----Chọn tỉnh----</option>
							<c:forEach items="${listProvince}" var="province">
								<option value="${province.id}">${province.name}</option>
							</c:forEach>
					</select> <span class="addPrv" title="Chỉnh sửa danh sách tỉnh"><i class="fas fa-edit"></i></span></td>
					
				</tr>
				<tr>
					<td><label for="math">Điểm toán</label></td>
					<td><input type="number" min="0" max="10" step="0.001" id="math" name="math" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="physical">Điểm lý</label></td>
					<td><input type="number" min="0" max="10" step="0.001" id="physical" name="physical" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="chemistry">Điểm hóa</label></td>
					<td><input type="number" min="0" max="10" step="0.001" id="chemistry" name="chemistry" value="" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
					<button class="btn btnSave"><i class="far fa-save"></i>Lưu</button>
					<span class="cancer">Hủy</span> 	
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- End Form tạo thí sinh mới -->
		
	<!-- Form sửa thông tin thí sinh -->
	<div class="editStd">
		<form class="editStdFrm" action="<%=request.getContextPath()%>/" method="post">
			<table border='1'>
				<th colspan="2"><h1>Thông tin thí sinh</h1></th>
				<tr>
					<td><label for="studentID_">Mã thí sinh (*)</label></td>
					<td><input type="number" min="10000" id="studentID_" name="studentID" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="studentName_">Họ và tên</label></td>
					<td><input type="text" id="studentName_" name="studentName" value="" required="required"  onkeyup="validateInputSpecialChar('studentName_')" onkeypress="validateInputSpecialChar('studentName_')"></td>
					
				</tr>
				<tr>
					<td><label for="studentBirth_">Ngày sinh</label></td>
					<td><input type="date" id="studentBirth_" name="studentBirth" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="male_">Giới tính</label></td>
					<td><input type="radio" name="studentGender" value="1" id="male_">
						<label for="male_">Nam</label>
						<input type="radio" name="studentGender" value="0" id="female_"> 
						<label for="female_">Nữ</label></td>
					
				</tr>
				<tr>
					<td><label for="studentPlaceId_">Quê quán</label></td>
					<td><select class="" name="studentPlaceId" id="studentPlaceId_" required="required">
							<option class="optStd"></option>
							<c:forEach items="${listProvince}" var="province">
								<option value="${province.id}">${province.name}</option>
							</c:forEach>
					</select> <span class="addPrv" title="Chỉnh sửa danh sách tỉnh"><i class="fas fa-edit"></i></span></td>
					
				</tr>
				<tr>
					<td><label for="math_">Điểm toán</label></td>
					<td><input type="number" min="0" max="10" step="0.001"  id="math_" name="math" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="physical_">Điểm lý</label></td>
					<td><input type="number" min="0" max="10" step="0.001" id="physical_" name="physical" value="" required="required"></td>
					
				</tr>
				<tr>
					<td><label for="chemistry_">Điểm hóa</label></td>
					<td><input type="number" min="0" max="10" step="0.001" id="chemistry_" name="chemistry" value="" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
					<button class="btn btnSave"><i class="far fa-save"></i>Lưu</button>
					<button type="button" class="btn btnDelete" id="btnDel"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button>
					<a id="printLink" href="" target="_blank"><button type="button" class="btn btnPrint" id="btnPrt"><i class="fas fa-print" aria-hidden="true"></i>In</button></a>
					<span class="cancer">Hủy</span> 	
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- End Form sửa thông tin thí sinh -->
	
	<!-- Form danh sách tỉnh -->
	<div class="prvForm">
		<form class="prvViewForm" action="">
			<table border="1">
				<!-- <tr><th colspan="2">Danh sách tỉnh</th></tr> -->
				<tr>
					<th>Mã tỉnh</th>
					<th>Tên tỉnh</th>
				</tr>
				<c:forEach items="${listProvince}" var="province">
					<tr class="prvTr">
						<td>${province.id}</td>
						<td>${province.name}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2">
						<button type="button" class="btn btnPrint" id="btnAddPrv"><i class="fas fa-plus-circle" aria-hidden="true"></i>Thêm</button>
						<span class="cancer2">Hủy</span>	
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- End Form danh sách tỉnh -->
	
	<!-- Form sửa thông tin tỉnh -->
	<div class="editPrv">
		<form class="editPrvFrm" action="<%=request.getContextPath()%>/EditProvince" method="post">
			<table border='1' style="width:20%">
				<th colspan="2"><h1>Update tỉnh</h1></th>
				<tr>
					<td><label for="provinceId_">Mã tỉnh (*)</label></td>
					<td><input type="text" id="provinceId_" name="provinceId" value="" disabled="disable"></td>
				</tr>
				<tr>
					<td><label for="provinceName_">Tên</label></td>
					<td><input type="text" id="provinceName_" name="provinceName" value=""  onkeyup="validateInputSpecialChar('provinceName')" onkeypress="validateInputSpecialChar('provinceName')" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button class="btn btnSave"><i class="far fa-save"></i>Lưu</button>
						<button type="button" class="btn btnDelete" id="btnDelPrv"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button>
						<span class="cancer3">Hủy</span> 	
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- End Form sửa thông tin tỉnh -->
	
	<!-- Form thêm tỉnh mới -->
	<div class="createPrv">
		<form class="createPrvFrm" action="<%=request.getContextPath()%>/CreateProvince" method="post">
			<table border='1' style="width:20%">
				<th colspan="2"><h1>Thêm Tỉnh Mới</h1></th>
				<tr>
					<td><label for="provinceId">Mã tỉnh (*)</label></td>
					<td><input type="text" id="provinceId" name="provinceId" value="" disabled="disable"></td>
				</tr>
				<tr>
					<td><label for="provinceName">Tên</label></td>
					<td><input type="text" id="provinceName" name="provinceName" value=""  onkeyup="validateInputSpecialChar('provinceName')" onkeypress="validateInputSpecialChar('provinceName')" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button class="btn btnSave"><i class="far fa-save"></i>Lưu</button>
						<span class="cancer3">Hủy</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- End Form thêm tỉnh mới -->
	
	<!-- Form xác nhận xóa -->
	<div class="accept">
		<table class="acceptFrm">
			<th>Xóa thí sinh</th>
			<tr><td>Bạn có chắc muốn xóa?</td></tr>
			<tr>
				<td><a id="deleteLink" href="<%=request.getContextPath()%>/#">
					<button class="btn btnDelete"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button>
				</a>
				<span class="cancer3">Hủy</span></td>
			</tr>
		</table>
	</div>
	<!-- End Form xác nhận xóa -->
	
	<div id="dialogMess" title="Thông báo">
		<p></p>
	</div>

</body>
</html>