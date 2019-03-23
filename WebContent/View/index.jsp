<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsRLbUSDcmvWi_FEG57LHikgus97diPwgKjGwG9QGPtvL-QbAN" type="image/x-icon" />
<title>Danh sách thí sinh thi Đại học</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<c:if test="${not empty msg}">
 		<script>
			//$(function() {
				//$("#dialogMess p").text(${msg});
				//$("#dialogMess").dialog();
			//});
		alert("${msg}");
		// cach 1: 
        window.location.href="<%=request.getContextPath()%>";
		</script>
		<c:redirect url="<%=request.getContextPath()%>"/>
	</c:if>
		<div class="wrapper">
		<a href="<%=request.getContextPath()%>/Home"><h1>Danh sách thí sinh dự thi Đại Học</h1></a>
		<div id="findStudent">
			<form method="GET" action="<%=request.getContextPath()%>/searchStudent">
				<label for="idSearch" name="" ><i class="far fa-id-card"></i>Mã sinh viên:</label> 
				<input type="text" name="idSearch" id="idSearch" value="${idSearch}" onkeyup="validateInputSpecialChar('idSearch')" onkeypress="validateInputSpecialChar('idSearch')"> 
				<label for="placeSearch" name=""><i class="fas fa-map-marker-alt"></i>Quê quán:</label> 
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
				<button class="btn btnSearch"><i class="fas fa-search"></i>Tìm Kiếm</i></button>
			</form>

		</div>
		<table id="tblShow" border="1">
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
				<!-- <th>Menu</th> -->
			</tr>
			<%!int i = 1; %> 
			<c:forEach items="${listStudent}" var="student">
				<tr>
					<td><% out.print(i);i++; %></td>
					<%-- <td><a href="ViewStudent?id=${student.id}" title="Xem Thông tin sinh viên">${student.id}</a></td> --%>
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
					<%-- <td><a href="<%=request.getContextPath()%>/editStudent?id=${student.id}">
							<button class="btn btnEdit"><i class="fas fa-edit" aria-hidden="true"></i>Sửa</button>
						</a> | 
						<a href="<%=request.getContextPath()%>/deleteStudent?id=${student.id}">
							<button class="btn btnDelete"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button>
						</a>
						<!-- <button class="btn btnDelete" id="btnDel"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button> -->
						</td> --%>
				</tr>
			</c:forEach>
			<%i = 1; %>
			<%-- 			<tr><td colspan="9"><a href="<%=request.getContextPath()%>/View/test.jsp" href="createStudent" >Create new</a></td></tr> --%>
		</table>
		<button id="btnAdd">
				<i class="fas fa-plus-circle"></i>Thêm Mới
			</button>
	</div>
	<div class="createStd">
		<form class="createStdFrm" action="<%=request.getContextPath()%>/CreateStudent" method="post">
		<table border='1'>
			<th colspan="2"><h1>Thêm thí sinh mới</h1></th>
			<tr>
				<td><label for="studentID">Mã sinh viên (*)</label></td>
				<td><input type="text" id="studentID" name="studentID" value="" required="required"></td>
				
			</tr>
			<tr>
				<td><label for="studentName">Họ và tên</label></td>
				<td><input type="text" id="studentName" name="studentName" value="" required="required"></td>
				
			</tr>
			<tr>
				<td><label for="studentBirth">Ngày sinh</label></td>
				<td><input type="date" id="studentBirth" name="studentBirth" value=""></td>
				
			</tr>
			<tr>
				<td><label for="">Giới tính</label></td>
				<td><input type="radio" name="studentSex" value="1" id="male" checked>
					<label for="male">Nam</label>
					<input type="radio" name="studentSex" value="0" id="female"> 
					<label for="female">Nữ</label></td>
				
			</tr>
			<tr>
				<td><label for="studentPlaceCode">Quê quán</label></td>
				<td><select class="" name="studentPlaceCode" id="studentPlaceCode">
						<option value="0">----Chọn tỉnh----</option>
						<c:forEach items="${listProvince}" var="province">
							<option value="${province.code}">${province.name}</option>
						</c:forEach>
				</select> <span class="addPrv" title="Thêm tỉnh mới"><i class="far fa-plus-square"></i></span></td>
				
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
				<td colspan="2">
				<button class="btn btnSave"><i class="far fa-save"></i>Lưu</i></button>
				<span class="cancer">Hủy</span> 	
				</td>
			</tr>
		</table>
	</form>
