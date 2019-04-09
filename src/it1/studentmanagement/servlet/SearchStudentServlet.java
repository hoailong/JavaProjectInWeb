package it1.studentmanagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it1.studentmanagement.bus.ProvinceBUS;
import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchStudentServlet() {
        super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idStdSearch");
		String place = request.getParameter("namePlaceSearch");
		
		int page = 1;
		int count = 10;
		int totalPage = 1;
		int record = 0;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			count = Integer.parseInt(request.getParameter("count"));
		} catch (NumberFormatException e) {
			
		}
		ProvinceBUS prvBus = new ProvinceBUS();
		StudentBUS stdBus = new StudentBUS();
		List<StudentDTO> listStd = stdBus.findStudentByIdAndPlace(id, place);
		List<ProvinceDTO> listPrv = prvBus.findAll();
		record = listStd.size();
		count = record/5 * 5 + 5;
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("record", record);
		request.setAttribute("idStdSearch", id);
		request.setAttribute("namePlaceSearch", place);
		request.setAttribute("listProvince", listPrv);
		request.setAttribute("listStudent", listStd);

		//chuyển hướng trang  về jsp
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/View/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
