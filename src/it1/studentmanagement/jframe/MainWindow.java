package it1.studentmanagement.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MainWindow extends JFrame {

	public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainWindow.this.setVisible(false);
                MainWindow.this.dispose();
            }
        });

        final JButton btn = new JButton("Button");
        btn.setBounds(100, 100, 100, 100);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentJFrame studentJframe = new StudentJFrame();
                studentJframe.setVisible(true);
            }
        });

        
        add(btn);
        
        final JButton btn2 = new JButton("Button2");
        btn2.setBounds(200, 200, 100, 100);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProvinceJFrame provinceJframe = new ProvinceJFrame();
                provinceJframe.setVisible(true);
            }
        });

        
        add(btn2);
		JLabel lblTitle = new JLabel("Chương trình quản lý thí sinh dự thi Đại Học");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(71, 26, 994, 52);
		add(lblTitle);
		
		JPanel aboutPanelInfor = new JPanel();
		aboutPanelInfor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		aboutPanelInfor.setBounds(283, 112, 571, 315);
		add(aboutPanelInfor);
		aboutPanelInfor.setLayout(null);

		JLabel lblTeacherName = new JLabel("Bùi Minh Cường");
		lblTeacherName.setBounds(282, 41, 167, 30);
		aboutPanelInfor.add(lblTeacherName);
		lblTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblTeacher = new JLabel("Thầy giáo bộ môn:");
		lblTeacher.setBounds(44, 41, 167, 30);
		aboutPanelInfor.add(lblTeacher);
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblStudentList = new JLabel("Danh sách sinh viên:");
		lblStudentList.setBounds(44, 82, 167, 30);
		aboutPanelInfor.add(lblStudentList);
		lblStudentList.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblHoai = new JLabel("Phan Văn Hoài (171203470)");
		lblHoai.setBounds(282, 82, 296, 30);
		aboutPanelInfor.add(lblHoai);
		lblHoai.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblNam.setBounds(282, 123, 296, 30);
		aboutPanelInfor.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblTung = new JLabel("Lê Sơn Tùng (171210160)");
		lblTung.setBounds(282, 164, 296, 30);
		aboutPanelInfor.add(lblTung);
		lblTung.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblClassName = new JLabel("Công nghệ thông tin 1 - K58");
		lblClassName.setBounds(282, 205, 296, 30);
		aboutPanelInfor.add(lblClassName);
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblClass = new JLabel("Lớp:");
		lblClass.setBounds(44, 205, 195, 30);
		aboutPanelInfor.add(lblClass);
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblUniversity = new JLabel("Trường:");
		lblUniversity.setBounds(44, 246, 195, 30);
		aboutPanelInfor.add(lblUniversity);
		lblUniversity.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblUniversityName = new JLabel("Đại học Giao Thông Vận Tải");
		lblUniversityName.setBounds(282, 246, 265, 30);
		aboutPanelInfor.add(lblUniversityName);
		lblUniversityName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    }

}
