package it1.studentmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import it1.studentmanagement.dto.StudentDTO;

public interface IStudentDAO {
	public List<StudentDTO> showStudent(int offset, int count) throws SQLException;
	public int getCountRow() throws SQLException;
	public StudentDTO findStudent(int idSearch) throws SQLException;
	public List<StudentDTO> findStudent(String idSearch, String placeSearch) throws SQLException;
	public void insertStudent(StudentDTO student) throws SQLException;
	public void updateStudent(StudentDTO student, int id) throws SQLException;
	public void deleteStudent(int studentId) throws SQLException;
}
