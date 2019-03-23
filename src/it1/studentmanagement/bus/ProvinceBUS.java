package it1.studentmanagement.bus;

import java.sql.SQLException;
import java.util.List;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;

public class ProvinceBUS {
	public static boolean checkConstant(String provinceName) throws SQLException {
		ProvinceDAO prvDAO = new ProvinceDAO();
		List<ProvinceDTO> listPrv = prvDAO.showProvince();
		for (ProvinceDTO prv : listPrv) {
			if (prv.getName().equals(provinceName)) return true;
		}
		return  false;
	}
}
