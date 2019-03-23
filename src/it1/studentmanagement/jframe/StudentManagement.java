package it1.studentmanagement.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StudentManagement {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement window = new StudentManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1015, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Student", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Province", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("About us", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblChngTrnhQun = new JLabel("Chương trình quản lý thí sinh dự thi Đại Học");
		lblChngTrnhQun.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblChngTrnhQun.setHorizontalAlignment(SwingConstants.CENTER);
		lblChngTrnhQun.setBounds(0, 11, 994, 52);
		panel_2.add(lblChngTrnhQun);
		
		JLabel lblThyGioB = new JLabel("Nguyễn Trọng Phúc");
		lblThyGioB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThyGioB.setBounds(515, 92, 167, 30);
		panel_2.add(lblThyGioB);
		
		JLabel label = new JLabel("Thầy giáo bộ môn:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(233, 92, 167, 30);
		panel_2.add(label);
		
		JLabel lblDanhSchSinh = new JLabel("Danh sách sinh viên:");
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSchSinh.setBounds(233, 133, 167, 30);
		panel_2.add(lblDanhSchSinh);
		
		JLabel lblPhanVnHoi = new JLabel("Phan Văn Hoài (171203470)");
		lblPhanVnHoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhanVnHoi.setBounds(515, 133, 296, 30);
		panel_2.add(lblPhanVnHoi);
		
		JLabel lblPhmNhtNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblPhmNhtNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhmNhtNam.setBounds(515, 174, 296, 30);
		panel_2.add(lblPhmNhtNam);
		
		JLabel lblLSnTng = new JLabel("Lê Sơn Tùng (171210160)");
		lblLSnTng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLSnTng.setBounds(515, 215, 296, 30);
		panel_2.add(lblLSnTng);
		
		JLabel lblCngNghThng = new JLabel("Công nghệ thông tin 1 - K58");
		lblCngNghThng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCngNghThng.setBounds(515, 256, 296, 30);
		panel_2.add(lblCngNghThng);
		
		JLabel lblLp = new JLabel("Lớp:");
		lblLp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLp.setBounds(233, 256, 195, 30);
		panel_2.add(lblLp);
		
		JLabel lblTrng = new JLabel("Trường:");
		lblTrng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTrng.setBounds(233, 297, 195, 30);
		panel_2.add(lblTrng);
		
		JLabel lbliHcGiao = new JLabel("Đại học Giao Thông Vận Tải");
		lbliHcGiao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbliHcGiao.setBounds(515, 297, 265, 30);
		panel_2.add(lbliHcGiao);
	}
}
