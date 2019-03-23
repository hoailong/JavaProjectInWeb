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

@WebServlet("/EditProvince")
public class EditProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProvinceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sử dụng đc tiếng việt
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		
		String nameUpdate = request.getParameter("name");
		
		String name = request.getParameter("provinceName");
		name = FormatName.formatName(name);
		
		String message = null;
		ProvinceDAO prvDao = new ProvinceDAO();
		
		try {
			boolean canUpdate = true;
			
			//kiểm tra xem có thay  đổi mã tỉnh không
			if (!nameUpdate.equals(name)) {
				//kiểm tra xem mã tỉnh mới đã tồn tại hay chưa 
				if (ProvinceBUS.checkConstant(name)) {
					canUpdate = false;
					message =  "Update tỉnh không thành công! Tỉnh đã tồn tại!";
				}
			}
			
			//nếu không thay đổi mã tỉnh hoặc mã tỉnh mới chưa tồn tại 
			if (canUpdate) {
				prvDao.updateProvince(name,idUpdate);
				message =  "Update tỉnh thành công!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			message = "Update tỉnh không thành công!\nLỗi: " + e.getMessage();
		} 
		request.setAttribute("msg", message);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Home");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
