package DAO;

import java.util.List;

import DTO.StudentDTO;

public interface IStudentDAO {
	public List<StudentDTO> showStudent();
	public boolean insertStudent(StudentDTO student);
	public boolean updateStudent(StudentDTO student, int id);
	public boolean deleteStudent(int studentId);
	public StudentDTO findStudent(int idSearch);
	public List<StudentDTO> findStudent(String idSearch, String placeSearch);
}
