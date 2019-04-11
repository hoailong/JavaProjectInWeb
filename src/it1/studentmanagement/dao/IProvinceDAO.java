package it1.studentmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import it1.studentmanagement.dto.ProvinceDTO;

public interface IProvinceDAO {
	public List<ProvinceDTO> getAllProvinces() throws SQLException;
	public void insertProvince(String name) throws SQLException;
	public void deleteProvince(int provinceId) throws SQLException;
	public void updateProvince(String name, int id) throws SQLException;
}
