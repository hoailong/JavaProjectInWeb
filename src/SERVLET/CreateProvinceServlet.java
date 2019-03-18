package SERVLET;

import java.io.IOException;
import java.sql.Connection;

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
 * Servlet implementation class CreateProvinceView
 */
@WebServlet("/CreateProvince")
public class CreateProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProvinceServlet() {
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
		
		int code = Integer.parseInt(request.getParameter("provinceCode"));
		String name = request.getParameter("provinceName");
		
		ProvinceDTO prvDTO = new ProvinceDTO(name, code);
		
		Connection conn = DBUtil.getSqlConn();
		
		ProvinceDAO prvDao = new ProvinceDAO(conn);
		
		if(prvDao.insertProvince(prvDTO)) {
			request.setAttribute("msg", "Thêm tỉnh mới thành công!");
		}
		
		else {
			request.setAttribute("msg", "Thêm prvDTO mới không thành công!");
		}
		
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
