package it1.studentmanagement.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.bus.StudentBUS;
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
		String birth = request.getParameter("studentBirth");
		int gender = Integer.parseInt(request.getParameter("studentGender"));
		int placeId = Integer.parseInt(request.getParameter("studentPlaceId"));
		float math = Float.parseFloat(request.getParameter("math"));
		float physical = Float.parseFloat(request.getParameter("physical"));
		float chemistry = Float.parseFloat(request.getParameter("chemistry"));
		StudentDTO stdDTO = new StudentDTO(id, name, new ProvinceDTO("", placeId), birth, gender, math, physical, chemistry);

		StudentBUS stdBus = new StudentBUS();
		String message = stdBus.insert(stdDTO);
		request.setAttribute("msg", message);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
