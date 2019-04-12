package it1.studentmanagement.jframe.province;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.bus.ProvinceBUS;

public class ProvinceInfoPanel extends JPanel {
	protected JTextField txtProvinceID;
	protected JTextField txtProvinceName;
	protected JButton btnInsertProvince;
	protected JButton btnEditProvince;
	protected JButton btnDeleteProvince;
	protected JButton btnSaveProvince;
	protected JButton btnCancelProvince;
	private static boolean isEditProvince = false;
	/**
	 * Create the panel.
	 */
	public ProvinceInfoPanel(ProvinceScrollPane scrollPane, ProvinceMessagePanel messagePanel, ProvinceBUS provinceBUS) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(500, 115, 600, 175);
		setLayout(null);

		JLabel lblProvinceInformation = new JLabel("Province Information");
		lblProvinceInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProvinceInformation.setBounds(204, 11, 199, 39);
		add(lblProvinceInformation);
		
		JLabel lblProvinceID = new JLabel("Province ID:");
		lblProvinceID.setBounds(10, 55, 125, 17);
		lblProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblProvinceID);
		
		txtProvinceID = new JTextField();
		txtProvinceID.setBounds(190, 55, 400, 25);
		txtProvinceID.setEditable(false);
		txtProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProvinceID.setColumns(10);
		add(txtProvinceID);
		
		JLabel lblProvinceName = new JLabel("Province Name:");
		lblProvinceName.setBounds(10, 90, 125, 17);
		lblProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblProvinceName);
		
		txtProvinceName = new JTextField();
		txtProvinceName.setBounds(190, 90, 400, 25);
		txtProvinceName.setEditable(false);
		txtProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProvinceName.setColumns(10);
		add(txtProvinceName);
		
		btnInsertProvince = new JButton("Insert");
		btnInsertProvince.setBounds(10, 135, 100, 25);
		btnInsertProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnInsertProvince);
		
		btnEditProvince = new JButton("Edit");
		btnEditProvince.setBounds(130, 135, 100, 25);
		btnEditProvince.setEnabled(false);
		btnEditProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnEditProvince);
		
		btnDeleteProvince = new JButton("Delete");
		btnDeleteProvince.setBounds(250, 135, 100, 25);
		btnDeleteProvince.setEnabled(false);
		btnDeleteProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnDeleteProvince);
		
		btnSaveProvince = new JButton("Save");
		btnSaveProvince.setBounds(370, 135, 100, 25);
		btnSaveProvince.setEnabled(false);
		btnSaveProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnSaveProvince);
		
		btnCancelProvince = new JButton("Cancel");
		btnCancelProvince.setBounds(490, 135, 100, 25);
		btnCancelProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnCancelProvince);
		
		// Event listener
		btnCancelProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceName.setEditable(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				btnSaveProvince.setEnabled(false);
				btnEditProvince.setEnabled(false);
				btnDeleteProvince.setEnabled(false);
			}
		});

		btnSaveProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtProvinceName.getText().isEmpty()) {
					messagePanel.showProvinceMessage("Tên tỉnh không được để trống.");
					txtProvinceName.requestFocus();
				} else {
					String provinceName = txtProvinceName.getText();
					if (!isEditProvince) {
						String message = provinceBUS.insert(provinceName);
						messagePanel.showProvinceMessage(message);
					} else {
						int provinceId = Integer.parseInt(txtProvinceID.getText());
						String message = provinceBUS.update(provinceId, provinceName);
						messagePanel.showProvinceMessage(message);
					}
					scrollPane.addRowToProvinceTable(provinceBUS.getProvinceList());

					txtProvinceID.setText("");
					txtProvinceName.setText("");
					btnSaveProvince.setEnabled(false);
					txtProvinceName.setEditable(false);
					btnEditProvince.setEnabled(false);
					btnDeleteProvince.setEnabled(false);
				}
			}
		});

		btnDeleteProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowIndex = scrollPane.provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					int accept = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc muốn xóa?\nID: " + scrollPane.provinceTable.getValueAt(selectedRowIndex, 0).toString()
									+ "\nName: " + scrollPane.provinceTable.getValueAt(selectedRowIndex, 1).toString(),
							"Xóa tỉnh", JOptionPane.YES_NO_OPTION);
					if (accept == JOptionPane.YES_OPTION) {
						String message = provinceBUS.delete(Integer.parseInt(txtProvinceID.getText()));
						messagePanel.showProvinceMessage(message);
						scrollPane.addRowToProvinceTable(provinceBUS.getProvinceList());

						txtProvinceID.setText("");
						txtProvinceName.setText("");
						txtProvinceName.setEditable(false);
						btnDeleteProvince.setEnabled(false);
						btnEditProvince.setEnabled(false);
					}

				} else {
					messagePanel.showProvinceMessage("Bạn cần chọn tỉnh trước");
				}
			}
		});

		btnEditProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex = scrollPane.provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					isEditProvince = true;
					btnSaveProvince.setEnabled(true);
					txtProvinceName.setEditable(true);
					txtProvinceName.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "Bạn cần chọn tỉnh trước", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnInsertProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				txtProvinceName.setEditable(true);
				txtProvinceName.requestFocus();
				btnSaveProvince.setEnabled(true);
				isEditProvince = false;
			}
		});
		
		// Add an event for scrollPane table
		scrollPane.provinceTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditProvince.setEnabled(true);
				btnDeleteProvince.setEnabled(true);
				DefaultTableModel model = (DefaultTableModel) scrollPane.provinceTable.getModel();
				int selectedRowIndex = scrollPane.provinceTable.getSelectedRow();
				txtProvinceID.setText(model.getValueAt(selectedRowIndex, 0).toString());
				txtProvinceName.setText(model.getValueAt(selectedRowIndex, 1).toString());
			}
		});
	}

}
