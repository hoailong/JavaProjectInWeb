package it1.studentmanagement.jframe.studentFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class studentSearchPanel  extends JPanel{
	private JTextField txtStudenSeachId;
	private JComboBox cbProvinceStudenSearch;

	public studentSearchPanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(734, 261, 394, 162);
		setLayout(null);

		JLabel lblSearchBox = new JLabel("Student Filtre");
		lblSearchBox.setForeground(Color.BLACK);
		lblSearchBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearchBox.setBounds(131, 11, 157, 30);
		add(lblSearchBox);

		JLabel lblStudentId = new JLabel("Student ID: ");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentId.setBounds(54, 56, 86, 16);
		add(lblStudentId);

		JLabel lblProvinceName_1 = new JLabel("Province Name:");
		lblProvinceName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProvinceName_1.setBounds(54, 87, 109, 16);
		add(lblProvinceName_1);

		txtStudenSeachId = new JTextField();
		txtStudenSeachId.setBounds(163, 54, 177, 22);
		add(txtStudenSeachId);
		txtStudenSeachId.setColumns(10);

		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setBounds(121, 178, 157, -90);
		add(list);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(243, 123, 97, 25);
		add(btnSearch);

		cbProvinceStudenSearch = new JComboBox();
		cbProvinceStudenSearch.setBounds(163, 85, 177, 22);
		add(cbProvinceStudenSearch);
	}
}
