package it1.studentmanagement.jframe.about;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class AboutPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBounds(0, 0, 1200, 600);
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Chương trình quản lý thí sinh dự thi Đại Học");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(120, 20, 960, 50);
		add(lblTitle);
		
		JPanel panelAboutInfor = new JPanel();
		panelAboutInfor.setBackground(Color.WHITE);
		panelAboutInfor.setBounds(265, 110, 670, 327);
		add(panelAboutInfor);
		panelAboutInfor.setLayout(null);
		
		JLabel lblTeacher = new JLabel("Thầy giáo bộ môn:");
		lblTeacher.setBounds(63, 47, 165, 30);
		panelAboutInfor.add(lblTeacher);
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTeacherName = new JLabel("Bùi Minh Cường");
		lblTeacherName.setBounds(270, 47, 165, 30);
		panelAboutInfor.add(lblTeacherName);
		lblTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblStudentList = new JLabel("Danh sách sinh viên:");
		lblStudentList.setBounds(63, 87, 165, 30);
		panelAboutInfor.add(lblStudentList);
		lblStudentList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblHoai = new JLabel("Phan Văn Hoài (171203470)");
		lblHoai.setBounds(270, 87, 340, 30);
		panelAboutInfor.add(lblHoai);
		lblHoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblNam.setBounds(270, 127, 340, 30);
		panelAboutInfor.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTung = new JLabel("Lê Sơn Tùng (171210160)");
		lblTung.setBounds(270, 167, 340, 30);
		panelAboutInfor.add(lblTung);
		lblTung.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblClass = new JLabel("Lớp:");
		lblClass.setBounds(63, 207, 195, 30);
		panelAboutInfor.add(lblClass);
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblClassName = new JLabel("Công nghệ thông tin 1 - K58");
		lblClassName.setBounds(270, 207, 340, 30);
		panelAboutInfor.add(lblClassName);
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblUniversity = new JLabel("Trường:");
		lblUniversity.setBounds(63, 247, 195, 30);
		panelAboutInfor.add(lblUniversity);
		lblUniversity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblUniversityName = new JLabel("Đại học Giao Thông Vận Tải");
		lblUniversityName.setBounds(270, 247, 340, 30);
		panelAboutInfor.add(lblUniversityName);
		lblUniversityName.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

}
