package it1.studentmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.dao.StudentDAO;

@WebServlet("/DeleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String message = null;
		StudentDAO stdDao = new StudentDAO();
		
		try {
			stdDao.deleteStudent(id);
			message =  "Xóa thí sinh thành công!";
		} catch (SQLException e) {
			e.printStackTrace();
			message =  "Xóa thí sinh không thành công!";
			message = "\nLỗi: " + e.getMessage();
		}
		
<<<<<<< HEAD:src/it1/studentmanagement/servlet/DeleteStudentServlet.java
		request.setAttribute("msg", message);
=======
		else {
			request.setAttribute("msg", "Xóa sinh viên mới không thành công!");
		}
		
		//đóng connection
		DBUtil.closeConnect(conn);
		
>>>>>>> 7f99c9649e0e0c7e680bc1756a8cfb86a0cb772b:src/SERVLET/DeleteStudentServlet.java
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
