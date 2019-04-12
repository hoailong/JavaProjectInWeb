package it1.studentmanagement.jframe.province;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import it1.studentmanagement.bus.ProvinceBUS;

public class ProvincePanel extends JPanel {
	private static ProvinceBUS provinceBUS = new ProvinceBUS();

	public ProvincePanel() {
        setBounds(0, 0, 1200, 600);
		setLayout(null);
		
		JLabel lblProvinceManagement = new JLabel("Province Management");
		lblProvinceManagement.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProvinceManagement.setBounds(465, 11, 270, 32);
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
