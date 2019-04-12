package it1.studentmanagement.jframe.province;


import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.bus.ProvinceBUS;

import it1.studentmanagement.dto.ProvinceDTO;

public class ProvinceJFrame extends JFrame {
	private static ProvinceBUS provinceBUS = new ProvinceBUS();

	public ProvinceJFrame() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
		setLayout(null);
		
		JLabel lblProvinceManagement = new JLabel("Province Management");
		lblProvinceManagement.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProvinceManagement.setBounds(424, 11, 273, 32);
		add(lblProvinceManagement);
		
		ProvinceMessagePanel messagePanel = new ProvinceMessagePanel();
		add(messagePanel);
		
		ProvinceScrollPane scrollPane = new ProvinceScrollPane();
		add(scrollPane);
		
		ProvinceInfoPanel infoPanel = new ProvinceInfoPanel(scrollPane, messagePanel, provinceBUS);
		add(infoPanel);
		scrollPane.addRowToProvinceTable(provinceBUS.getProvinceList());
	}

}
