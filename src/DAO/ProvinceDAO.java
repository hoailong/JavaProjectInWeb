package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ProvinceDTO;
import JDBC.DBUtil;

public class ProvinceDAO implements IProvinceDAO{
	private Connection conn;

	public ProvinceDAO(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<ProvinceDTO> showProvince() {
		String sql = "SELECT * FROM province";
		//tạo mới connection ở đây:
		//Connection conn = DBUtil.getSqlConn();
		
		List<ProvinceDTO> list = new ArrayList<ProvinceDTO>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			
			while (result.next()) {
				int provinceId = result.getInt("province_id");
				String provinceName = result.getString("name");
				ProvinceDTO province = new ProvinceDTO(provinceName, provinceId);
				list.add(province);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//đóng luôn connection ở đây
		//conn.close
		return list;
	}

	@Override
	public boolean insertProvince(ProvinceDTO province) {
		String sqlQuery = "INSERT INTO province(province_id, name) VALUES (?,?)";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sqlQuery);
			pstm.setInt(1, province.getId());
			pstm.setString(2, province.getName());
			if (pstm.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProvince(ProvinceDTO prv, int code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProvince(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
