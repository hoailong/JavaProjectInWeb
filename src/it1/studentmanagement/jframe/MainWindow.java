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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

import it1.studentmanagement.jframe.about.AboutPanel;
import it1.studentmanagement.jframe.province.ProvinceJFrame;

public class MainWindow extends JFrame {

	public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(360, 240, 1200, 600);
        setLayout(null);

		JLabel lblTitle = new JLabel("Chương trình quản lý thí sinh dự thi Đại Học");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(120, 20, 960, 45);
		add(lblTitle);
		
		AboutPanel about = new AboutPanel();
		add(about);
		
        final JButton btnOpenSM = new JButton("Student Management");
        btnOpenSM.setBounds(300, 450, 200, 50);
        btnOpenSM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentJFrame studentJframe = new StudentJFrame();
                studentJframe.setVisible(true);
            }
        });
        add(btnOpenSM);
        
        final JButton btnOpenPM = new JButton("Province Management");
        btnOpenPM.setBounds(700, 450, 200, 50);
        btnOpenPM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProvinceJFrame provinceJframe = new ProvinceJFrame();
                provinceJframe.setVisible(true);
            }
        });
        add(btnOpenPM);
    }

}
