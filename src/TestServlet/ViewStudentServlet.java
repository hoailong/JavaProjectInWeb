package TestServlet;

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
 * Servlet implementation class EditStudentView
 */
@WebServlet("/ViewStudent")
public class ViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection conn = DBUtil.getSqlConn();
		
		StudentDAO stdDao = new StudentDAO(conn);
		
		StudentDTO studentDTO = stdDao.findStudent(id);
		
		request.setAttribute("student", studentDTO);
		
		ProvinceDAO prvDao = new ProvinceDAO(conn);
		List<ProvinceDTO> listPrv = prvDao.showProvince();
		
		request.setAttribute("listProvince", listPrv);
	
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/viewStudent.jsp");
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
