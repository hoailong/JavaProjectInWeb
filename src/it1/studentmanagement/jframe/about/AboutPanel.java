package it1.studentmanagement.jframe.about;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class AboutPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBounds(300, 100, 600, 300);
		setLayout(null);

		JLabel lblTeacher = new JLabel("Thầy giáo bộ môn:");
		lblTeacher.setBounds(45, 30, 165, 30);
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTeacher);
		
		JLabel lblTeacherName = new JLabel("Bùi Minh Cường");
		lblTeacherName.setBounds(280, 30, 165, 30);		
		lblTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTeacherName);
		
		JLabel lblStudentList = new JLabel("Danh sách sinh viên:");
		lblStudentList.setBounds(45, 70, 167, 30);
		lblStudentList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblStudentList);
		
		JLabel lblHoai = new JLabel("Phan Văn Hoài (171203470)");
		lblHoai.setBounds(280, 70, 296, 30);
		lblHoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblHoai);
		
		JLabel lblNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblNam.setBounds(280, 110, 296, 30);
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNam);
		
		JLabel lblTung = new JLabel("Lê Sơn Tùng (171210160)");
		lblTung.setBounds(280, 150, 296, 30);
		lblTung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTung);

		JLabel lblClass = new JLabel("Lớp:");
		lblClass.setBounds(45, 190, 195, 30);
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblClass);
		
		JLabel lblClassName = new JLabel("Công nghệ thông tin 1 - K58");
		lblClassName.setBounds(280, 190, 296, 30);
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblClassName);
		
		JLabel lblUniversity = new JLabel("Trường:");
		lblUniversity.setBounds(45, 230, 195, 30);
		lblUniversity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblUniversity);
		
		JLabel lblUniversityName = new JLabel("Đại học Giao Thông Vận Tải");
		lblUniversityName.setBounds(280, 230, 265, 30);
		lblUniversityName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblUniversityName);
	}

}
