package it1.studentmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;
import it1.studentmanagement.jdbc.DBUtil;

public class StudentDAO implements IStudentDAO {
	@Override
	public List<StudentDTO> showStudent() throws SQLException{
		//tạo mới connection ở đây:
		Connection conn = DBUtil.getSqlConn();
		String sql = "SELECT s.student_id, s.name as student_name, s.dob, s.gender, s.math, s.physical, s.chemistry, p.name as province_name, p.province_id "
				+ "FROM student s, province p WHERE s.province_id = p.province_id";

		List<StudentDTO> list = new ArrayList<StudentDTO>();
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
		//đóng luôn connection ở đây
		conn.close();
		return list;
	}

	@Override
	public StudentDTO findStudent(int idSearch) throws SQLException {
		//tạo mới connection ở đây:
		Connection conn = DBUtil.getSqlConn();
		String sql = "SELECT s.student_id, s.name, s.dob, s.gender, s.math, s.physical, s.chemistry, p.name as province_name, p.province_id "
				+ "FROM student s, province p WHERE s.province_id = p.province_id AND s.student_id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idSearch);
		ResultSet result = pstm.executeQuery();
		while (result.next()) {
			int provinceId = result.getInt("province_id");
			String provinceName = result.getString("province_name");
			int studentId = result.getInt("student_id");
			String studentName = result.getString("name");
			String studentDob = result.getString("dob");
			int studentGender = result.getInt("gender");
			float math = result.getFloat("math");
			float physical = result.getFloat("physical");
			float chemistry = result.getFloat("chemistry");
			StudentDTO student = new StudentDTO(studentId, studentName, new ProvinceDTO(provinceName, provinceId), studentDob, studentGender, math, physical, chemistry);
			return student;
			} 			
		//đóng luôn connection ở đây
		conn.close();
		return null;
	}

	@Override
	public List<StudentDTO> findStudent(String idSearch, String placeSearch) throws SQLException {
		//tạo mới connection ở đây:
		Connection conn = DBUtil.getSqlConn();
		String sql = "SELECT student_id, s.name, s.dob, s.gender, s.math, s.physical, s.chemistry, p.name as province_name, p.province_id  FROM student s,province p WHERE s.province_id = p.province_id AND s.student_id LIKE '" + idSearch + "%' AND  p.province_id LIKE '" + placeSearch + "%'";
//		String sql = "SELECT student_id, s.name, s.dob, s.gender, s.math, s.physical, s.chemistry, p.name as province_name, p.province_id  FROM student s,province p WHERE s.province_id = p.province_id AND s.student_id LIKE ? AND  p.province_id LIKE ?";
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet result = pstm.executeQuery();
		while (result.next()) {
			int provinceId = result.getInt("province_id");
			String provinceName = result.getString("province_name");
			int studentId = result.getInt("student_id");
			String studentName = result.getString("name");
			String studentDob = result.getString("dob");
			int studentGender = result.getInt("gender");
			float math = result.getFloat("math");
			float physical = result.getFloat("physical");
			float chemistry = result.getFloat("chemistry");
			StudentDTO student = new StudentDTO(studentId, studentName, new ProvinceDTO(provinceName, provinceId), studentDob, studentGender, math, physical, chemistry);
			list.add(student);
		}			
		//đóng luôn connection ở đây
		conn.close();
		return list;
	}

	@Override
	public void insertStudent(StudentDTO student) throws SQLException {
		//tạo mới connection ở đây:
		Connection conn = DBUtil.getSqlConn();
		String sql = "INSERT INTO student(student_id, name, province_id, dob, gender, math, physical, chemistry) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, student.getId());
		pstm.setString(2, student.getName());
		pstm.setInt(3, student.getPlace().getId());
		pstm.setString(4, student.getBirth());
		pstm.setInt(5, student.getGender());
		pstm.setFloat(6, student.getMath());
		pstm.setFloat(7, student.getPhysical());
		pstm.setFloat(8, student.getChemistry());
		pstm.executeUpdate();			
		//đóng luôn connection ở đây
		conn.close();
	}

	@Override
		public void updateStudent(StudentDTO student, int studentId) throws SQLException {
		//tạo mới connection ở đây:
		Connection conn = DBUtil.getSqlConn();
		String sql = "UPDATE student set student_id = ?, name = ?, province_id = ?, dob = ? , gender = ? , math = ?, physical = ?, chemistry = ? where student_id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, student.getId());
		pstm.setString(2, student.getName());
		pstm.setInt(3, student.getPlace().getId());
		pstm.setString(4, student.getBirth());
		pstm.setInt(5, student.getGender());
		pstm.setFloat(6, student.getMath());
		pstm.setFloat(7, student.getPhysical());
		pstm.setFloat(8, student.getChemistry());
		pstm.setInt(9, studentId);
		pstm.executeUpdate();			
		//đóng luôn connection ở đây
		conn.close();

	}

	@Override
	public void deleteStudent(int studentId) throws SQLException {
		//tạo mới connection ở đây:
		Connection conn = DBUtil.getSqlConn();
		String sql = "DELETE from student WHERE student_id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, studentId);
		pstm.executeUpdate();			
		//đóng luôn connection ở đây
		conn.close();
	}

}
