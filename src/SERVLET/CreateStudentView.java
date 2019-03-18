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
import DTO.ProvinceDTO;
import JDBC.DBUtil;

/**
 * Servlet implementation class CreateStudentServlet
 */
@WebServlet("/createStudent")
public class CreateStudentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStudentView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBUtil.getSqlConn();
		
		ProvinceDAO prvDao = new ProvinceDAO(conn);
		List<ProvinceDTO> listPrv = prvDao.showProvince();
		
		request.setAttribute("listProvince", listPrv);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/createStudentView.jsp");
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
