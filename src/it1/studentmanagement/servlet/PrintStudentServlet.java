package it1.studentmanagement.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dto.StudentDTO;

@WebServlet("/PrintStudent")
public class PrintStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrintStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		StudentBUS stdBus = new StudentBUS();
		StudentDTO studentDTO = stdBus.getStudentList(id, "").get(0);
		request.setAttribute("student", studentDTO);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/printStudent.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
