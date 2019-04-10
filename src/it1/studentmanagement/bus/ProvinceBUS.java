package it1.studentmanagement.bus;

import java.sql.SQLException;
import java.util.List;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dao.StudentDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

public class ProvinceBUS implements IProvinceBUS {
	private ProvinceDAO prvDao;
	private StudentDAO stdDao;

	public ProvinceBUS() {
		this.prvDao = new ProvinceDAO();
		this.stdDao = new StudentDAO();
	}

	@Override
	public List<ProvinceDTO> findAll() {
		try {
			List<ProvinceDTO> list = prvDao.getProvinceList();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insert(String name) {
		name = FormatString.formatName(name);
		if (checkConstant(name)) {
			return "Không thành công! Tỉnh đã tồn tại!";
		} else {
			try {
				prvDao.insertProvince(name);
				return "Thêm thành công!";
			} catch (SQLException e) {
				return "Không thành công! " + e.toString();
			}
		}
	}

	@Override
	public String update(int id, String name) {
		name = FormatString.formatName(name);
		if (checkConstant(name)) {
			return "Không thành công! Tỉnh đã tồn tại!";
		} else {
			try {
				prvDao.updateProvince(name, id);
				return "Cập nhật thành công!";
			} catch (SQLException e) {
				return "Cập nhật không thành công! " + e.toString();
			}
		}
	}

	@Override
	public String delete(int id) {
		try {
			for (StudentDTO stdDto : stdDao.getAllStudents()) {
				if (stdDto.getPlace().getId() == id) {
					return "Xóa không thành công!\nTỉnh có thí sinh!";
				}
			}
			prvDao.deleteProvince(id);
			return "Xóa thành công!";
		} catch (SQLException e) {
			return "Xóa không thành công! " + e.toString();
		}
	}	

	@Override
	public boolean checkConstant(String name) {
		for (ProvinceDTO prv : findAll()) {
			if (prv.getName().equals(name))
				return true;
		}
		return false;
	}
}
