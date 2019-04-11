package it1.studentmanagement.jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.bus.ProvinceBUS;
import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

public class StudentManagement {

	private JFrame frame;
	private JTextField txtProvinceID;
	private JTextField txtProvinceName;
	private static ProvinceBUS provinceBUS = new ProvinceBUS();
	private static StudentBUS studentsBUS = new StudentBUS();
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
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JTextArea txtStudentMessage;
	private JComboBox comboBoxStudent;
	private JComboBox cbProvinceStudenSearch;
	private JTextArea txtProvinceMessage;
	private Timer timer = new Timer(5000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtStudentMessage.setText("");
		}

	});

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Use Windows look and feel instead java swing look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
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
		frame.setBounds(100, 100, 1160, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 6, 1142, 597);
		frame.getContentPane().add(tabbedPane);

		initializeStudent();
		initializeProvince();
		initializeAbout();
		addProvinceNameComboBox();
		addRowToProvinceTable(provinceBUS.getProvinceList());
		addRowToStudentTable(studentsBUS.getStudentList());
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

		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		studentInfoPanel.setBounds(12, 261, 712, 293);
		studentPanel.add(studentInfoPanel);
		studentInfoPanel.setLayout(null);

		JLabel lblStudentID = new JLabel("Student ID:");
		lblStudentID.setBounds(33, 66, 72, 17);
		studentInfoPanel.add(lblStudentID);
		lblStudentID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtStudentId = new JTextField();
		txtStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStudentId.setEditable(false);
		txtStudentId.setBounds(141, 58, 242, 30);
		studentInfoPanel.add(txtStudentId);
		txtStudentId.setColumns(10);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(33, 94, 105, 31);
		studentInfoPanel.add(lblStudentName);
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDayOfBirth = new JLabel("Day Of Birth:");
		lblDayOfBirth.setBounds(33, 134, 105, 16);
		studentInfoPanel.add(lblDayOfBirth);
		lblDayOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtStudentName = new JTextField();
		txtStudentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStudentName.setEditable(false);
		txtStudentName.setBounds(141, 93, 242, 30);
		studentInfoPanel.add(txtStudentName);
		txtStudentName.setColumns(10);

		txtStudentDob = new JTextField();
		txtStudentDob.setToolTipText("YYYY-MM-DD");
		txtStudentDob.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStudentDob.setEditable(false);
		txtStudentDob.setBounds(141, 128, 242, 30);
		studentInfoPanel.add(txtStudentDob);
		txtStudentDob.setColumns(10);

		JLabel lblStudentProvinceName = new JLabel("Province Name\r\n:");
		lblStudentProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentProvinceName.setBounds(33, 169, 98, 16);
		studentInfoPanel.add(lblStudentProvinceName);

		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(468, 66, 72, 16);
		studentInfoPanel.add(lblGender);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setEnabled(false);
		rdbtnMale.setBounds(552, 60, 66, 25);
		studentInfoPanel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setEnabled(false);
		rdbtnFemale.setBounds(622, 60, 72, 25);
		studentInfoPanel.add(rdbtnFemale);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFemale);
		buttonGroup.add(rdbtnMale);

		JLabel lblMath = new JLabel("Math:");
		lblMath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMath.setBounds(468, 101, 72, 16);
		studentInfoPanel.add(lblMath);

		JLabel lblPhysical = new JLabel("Physical:");
		lblPhysical.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhysical.setBounds(468, 134, 72, 16);
		studentInfoPanel.add(lblPhysical);

		JLabel lblChemistry = new JLabel("Chemistry:");
		lblChemistry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChemistry.setBounds(468, 169, 72, 16);
		studentInfoPanel.add(lblChemistry);

		txtMath = new JTextField();
		txtMath.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMath.setEditable(false);
		txtMath.setBounds(548, 95, 142, 30);
		studentInfoPanel.add(txtMath);
		txtMath.setColumns(10);

		txtPhysical = new JTextField();
		txtPhysical.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPhysical.setEditable(false);
		txtPhysical.setBounds(548, 128, 142, 30);
		studentInfoPanel.add(txtPhysical);
		txtPhysical.setColumns(10);

		txtChemistry = new JTextField();
		txtChemistry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtChemistry.setEditable(false);
		txtChemistry.setBounds(548, 163, 142, 30);
		studentInfoPanel.add(txtChemistry);
		txtChemistry.setColumns(10);

		JButton btnSaveStudent = new JButton("Save");
		btnSaveStudent.setEnabled(false);
		btnSaveStudent.setBounds(259, 255, 97, 25);
		studentInfoPanel.add(btnSaveStudent);

		JButton btnInsertStudent = new JButton("Insert");
		btnInsertStudent.setBounds(42, 255, 97, 25);
		studentInfoPanel.add(btnInsertStudent);

		JButton btnEditStudent = new JButton("Edit");
		btnEditStudent.setEnabled(false);
		btnEditStudent.setBounds(150, 255, 97, 25);
		studentInfoPanel.add(btnEditStudent);

		JButton btnDeleteStudent = new JButton("Delete");
		btnDeleteStudent.setEnabled(false);
		btnDeleteStudent.setBounds(368, 255, 97, 25);
		studentInfoPanel.add(btnDeleteStudent);

		JButton btnCancelStudent = new JButton("Cancel");
		btnCancelStudent.setBounds(477, 255, 97, 25);
		studentInfoPanel.add(btnCancelStudent);

		JLabel lblStudentInfomation = new JLabel("Student Information");
		lblStudentInfomation.setForeground(Color.BLACK);
		lblStudentInfomation.setBounds(291, 14, 218, 16);
		studentInfoPanel.add(lblStudentInfomation);
		lblStudentInfomation.setFont(new Font("Tahoma", Font.BOLD, 20));

		comboBoxStudent = new JComboBox();
		comboBoxStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxStudent.setBounds(141, 163, 242, 30);
		comboBoxStudent.setEditable(false);
		comboBoxStudent.setEnabled(false);
		studentInfoPanel.add(comboBoxStudent);

		JLabel lblStudentList = new JLabel("Student List\r\n");
		lblStudentList.setForeground(Color.BLACK);
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentList.setBounds(508, 5, 121, 25);
		studentPanel.add(lblStudentList);

		JScrollPane studentScrollPane = new JScrollPane(table);
		studentScrollPane.setBounds(12, 37, 1114, 211);
		studentPanel.add(studentScrollPane);

		table = new JTable() {
			;
			@Override
			// users not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Date", "Gender", "Province", "Math", "Physical", "Chemistry" }));
		studentScrollPane.setViewportView(table);

		JPanel studentSearchPanel = new JPanel();
		studentSearchPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		studentSearchPanel.setBounds(734, 261, 394, 162);
		studentPanel.add(studentSearchPanel);
		studentSearchPanel.setLayout(null);

		JLabel lblSearchBox = new JLabel("Student Filtre");
		lblSearchBox.setForeground(Color.BLACK);
		lblSearchBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearchBox.setBounds(131, 11, 157, 30);
		studentSearchPanel.add(lblSearchBox);

		JLabel lblStudentId = new JLabel("Student ID: ");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentId.setBounds(54, 56, 86, 16);
		studentSearchPanel.add(lblStudentId);

		JLabel lblProvinceName_1 = new JLabel("Province Name:");
		lblProvinceName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProvinceName_1.setBounds(54, 87, 109, 16);
		studentSearchPanel.add(lblProvinceName_1);

		txtStudenSeachId = new JTextField();
		txtStudenSeachId.setBounds(163, 54, 177, 22);
		studentSearchPanel.add(txtStudenSeachId);
		txtStudenSeachId.setColumns(10);

		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setBounds(121, 178, 157, -90);
		studentSearchPanel.add(list);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(243, 123, 97, 25);
		studentSearchPanel.add(btnSearch);

		cbProvinceStudenSearch = new JComboBox();
		cbProvinceStudenSearch.setBounds(163, 85, 177, 22);
		studentSearchPanel.add(cbProvinceStudenSearch);

		JPanel studentMessagePane = new JPanel();
		studentMessagePane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		studentMessagePane.setBounds(734, 436, 392, 118);
		studentPanel.add(studentMessagePane);
		studentMessagePane.setLayout(null);

		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(163, 0, 90, 34);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		studentMessagePane.add(lblMessage);

		JScrollPane studentMessageScrollPanel = new JScrollPane();
		studentMessageScrollPanel.setBounds(12, 34, 370, 75);
		studentMessagePane.add(studentMessageScrollPanel);
		
				txtStudentMessage = new JTextArea();
				studentMessageScrollPanel.setViewportView(txtStudentMessage);
				txtStudentMessage.setEditable(false);
				txtStudentMessage.setWrapStyleWord(true);
				txtStudentMessage.setLineWrap(true);
				txtStudentMessage.setFont(new Font("Monospaced", Font.BOLD, 18));
				txtStudentMessage.setForeground(Color.RED);
				txtStudentMessage.setColumns(10);

		// khi chọn một row
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBoxStudent.setEnabled(true);
				btnEditStudent.setEnabled(true);
				btnDeleteStudent.setEnabled(true);

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

				setEditableTextFieldStudent(false);
			}
		});

		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isEditStudent = true;
				if (table.getSelectedRow() == -1) {
					showStudentMessage("You have to choose the student row first");
				} else {
					setEditableTextFieldStudent(true);
					btnSaveStudent.setEnabled(true);
				}
			}
		});

		btnInsertStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isEditStudent = false;
				clearTextFieldStudent();
				txtStudentDob.setText("YYYY-MM-DD");
				rdbtnMale.setSelected(true);
				comboBoxStudent.setEnabled(true);
				setEditableTextFieldStudent(true);
				btnSaveStudent.setEnabled(true);
			}
		});

		btnSaveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDTO student = new StudentDTO();
				String message;
				String name = txtStudentName.getText();
				String dob = txtStudentDob.getText();
				ProvinceDTO province = null;
				provinceBUS = new ProvinceBUS();
				List<ProvinceDTO> provinceList = provinceBUS.getProvinceList();
				for (int i = 0; i < provinceList.size(); i++) {
					if (provinceList.get(i).getName().equals(comboBoxStudent.getSelectedItem())) {
						province = new ProvinceDTO(provinceList.get(i).getName(), provinceList.get(i).getId());
					}
				}

				int gender = -1;
				if (rdbtnMale.isSelected()) {
					gender = 1;
				} else {
					gender = 0;
				}

				int id = 0;
				if (!txtStudentId.getText().isEmpty()) {
					id = Integer.parseInt(txtStudentId.getText());
				}
				// TH điền thiếu thông tin
				if (name.isEmpty() || dob.isEmpty() || txtMath.getText().isEmpty() || txtPhysical.getText().isEmpty()
						|| txtChemistry.getText().isEmpty() || gender == -1 || province == null) {
					showStudentMessage("Vui lòng điền đầy đủ thông tin!");
					return;
				}
				float math = -1;
				float physical = -1;
				float chemistry = -1;
				// bắt lỗi nhập chữ trong ô điểm
				try {
					math = Float.parseFloat(txtMath.getText());
					physical = Float.parseFloat(txtPhysical.getText());
					chemistry = Float.parseFloat(txtChemistry.getText());
				} catch (NumberFormatException e) {
					showStudentMessage("Điểm không hợp lệ!");
					return;
				}
				// TH điểm k hợp lệ
				if (math < 0 || math > 10 || physical < 0 || physical > 10 || chemistry < 0 || chemistry > 10) {
					showStudentMessage("Điểm phải từ 0 -10!");
					return;
				}

				student = new StudentDTO(id, name, province, dob, gender, math, physical, chemistry);

				if (!isEditStudent) {
					message = studentsBUS.insert(student);
					showStudentMessage(message);
					clearTextFieldStudent();
					setEditableTextFieldStudent(false);
				} else {
					message = studentsBUS.update(student);
					showStudentMessage(message);
				}
				addRowToStudentTable(studentsBUS.getStudentList());
			}
		});

		btnCancelStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxStudent.setEnabled(false);
				btnSaveStudent.setEnabled(false);
				setEditableTextFieldStudent(false);
				clearTextFieldStudent();
				addRowToStudentTable(studentsBUS.getStudentList());
			}
		});

		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					showStudentMessage("You have to choose the student row first");

				} else {
					int selectedRow = table.getSelectedRow();
					int accept = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc muốn xóa?\nID: " + table.getValueAt(selectedRow, 0).toString() + "\nName: "
									+ table.getValueAt(selectedRow, 1).toString(),
							"Xóa thí sinh", JOptionPane.YES_NO_OPTION);
					if (accept == JOptionPane.YES_OPTION) {
						String message = studentsBUS
								.delete(Integer.parseInt(table.getValueAt(selectedRow, 0).toString()));
						showStudentMessage(message);
						btnSaveStudent.setEnabled(false);
						setEditableTextFieldStudent(false);
						clearTextFieldStudent();
						addRowToStudentTable(studentsBUS.getStudentList());
					}
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentIdSearch = txtStudenSeachId.getText();
				String studentProvinceNameSearch = cbProvinceStudenSearch.getSelectedItem().toString();
				if (studentProvinceNameSearch.equals("--Tất cả--")) {
					studentProvinceNameSearch = "";
				}
				List<StudentDTO> studentsSearchList = studentsBUS.getStudentList(studentIdSearch,
						studentProvinceNameSearch);
				addRowToStudentTable(studentsSearchList);
			}
		});

	}

	private void initializeProvince() {
		JPanel provincePanel = new JPanel();
		tabbedPane.addTab("Province", null, provincePanel, null);
		provincePanel.setLayout(null);

		JScrollPane provinceScrollPane = new JScrollPane();
		provinceScrollPane.setBounds(61, 62, 415, 474);
		provincePanel.add(provinceScrollPane);

		provinceTable = new JTable() {
			;
			@Override
			// users not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		provinceTable.setRowHeight(30);
		provinceTable.setFont(new Font("Tahoma", Font.PLAIN, 18));

		provinceTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Province Name" }));
		provinceScrollPane.setViewportView(provinceTable);

		JPanel provinceInformationPane = new JPanel();
		provinceInformationPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		provinceInformationPane.setBounds(501, 113, 599, 177);
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
		txtProvinceID.setBounds(132, 61, 450, 25);
		provinceInformationPane.add(txtProvinceID);
		txtProvinceID.setEditable(false);
		txtProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProvinceID.setColumns(10);

		txtProvinceName = new JTextField();
		txtProvinceName.setBounds(132, 89, 450, 25);
		provinceInformationPane.add(txtProvinceName);
		txtProvinceName.setEditable(false);
		txtProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProvinceName.setColumns(10);

		JButton btnInsertProvince = new JButton("Insert");
		btnInsertProvince.setBounds(10, 141, 97, 25);
		provinceInformationPane.add(btnInsertProvince);

		btnInsertProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEditProvince = new JButton("Edit");
		btnEditProvince.setBounds(132, 141, 97, 25);
		btnEditProvince.setEnabled(false);
		provinceInformationPane.add(btnEditProvince);

		btnEditProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnDeleteProvince = new JButton("Delete");
		btnDeleteProvince.setBounds(252, 141, 97, 25);
		btnDeleteProvince.setEnabled(false);
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

		JPanel provinceMessagePane = new JPanel();
		provinceMessagePane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		provinceMessagePane.setBounds(501, 324, 599, 175);
		provincePanel.add(provinceMessagePane);
		provinceMessagePane.setLayout(null);

		txtProvinceMessage = new JTextArea();
		txtProvinceMessage.setEditable(false);
		txtProvinceMessage.setLineWrap(true);
		txtProvinceMessage.setWrapStyleWord(true);
		txtProvinceMessage.setBounds(12, 37, 575, 125);
		provinceMessagePane.add(txtProvinceMessage);
		txtProvinceMessage.setForeground(Color.RED);
		txtProvinceMessage.setFont(new Font("Monospaced", Font.BOLD, 20));

		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setBounds(258, 0, 83, 36);
		provinceMessagePane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		// Event listener
		btnCancelProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceName.setEditable(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				btnSaveProvince.setEnabled(false);
			}
		});

		btnSaveProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtProvinceName.getText().isEmpty()) {
					showProvinceMessage("Province name can't be null");
					txtProvinceName.requestFocus();
				} else {
					String provinceName = txtProvinceName.getText();
					if (!isEditProvince) {
						String message = provinceBUS.insert(provinceName);
						showProvinceMessage(message);
					} else {
						int provinceId = Integer.parseInt(txtProvinceID.getText());
						String message = provinceBUS.update(provinceId, provinceName);
						showProvinceMessage(message);
					}
					addRowToProvinceTable(provinceBUS.getProvinceList());
					addProvinceNameComboBox();
					txtProvinceID.setText("");
					txtProvinceName.setText("");
					btnSaveProvince.setEnabled(false);
				}
			}
		});

		btnDeleteProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					int accept = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc muốn xóa?\nID: " + provinceTable.getValueAt(selectedRowIndex, 0).toString()
									+ "\nName: " + provinceTable.getValueAt(selectedRowIndex, 1).toString(),
							"Xóa tỉnh", JOptionPane.YES_NO_OPTION);
					if (accept == JOptionPane.YES_OPTION) {
						String message = provinceBUS.delete(Integer.parseInt(txtProvinceID.getText()));
						showProvinceMessage(message);
						addRowToProvinceTable(provinceBUS.getProvinceList());
						addProvinceNameComboBox();
						txtProvinceID.setText("");
						txtProvinceName.setText("");
						txtProvinceName.setEditable(false);
					}

				} else {
					showProvinceMessage("You have to choose a province row first");
				}
			}
		});

		btnEditProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					isEditProvince = true;
					btnSaveProvince.setEnabled(true);
					txtProvinceName.setEditable(true);
					txtProvinceName.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "You have to choose a province row first", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
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

		provinceTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditProvince.setEnabled(true);
				btnDeleteProvince.setEnabled(true);
				btnEditProvince.setEnabled(true);
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
		lblTitle.setBounds(71, 26, 994, 52);
		aboutPanel.add(lblTitle);
		
		JPanel aboutPanelInfor = new JPanel();
		aboutPanelInfor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		aboutPanelInfor.setBounds(283, 112, 571, 315);
		aboutPanel.add(aboutPanelInfor);
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

	private void addRowToProvinceTable(List<ProvinceDTO> provinces) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Province ID");
		model.addColumn("Province Name");
		provinces = provinceBUS.getProvinceList();
		Object provinceTableRowData[] = new Object[2];
		for (ProvinceDTO province : provinces) {
			provinceTableRowData[0] = province.getId();
			provinceTableRowData[1] = province.getName();
			model.addRow(provinceTableRowData);
		}
		provinceTable.setModel(model);
	}

	private void addRowToStudentTable(List<StudentDTO> students) {

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Date");
		model.addColumn("Gender");
		model.addColumn("Province");
		model.addColumn("Math");
		model.addColumn("Physical");
		model.addColumn("Chemistry");

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
		ProvinceBUS provinces = new ProvinceBUS();
		List<ProvinceDTO> provinceList;
		comboBoxStudent.removeAllItems();
		cbProvinceStudenSearch.removeAllItems();
		comboBoxStudent.addItem("--Chọn tỉnh--");
		cbProvinceStudenSearch.addItem("--Tất cả--");
		provinceList = provinces.getProvinceList();
		for (int i = 0; i < provinceList.size(); i++) {
			comboBoxStudent.addItem(provinceList.get(i).getName());
			cbProvinceStudenSearch.addItem(provinceList.get(i).getName());
		}
	}

	private void clearTextFieldStudent() {
		txtStudentName.setText("");
		txtStudentId.setText("");
		txtStudentDob.setText("");
		txtMath.setText("");
		txtChemistry.setText("");
		txtPhysical.setText("");
		txtStudentName.requestFocus();
	}

	private void setEditableTextFieldStudent(boolean bool) {
		txtStudentName.setEditable(bool);
		txtStudentDob.setEditable(bool);
		txtMath.setEditable(bool);
		txtChemistry.setEditable(bool);
		txtPhysical.setEditable(bool);
		rdbtnMale.setEnabled(bool);
		rdbtnFemale.setEnabled(bool);
	}

	private void showStudentMessage(String message) {
		txtStudentMessage.setText(message);
		timer.restart();
	}

	private void showProvinceMessage(String message) {
		txtProvinceMessage.setText(message);
		timer.restart();
	}
}
