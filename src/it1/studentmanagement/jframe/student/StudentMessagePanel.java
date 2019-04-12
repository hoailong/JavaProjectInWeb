package it1.studentmanagement.jframe.student;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

public class StudentMessagePanel	 extends JPanel{
	private JTextArea txtStudentMessage;
	private Timer timer = new Timer(5000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtStudentMessage.setText("");
		}

	});
	
	public StudentMessagePanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(734, 436, 454, 118);
		setLayout(null);

		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(190, 0, 80, 34);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblMessage);

		JScrollPane studentMessageScrollPanel = new JScrollPane();
		studentMessageScrollPanel.setBounds(12, 34, 430, 75);
		add(studentMessageScrollPanel);
		
		txtStudentMessage = new JTextArea();
		studentMessageScrollPanel.setViewportView(txtStudentMessage);
		txtStudentMessage.setEditable(false);
		txtStudentMessage.setWrapStyleWord(true);
		txtStudentMessage.setLineWrap(true);
		txtStudentMessage.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtStudentMessage.setForeground(Color.RED);
		txtStudentMessage.setColumns(10);
		
	}
	
	public void showStudentMessage(String message) {
		txtStudentMessage.setText(message);
		timer.restart();
	}
}
