package DAO;

import java.util.List;

import DTO.StudentDTO;

public interface IStudentDAO {
	public List<StudentDTO> showStudent();
	public boolean insertStudent(StudentDTO std);
	public boolean updateStudent(StudentDTO std, int id);
	public boolean deleteStudent(int id);
	public StudentDTO findStudent(int idSearch);
	public List<StudentDTO> findStudent(String idSearch, String placeSearch);
}
