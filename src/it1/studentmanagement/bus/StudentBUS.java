package it1.studentmanagement.bus;

import java.sql.SQLException;
import java.util.List;

import it1.studentmanagement.dao.StudentDAO;
import it1.studentmanagement.dto.StudentDTO;

public class StudentBUS implements IStudentBUS {

	private StudentDAO stdDao;

	public StudentBUS() {
		this.stdDao = new StudentDAO();
	}

	@Override
	public List<StudentDTO> getStudentList() {
		try {
			List<StudentDTO> list = stdDao.getAllStudents();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<StudentDTO> getStudentListPerPages(int offset, int count) {
		try {
			List<StudentDTO> list = stdDao.getStudentsWithPage(offset, count);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<StudentDTO> getStudentList(String studentId, String provinceName) {
		try {
			List<StudentDTO> list = stdDao.getStudentList(studentId, provinceName);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insert(StudentDTO student) {
		student.setName(FormatString.formatName(student.getName()));
		try {
			stdDao.insertStudent(student);
			return "Thêm thí sinh mới thành công!";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Thêm thí sinh mới không thành công! " + e.toString();
		}
	}

	@Override
	public String update(StudentDTO student) {
		student.setName(FormatString.formatName(student.getName()));
		try {
			stdDao.updateStudent(student);
			return "Cập nhật thông tin thành công!";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Cập nhật thông tin không thành công! " + e.toString();
		}
	}

	@Override
	public String delete(int id) {
		try {
			stdDao.deleteStudent(id);
			return "Xóa thí sinh thành công!";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Xóa thí sinh không thành công! " + e.toString();
		}
	}

	@Override
	public int getCountRow() {
		try {
			return stdDao.getCountRow();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
