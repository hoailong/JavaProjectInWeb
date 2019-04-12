package it1.studentmanagement.jframe.studentFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import it1.studentmanagement.bus.StudentBUS;
import it1.studentmanagement.bus.ProvinceBUS;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class studentFrame extends JFrame{
	private StudentBUS studentsBUS;
	private ProvinceBUS provinceBUS = new ProvinceBUS();
	public studentFrame() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		
		JLabel lblStudentList = new JLabel("Student List\r\n");
		lblStudentList.setForeground(Color.BLACK);
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentList.setBounds(508, 5, 121, 25);
		getContentPane().add(lblStudentList);
		
		studentsBUS  = new StudentBUS();
		provinceBUS = new ProvinceBUS();
		
		
		studentMessagePane messagePanel = new studentMessagePane();
		getContentPane().add(messagePanel);
		
		studentScrollPane scrollPane = new studentScrollPane();
		getContentPane().add(scrollPane);
		
		studentSearchPanel searchPanel = new studentSearchPanel();
		getContentPane().add(searchPanel);
		
		studentInfoPanel infoPanel = new studentInfoPanel(studentsBUS , provinceBUS, scrollPane, messagePanel);
		getContentPane().add(infoPanel);
		
		scrollPane.addRowToStudentTable(studentsBUS.getStudentList());
	}
	
}
