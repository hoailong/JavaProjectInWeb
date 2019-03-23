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
import it1.studentmanagement.dto.StudentDTO;

@WebServlet("/PrintStudent")
public class PrintStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrintStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String message = null;
		StudentDAO stdDao = new StudentDAO();
		StudentDTO studentDTO = null;
		
		try {
			studentDTO = stdDao.findStudent(id);
		} catch (SQLException e) {
			e.printStackTrace();
			message = "Lỗi: " + e.getMessage();
		}
		
		request.setAttribute("msg", message);
		request.setAttribute("student", studentDTO);
	
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/printStudent.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
