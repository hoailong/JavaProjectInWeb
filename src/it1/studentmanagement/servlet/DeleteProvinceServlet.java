package it1.studentmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.dao.ProvinceDAO;

@WebServlet("/DeleteProvince")
public class DeleteProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteProvinceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String message = null;
		ProvinceDAO prvDao = new ProvinceDAO();
		
		try {
			prvDao.deleteProvince(id);
			message =  "Xóa tỉnh thành công!";
		} catch (SQLException e) {
			e.printStackTrace();
			message =  "Xóa tỉnh không thành công!";
			message = "\nLỗi: " + e.getMessage();
		}
		
		request.setAttribute("msg", message);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
