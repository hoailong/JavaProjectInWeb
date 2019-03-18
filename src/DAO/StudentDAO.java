package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ProvinceDTO;
import DTO.StudentDTO;

public class StudentDAO implements IStudentDAO {
	private Connection conn;

	public StudentDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<StudentDTO> showStudent(){
		String sql = "SELECT s.ID, s.Name, s.Birth, s.Sex, s.Math, s.Physical, s.Chemistry, p.Name as pName, p.Code "
				+ "FROM student s, province p WHERE s.Place = p.Code ";

		List<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				int pCode = rs.getInt("Code");
				String pName = rs.getString("pName");
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				int sex = rs.getInt("Sex");
				float math = rs.getFloat("Math");
				float physical = rs.getFloat("Physical");
				float chemistry = rs.getFloat("Chemistry");
				StudentDTO std = new StudentDTO(id, name, new ProvinceDTO(pName, pCode), birth, sex, math, physical, chemistry);
				list.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public StudentDTO findStudent(int idSearch) {
//		String sql = "Select * from Student where id = ?";
		String sql = "SELECT s.ID, s.Name, s.Birth, s.Sex, s.Math, s.Physical, s.Chemistry, p.Name as pName, p.Code "
				+ "FROM student s, province p WHERE s.Place = p.Code and s.ID = ?";
		
		PreparedStatement pstm;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idSearch);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int pCode = rs.getInt("Code");
				String pName = rs.getString("pName");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				int sex = rs.getInt("Sex");
				float math = rs.getFloat("Math");
				float physical = rs.getFloat("Physical");
				float chemistry = rs.getFloat("Chemistry");
				StudentDTO std = new StudentDTO(idSearch, name, new ProvinceDTO(pName, pCode), birth, sex, math, physical, chemistry);
				return std;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentDTO> findStudent(String idSearch, String placeSearch) {
		String sql = "SELECT s.ID, s.Name, s.Birth, s.Sex, s.Math, s.Physical, s.Chemistry, p.Name as pName, p.Code "
				+ "FROM student s, province p WHERE s.Place = p.Code AND s.ID LIKE '" + idSearch + "%' AND  p.Code LIKE '" + placeSearch +"%'";
		
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				int pCode = rs.getInt("Code");
				String pName = rs.getString("pName");
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String birth = rs.getString("Birth");
				int sex = rs.getInt("Sex");
				float math = rs.getFloat("Math");
				float physical = rs.getFloat("Physical");
				float chemistry = rs.getFloat("Chemistry");
				StudentDTO std = new StudentDTO(id, name, new ProvinceDTO(pName, pCode), birth, sex, math, physical, chemistry);
				list.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insertStudent(StudentDTO std) {
		String sql = "Insert into Student(ID,Name,Place,Birth,Sex,Math,Physical,Chemistry) values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, std.getId());
			pstm.setString(2, std.getName());
			pstm.setInt(3, std.getPlace().getCode());
			pstm.setString(4, std.getBirth());
			pstm.setInt(5, std.getSex());
			pstm.setFloat(6, std.getMath());
			pstm.setFloat(7, std.getPhysical());
			pstm.setFloat(8, std.getChemistry());
			
			if (pstm.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateStudent(StudentDTO std, int id) {
		String sql = "Update Student set ID = ?, Name = ?, Place = ?,Birth = ? ,Sex = ? ,Math = ?, Physical = ?, Chemistry = ? where ID = ?";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, std.getId());
			pstm.setString(2, std.getName());
			pstm.setInt(3, std.getPlace().getCode());
			pstm.setString(4, std.getBirth());
			pstm.setInt(5, std.getSex());
			pstm.setFloat(6, std.getMath());
			pstm.setFloat(7, std.getPhysical());
			pstm.setFloat(8, std.getChemistry());
			pstm.setInt(9, id);
			
			if (pstm.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		String sql = "Delete Student where ID = ?";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			if (pstm.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
