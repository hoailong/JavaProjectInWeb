package it1.studentmanagement.jframe.student;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

public class StudentScrollPane  extends JScrollPane{
	private JTable studentTable;

	public JTable getStudentTable() {
		return studentTable;
	}

	public StudentScrollPane() {
		setBounds(12, 37, 1176, 211);
		//getContentPane().add(studentScrollPane);

		studentTable = new JTable() {
			;
			@Override
			// users not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		studentTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		studentTable.setRowHeight(25);
		studentTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Date", "Gender", "Province", "Math", "Physical", "Chemistry" }));
		setViewportView(studentTable);
	}
	
	void addRowToStudentTable(List<StudentDTO> students) {

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
		studentTable.setModel(model);
	}
	
	protected void addProvinceComboBox(JComboBox comboBox) {
		ProvinceDAO provinces = new ProvinceDAO();
		List<ProvinceDTO> provinceList;
		try {
			comboBox.removeAllItems();
			comboBox.addItem("--Chọn tỉnh--");
			provinceList = provinces.getAllProvinces();
			for (int i = 0; i < provinceList.size(); i++) {
				comboBox.addItem(provinceList.get(i).getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
