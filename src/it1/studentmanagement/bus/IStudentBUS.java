package it1.studentmanagement.bus;

import java.util.List;

import it1.studentmanagement.dto.StudentDTO;

public interface IStudentBUS {
	List<StudentDTO> getAll();
	List<StudentDTO> findWithPage(int offset, int count);
	List<StudentDTO> findStudentByIdAndPlace(String id, String place);
	String insert(StudentDTO student);
	String update(StudentDTO student);
	String delete(int id);
	int getCountRow();
}
