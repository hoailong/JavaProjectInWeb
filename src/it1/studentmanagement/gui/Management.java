//Class để test chương trình trên màn hình console
package it1.studentmanagement.gui;
public class Management {};

/*package it1.studentmanagement.gui;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dao.StudentDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;
import it1.studentmanagement.jdbc.DBUtil;

public class Management {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Connection conn = DBUtil.getSqlConn();
		run(conn);
		DBUtil.closeConnect(conn);
	}

	private static int menu() {
		int choice = 0;
		System.out.println();
		System.out.println("=====BAI TAP LON NHAP MON JAVA=====");
		System.out.println("1.Hiển thi danh sách sinh viên");
		System.out.println("2.Thêm sinh viên");
		System.out.println("3.Sửa thông tin sinh viên");
		System.out.println("4.Xóa sinh viên");
		System.out.println("5.Tìm kiếm sinh viên");
		System.out.println("6.Hiên thị danh sách tỉnh");
		System.out.println("7.Thêm tỉnh");
		System.out.println("8.Exit");
		do {
			System.out.println("Chọn: ");
			choice = Integer.parseInt(sc.nextLine());
		} while (choice > 8 || choice < 1);
		return choice;
	}

	private static void run(Connection conn) {
		boolean conti = true;
		while (conti) {
			switch (menu()) {
			case 1:
				showListStudent(conn);
				break;
			case 2:
				insertStudent(conn);
				break;
			case 3:
				updateStudent(conn);
				break;
			case 4:
				deleteStudent(conn);
				break;
			case 5:
				findStudent(conn);
				break;
			case 6:
				showListProvince(conn);
				break;
			case 7:
				insertProvince(conn);
				break;
			default:conti = false;
				break;
			}
		}
	}

	private static void showListStudent(Connection conn) {
		StudentDAO studentDao = new StudentDAO();
		List<StudentDTO> liststudent = studentDao.showStudent();

		if (liststudent.isEmpty()) {
			System.out.println("List Empty!");
		} else {
			for (StudentDTO student : liststudent) {
				System.out.println(student.toString());
			}

		}

	}

	private static void insertStudent(Connection conn) {
		StudentDAO studentDao = new StudentDAO();
		System.out.println("Nhập thông tin sinh viên mới:");
		StudentDTO studentDTO = inputNewStudent();
		if (studentDao.insertStudent(studentDTO)) {
			System.out.println("Insert success!");
		} else {
			System.out.println("Insert fail!");
		}
	}

	private static void findStudent(Connection conn) {
		int idFind;
		System.out.println("Nhập mã sinh viên cần tìm: ");
		idFind = Integer.parseInt(sc.nextLine());
		StudentDAO studentDao = new StudentDAO();
		StudentDTO student = studentDao.findStudent(idFind);
		if (student != null) {
			System.out.println("Student you find: ");
			System.out.println(student.toString());
		} else {
			System.out.println("No record ID = " + idFind);
		}
	}

	private static void updateStudent(Connection conn) {
		int idUpdate;
		System.out.println("Nhập mã sinh viên cần update: ");
		idUpdate = Integer.parseInt(sc.nextLine());
		// kiểm tra mã sinh viên có tồn tại hay k
		// dùng BUS
		// nếu mã sinh viên có tồn tại thì tiếp tục
		StudentDAO studentDao = new StudentDAO();
		System.out.println("Nhập thông tin mới của sinh viên:");
		StudentDTO studentDTO = inputNewStudent();
		if (studentDao.updateStudent(studentDTO, idUpdate)) {
			System.out.println("Update success!");
		} else {
			System.out.println("Update fail!");
		}
	}

	private static void deleteStudent(Connection conn) {
		int idDelete;
		System.out.println("Nhập mã sinh viên cần xóa: ");
		idDelete = Integer.parseInt(sc.nextLine());
		// kiểm tra mã sinh viên có tồn tại hay k
		// dùng BUS
		// nếu mã sinh viên có tồn tại thì tiếp tục
		StudentDAO studentDao = new StudentDAO();
		if (studentDao.deleteStudent(idDelete)) {
			System.out.println("Delete success!");
		} else {
			System.out.println("Delete fail!");
		}
	}

	private static void showListProvince(Connection conn) {
		ProvinceDAO prvDao = new ProvinceDAO();
		List<ProvinceDTO> listPrv = prvDao.showProvince();

		if (listPrv.isEmpty()) {
			System.out.println("List Empty!");
		} else {
			for (ProvinceDTO student : listPrv) {
				System.out.println(student.toString());
			}

		}
	}

	private static void insertProvince(Connection conn) {
		ProvinceDAO prvDao = new ProvinceDAO();
		System.out.println("Nhập thông tin tinh mới:");
		ProvinceDTO prvDTO = inputNewProvince();
		if (prvDao.insertProvince(prvDTO.getName())) {
			System.out.println("Insert success!");
		} else {
			System.out.println("Insert fail!");
		}
	}

	private static StudentDTO inputNewStudent() {
		int id;
		String name;
		int placeCode;
		ProvinceDTO place;
		String birth;
		int sex;
		float math;
		float physical;
		float chemistry;
		System.out.println("Mã sinh viên: ");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Họ tên: ");
		name = sc.nextLine();
		System.out.println("Mã tỉnh: ");
		placeCode = Integer.parseInt(sc.nextLine());
		place = new ProvinceDTO("", placeCode);
		System.out.println("Birthday: ");
		birth = sc.nextLine();
		System.out.println("Giới tính (1:Nam 0:Nữ): ");
		sex = Integer.parseInt(sc.nextLine());
		System.out.println("Điểm toán: ");
		math = Float.parseFloat(sc.nextLine());
		System.out.println("Điểm lý: ");
		physical = Float.parseFloat(sc.nextLine());
		System.out.println("Điểm hóa: ");
		chemistry = Float.parseFloat(sc.nextLine());
		return new StudentDTO(id, name, place, birth, sex, math, physical, chemistry);
	}

	private static ProvinceDTO inputNewProvince() {
		int code;
		String name;
		System.out.println("Mã tỉnh: ");
		code = Integer.parseInt(sc.nextLine());
		System.out.println("Tên tỉnh: ");
		name = sc.nextLine();
		return new ProvinceDTO(name, code);
	}

	private static void testMethod() {
		
		 * Date date = Calendar.getInstance().getTime(); DateFormat dateFormat1 = new
		 * SimpleDateFormat("yyyy-MM-dd"); String dateStr = dateFormat1.format(date);
		 * System.out.println("String: " + dateStr);
		 * 
		 * try { Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		 * System.out.println("Date: " + date2); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 
	}
}
*/