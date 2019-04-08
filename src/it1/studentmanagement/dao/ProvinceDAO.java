package it1.studentmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.jdbc.DBUtil;

public class ProvinceDAO implements IProvinceDAO{
	
	@Override
	public List<ProvinceDTO> getProvinceList() throws SQLException {
		String sqlQuery = "SELECT * FROM province ORDER BY name ASC";
		// Create new database connection
		Connection conn = DBUtil.getSqlConn();
		
		List<ProvinceDTO> list = new ArrayList<ProvinceDTO>();

		PreparedStatement pstm = conn.prepareStatement(sqlQuery);
		ResultSet result = pstm.executeQuery();
		
		while (result.next()) {
			int provinceId = result.getInt("province_id");
			String provinceName = result.getString("name");
			ProvinceDTO province = new ProvinceDTO(provinceName, provinceId);
			list.add(province);
		}	
		
		// Close database connection
		conn.close();
		pstm.close();
		result.close();
		return list;
	}

	@Override
	public void insertProvince(String name) throws SQLException {
		String sqlQuery = "INSERT INTO province(name) VALUES (?)";
		Connection conn = DBUtil.getSqlConn();
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sqlQuery);
		pstm.setString(1, name);
		pstm.executeUpdate();
		// Close database connection
		conn.close();
		pstm.close();
	}

	@Override
	public void updateProvince(String name, int id) throws SQLException {
		Connection conn = DBUtil.getSqlConn();
		String sqlQuery = "UPDATE province Set name = ? WHERE province_id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sqlQuery);
		pstm.setString(1, name);
		pstm.setInt(2, id);
		pstm.executeUpdate();
		
		// Close database connection
		conn.close();
		pstm.close();
	}

	@Override
	public void deleteProvince(int id) throws SQLException {
		Connection conn = DBUtil.getSqlConn();
		String sqlQuery = "DELETE FROM province WHERE province_id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sqlQuery);
		pstm.setInt(1, id);
		pstm.executeUpdate();
		
		// Close database connection
		conn.close();
		pstm.close();
	}
	
}
