package it1.studentmanagement.jframe.about;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

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
		
		JLabel lblTeacher = new JLabel("Thầy giáo bộ môn:");
		lblTeacher.setBounds(340, 130, 165, 30);
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTeacher);
		
		JLabel lblTeacherName = new JLabel("Bùi Minh Cường");
		lblTeacherName.setBounds(570, 130, 165, 30);		
		lblTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTeacherName);
		
		JLabel lblStudentList = new JLabel("Danh sách sinh viên:");
		lblStudentList.setBounds(340, 170, 165, 30);
		lblStudentList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblStudentList);
		
		JLabel lblHoai = new JLabel("Phan Văn Hoài (171203470)");
		lblHoai.setBounds(570, 170, 340, 30);
		lblHoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblHoai);
		
		JLabel lblNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblNam.setBounds(570, 210, 340, 30);
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNam);
		
		JLabel lblTung = new JLabel("Lê Sơn Tùng (171210160)");
		lblTung.setBounds(570, 250, 340, 30);
		lblTung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTung);

		JLabel lblClass = new JLabel("Lớp:");
		lblClass.setBounds(340, 290, 195, 30);
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblClass);
		
		JLabel lblClassName = new JLabel("Công nghệ thông tin 1 - K58");
		lblClassName.setBounds(570, 290, 340, 30);
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblClassName);
		
		JLabel lblUniversity = new JLabel("Trường:");
		lblUniversity.setBounds(340, 330, 195, 30);
		lblUniversity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblUniversity);
		
		JLabel lblUniversityName = new JLabel("Đại học Giao Thông Vận Tải");
		lblUniversityName.setBounds(570, 330, 340, 30);
		lblUniversityName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblUniversityName);
	}

}
