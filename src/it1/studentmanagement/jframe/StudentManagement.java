package it1.studentmanagement.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dao.StudentDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;
import it1.studentmanagement.jdbc.DBUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JList;

public class StudentManagement {

	private JFrame frame;
	private JTextField txtProvinceID;
	private JTextField txtProvinceName;
	private static ProvinceDAO provinceDAO = new ProvinceDAO();
	private static boolean isEditProvince = false;
	private JTable provinceTable;
	private JTextField txtStudentId;
	private JTextField txtStudentName;
	private JTextField txtStudentDob;
	private JTextField txtStudentProvinceName;
	private JTextField txtMath;
	private JTextField txtPhysical;
	private JTextField txtChemistry;
	private JTextField textField_7;
	private JTable table;
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
		addRowToProvinceTable();
		addRowToStudentTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1015, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JScrollPane studentScrollList = new JScrollPane();
		studentScrollList.setBounds(0, 249, 668, -220);
		
		JPanel studentPanel = new JPanel();
		tabbedPane.addTab("Student", null, studentPanel, null);
		studentPanel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 0, 0);
		studentPanel.add(label_1);
		
		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setBounds(12, 266, 980, 190);
		studentPanel.add(studentInfoPanel);
		studentInfoPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setBounds(12, 33, 72, 17);
		studentInfoPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtStudentId = new JTextField();
		txtStudentId.setEnabled(false);
		txtStudentId.setEditable(false);
		txtStudentId.setBounds(120, 31, 242, 22);
		studentInfoPanel.add(txtStudentId);
		txtStudentId.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(12, 59, 105, 31);
		studentInfoPanel.add(lblStudentName);
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDayOfBirth = new JLabel("Day Of Birth:");
		lblDayOfBirth.setBounds(12, 103, 105, 16);
		studentInfoPanel.add(lblDayOfBirth);
		lblDayOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtStudentName = new JTextField();
		txtStudentName.setEnabled(false);
		txtStudentName.setEditable(false);
		txtStudentName.setBounds(120, 66, 242, 22);
		studentInfoPanel.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtStudentDob = new JTextField();
		txtStudentDob.setEnabled(false);
		txtStudentDob.setEditable(false);
		txtStudentDob.setBounds(120, 101, 242, 22);
		studentInfoPanel.add(txtStudentDob);
		txtStudentDob.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Province Name\r\n:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(12, 132, 98, 16);
		studentInfoPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(453, 33, 72, 16);
		studentInfoPanel.add(lblNewLabel_3);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setEnabled(false);
		rdbtnMale.setBounds(533, 30, 66, 25);
		studentInfoPanel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setEnabled(false);
		rdbtnFemale.setBounds(603, 30, 72, 25);
		studentInfoPanel.add(rdbtnFemale);
		
		txtStudentProvinceName = new JTextField();
		txtStudentProvinceName.setEnabled(false);
		txtStudentProvinceName.setEditable(false);
		txtStudentProvinceName.setBounds(120, 130, 242, 22);
		studentInfoPanel.add(txtStudentProvinceName);
		txtStudentProvinceName.setColumns(10);
		
		JLabel lblMath = new JLabel("Math:");
		lblMath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMath.setBounds(453, 66, 72, 16);
		studentInfoPanel.add(lblMath);
		
		JLabel lblPhysical = new JLabel("Physical:");
		lblPhysical.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhysical.setBounds(453, 103, 72, 16);
		studentInfoPanel.add(lblPhysical);
		
		JLabel lblChemistry = new JLabel("Chemistry");
		lblChemistry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChemistry.setBounds(453, 132, 72, 16);
		studentInfoPanel.add(lblChemistry);
		
		txtMath = new JTextField();
		txtMath.setEnabled(false);
		txtMath.setEditable(false);
		txtMath.setBounds(533, 64, 142, 22);
		studentInfoPanel.add(txtMath);
		txtMath.setColumns(10);
		
		txtPhysical = new JTextField();
		txtPhysical.setEnabled(false);
		txtPhysical.setEditable(false);
		txtPhysical.setBounds(533, 101, 142, 22);
		studentInfoPanel.add(txtPhysical);
		txtPhysical.setColumns(10);
		
		txtChemistry = new JTextField();
		txtChemistry.setEnabled(false);
		txtChemistry.setEditable(false);
		txtChemistry.setBounds(533, 130, 142, 22);
		studentInfoPanel.add(txtChemistry);
		txtChemistry.setColumns(10);
		
		JButton btnSaveStudent = new JButton("Save");
		btnSaveStudent.setEnabled(false);
		btnSaveStudent.setBounds(252, 165, 97, 25);
		studentInfoPanel.add(btnSaveStudent);
		
		JButton btnInsertStudent = new JButton("Insert");
		btnInsertStudent.setBounds(12, 161, 97, 25);
		studentInfoPanel.add(btnInsertStudent);
		
		JButton btnEditStudent = new JButton("Edit");
		btnEditStudent.setBounds(130, 165, 97, 25);
		studentInfoPanel.add(btnEditStudent);
		
		JButton btnDeleteStudent = new JButton("Delete");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteStudent.setBounds(372, 165, 97, 25);
		studentInfoPanel.add(btnDeleteStudent);
		
		JButton btnCancelStudent = new JButton("Cancel");
		btnCancelStudent.setBounds(883, 165, 97, 25);
		studentInfoPanel.add(btnCancelStudent);
		
		JLabel lblStudentInfomation = new JLabel("Student Information");
		lblStudentInfomation.setForeground(Color.RED);
		lblStudentInfomation.setBounds(341, 0, 218, 16);
		studentInfoPanel.add(lblStudentInfomation);
		lblStudentInfomation.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		JLabel lblStudentList = new JLabel("Student List\r\n");
		lblStudentList.setForeground(Color.RED);
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentList.setBounds(272, 13, 128, 16);
		studentPanel.add(lblStudentList);
		
		
		JScrollPane studentScrollPane = new JScrollPane(table);
		studentScrollPane.setBounds(12, 42, 646, 206);
		studentPanel.add(studentScrollPane);
		table = new JTable() {;
			@Override
			//users not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
			       return false;
			}
		};
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Date", "Gender", "Province", "Math", "Physical","Chemistry"
				}
			));
		studentScrollPane.setViewportView(table);
		
		JTextArea textStudentError = new JTextArea();
		textStudentError.setBounds(670, 0, 310, 66);
		studentPanel.add(textStudentError);
		textStudentError.setFocusable(false);
		
		JPanel studentSearchPanel = new JPanel();
		studentSearchPanel.setBounds(670, 79, 322, 168);
		studentPanel.add(studentSearchPanel);
		studentSearchPanel.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(79, 0, 78, 1);
		studentSearchPanel.add(label_2);
		
		JLabel lblSearchBox = new JLabel("SEARCH BOX");
		lblSearchBox.setForeground(Color.RED);
		lblSearchBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearchBox.setBounds(89, 0, 138, 30);
		studentSearchPanel.add(lblSearchBox);
		
		JLabel lblStudentId = new JLabel("Student ID: ");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentId.setBounds(12, 56, 86, 16);
		studentSearchPanel.add(lblStudentId);
		
		JLabel lblProvinceName_1 = new JLabel("Province Name:");
		lblProvinceName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProvinceName_1.setBounds(12, 87, 109, 16);
		studentSearchPanel.add(lblProvinceName_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(121, 54, 157, 22);
		studentSearchPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setBounds(121, 178, 157, -90);
		studentSearchPanel.add(list);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(181, 130, 97, 25);
		studentSearchPanel.add(btnSearch);
		
		
		JPanel provincePanel = new JPanel();
		tabbedPane.addTab("Province", null, provincePanel, null);
		provincePanel.setLayout(null);
		
		JLabel lblProvinceID = new JLabel("Province ID:");
		lblProvinceID.setBounds(535, 89, 80, 14);
		lblProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(lblProvinceID);
		
		JLabel lblProvinceName = new JLabel("Province Name:");
		lblProvinceName.setBounds(535, 117, 124, 14);
		lblProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(lblProvinceName);
		
		txtProvinceID = new JTextField();
		txtProvinceID.setBounds(669, 86, 225, 20);
		txtProvinceID.setEditable(false);
		txtProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(txtProvinceID);
		txtProvinceID.setColumns(10);
		
		txtProvinceName = new JTextField();
		txtProvinceName.setBounds(669, 116, 225, 20);
		txtProvinceName.setEditable(false);
		txtProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProvinceName.setColumns(10);
		provincePanel.add(txtProvinceName);
		
		JTextArea txtProvinceError = new JTextArea();
		txtProvinceError.setBounds(535, 11, 359, 58);
		txtProvinceError.setLineWrap(true);
		txtProvinceError.setEditable(false);
		txtProvinceError.setFont(new Font("Courier New", Font.PLAIN, 18));
		txtProvinceError.setForeground(Color.RED);
		provincePanel.add(txtProvinceError);
		
		JButton btnInsertProvince = new JButton("Insert");
		btnInsertProvince.setBounds(535, 174, 89, 23);

		btnInsertProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnInsertProvince);
		
		JButton btnEditProvince = new JButton("Edit");
		btnEditProvince.setBounds(669, 176, 89, 23);
		
		btnEditProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnEditProvince);
		
		JPanel confirmDelProvincePanel = new JPanel();
		confirmDelProvincePanel.setBounds(77, 258, 817, 195);
		provincePanel.add(confirmDelProvincePanel);
		confirmDelProvincePanel.setLayout(null);
		
		JButton btnDeleteProvince = new JButton("Delete");
		btnDeleteProvince.setBounds(805, 176, 89, 23);
	
		btnDeleteProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnDeleteProvince);
		
		JButton btnSaveProvince = new JButton("Save");
		btnSaveProvince.setBounds(535, 222, 89, 23);
		
		btnSaveProvince.setEnabled(false);
		btnSaveProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnSaveProvince);
		
		Timer timer = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceError.setText("");
			}
			
		});
		
		JButton btnCancelProvince = new JButton("Cancel");
		btnCancelProvince.setBounds(669, 224, 89, 23);
		
		
		btnCancelProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnCancelProvince);
		
		JButton btnConfirmDel = new JButton("Confirm");
		
		btnConfirmDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmDel.setBounds(250, 140, 117, 23);
		confirmDelProvincePanel.add(btnConfirmDel);
		
		JButton btnCancelDel = new JButton("Cancel");
		btnCancelDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelDel.setBounds(450, 140, 117, 23);
		confirmDelProvincePanel.add(btnCancelDel);
		
		JLabel lblYouAreDeleting = new JLabel("You are deleting province:");
		lblYouAreDeleting.setForeground(Color.RED);
		lblYouAreDeleting.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYouAreDeleting.setBounds(211, 11, 241, 36);
		confirmDelProvincePanel.add(lblYouAreDeleting);
		
		JLabel lblDelProvince = new JLabel("Hồ Chí Minh");
		lblDelProvince.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDelProvince.setBounds(477, 11, 206, 36);
		confirmDelProvincePanel.add(lblDelProvince);
		
		JLabel lblNewLabel = new JLabel("Please choose \"Confirm\" to delete");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(253, 73, 314, 36);
		confirmDelProvincePanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 11, 441, 234);
		provincePanel.add(scrollPane);
		
		provinceTable = new JTable() {;
			@Override
			//users not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
			       return false;
			}
		};
		
		provinceTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Province Name"
			}
		));
		scrollPane.setViewportView(provinceTable);
		
		confirmDelProvincePanel.setVisible(false);
		
		JPanel aboutPanel = new JPanel();
		tabbedPane.addTab("About us", null, aboutPanel, null);
		aboutPanel.setLayout(null);
		
		JLabel lblChngTrnhQun = new JLabel("Chương trình quản lý thí sinh dự thi Đại Học");
		lblChngTrnhQun.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblChngTrnhQun.setHorizontalAlignment(SwingConstants.CENTER);
		lblChngTrnhQun.setBounds(0, 11, 994, 52);
		aboutPanel.add(lblChngTrnhQun);
		
		JLabel lblThyGioB = new JLabel("Nguyễn Trọng Phúc");
		lblThyGioB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThyGioB.setBounds(515, 92, 167, 30);
		aboutPanel.add(lblThyGioB);
		
		JLabel label = new JLabel("Thầy giáo bộ môn:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(233, 92, 167, 30);
		aboutPanel.add(label);
		
		JLabel lblDanhSchSinh = new JLabel("Danh sách sinh viên:");
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSchSinh.setBounds(233, 133, 167, 30);
		aboutPanel.add(lblDanhSchSinh);
		
		JLabel lblPhanVnHoi = new JLabel("Phan Văn Hoài (171203470)");
		lblPhanVnHoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhanVnHoi.setBounds(515, 133, 296, 30);
		aboutPanel.add(lblPhanVnHoi);
		
		JLabel lblPhmNhtNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblPhmNhtNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhmNhtNam.setBounds(515, 174, 296, 30);
		aboutPanel.add(lblPhmNhtNam);
		
		JLabel lblLSnTng = new JLabel("Lê Sơn Tùng (171210160)");
		lblLSnTng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLSnTng.setBounds(515, 215, 296, 30);
		aboutPanel.add(lblLSnTng);
		
		JLabel lblCngNghThng = new JLabel("Công nghệ thông tin 1 - K58");
		lblCngNghThng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCngNghThng.setBounds(515, 256, 296, 30);
		aboutPanel.add(lblCngNghThng);
		
		JLabel lblLp = new JLabel("Lớp:");
		lblLp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLp.setBounds(233, 256, 195, 30);
		aboutPanel.add(lblLp);
		
		JLabel lblTrng = new JLabel("Trường:");
		lblTrng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTrng.setBounds(233, 297, 195, 30);
		aboutPanel.add(lblTrng);
		
		JLabel lbliHcGiao = new JLabel("Đại học Giao Thông Vận Tải");
		lbliHcGiao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbliHcGiao.setBounds(515, 297, 265, 30);
		aboutPanel.add(lbliHcGiao);
		
		btnCancelProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceName.setEditable(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				btnSaveProvince.setEnabled(false);
				confirmDelProvincePanel.setVisible(false);
			}
		});
		
		btnInsertProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				txtProvinceName.setEditable(true);
				txtProvinceName.requestFocus();
				btnSaveProvince.setEnabled(true);
			}
		});
		
		btnEditProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					btnSaveProvince.setEnabled(true);
					isEditProvince = true;
					txtProvinceName.setEditable(true);
					txtProvinceName.requestFocus();
				} else {
					txtProvinceError.setText("You have to choose a province to edit.");
					timer.start();
				}
			}
		});
		
		btnSaveProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtProvinceName.getText().length() == 0) {
					txtProvinceError.setText("Province name can't be null");
					txtProvinceName.requestFocus();
				} else {
					if (!isEditProvince) {
						try {
							provinceDAO.insertProvince(txtProvinceName.getText());
							txtProvinceError.setText("Insert new province success!");
						} catch (SQLException e) {
							txtProvinceError.setText("Insert new province failed! SQL Exception has occured.");
						}
					} else {
						try {
							provinceDAO.updateProvince(txtProvinceName.getText().toString(), Integer.parseInt(txtProvinceID.getText().toString()));
							txtProvinceError.setText("Edit province success!");
						} catch (NumberFormatException e) {
							txtProvinceError.setText("Edit failed! Number Format Exception occured.");
							e.printStackTrace();
						} catch (SQLException e) {
							txtProvinceError.setText("Edit failed! SQL Exception occured.");
							e.printStackTrace();
						}
					}
					addRowToProvinceTable();
					btnSaveProvince.setEnabled(false);
					txtProvinceID.setText("");
					txtProvinceName.setText("");
					txtProvinceName.setEditable(false);
				}
				timer.start();
			}
		});
		
		btnDeleteProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					confirmDelProvincePanel.setVisible(true);
					lblDelProvince.setText(model.getValueAt(selectedRowIndex, 1).toString());
				} else {
					txtProvinceError.setText("You have to choose a province to delete.");
					timer.start();
				}
			}
		});
		
		btnConfirmDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					provinceDAO.deleteProvince(Integer.parseInt(txtProvinceID.getText()));
					txtProvinceError.setText("Delete success!");
				} catch (NumberFormatException e1) {
					txtProvinceError.setText("Delete failed! Number Format Exception occured.");
					e1.printStackTrace();
				} catch (SQLException e1) {
					txtProvinceError.setText("Delete failed! SQL Exception occured.");
					e1.printStackTrace();
				}
				addRowToProvinceTable();
				confirmDelProvincePanel.setVisible(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				timer.setRepeats(false);
				timer.start();
			}
		});
		
		btnCancelDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmDelProvincePanel.setVisible(false);
			}
		});
		
		provinceTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				txtProvinceID.setText(model.getValueAt(selectedRowIndex, 0).toString());
				txtProvinceName.setText(model.getValueAt(selectedRowIndex, 1).toString());
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				txtStudentId.setText(table.getModel().getValueAt(selectedRowIndex, 0).toString());
				txtStudentName.setText(table.getModel().getValueAt(selectedRowIndex, 1).toString());
				txtStudentDob.setText(table.getModel().getValueAt(selectedRowIndex, 2).toString());
				//Reset radio button
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				//If gender = 1, it means that gender is male, otherwise it's female
				if(table.getModel().getValueAt(selectedRowIndex, 3).toString().equals("1")) {
					rdbtnMale.setSelected(true);
				}else {
					rdbtnFemale.setSelected(true);
				}
				txtStudentProvinceName.setText(table.getModel().getValueAt(selectedRowIndex, 4).toString());
				txtMath.setText(table.getModel().getValueAt(selectedRowIndex, 5).toString());
				txtChemistry.setText(table.getModel().getValueAt(selectedRowIndex, 6).toString());
				txtPhysical.setText(table.getModel().getValueAt(selectedRowIndex, 7).toString());
				txtStudentName.setEnabled(true);
				txtStudentProvinceName.setEnabled(true);
				txtStudentId.setEnabled(true);
				txtStudentDob.setEnabled(true);;
				txtMath.setEnabled(true);
				txtChemistry.setEnabled(true);
				txtPhysical.setEnabled(true);
			}
		});
		
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtStudentId.setEditable(true);
				txtStudentName.setEditable(true);
				txtStudentDob.setEditable(true);
				txtStudentProvinceName.setEditable(true);
				txtMath.setEditable(true);
				txtChemistry.setEditable(true);
				txtPhysical.setEditable(true);
				rdbtnMale.setEnabled(true);
				rdbtnFemale.setEnabled(true);
				btnSaveStudent.setEnabled(true);
			}
		});
		
		btnInsertStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSaveStudent.setEnabled(true);
				txtStudentName.setText("");
				txtStudentId.setText("");
				txtStudentDob.setText("");
				txtStudentId.requestFocus();
				txtMath.setText("");
				txtStudentProvinceName.setText("");
				txtChemistry.setText("");
				txtPhysical.setText("");
				
				txtStudentId.setEditable(true);
				txtStudentName.setEditable(true);
				txtStudentDob.setEditable(true);
				txtStudentProvinceName.setEditable(true);
				txtMath.setEditable(true);
				txtChemistry.setEditable(true);
				txtPhysical.setEditable(true);
				rdbtnMale.setEnabled(true);
				rdbtnFemale.setEnabled(true);
				btnSaveStudent.setEnabled(true);
			}
		});
		
		btnSaveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDAO students = new StudentDAO();
				ProvinceDTO province = new ProvinceDTO(txtStudentProvinceName.getText());
				StudentDTO student1 = new StudentDTO();
				if(rdbtnMale.isSelected()) {
					StudentDTO student = new StudentDTO(Integer.parseInt(txtStudentId.getText()), txtStudentName.getText(), province, 
							txtStudentDob.getText(), 1, Float.parseFloat(txtMath.getText()),
							Float.parseFloat(txtPhysical.getText()), Float.parseFloat(txtChemistry.getText()));
					try {
						students.insertStudent(student);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(rdbtnFemale.isSelected()) {
					StudentDTO student = new StudentDTO(Integer.parseInt(txtStudentId.getText()), txtStudentName.getText(), province, 
							txtStudentDob.getText(), 1, Float.parseFloat(txtMath.getText()),
							Float.parseFloat(txtPhysical.getText()), Float.parseFloat(txtChemistry.getText()));
					try {
						students.insertStudent(student);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	private void addRowToProvinceTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Province ID");
		model.addColumn("Province Name");
		List<ProvinceDTO> provinces = new ArrayList<ProvinceDTO>();
		try {
			provinces = provinceDAO.showProvince();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object provinceTableRowData[] = new Object[2];
		for (ProvinceDTO province : provinces) {
			provinceTableRowData[0] = province.getId();
			provinceTableRowData[1] = province.getName();
			model.addRow(provinceTableRowData);
		}
		provinceTable.setModel(model);
	}

	
	//Student event handler
	private void addRowToStudentTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Date");
		model.addColumn("Gender");
		model.addColumn("Province");
		model.addColumn("Math");
		model.addColumn("Physical");
		model.addColumn("Chemistry");
		//Append rows
		StudentDAO studentDAO = new StudentDAO();
		List<StudentDTO> students = new ArrayList<StudentDTO>();

		try {
			students = studentDAO.showStudent(0, 1000000000);
		}catch(SQLException e) {
			e.printStackTrace();
		}

		Object studentTableRowData[] = new Object[10];
		for (StudentDTO student : students) {
			studentTableRowData[0] = student.getId();
			studentTableRowData[1] = student.getName();
			studentTableRowData[2] = student.getBirth();
			if(student.getGender() == 1) {
				studentTableRowData[3] = "Male";
			}else {
				studentTableRowData[3] = "Female";
			}
			studentTableRowData[4] = student.getPlace().getName();
			studentTableRowData[5] = student.getMath();
			studentTableRowData[6] = student.getPhysical();
			studentTableRowData[7] = student.getChemistry();
			model.addRow(studentTableRowData);
		}
		table.setModel(model);
	}

}
