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

import org.apache.jasper.tagplugins.jstl.core.Catch;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dao.StudentDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message1 = null;
		int page = 1;
		int count = 10;
		int totalPage = 1;
		int record = 0;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			count = Integer.parseInt(request.getParameter("count"));
		} catch (NumberFormatException e) {
			
		}
		StudentDAO stdDao = new StudentDAO();
		ProvinceDAO prvDao = new ProvinceDAO();
		List<StudentDTO> listStd = null;
		List<ProvinceDTO> listPrv = null;
		try {
			listStd = stdDao.showStudent((page-1)*count,count);
			listPrv = prvDao.showProvince();
			record = stdDao.getCountRow();
			totalPage = (int) Math.ceil((double)record/count);
		} catch (SQLException e) {
			e.printStackTrace();
			message1 = "Lỗi: " + e.getMessage();
		}
		
		request.setAttribute("msg1", message1);
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("record", record);
		request.setAttribute("totalPage", totalPage);
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
