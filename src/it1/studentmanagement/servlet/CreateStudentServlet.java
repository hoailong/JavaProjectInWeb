package it1.studentmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.bus.FormatName;
import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dao.StudentDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

@WebServlet("/CreateStudent")
public class CreateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateStudentServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//sử dụng đc tiếng việt
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//lấy thông tin đã nhập trên form
		int id = Integer.parseInt(request.getParameter("studentID"));
		String name = request.getParameter("studentName");
		name = FormatName.formatName(name);
		String birth = request.getParameter("studentBirth");
		int gender = Integer.parseInt(request.getParameter("studentGender"));
		int placeId = Integer.parseInt(request.getParameter("studentPlaceId"));
		float math = Float.parseFloat(request.getParameter("math"));
		float physical = Float.parseFloat(request.getParameter("physical"));
		float chemistry = Float.parseFloat(request.getParameter("chemistry"));
		
		StudentDTO stdDTO = new StudentDTO(id, name, new ProvinceDTO("", placeId), birth, gender, math, physical, chemistry);
		
		String message = null;
		StudentDAO stdDao = new StudentDAO();
		
		try {
			//kiểm tra xem mã thí sinh đã tồn tại hay chưa 
			if (StudentBUS.checkConstant(id)) {
				message =  "Thêm thí sinh mới không thành công! Mã thí sinh đã tồn tại!";
			}
			
			//nếu chưa tồn tại thì tiến hành thêm
			else {
				stdDao.insertStudent(stdDTO);
				message =  "Thêm thí sinh mới thành công!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			message =  "Thêm thí sinh mới không thành công!";
			message = "\nLỗi: " + e.getMessage();
		}
		
<<<<<<< HEAD:src/it1/studentmanagement/servlet/CreateStudentServlet.java
		request.setAttribute("msg", message);
=======
		else {
			request.setAttribute("msg", "Thêm sinh viên mới không thành công!");
		}
		
		//đóng connection
		DBUtil.closeConnect(conn);
		
>>>>>>> 7f99c9649e0e0c7e680bc1756a8cfb86a0cb772b:src/SERVLET/CreateStudentServlet.java
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
		rd.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