</div>
	<div class="editStd">
		<form class="editStdFrm" action="<%=request.getContextPath()%>/" method="post">
		<table border='1'>
			<th colspan="2"><h1>Thông tin sinh viên</h1></th>
			<tr>
				<td><label for="studentID_">Mã sinh viên (*)</label></td>
				<td><input type="text" id="studentID_" name="studentID" value="" required="required"></td>
				
			</tr>
			<tr>
				<td><label for="studentName_">Họ và tên</label></td>
				<td><input type="text" id="studentName_" name="studentName" value="" required="required"></td>
				
			</tr>
			<tr>
				<td><label for="studentBirth_">Ngày sinh</label></td>
				<td><input type="date" id="studentBirth_" name="studentBirth" value=""></td>
				
			</tr>
			<tr>
				<td><label for="male_">Giới tính</label></td>
				<td><input type="radio" name="studentSex" value="1" id="male_" checked>
					<label for="male_">Nam</label>
					<input type="radio" name="studentSex" value="0" id="female_"> 
					<label for="female_">Nữ</label></td>
				
			</tr>
			<tr>
				<td><label for="studentPlaceCode_">Quê quán</label></td>
				<td><select class="" name="studentPlaceCode" id="studentPlaceCode_">
						<option value="1">----Chọn tỉnh----</option>
						<c:forEach items="${listProvince}" var="province">
							<option value="${province.code}">${province.name}</option>
						</c:forEach>
				</select> <span class="addPrv" title="Thêm tỉnh mới"><i class="far fa-plus-square"></i></span></td>
				
			</tr>
			<tr>
				<td><label for="math_">Điểm toán</label></td>
				<td><input type="text" id="math_" name="math" value=""></td>
				
			</tr>
			<tr>
				<td><label for="physical_">Điểm lý</label></td>
				<td><input type="text" id="physical_" name="physical" value=""></td>
				
			</tr>
			<tr>
				<td><label for="chemistry_">Điểm hóa</label></td>
				<td><input type="text" id="chemistry_" name="chemistry" value=""></td>
			</tr>
			<tr>
				<td colspan="2">
				<button class="btn btnSave"><i class="far fa-save"></i>Lưu</i></button>
				<button type="button" class="btn btnDelete" id="btnDel"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button>
				<span class="cancer">Hủy</span> 	
				</td>
			</tr>
		</table>
	</form>
</div>

	<div class="createPrv">
		<form class="createPrvFrm" action="<%=request.getContextPath()%>/CreateProvince" method="post">
		<table border='1' style="width:20%">
			<th colspan="2"><h1>Thêm Tỉnh Mới</h1></th>
			<tr>
				<td><label for="provinceCode">Mã tỉnh (*)</label></td>
				<td><input type="text" id="provinceCode" name="provinceCode" value=""></td>
				<br />
			</tr>
			<tr>
				<td><label for="provinceName">Tên</label></td>
				<td><input type="text" id="provinceName" name="provinceName" value=""></td>
				<br />
			</tr>
			<tr>
				<td colspan="2">
					<button class="btn btnSave"><i class="far fa-save"></i>Lưu</i></button>
					<span class="cancer">Hủy</span>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="accept">
		<table class="acceptFrm">
			<th>Xóa thí sinh</th>
			<tr><td>Bạn có chắc muốn xóa?</td></tr>
			<tr>
				<td><a id="deleteLink" href="<%=request.getContextPath()%>/#">
					<button class="btn btnDelete"><i class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</button>
				</a>
				<span class="cancer">Hủy</span></td>
			</tr>
		</table>
	</div>
	<div id="dialogMess" title="Thông báo">
		<p></p>
	</div>
		<script type="text/javascript">
			$(document).ready(function(){
				//xử lý các button
				$("#btnAdd").click(function(){
					$(".createStd").fadeToggle();
				});
				
				$("#btnDel").click(function(){
					$(".accept").fadeToggle();
				});
				
				$(".addPrv").click(function(){
					$(".createPrv").fadeToggle();
				});
				
				$(".cancer").click(function(){
					$(".createStd,.createPrv,.editStd,.accept").hide();
				});
				//xử lý khi ấn vào mỗi tr
				$("#tblShow tr").click(function(){
					//$(this).css("background","red");
					//lấy các value của tr
					var id = $(this).find('td:nth-child(2)').text();
					$('.editStd #studentID_').val(id);
					$('.editStd #studentName_').val($(this).find('td:nth-child(3)').text());
					$('.editStd #studentBirth_').val($(this).find('td:nth-child(4)').text());
					$('.editStd #studentSex_').val($(this).find('td:nth-child(5)').text());
					$('.editStd #studentPlace_ option:first').text($(this).find('td:nth-child(6)').text());
					$('.editStd #math_').val($(this).find('td:nth-child(7)').text());
					$('.editStd #physical_').val($(this).find('td:nth-child(8)').text());
					$('.editStd #chemistry_').val($(this).find('td:nth-child(9)').text());
					
					//hiện form
					$(".editStd").fadeToggle();	
					
					//sửa link href
					$(".editStdFrm").attr("action","EditStudent?id="+id);
					$("#deleteLink").attr("href","deleteStudent?id="+id);
				});
			});
			
			
			//validate input
					function validateInputSpecialChar(para) {
						var specialChar = "`~!@#$%^&*()";
						if (para == "idSearch") {
							var content = $("#idSearch").val();
							content = content.trim();
							for (var i = 0; i < content.length; i++) {
								if (specialChar.indexOf(content.charAt(i)) != -1) {
									content = content.replace(content.charAt(i),'');
								}
							}
							$("#idSearch").val(content);	
						}
					}
			
			//validate number
				$("#studentID").onkeypress(e) {
				
				
			}
		</script>

</body>
</html>