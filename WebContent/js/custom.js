//jquery
$(document).ready(function(){
	//xử lý tab menu
	$(".btnhome").click(function(){
	  $(".content").show();
	  $(".about").hide();
	  $(this).addClass("active");
	  $(".btnabout").removeClass("active");
	});
	$(".btnabout").click(function(){
		  $(".about").show();
	  $(".content").hide();
	  $(this).addClass("active");
	  $(".btnhome").removeClass("active");
	});
	
	//xử lý khi ấn ESC thì ẩn các form
	$("body").keydown(function(e) {
		if (e.keyCode == 27) {
			$(".createStd,.editStd,.prvForm,.createPrv, .editPrv, .accept").hide();
		}
	})
	//xử lý khi ấn vào các button form hiện lên
	$("#btnAdd").click(function(){
		$(".createStd").fadeToggle();
	});
	
	$("#btnDel").click(function(){
		$(".accept").fadeToggle();
	});
	
	$("#btnDelPrv").click(function(){
		$(".accept").fadeToggle();
	});
	
	$(".addPrv").click(function(){
		$(".prvForm").fadeToggle();
	});
	
	$("#btnAddPrv").click(function(){
		$(".createPrv").fadeToggle();
	});
	
	//xử lý khi ấn vào nút hủy thì ẩn các form
	$(".cancer").click(function(){
		$(".createStd,.editStd").hide();
	});
	
	$(".cancer2").click(function(){
		$(".prvForm").hide();
	});
	
	$(".cancer3").click(function(){
		$(".createPrv, .editPrv, .accept").hide();
	});
	
	//xử lý khi ấn vào mỗi tr thì lấy thông tin và cho vào form
	$("#tblShow .stdTr").click(function(){
		//$(this).css("background","red");
		//lấy các value của tr
		var id = $(this).find('td:nth-child(2)').text();
		$('.editStd #studentID_').val(id);
		$('.editStd #studentName_').val($(this).find('td:nth-child(3)').text());
		$('.editStd #studentBirth_').val($(this).find('td:nth-child(4)').text());
		var gender = $(this).find('td:nth-child(5)').text().trim();
		if (gender == "Nam") {
			$('.editStd input[type = "radio"]:odd').attr("checked");
			$('.editStd input[type = "radio"]:even').prop("checked",true);
		}
		else {
			$('.editStd input[type = "radio"]:odd').prop("checked",true);
			$('.editStd input[type = "radio"]:even').attr("checked")
		}
		$('.editStd #math_').val($(this).find('td:nth-child(7)').text());
		$('.editStd #physical_').val($(this).find('td:nth-child(8)').text());
		$('.editStd #chemistry_').val($(this).find('td:nth-child(9)').text());
		var placeId = $(this).find('td:nth-child(10)').text();
		var placeName = $(this).find('td:nth-child(6)').text();
		$('.optStd').attr("value",placeId);
		$('.optStd').text(placeName);
		
		//hiện form
		$(".editStd").fadeToggle();	
		
		//sửa link href
		$(".editStdFrm").attr("action","EditStudent?id="+id);
		$("#deleteLink").attr("href","DeleteStudent?id="+id);
		$("#btnPrt").click(function(){
			$("#printLink").attr("href","PrintStudent?id="+id);
		})
	});
	
	
	//xử lý khi ấn vào mỗi tr province thì lấy thông tin tr 
	$('.prvForm .prvTr').click(function(){
		var id = $(this).find('td:nth-child(1)').text();
		var name = $(this).find('td:nth-child(2)').text();
		$(".editPrvFrm").attr("action","EditProvince?id="+id);
		$("#deleteLink").attr("href","DeleteProvince?id="+id);
		$('.editPrv #provinceId_').val(id);
		$('.editPrv #provinceName_').val(name);
		
		//hiện form
		$('.editPrv').fadeToggle();
	});
});


//không cho nhập ký tự đặc biệt vào tên tỉnh và tên sinh viên
function validateInputSpecialChar(para) {
	var specialChar = "`~!@#$%^&*()[]{}\|/\\<>?";
	//tên tỉnh
	if (para == "provinceName") {
		var content = $("#provinceName").val();
//		content = content.trim();
		for (var i = 0; i < content.length; i++) {
			if (specialChar.indexOf(content.charAt(i)) != -1) {
				content = content.replace(content.charAt(i),'');
			}
		}
		$("#provinceName").val(content);	
	}
	//tên sinh viên thêm mới
	if (para == "studentName") {
		var content = $("#studentName").val();
//		content = content.trim();
		for (var i = 0; i < content.length; i++) {
			if (specialChar.indexOf(content.charAt(i)) != -1) {
				content = content.replace(content.charAt(i),'');
			}
		}
		$("#studentName").val(content);	
	}
	//tên sinh viên sửa
	if (para == "studentName_") {
		var content = $("#studentName_").val();
//		content = content.trim();
		for (var i = 0; i < content.length; i++) {
			if (specialChar.indexOf(content.charAt(i)) != -1) {
				content = content.replace(content.charAt(i),'');
			}
		}
		$("#studentName_").val(content);	
	}
}