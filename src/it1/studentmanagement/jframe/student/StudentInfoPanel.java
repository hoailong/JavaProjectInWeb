package it1.studentmanagement.jframe.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.JTextComponent;

import it1.studentmanagement.bus.ProvinceBUS;
import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

public class StudentInfoPanel extends JPanel{
	private JTextField txtStudentId;
	private JTextField txtStudentName;
	private JTextField txtStudentDob;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JTextField txtMath;
	private JTextField txtPhysical;
	private JTextField txtChemistry;
	private JComboBox comboBoxStudent;
	protected boolean isEditStudent = false;

	public StudentInfoPanel(StudentBUS studentBUS, ProvinceBUS provinceBUS, StudentScrollPane scrollPane, StudentMessagePanel messagePanel) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(12, 261, 712, 293);
		//getContentPane().add(studentInfoPanel);
		setLayout(null);

		JLabel lblStudentID = new JLabel("Student ID:");
		lblStudentID.setBounds(33, 66, 72, 17);
		add(lblStudentID);
		lblStudentID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtStudentId = new JTextField();
		txtStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStudentId.setEditable(false);
		txtStudentId.setBounds(141, 58, 242, 30);
		add(txtStudentId);
		txtStudentId.setColumns(10);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(33, 94, 105, 31);
		add(lblStudentName);
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDayOfBirth = new JLabel("Day Of Birth:");
		lblDayOfBirth.setBounds(33, 134, 105, 16);
		add(lblDayOfBirth);
		lblDayOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtStudentName = new JTextField();
		txtStudentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStudentName.setEditable(false);
		txtStudentName.setBounds(141, 93, 242, 30);
		add(txtStudentName);
		txtStudentName.setColumns(10);

		txtStudentDob = new JTextField();
		txtStudentDob.setToolTipText("YYYY-MM-DD");
		txtStudentDob.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStudentDob.setEditable(false);
		txtStudentDob.setBounds(141, 128, 242, 30);
		add(txtStudentDob);
		txtStudentDob.setColumns(10);

