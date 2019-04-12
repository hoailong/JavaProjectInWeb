package it1.studentmanagement.jframe.province;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

public class ProvinceMessagePanel extends JPanel {
	private JTextArea txtProvinceMessage;
	
	private Timer timer = new Timer(5000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtProvinceMessage.setText("");
		}

	});

	public ProvinceMessagePanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(500, 325, 600, 175);
		setLayout(null);

		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(258, 0, 83, 36);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblMessage);
		
		txtProvinceMessage = new JTextArea();
		txtProvinceMessage.setEditable(false);
		txtProvinceMessage.setLineWrap(true);
		txtProvinceMessage.setWrapStyleWord(true);
		txtProvinceMessage.setBounds(12, 37, 575, 125);
		txtProvinceMessage.setForeground(Color.RED);
		txtProvinceMessage.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(txtProvinceMessage);
		
	}
	
	protected void showProvinceMessage(String message) {
		txtProvinceMessage.setText(message);
		timer.restart();
	}
}
