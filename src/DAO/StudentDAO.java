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
		String sql = "SELECT s.student_id, s.name as student_name, s.dob, s.gender, s.math, s.physical, s.chemistry, p.name as province_name, p.province_id "
				+ "FROM student s, province p WHERE s.province_id = p.province_id";

		List<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			while (result.next()) {
				int provinceId = result.getInt("province_id");
				String provinceName = result.getString("province_name");
				int studentId = result.getInt("student_id");
				String studentName = result.getString("student_name");
				String studentDob = result.getString("dob");
				int studentGender = result.getInt("gender");
				float math = result.getFloat("math");
				float physical = result.getFloat("physical");
				float chemistry = result.getFloat("chemistry");
				StudentDTO student = new StudentDTO(studentId, studentName, new ProvinceDTO(provinceName, provinceId), studentDob, studentGender, math, physical, chemistry);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public StudentDTO findStudent(int idSearch) {
//		String sql = "Select * from Student where id = ?";
		String sql = "SELECT s.student_id, s.name, s.dob, s.gender, s.math, s.physical, s.chemistry, p.name as province_name, p.province_id "
				+ "FROM student s, province p WHERE s.province_id = p.province_id AND s.student_id = ?";
		
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idSearch);
			ResultSet result = pstm.executeQuery();
			while (result.next()) {
				int provinceId = result.getInt("province_id");
				String provinceName = result.getString("province_name");
				int studentId = result.getInt("student_id");
				String studentName = result.getString("student_name");
				String studentDob = result.getString("dob");
				int studentGender = result.getInt("gender");
				float math = result.getFloat("math");
				float physical = result.getFloat("physical");
				float chemistry = result.getFloat("chemistry");
				StudentDTO student = new StudentDTO(studentId, studentName, new ProvinceDTO(provinceName, provinceId), studentDob, studentGender, math, physical, chemistry);
				return student;
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<StudentDTO> findStudent(String idSearch, String placeSearch) {
		String sql = "SELECT student_id, s.name, s.dob, s.gender, s.math, s.physical, s.chemistry, p.name as province_name, p.province_id "
				+ "FROM student s, province p WHERE s.province_id = p.province_id AND student_id LIKE ? AND  p.Code LIKE ?";
		
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			while (result.next()) {
				int provinceId = result.getInt("province_id");
				String provinceName = result.getString("province_name");
				int studentId = result.getInt("student_id");
				String studentName = result.getString("student_name");
				String studentDob = result.getString("dob");
				int studentGender = result.getInt("gender");
				float math = result.getFloat("math");
				float physical = result.getFloat("physical");
				float chemistry = result.getFloat("chemistry");
				StudentDTO student = new StudentDTO(studentId, studentName, new ProvinceDTO(provinceName, provinceId), studentDob, studentGender, math, physical, chemistry);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insertStudent(StudentDTO student) {
		String sql = "INSERT INTO student(student_id, name, province_id, dob, gender, math, physical, chemistry) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, student.getId());
			pstm.setString(2, student.getName());
			pstm.setInt(3, student.getPlace().getId());
			pstm.setString(4, student.getBirth());
			pstm.setInt(5, student.getGender());
			pstm.setFloat(6, student.getMath());
			pstm.setFloat(7, student.getPhysical());
			pstm.setFloat(8, student.getChemistry());
			if (pstm.executeUpdate() > 0) 
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateStudent(StudentDTO student, int studentId) {
		String sql = "UPDATE student set student_id = ?, name = ?, province_id = ?, dob = ? , gender = ? , math = ?, physical = ?, chemistry = ? where student_id = ?";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, student.getId());
			pstm.setString(2, student.getName());
			pstm.setInt(3, student.getPlace().getId());
			pstm.setString(4, student.getBirth());
			pstm.setInt(5, student.getGender());
			pstm.setFloat(6, student.getMath());
			pstm.setFloat(7, student.getPhysical());
			pstm.setFloat(8, student.getChemistry());
			pstm.setInt(9, studentId);
			
			if (pstm.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		String sql = "DELETE student WHERE student_id = ?";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, studentId);
			
			if (pstm.executeUpdate() > 0) { 
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
