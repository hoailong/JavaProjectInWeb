package it1.studentmanagement.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	// tạo kết nối tới sql server
	public static Connection getSqlConn(){
		Connection conn = null;
		String strConnection = "jdbc:mysql://localhost:3306/student_management?useUnicode=true&characterEncoding=utf-8&useServerPrepStmts=false";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(strConnection,username,password);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Loi: " + e.toString());
		}
		return conn;
	}
	
	// đóng kết nối t sửa rồi
	public static void closeConnect(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
}
