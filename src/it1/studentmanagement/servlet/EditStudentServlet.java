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

@WebServlet("/EditStudent")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sử dụng đc tiếng việt
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int idUpdate = Integer.parseInt(request.getParameter("id"));
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
			boolean canUpdate = true;
			
			//kiểm tra xem có thay  đổi mã thí sinh không
			if (idUpdate != id) {
				//kiểm tra xem mã thí sinh mới đã tồn tại hay chưa 
				if (StudentBUS.checkConstant(id)) {
					canUpdate = false;
					message =  "Update thí sinh không thành công! Mã thí sinh đã tồn tại!";
				}
			}
			
			//nếu không thay đổi mã thí sinh hoặc mã thí sinh mới chưa tồn tại 
			if (canUpdate) {
				stdDao.updateStudent(stdDTO,idUpdate);
				message =  "Update thí sinh thành công!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			message = "Update thí sinh không thành công!\nLỗi: " + e.getMessage();
		} 
//		finally {
			request.setAttribute("msg", message);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
			rd.forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
