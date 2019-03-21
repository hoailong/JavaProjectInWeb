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
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSearch = request.getParameter("idSearch");
		String placeSearch = request.getParameter("placeSearch");
		
			Connection conn = DBUtil.getSqlConn();
	//		DBUtil.closeConnect(conn);
			StudentDAO stdDao = new StudentDAO(conn);
			List<StudentDTO> listStd = stdDao.findStudent(idSearch, placeSearch);
			
			ProvinceDAO prvDao = new ProvinceDAO(conn);
			List<ProvinceDTO> listPrv = prvDao.showProvince();
			
			request.setAttribute("idSearch", idSearch);
			request.setAttribute("placeSearch", placeSearch);
			//
			request.setAttribute("listProvince", listPrv);
			//
			request.setAttribute("listStudent", listStd);
			
			
			//đóng connection
			DBUtil.closeConnect(conn);
			
			//chuyển hướng trang  về jsp
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/index.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
