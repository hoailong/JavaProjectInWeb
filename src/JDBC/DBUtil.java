package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	// tạo kết nối tới sql server
	public static Connection getSqlConn(){
		Connection conn = null;
		String strConnection = "jdbc:sqlserver://HH-201807241030;databaseName=JavaProj;user=sa;password=123456";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(strConnection);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Loi: " + e.toString());
		}
		return conn;
	}
	
	// đóng kết nối
	public static void closeConnect(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
}
