package SERVLET;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProvinceDAO;
import DAO.StudentDAO;
import DTO.ProvinceDTO;
import DTO.StudentDTO;
import JDBC.DBUtil;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		Connection conn = DBUtil.getSqlConn();
//		DBUtil.closeConnect(conn);
		StudentDAO stdDao = new StudentDAO(conn);
		List<StudentDTO> listStd = stdDao.showStudent();
		
		ProvinceDAO prvDao = new ProvinceDAO(conn);
		List<ProvinceDTO> listPrv = prvDao.showProvince();
		
		//
		request.setAttribute("listProvince", listPrv);
		//
		request.setAttribute("listStudent", listStd);
		//
//		request.setAttribute("msg", "Thông báo");
		//đóng connection
		DBUtil.closeConnect(conn);
		
		//chuyển hướng trang  về jsp
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
