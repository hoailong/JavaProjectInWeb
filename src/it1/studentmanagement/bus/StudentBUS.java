package it1.studentmanagement.bus;

import java.sql.SQLException;

import it1.studentmanagement.dao.StudentDAO;

public class StudentBUS {
	public static boolean checkConstant(int studentId) throws SQLException{
		StudentDAO stdDao = new StudentDAO();
		return (stdDao.findStudent(studentId) != null);
	}
}
