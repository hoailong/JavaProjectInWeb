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
import DTO.ProvinceDTO;
import DTO.StudentDTO;
import JDBC.DBUtil;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/EditStudent")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sử dụng đc tiếng việt
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		//lấy thông tin đã nhập trên form
		int id = Integer.parseInt(request.getParameter("studentID"));
		String name = request.getParameter("studentName");
		String birth = request.getParameter("studentBirth");
		int sex = Integer.parseInt(request.getParameter("studentSex"));
		int placeCode = Integer.parseInt(request.getParameter("studentPlaceCode"));
		float math = Float.parseFloat(request.getParameter("math"));
		float physical = Float.parseFloat(request.getParameter("physical"));
		float chemistry = Float.parseFloat(request.getParameter("chemistry"));
		
		StudentDTO stdDTO = new StudentDTO(id, name, new ProvinceDTO("", placeCode), birth, sex, math, physical, chemistry);
		Connection conn = DBUtil.getSqlConn();
		
		StudentDAO stdDao = new StudentDAO(conn);
		
		if(stdDao.updateStudent(stdDTO,idUpdate)) {
			request.setAttribute("msg", "Update sinh viên mới thành công!");
		}
		
		else {
			request.setAttribute("msg", "Update sinh viên mới không thành công!");
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
