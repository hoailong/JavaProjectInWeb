package it1.studentmanagement.bus;

import java.util.List;

import it1.studentmanagement.dto.StudentDTO;

public interface IStudentBUS {
	List<StudentDTO> getStudentList();
	List<StudentDTO> getStudentListPerPages(int offset, int count);
	List<StudentDTO> getStudentList(String id, String place);
	String insert(StudentDTO student);
	String update(StudentDTO student);
	String delete(int id);
	int getCountRow();
}
