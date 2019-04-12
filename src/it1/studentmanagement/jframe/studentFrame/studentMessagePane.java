package it1.studentmanagement.jframe.studentFrame;

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

public class studentMessagePane	 extends JPanel{
	private JLabel txtStudentMessage;
	private Timer timer = new Timer(5000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtStudentMessage.setText("");
		}

	});
	
	public studentMessagePane() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(734, 436, 392, 118);
		//getContentPane().add(studentMessagePane);
		setLayout(null);

		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(163, 0, 90, 34);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblMessage);

		JScrollPane studentMessageScrollPanel = new JScrollPane();
		studentMessageScrollPanel.setBounds(12, 34, 370, 75);
		add(studentMessageScrollPanel);
	}
	
	public void showStudentMessage(String message) {
		txtStudentMessage.setText(message);
		timer.restart();
	}
}
