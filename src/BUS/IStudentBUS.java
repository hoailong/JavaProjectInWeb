package BUS;

import java.util.List;

import DTO.StudentDTO;

public interface IStudentBUS {
	public List<StudentDTO> showStudent();
	public boolean insertStudent(StudentDTO std);
	public boolean updateStudent(StudentDTO std, int id);
	public boolean deleteStudent(int id);
	public boolean findStudent(int id, String name);
}
