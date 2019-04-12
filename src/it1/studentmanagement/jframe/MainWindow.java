package it1.studentmanagement.jframe;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

import it1.studentmanagement.jframe.about.AboutPanel;
import it1.studentmanagement.jframe.province.ProvincePanel;
import it1.studentmanagement.jframe.student.StudentPanel;

public class MainWindow extends JFrame {
	private JTabbedPane tabbedPane;
	
	public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(360, 240, 1225, 650);
        setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 1200, 600);
		add(tabbedPane);
		
		StudentPanel studentPanel = new StudentPanel();
		tabbedPane.addTab("Student", studentPanel);
		
		ProvincePanel provincePanel = new ProvincePanel();
		tabbedPane.addTab("Province", provincePanel);
		
		AboutPanel about = new AboutPanel();
		tabbedPane.addTab("About", about);
    }

}
