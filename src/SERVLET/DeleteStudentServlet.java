package SERVLET;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import JDBC.DBUtil;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
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
		
		if(stdDao.deleteStudent(id)) {
			request.setAttribute("msg", "Xóa sinh viên mới thành công!");
		}
		
		else {
			request.setAttribute("msg", "Xóa sinh viên mới không thành công!");
		}
		
		//đóng connection
		DBUtil.closeConnect(conn);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
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
