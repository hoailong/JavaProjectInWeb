package it1.studentmanagement.jframe.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.dto.StudentDTO;

public class StudentSearchPanel  extends JPanel{
	private JTextField txtStudenSeachId;
	protected JComboBox cbProvinceStudenSearch;

	public StudentSearchPanel(StudentBUS studentBUS, StudentScrollPane scrollPane) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(734, 261, 454, 162);
		setLayout(null);

		JLabel lblSearchBox = new JLabel("Student Filter");
		lblSearchBox.setForeground(Color.BLACK);
		lblSearchBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearchBox.setBounds(155, 11, 157, 30);
		add(lblSearchBox);

		JLabel lblStudentId = new JLabel("Student ID: ");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentId.setBounds(75, 56, 86, 16);
		add(lblStudentId);

		JLabel lblProvinceName_1 = new JLabel("Province Name:");
		lblProvinceName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProvinceName_1.setBounds(75, 87, 109, 16);
		add(lblProvinceName_1);

		txtStudenSeachId = new JTextField();
		txtStudenSeachId.setBounds(185, 54, 177, 22);
		add(txtStudenSeachId);

		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setBounds(143, 178, 157, -90);
		add(list);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(265, 123, 97, 25);
		add(btnSearch);

		cbProvinceStudenSearch = new JComboBox();
		cbProvinceStudenSearch.setBounds(185, 85, 177, 22);
		addProvinceCBInSearch();
		add(cbProvinceStudenSearch);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentIdSearch = txtStudenSeachId.getText();
				String studentProvinceNameSearch = cbProvinceStudenSearch.getSelectedItem().toString();
				if (studentProvinceNameSearch.equals("--Tất cả--")) {
					studentProvinceNameSearch = "";
				}
				List<StudentDTO> studentsSearchList = studentBUS.getStudentList(studentIdSearch,
						studentProvinceNameSearch);
				scrollPane.addRowToStudentTable(studentsSearchList);
			}
		});
	}
	
	protected void addProvinceCBInSearch() {
		ProvinceDAO provinces = new ProvinceDAO();
		List<ProvinceDTO> provinceList;
		try {
			cbProvinceStudenSearch.removeAllItems();
			cbProvinceStudenSearch.addItem("--Tất cả--");
			provinceList = provinces.getAllProvinces();
			for (int i = 0; i < provinceList.size(); i++) {
				cbProvinceStudenSearch.addItem(provinceList.get(i).getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