		JLabel lblStudentProvinceName = new JLabel("Province Name\r\n:");
		lblStudentProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentProvinceName.setBounds(33, 169, 98, 16);
		add(lblStudentProvinceName);

		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(468, 66, 72, 16);
		add(lblGender);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setEnabled(false);
		rdbtnMale.setBounds(552, 60, 66, 25);
		add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setEnabled(false);
		rdbtnFemale.setBounds(622, 60, 72, 25);
		add(rdbtnFemale);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFemale);
		buttonGroup.add(rdbtnMale);

		JLabel lblMath = new JLabel("Math:");
		lblMath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMath.setBounds(468, 101, 72, 16);
		add(lblMath);

		JLabel lblPhysical = new JLabel("Physical:");
		lblPhysical.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhysical.setBounds(468, 134, 72, 16);
		add(lblPhysical);

		JLabel lblChemistry = new JLabel("Chemistry:");
		lblChemistry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChemistry.setBounds(468, 169, 72, 16);
		add(lblChemistry);

		txtMath = new JTextField();
		txtMath.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMath.setEditable(false);
		txtMath.setBounds(548, 95, 142, 30);
		add(txtMath);
		txtMath.setColumns(10);

		txtPhysical = new JTextField();
		txtPhysical.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPhysical.setEditable(false);
		txtPhysical.setBounds(548, 128, 142, 30);
		add(txtPhysical);
		txtPhysical.setColumns(10);

		txtChemistry = new JTextField();
		txtChemistry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtChemistry.setEditable(false);
		txtChemistry.setBounds(548, 163, 142, 30);
		add(txtChemistry);
		txtChemistry.setColumns(10);

		JButton btnSaveStudent = new JButton("Save");
		btnSaveStudent.setEnabled(false);
		btnSaveStudent.setBounds(259, 255, 97, 25);
		add(btnSaveStudent);

		JButton btnInsertStudent = new JButton("Insert");
		btnInsertStudent.setBounds(42, 255, 97, 25);
		add(btnInsertStudent);

		JButton btnEditStudent = new JButton("Edit");
		btnEditStudent.setEnabled(false);
		btnEditStudent.setBounds(150, 255, 97, 25);
		add(btnEditStudent);

		JButton btnDeleteStudent = new JButton("Delete");
		btnDeleteStudent.setEnabled(false);
		btnDeleteStudent.setBounds(368, 255, 97, 25);
		add(btnDeleteStudent);

		JButton btnCancelStudent = new JButton("Cancel");
		btnCancelStudent.setBounds(477, 255, 97, 25);
		add(btnCancelStudent);

		JLabel lblStudentInfomation = new JLabel("Student Information");
		lblStudentInfomation.setForeground(Color.BLACK);
		lblStudentInfomation.setBounds(291, 14, 218, 16);
		add(lblStudentInfomation);
		lblStudentInfomation.setFont(new Font("Tahoma", Font.BOLD, 20));

		comboBoxStudent = new JComboBox();
		comboBoxStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxStudent.setBounds(141, 163, 242, 30);
		comboBoxStudent.setEditable(false);
		comboBoxStudent.setEnabled(false);
		scrollPane.addProvinceComboBox(comboBoxStudent);
		add(comboBoxStudent);
		
		
		// Event Listener
		scrollPane.getStudentTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBoxStudent.setEnabled(true);
				btnEditStudent.setEnabled(true);
				btnDeleteStudent.setEnabled(true);
				
				JTable table = scrollPane.getStudentTable();
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
				isEditStudent  = true;
				if (scrollPane.getStudentTable().getSelectedRow() == -1) {
					messagePanel.showStudentMessage("You have to choose the student row first");
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
					messagePanel.showStudentMessage("Vui lòng điền đầy đủ thông tin!");
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
					messagePanel.showStudentMessage("Điểm không hợp lệ!");
					return;
				}
				// TH điểm k hợp lệ
				if (math < 0 || math > 10 || physical < 0 || physical > 10 || chemistry < 0 || chemistry > 10) {
					messagePanel.showStudentMessage("Điểm phải từ 0 -10!");
					return;
				}

				student = new StudentDTO(id, name, province, dob, gender, math, physical, chemistry);

				if (!isEditStudent) {
					message = studentBUS.insert(student);
					messagePanel.showStudentMessage(message);
					clearTextFieldStudent();
					setEditableTextFieldStudent(false);
				} else {
					message = studentBUS.update(student);
					messagePanel.showStudentMessage(message);
				}
				scrollPane.addRowToStudentTable(studentBUS.getStudentList());
			}
		});

		btnCancelStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxStudent.setEnabled(false);
				btnSaveStudent.setEnabled(false);
				setEditableTextFieldStudent(false);
				clearTextFieldStudent();
				scrollPane.addRowToStudentTable(studentBUS.getStudentList());
			}
		});

		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = new JTable();
				table = scrollPane.getStudentTable();
				
				if (scrollPane.getStudentTable().getSelectedRow() == -1) {
					messagePanel.showStudentMessage("You have to choose the student row first");

				} else {
					int selectedRow = table.getSelectedRow();
					int accept = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc muốn xóa?\nID: " + table.getValueAt(selectedRow, 0).toString() + "\nName: "
									+ table.getValueAt(selectedRow, 1).toString(),
							"Xóa thí sinh", JOptionPane.YES_NO_OPTION);
					if (accept == JOptionPane.YES_OPTION) {
						String message = studentBUS
								.delete(Integer.parseInt(table.getValueAt(selectedRow, 0).toString()));
						messagePanel.showStudentMessage(message);
						btnSaveStudent.setEnabled(false);
						setEditableTextFieldStudent(false);
						clearTextFieldStudent();
						scrollPane.addRowToStudentTable(studentBUS.getStudentList());
					}
				}
			}
		});
		
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
	
}
