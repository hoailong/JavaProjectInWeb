package it1.studentmanagement.jframe.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.List;

import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.bus.ProvinceBUS;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class StudentPanel extends JPanel{
	private static StudentBUS studentBUS = new StudentBUS();
	private static ProvinceBUS provinceBUS = new ProvinceBUS();
	public StudentPanel() {
		setBounds(0, 0, 1200, 600);
		setLayout(null);
		
		JLabel lblStudentList = new JLabel("Student Management");
		lblStudentList.setForeground(Color.BLACK);
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentList.setBounds(465, 11, 230, 25);
		add(lblStudentList);	
		
		StudentMessagePanel messagePanel = new StudentMessagePanel();
		add(messagePanel);
		
		StudentScrollPane scrollPane = new StudentScrollPane();
		add(scrollPane);
	
		StudentSearchPanel searchPanel = new StudentSearchPanel(studentBUS, scrollPane);
		add(searchPanel);
		
		StudentInfoPanel infoPanel = new StudentInfoPanel(studentBUS , provinceBUS, scrollPane, messagePanel, searchPanel);
		add(infoPanel);
		
		scrollPane.addRowToStudentTable(studentBUS.getStudentList());
		
	}
	
}
