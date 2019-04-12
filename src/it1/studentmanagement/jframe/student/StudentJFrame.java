package it1.studentmanagement.jframe.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.bus.ProvinceBUS;
import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

public class StudentJFrame extends JFrame {
	private JTextField txtStudentId;
	private JTextField txtStudentName;
	private JTextField txtStudentDob;
	private JTextField txtMath;
	private JTextField txtPhysical;
	private JTextField txtChemistry;
	private JTextField txtStudenSeachId;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JTextArea txtStudentMessage;
	private JComboBox comboBoxStudent;
	private JComboBox cbProvinceStudenSearch;
	private JTable table;
	private static ProvinceBUS provinceBUS = new ProvinceBUS();
	private static StudentBUS studentsBUS = new StudentBUS();
	private static boolean isEditStudent = false;
	private Timer timer = new Timer(5000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtStudentMessage.setText("");
		}

	});
	private JPanel studentMessagePane;
	public StudentJFrame() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		JScrollPane studentScrollList = new JScrollPane();
		studentScrollList.setBounds(0, 249, 668, -220);

		getContentPane().setLayout(null);

		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		studentInfoPanel.setBounds(12, 261, 712, 293);
		getContentPane().add(studentInfoPanel);
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
		getContentPane().add(lblStudentList);

		JScrollPane studentScrollPane = new JScrollPane(table);
		studentScrollPane.setBounds(12, 37, 1114, 211);
		getContentPane().add(studentScrollPane);

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
		getContentPane().add(studentSearchPanel);
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

		studentMessagePane = new JPanel();
		studentMessagePane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		studentMessagePane.setBounds(734, 436, 392, 118);
		getContentPane().add(studentMessagePane);
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
		ProvinceDAO provinces = new ProvinceDAO();
		List<ProvinceDTO> provinceList;
		try {
			comboBoxStudent.removeAllItems();
			cbProvinceStudenSearch.removeAllItems();
			comboBoxStudent.addItem("--Chọn tỉnh--");
			cbProvinceStudenSearch.addItem("--Tất cả--");
			provinceList = provinces.getAllProvinces();
			for (int i = 0; i < provinceList.size(); i++) {
				comboBoxStudent.addItem(provinceList.get(i).getName());
				cbProvinceStudenSearch.addItem(provinceList.get(i).getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
}
