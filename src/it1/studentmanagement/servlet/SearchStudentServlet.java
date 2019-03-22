package it1.studentmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dao.StudentDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchStudentServlet() {
        super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStdSearch = request.getParameter("idStdSearch");
		String idPlaceSearch = request.getParameter("idPlaceSearch");
		
		String message = null;
		StudentDAO stdDao = new StudentDAO();
		ProvinceDAO prvDao = new ProvinceDAO();
		List<StudentDTO> listStd = null;
		List<ProvinceDTO> listPrv = null;
		
		try {
			listStd = stdDao.findStudent(idStdSearch, idPlaceSearch);
			listPrv = prvDao.showProvince();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Lỗi: " + e.getMessage();
		}
		
		
		request.setAttribute("msg", message);
		request.setAttribute("idStdSearch", idStdSearch);
		request.setAttribute("idPlaceSearch", idPlaceSearch);
		request.setAttribute("listProvince", listPrv);
		request.setAttribute("listStudent", listStd);

		//chuyển hướng trang  về jsp
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
