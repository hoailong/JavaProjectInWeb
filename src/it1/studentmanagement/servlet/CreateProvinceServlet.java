package it1.studentmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.bus.FormatName;
import it1.studentmanagement.bus.ProvinceBUS;
import it1.studentmanagement.dao.ProvinceDAO;

@WebServlet("/CreateProvince")
public class CreateProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateProvinceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sử dụng đc tiếng việt
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("provinceName");
		name = FormatName.formatName(name);
		
		String message = null;
		ProvinceDAO prvDao = new ProvinceDAO();
		
		try {
			//kiểm tra xem tỉnh mới đã tồn tại chưa
			if (ProvinceBUS.checkConstant(name)) {
				message =  "Thêm tỉnh mới không thành công!Tỉnh đã tồn tại!";
			}
			else {
				prvDao.insertProvince(name);
				message =  "Thêm tỉnh mới thành công!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			message = "Thêm tỉnh mới không thành công!\nLỗi: " + e.getMessage();
		}
		
		request.setAttribute("msg", message);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
