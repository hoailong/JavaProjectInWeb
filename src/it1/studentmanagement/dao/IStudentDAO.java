package it1.studentmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it1.studentmanagement.dto.StudentDTO;

public interface IStudentDAO {
	List<StudentDTO> getAllStudents() throws SQLException;
	List<StudentDTO> getStudentsWithPage(int offset, int count) throws SQLException;
	int getCountRow() throws SQLException;
	List<StudentDTO> findStudentsByIdAndPlace(String idSearch, String placeSearch) throws SQLException;
	void insertStudent(StudentDTO student) throws SQLException;
	void updateStudent(StudentDTO student) throws SQLException;
	void deleteStudent(int studentId) throws SQLException;
	List<StudentDTO> studentDTOMapper(ResultSet result) throws SQLException;
}
