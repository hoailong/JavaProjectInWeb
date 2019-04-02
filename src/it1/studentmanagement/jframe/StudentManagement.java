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
import javax.swing.text.html.HTMLDocument.Iterator;

import it1.studentmanagement.bus.ProvinceBUS;
import it1.studentmanagement.bus.StudentBUS;
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
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextMeasurer;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;

public class StudentManagement {

	private JFrame frame;
	private JTextField txtProvinceID;
	private JTextField txtProvinceName;
	private static ProvinceDAO provinceDAO = new ProvinceDAO();
	private static ProvinceBUS provinceBUS = new ProvinceBUS();
	private static boolean isEditProvince = false;
	private static boolean isEditStudent = false;
	private JTable provinceTable;
	private JTextField txtStudentId;
	private JTextField txtStudentName;
	private JTextField txtStudentDob;
	private JTextField txtMath;
	private JTextField txtPhysical;
	private JTextField txtChemistry;
	private JTextField txtStudenSeachId;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JTextArea txtMessage;
	private JComboBox comboBoxStudent;
	private JComboBox cbProvinceStudenSearch;
	private Timer timer = new Timer(5000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtMessage.setText("");
		}

	});

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
		frame = new JFrame();
		frame.setBounds(100, 100, 1160, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1142, 490);
		frame.getContentPane().add(tabbedPane);

		txtMessage = new JTextArea();
		txtMessage.setForeground(Color.RED);
		txtMessage.setLineWrap(true);
		txtMessage.setBounds(10, 500, 1124, 80);
		frame.getContentPane().add(txtMessage);
		txtMessage.setFont(new Font("Monospaced", Font.BOLD, 20));

		initializeStudent();
		initializeProvince();
		initializeAbout();
		addProvinceNameComboBox();

		addRowToProvinceTable();
		addRowToStudentTable();
	}

	private void initializeProvince() {
		JPanel provincePanel = new JPanel();
		tabbedPane.addTab("Province", null, provincePanel, null);
		provincePanel.setLayout(null);

		JPanel confirmDelProvincePanel = new JPanel();
		confirmDelProvincePanel.setBounds(528, 256, 599, 195);
		provincePanel.add(confirmDelProvincePanel);
		confirmDelProvincePanel.setLayout(null);

		JButton btnConfirmDelProvince = new JButton("Confirm");

		btnConfirmDelProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmDelProvince.setBounds(140, 140, 117, 23);
		confirmDelProvincePanel.add(btnConfirmDelProvince);

		JButton btnCancelDelProvince = new JButton("Cancel");
		btnCancelDelProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelDelProvince.setBounds(340, 140, 117, 23);
		confirmDelProvincePanel.add(btnCancelDelProvince);

		JLabel lblYouAreDeleting = new JLabel("You are deleting province:");
		lblYouAreDeleting.setForeground(Color.RED);
		lblYouAreDeleting.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYouAreDeleting.setBounds(101, 11, 241, 36);
		confirmDelProvincePanel.add(lblYouAreDeleting);

		JLabel lblDelProvince = new JLabel("Hồ Chí Minh");
		lblDelProvince.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDelProvince.setBounds(367, 11, 206, 36);
		confirmDelProvincePanel.add(lblDelProvince);

		JLabel lblConfirmDel = new JLabel("Please choose \"Confirm\" to delete");
		lblConfirmDel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmDel.setBounds(143, 73, 314, 36);
		confirmDelProvincePanel.add(lblConfirmDel);

		JScrollPane provinceScrollPane = new JScrollPane();
		provinceScrollPane.setBounds(10, 68, 508, 383);
		provincePanel.add(provinceScrollPane);

		provinceTable = new JTable() {
			;
			@Override
			// users not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		provinceTable.setFont(new Font("Tahoma", Font.PLAIN, 16));

		provinceTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Province Name" }));
		provinceScrollPane.setViewportView(provinceTable);

		JPanel provinceInformationPane = new JPanel();
		provinceInformationPane.setBounds(528, 68, 599, 177);
		provincePanel.add(provinceInformationPane);
		provinceInformationPane.setLayout(null);

		JLabel lblProvinceID = new JLabel("Province ID:");
		lblProvinceID.setBounds(10, 64, 76, 17);
		provinceInformationPane.add(lblProvinceID);
		lblProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblProvinceName = new JLabel("Province Name:");
		lblProvinceName.setBounds(10, 92, 97, 17);
		provinceInformationPane.add(lblProvinceName);
		lblProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtProvinceID = new JTextField();
		txtProvinceID.setBounds(132, 61, 450, 23);
		provinceInformationPane.add(txtProvinceID);
		txtProvinceID.setEditable(false);
		txtProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProvinceID.setColumns(10);

		txtProvinceName = new JTextField();
		txtProvinceName.setBounds(132, 89, 450, 23);
		provinceInformationPane.add(txtProvinceName);
		txtProvinceName.setEditable(false);
		txtProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProvinceName.setColumns(10);

		JButton btnInsertProvince = new JButton("Insert");
		btnInsertProvince.setBounds(10, 141, 97, 25);
		provinceInformationPane.add(btnInsertProvince);

		btnInsertProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEditProvince = new JButton("Edit");
		btnEditProvince.setBounds(132, 141, 97, 25);
		provinceInformationPane.add(btnEditProvince);

		btnEditProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnDeleteProvince = new JButton("Delete");
		btnDeleteProvince.setBounds(252, 141, 97, 25);
		provinceInformationPane.add(btnDeleteProvince);

		btnDeleteProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnSaveProvince = new JButton("Save");
		btnSaveProvince.setBounds(369, 141, 97, 25);
		provinceInformationPane.add(btnSaveProvince);

		btnSaveProvince.setEnabled(false);
		btnSaveProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnCancelProvince = new JButton("Cancel");
		btnCancelProvince.setBounds(485, 141, 97, 25);
		provinceInformationPane.add(btnCancelProvince);

		btnCancelProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblProvinceInformation = new JLabel("Province Information");
		lblProvinceInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProvinceInformation.setBounds(204, 11, 199, 39);
		provinceInformationPane.add(lblProvinceInformation);

		JLabel lblProvinceManagement = new JLabel("Province Management");
		lblProvinceManagement.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProvinceManagement.setBounds(424, 11, 273, 32);
		provincePanel.add(lblProvinceManagement);

		// Event listener
		btnCancelProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceName.setEditable(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				btnSaveProvince.setEnabled(false);
				confirmDelProvincePanel.setVisible(false);
			}
		});

		btnSaveProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtProvinceName.getText().length() == 0) {
					txtMessage.setText("Province name can't be null");
					txtProvinceName.requestFocus();
				} else {
					String provinceName = txtProvinceName.getText();
					if (!isEditProvince) {
						txtMessage.setText(provinceBUS.insert(provinceName));
					} else {
						int provinceId = Integer.parseInt(txtProvinceID.getText());
						txtMessage.setText(provinceBUS.update(provinceId, provinceName));
					}
					addRowToProvinceTable();
					btnSaveProvince.setEnabled(false);
					txtProvinceID.setText("");
					txtProvinceName.setText("");
				}
				timer.restart();
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
					txtMessage.setText("You have to choose a province to delete.");
					timer.restart();
				}
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
					txtMessage.setText("You have to choose a province to edit.");
					timer.restart();
				}
			}
		});

		btnInsertProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				txtProvinceName.setEditable(true);
				txtProvinceName.requestFocus();
				btnSaveProvince.setEnabled(true);
				isEditProvince = false;
			}
		});

		confirmDelProvincePanel.setVisible(false);

		btnConfirmDelProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMessage.setText(provinceBUS.delete(Integer.parseInt(txtProvinceID.getText())));
				addRowToProvinceTable();
				confirmDelProvincePanel.setVisible(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				txtProvinceName.setEditable(false);
				timer.restart();
			}
		});

		btnCancelDelProvince.addActionListener(new ActionListener() {
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
	}

	private void initializeAbout() {
		JPanel aboutPanel = new JPanel();
		tabbedPane.addTab("About us", null, aboutPanel, null);
		aboutPanel.setLayout(null);

		JLabel lblTitle = new JLabel("Chương trình quản lý thí sinh dự thi Đại Học");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 11, 994, 52);
		aboutPanel.add(lblTitle);

		JLabel lblTeacherName = new JLabel("Nguyễn Trọng Phúc");
		lblTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeacherName.setBounds(515, 92, 167, 30);
		aboutPanel.add(lblTeacherName);

		JLabel lblTeacher = new JLabel("Thầy giáo bộ môn:");
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeacher.setBounds(233, 92, 167, 30);
		aboutPanel.add(lblTeacher);

		JLabel lblStudentList = new JLabel("Danh sách sinh viên:");
		lblStudentList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentList.setBounds(233, 133, 167, 30);
		aboutPanel.add(lblStudentList);

		JLabel lblHoai = new JLabel("Phan Văn Hoài (171203470)");
		lblHoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoai.setBounds(515, 133, 296, 30);
		aboutPanel.add(lblHoai);

		JLabel lblNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNam.setBounds(515, 174, 296, 30);
		aboutPanel.add(lblNam);

		JLabel lblTung = new JLabel("Lê Sơn Tùng (171210160)");
		lblTung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTung.setBounds(515, 215, 296, 30);
		aboutPanel.add(lblTung);

		JLabel lblClassName = new JLabel("Công nghệ thông tin 1 - K58");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClassName.setBounds(515, 256, 296, 30);
		aboutPanel.add(lblClassName);

		JLabel lblClass = new JLabel("Lớp:");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClass.setBounds(233, 256, 195, 30);
		aboutPanel.add(lblClass);

		JLabel lblUniversity = new JLabel("Trường:");
		lblUniversity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUniversity.setBounds(233, 297, 195, 30);
		aboutPanel.add(lblUniversity);

		JLabel lblUniversityName = new JLabel("Đại học Giao Thông Vận Tải");
		lblUniversityName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUniversityName.setBounds(515, 297, 265, 30);
		aboutPanel.add(lblUniversityName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initializeStudent() {
		JScrollPane studentScrollList = new JScrollPane();
		studentScrollList.setBounds(0, 249, 668, -220);

		JPanel studentPanel = new JPanel();
		tabbedPane.addTab("Student", null, studentPanel, null);
		studentPanel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 0, 0);
		studentPanel.add(label_1);

		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setBounds(12, 261, 1125, 190);
		studentPanel.add(studentInfoPanel);
		studentInfoPanel.setLayout(null);

		JLabel lblStudentID = new JLabel("Student ID:");
		lblStudentID.setBounds(12, 33, 72, 17);
		studentInfoPanel.add(lblStudentID);
		lblStudentID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtStudentId = new JTextField();
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
		txtStudentName.setEditable(false);
		txtStudentName.setBounds(120, 66, 242, 22);
		studentInfoPanel.add(txtStudentName);
		txtStudentName.setColumns(10);

		txtStudentDob = new JTextField();
		txtStudentDob.setEditable(false);
		txtStudentDob.setBounds(120, 101, 242, 22);
		studentInfoPanel.add(txtStudentDob);
		txtStudentDob.setColumns(10);

		JLabel lblStudentProvinceName = new JLabel("Province Name\r\n:");
		lblStudentProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentProvinceName.setBounds(12, 132, 98, 16);
		studentInfoPanel.add(lblStudentProvinceName);

		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(447, 31, 72, 16);
		studentInfoPanel.add(lblGender);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setEnabled(false);
		rdbtnMale.setBounds(531, 30, 66, 25);
		studentInfoPanel.add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setEnabled(false);
		rdbtnFemale.setBounds(597, 30, 72, 25);
		studentInfoPanel.add(rdbtnFemale);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFemale);
		buttonGroup.add(rdbtnMale);

		JLabel lblMath = new JLabel("Math:");
		lblMath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMath.setBounds(447, 61, 72, 16);
		studentInfoPanel.add(lblMath);

		JLabel lblPhysical = new JLabel("Physical:");
		lblPhysical.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhysical.setBounds(447, 92, 72, 16);
		studentInfoPanel.add(lblPhysical);

		JLabel lblChemistry = new JLabel("Chemistry");
		lblChemistry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChemistry.setBounds(447, 123, 72, 16);
		studentInfoPanel.add(lblChemistry);

		txtMath = new JTextField();
		txtMath.setEditable(false);
		txtMath.setBounds(527, 59, 142, 22);
		studentInfoPanel.add(txtMath);
		txtMath.setColumns(10);

		txtPhysical = new JTextField();
		txtPhysical.setEditable(false);
		txtPhysical.setBounds(527, 90, 142, 22);
		studentInfoPanel.add(txtPhysical);
		txtPhysical.setColumns(10);

		txtChemistry = new JTextField();
		txtChemistry.setEnabled(false);
		txtChemistry.setEditable(false);
		txtChemistry.setBounds(527, 121, 142, 22);
		studentInfoPanel.add(txtChemistry);
		txtChemistry.setColumns(10);

		JButton btnSaveStudent = new JButton("Save");
		btnSaveStudent.setEnabled(false);
		btnSaveStudent.setBounds(229, 165, 97, 25);
		studentInfoPanel.add(btnSaveStudent);

		JButton btnInsertStudent = new JButton("Insert");
		btnInsertStudent.setBounds(12, 165, 97, 25);
		studentInfoPanel.add(btnInsertStudent);

		JButton btnEditStudent = new JButton("Edit");
		btnEditStudent.setBounds(120, 165, 97, 25);
		studentInfoPanel.add(btnEditStudent);

		JButton btnDeleteStudent = new JButton("Delete");
		btnDeleteStudent.setBounds(338, 165, 97, 25);
		studentInfoPanel.add(btnDeleteStudent);

		JButton btnCancelStudent = new JButton("Cancel");
		btnCancelStudent.setBounds(447, 165, 97, 25);
		studentInfoPanel.add(btnCancelStudent);

		JLabel lblStudentInfomation = new JLabel("Student Information");
		lblStudentInfomation.setForeground(Color.BLACK);
		lblStudentInfomation.setBounds(327, 0, 218, 16);
		studentInfoPanel.add(lblStudentInfomation);
		lblStudentInfomation.setFont(new Font("Tahoma", Font.BOLD, 20));

		comboBoxStudent = new JComboBox();
		comboBoxStudent.setBounds(120, 136, 242, 22);
		comboBoxStudent.setEditable(false);
		studentInfoPanel.add(comboBoxStudent);

		JPanel studentDelConfirmPanel = new JPanel();
		studentDelConfirmPanel.setBounds(681, 0, 444, 190);
		studentInfoPanel.add(studentDelConfirmPanel);
		studentDelConfirmPanel.setVisible(false);
		studentDelConfirmPanel.setLayout(null);

		JLabel lblConfirmDelTitle = new JLabel("You are deleting student:");
		lblConfirmDelTitle.setForeground(Color.RED);
		lblConfirmDelTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmDelTitle.setBounds(71, 0, 241, 36);
		studentDelConfirmPanel.add(lblConfirmDelTitle);

		JLabel lblStudentNameDel = new JLabel("Name:");
		lblStudentNameDel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentNameDel.setForeground(Color.BLACK);
		lblStudentNameDel.setBounds(12, 95, 73, 36);
		studentDelConfirmPanel.add(lblStudentNameDel);

		JLabel lbIStudentIdDel = new JLabel("ID:");
		lbIStudentIdDel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbIStudentIdDel.setBounds(12, 64, 44, 31);
		studentDelConfirmPanel.add(lbIStudentIdDel);

		JLabel lblStudentIdDisplay = new JLabel("New label");
		lblStudentIdDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentIdDisplay.setBounds(93, 71, 219, 16);
		studentDelConfirmPanel.add(lblStudentIdDisplay);

		JLabel lblStudentNameDisplay = new JLabel("New label");
		lblStudentNameDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentNameDisplay.setBounds(93, 105, 219, 16);
		studentDelConfirmPanel.add(lblStudentNameDisplay);

		JButton btnCancelDelStudent = new JButton("Cancel");
		btnCancelDelStudent.setBounds(215, 165, 97, 25);
		studentDelConfirmPanel.add(btnCancelDelStudent);

		JButton btnConfirmDelStudent = new JButton("Confirm");
		btnConfirmDelStudent.setBounds(53, 165, 97, 25);
		studentDelConfirmPanel.add(btnConfirmDelStudent);

		JLabel lblStudentList = new JLabel("Student List\r\n");
		lblStudentList.setForeground(Color.BLACK);
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentList.setBounds(354, 8, 128, 16);
		studentPanel.add(lblStudentList);
		
		JScrollPane studentScrollPane = new JScrollPane(table);
		studentScrollPane.setBounds(12, 37, 803, 211);
		studentPanel.add(studentScrollPane);
		
		table = new JTable() {;
			@Override
			// users not to be able to edit the values in cells by double-clicking them
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

		JPanel studentSearchPanel = new JPanel();
		studentSearchPanel.setBounds(827, 0, 310, 248);
		studentPanel.add(studentSearchPanel);
		studentSearchPanel.setLayout(null);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(79, 0, 78, 1);
		studentSearchPanel.add(label_2);

		JLabel lblSearchBox = new JLabel("SEARCH BOX");
		lblSearchBox.setForeground(Color.BLACK);
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

		txtStudenSeachId = new JTextField();
		txtStudenSeachId.setBounds(121, 54, 177, 22);
		studentSearchPanel.add(txtStudenSeachId);
		txtStudenSeachId.setColumns(10);

		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setBounds(121, 178, 157, -90);
		studentSearchPanel.add(list);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(201, 123, 97, 25);
		studentSearchPanel.add(btnSearch);

		cbProvinceStudenSearch = new JComboBox();
		cbProvinceStudenSearch.setBounds(121, 85, 177, 22);
		studentSearchPanel.add(cbProvinceStudenSearch);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				txtStudentId.setText(table.getModel().getValueAt(selectedRowIndex, 0).toString());
				txtStudentName.setText(table.getModel().getValueAt(selectedRowIndex, 1).toString());
				txtStudentDob.setText(table.getModel().getValueAt(selectedRowIndex, 2).toString());
				// Reset radio button
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				// If gender = 1, it means that gender is male, otherwise it's female
				boolean isMale = table.getModel().getValueAt(selectedRowIndex, 3).toString().equals("Male");
				if (isMale) {
					rdbtnMale.setSelected(true);
				} else {
					rdbtnFemale.setSelected(true);
				}

				comboBoxStudent.setSelectedItem((table.getModel().getValueAt(selectedRowIndex, 4).toString()));
				comboBoxStudent.updateUI();
				txtMath.setText(table.getModel().getValueAt(selectedRowIndex, 5).toString());
				txtChemistry.setText(table.getModel().getValueAt(selectedRowIndex, 6).toString());
				txtPhysical.setText(table.getModel().getValueAt(selectedRowIndex, 7).toString());
				txtStudentName.setEnabled(true);
				comboBoxStudent.setEnabled(true);
				txtStudentId.setEnabled(true);
				txtStudentDob.setEnabled(true);
				;
				txtMath.setEnabled(true);
				txtChemistry.setEnabled(true);
				txtPhysical.setEnabled(true);
			}
		});

		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isEditStudent = true;
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					txtMessage.setText("You have to choose the student row first");
				} else {
					txtStudentId.setEditable(true);
					txtStudentName.setEditable(true);
					txtStudentDob.setEditable(true);
					comboBoxStudent.setEditable(true);
					txtMath.setEditable(true);
					txtChemistry.setEditable(true);
					txtPhysical.setEditable(true);
					rdbtnMale.setEnabled(true);
					rdbtnFemale.setEnabled(true);
					btnSaveStudent.setEnabled(true);
				}
			}
		});

		btnInsertStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isEditStudent = false;
				txtMessage.setText("Please insert a student");
				timer.restart();
				txtStudentName.setText("");
				txtStudentId.setText("");
				txtStudentDob.setText("");
				txtStudentId.requestFocus();
				txtMath.setText("");
				txtChemistry.setText("");
				txtPhysical.setText("");

				txtStudentId.setEditable(true);
				txtStudentName.setEditable(true);
				txtStudentDob.setEditable(true);
				txtMath.setEditable(true);
				txtChemistry.setEditable(true);
				txtPhysical.setEditable(true);

				btnSaveStudent.setEnabled(true);
				rdbtnMale.setEnabled(true);
				rdbtnFemale.setEnabled(true);
				btnSaveStudent.setEnabled(true);
				comboBoxStudent.setEnabled(true);
			}
		});

		btnSaveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDTO student = new StudentDTO();
				String message;
				try {
					ProvinceDTO province = new ProvinceDTO();
					ProvinceBUS provinceBUS = new ProvinceBUS();
					List<ProvinceDTO> provinceList = provinceBUS.findAll();
					for (int i = 0; i < provinceList.size(); i++) {
						if (provinceList.get(i).getName().equals(comboBoxStudent.getSelectedItem())) {
							province = provinceList.get(i);
						}
					}
					if (rdbtnMale.isSelected()) {
						student = new StudentDTO(Integer.parseInt(txtStudentId.getText()), txtStudentName.getText(),
								province, txtStudentDob.getText(), 1, Float.parseFloat(txtMath.getText()),
								Float.parseFloat(txtPhysical.getText()), Float.parseFloat(txtChemistry.getText()));
					} else {
						student = new StudentDTO(Integer.parseInt(txtStudentId.getText()), txtStudentName.getText(),
								province, txtStudentDob.getText(), 0, Float.parseFloat(txtMath.getText()),
								Float.parseFloat(txtPhysical.getText()), Float.parseFloat(txtChemistry.getText()));
					}
					StudentBUS studentsBUS = new StudentBUS();

					if (!isEditStudent) {
						message = studentsBUS.insert(student);
						txtMessage.setText(message);
					} else {
						message = studentsBUS.update(student);
						txtMessage.setText(message);
					}

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				addRowToStudentTable();
				timer.restart();
			}
		});

		btnCancelStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtStudentId.setEditable(false);
				txtStudentName.setEditable(false);
				txtStudentDob.setEditable(false);
				txtMath.setEditable(false);
				txtChemistry.setEditable(false);
				txtPhysical.setEditable(false);

				btnSaveStudent.setEnabled(false);
				rdbtnMale.setEnabled(false);
				rdbtnFemale.setEnabled(false);
				btnSaveStudent.setEnabled(false);
				comboBoxStudent.setEnabled(false);

				txtStudentName.setText("");
				txtStudentId.setText("");
				txtStudentDob.setText("");
				txtStudentId.requestFocus();
				txtMath.setText("");
				txtChemistry.setText("");
				txtPhysical.setText("");

				addRowToStudentTable();
			}
		});

		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					txtMessage.setText("You have to choose student row first");
				} else {
					studentDelConfirmPanel.setVisible(true);
					lblStudentIdDisplay.setText(table.getValueAt(selectedRow, 1).toString());
					lblStudentNameDisplay.setText(table.getValueAt(selectedRow, 1).toString());
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentIdSearch = txtStudenSeachId.getText();
				String studentProvinceSearch = comboBoxStudent.getSelectedItem().toString();
				StudentBUS studentBUS = new StudentBUS();
				List<StudentDTO> studentsSearchList = new ArrayList<StudentDTO>();
				studentsSearchList = studentBUS.findStudentByIdAndPlace(studentIdSearch, studentProvinceSearch);
				System.out.print(studentsSearchList);
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("ID");
				model.addColumn("Name");
				model.addColumn("Date");
				model.addColumn("Gender");
				model.addColumn("Province");
				model.addColumn("Math");
				model.addColumn("Physical");
				model.addColumn("Chemistry");
				// Append rows
				Object studentTableRowData[] = new Object[10];
				for (StudentDTO studentSearch : studentsSearchList) {
					studentTableRowData[0] = studentSearch.getId();
					studentTableRowData[1] = studentSearch.getName();
					studentTableRowData[2] = studentSearch.getBirth();
					if (studentSearch.getGender() == 1) {
						studentTableRowData[3] = "Male";
					} else {
						studentTableRowData[3] = "Female";
					}
					studentTableRowData[4] = studentSearch.getPlace().getName();
					studentTableRowData[5] = studentSearch.getMath();
					studentTableRowData[6] = studentSearch.getPhysical();
					studentTableRowData[7] = studentSearch.getChemistry();
					model.addRow(studentTableRowData);
				}
				table.setModel(model);
			}
		});

		btnConfirmDelStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentBUS studentsBUS = new StudentBUS();
				String studentID = txtStudentId.getText();
				String message = studentsBUS.delete(Integer.parseInt(studentID));
				txtMessage.setText(message);
				addRowToStudentTable();
			}
		});

		btnCancelDelStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentDelConfirmPanel.setVisible(false);
			}
		});
	}

	private void addRowToProvinceTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Province ID");
		model.addColumn("Province Name");
		List<ProvinceDTO> provinces = new ArrayList<ProvinceDTO>();
		provinces = provinceBUS.findAll();
		Object provinceTableRowData[] = new Object[2];
		for (ProvinceDTO province : provinces) {
			provinceTableRowData[0] = province.getId();
			provinceTableRowData[1] = province.getName();
			model.addRow(provinceTableRowData);
		}
		provinceTable.setModel(model);
	}

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
		// Append rows
		StudentBUS studentBUS = new StudentBUS();
		List<StudentDTO> students = new ArrayList<StudentDTO>();

		students = studentBUS.findAll();

		Object studentTableRowData[] = new Object[10];
		for (StudentDTO student : students) {
			studentTableRowData[0] = student.getId();
			studentTableRowData[1] = student.getName();
			studentTableRowData[2] = student.getBirth();
			if (student.getGender() == 1) {
				studentTableRowData[3] = "Male";
			} else {
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
	
	private void addProvinceNameComboBox() {
		ProvinceDAO provinces = new ProvinceDAO();
		List<ProvinceDTO> provinceList;
		try {
			provinceList = provinces.showProvince();
			for (int i = 0; i < provinceList.size(); i++) {
				comboBoxStudent.addItem(provinceList.get(i).getName());
				cbProvinceStudenSearch.addItem(provinceList.get(i).getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
