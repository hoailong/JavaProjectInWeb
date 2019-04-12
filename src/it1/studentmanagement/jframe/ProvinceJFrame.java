package it1.studentmanagement.jframe;


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
	private JTextField txtProvinceID;
	private JTextField txtProvinceName;
	private static ProvinceBUS provinceBUS = new ProvinceBUS();
	private static boolean isEditProvince = false;
	private JTable provinceTable;
	private JTextArea txtStudentMessage;
	private JTextArea txtProvinceMessage;
	private Timer timer = new Timer(5000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtStudentMessage.setText("");
		}

	});
	public ProvinceJFrame() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
		setLayout(null);
		JScrollPane provinceScrollPane = new JScrollPane();
		provinceScrollPane.setBounds(61, 62, 415, 474);
		add(provinceScrollPane);

		provinceTable = new JTable() {
			;
			@Override
			// users not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		provinceTable.setRowHeight(30);
		provinceTable.setFont(new Font("Tahoma", Font.PLAIN, 18));

		provinceTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Province Name" }));
		provinceScrollPane.setViewportView(provinceTable);

		JPanel provinceInformationPane = new JPanel();
		provinceInformationPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		provinceInformationPane.setBounds(501, 113, 599, 177);
		add(provinceInformationPane);
		provinceInformationPane.setLayout(null);

		JLabel lblProvinceID = new JLabel("Province ID:");
		lblProvinceID.setBounds(10, 64, 76, 17);
		provinceInformationPane.add(lblProvinceID);
		lblProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblProvinceName = new JLabel("Province Name:");
		lblProvinceName.setBounds(10, 92, 97, 17);
		provinceInformationPane.add(lblProvinceName);
		lblProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtProvinceID = new JTextField();
		txtProvinceID.setBounds(132, 61, 450, 25);
		provinceInformationPane.add(txtProvinceID);
		txtProvinceID.setEditable(false);
		txtProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProvinceID.setColumns(10);

		txtProvinceName = new JTextField();
		txtProvinceName.setBounds(132, 89, 450, 25);
		provinceInformationPane.add(txtProvinceName);
		txtProvinceName.setEditable(false);
		txtProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProvinceName.setColumns(10);

		JButton btnInsertProvince = new JButton("Insert");
		btnInsertProvince.setBounds(10, 141, 97, 25);
		provinceInformationPane.add(btnInsertProvince);

		btnInsertProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEditProvince = new JButton("Edit");
		btnEditProvince.setBounds(132, 141, 97, 25);
		btnEditProvince.setEnabled(false);
		provinceInformationPane.add(btnEditProvince);

		btnEditProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnDeleteProvince = new JButton("Delete");
		btnDeleteProvince.setBounds(252, 141, 97, 25);
		btnDeleteProvince.setEnabled(false);
		provinceInformationPane.add(btnDeleteProvince);

		btnDeleteProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnSaveProvince = new JButton("Save");
		btnSaveProvince.setBounds(369, 141, 97, 25);
		provinceInformationPane.add(btnSaveProvince);
		btnSaveProvince.setEnabled(false);
		btnSaveProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnCancelProvince = new JButton("Cancel");
		btnCancelProvince.setBounds(485, 141, 97, 25);
		provinceInformationPane.add(btnCancelProvince);

		btnCancelProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblProvinceInformation = new JLabel("Province Information");
		lblProvinceInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProvinceInformation.setBounds(204, 11, 199, 39);
		provinceInformationPane.add(lblProvinceInformation);

		JLabel lblProvinceManagement = new JLabel("Province Management");
		lblProvinceManagement.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProvinceManagement.setBounds(424, 11, 273, 32);
		add(lblProvinceManagement);

		JPanel provinceMessagePane = new JPanel();
		provinceMessagePane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		provinceMessagePane.setBounds(501, 324, 599, 175);
		add(provinceMessagePane);
		provinceMessagePane.setLayout(null);

		txtProvinceMessage = new JTextArea();
		txtProvinceMessage.setEditable(false);
		txtProvinceMessage.setLineWrap(true);
		txtProvinceMessage.setWrapStyleWord(true);
		txtProvinceMessage.setBounds(12, 37, 575, 125);
		provinceMessagePane.add(txtProvinceMessage);
		txtProvinceMessage.setForeground(Color.RED);
		txtProvinceMessage.setFont(new Font("Monospaced", Font.BOLD, 20));

		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setBounds(258, 0, 83, 36);
		provinceMessagePane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		// Event listener
		btnCancelProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceName.setEditable(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				btnSaveProvince.setEnabled(false);
				addRowToProvinceTable(provinceBUS.getProvinceList());
			}
		});

		btnSaveProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtProvinceName.getText().isEmpty()) {
					showProvinceMessage("Province name can't be null");
					txtProvinceName.requestFocus();
				} else {
					String provinceName = txtProvinceName.getText();
					if (!isEditProvince) {
						String message = provinceBUS.insert(provinceName);
						showProvinceMessage(message);
					} else {
						int provinceId = Integer.parseInt(txtProvinceID.getText());
						String message = provinceBUS.update(provinceId, provinceName);
						showProvinceMessage(message);
					}
					addRowToProvinceTable(provinceBUS.getProvinceList());

					txtProvinceID.setText("");
					txtProvinceName.setText("");
					btnSaveProvince.setEnabled(false);
				}
			}
		});

		btnDeleteProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					int accept = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc muốn xóa?\nID: " + provinceTable.getValueAt(selectedRowIndex, 0).toString()
									+ "\nName: " + provinceTable.getValueAt(selectedRowIndex, 1).toString(),
							"Xóa tỉnh", JOptionPane.YES_NO_OPTION);
					if (accept == JOptionPane.YES_OPTION) {
						String message = provinceBUS.delete(Integer.parseInt(txtProvinceID.getText()));
						showProvinceMessage(message);
						addRowToProvinceTable(provinceBUS.getProvinceList());

						txtProvinceID.setText("");
						txtProvinceName.setText("");
						txtProvinceName.setEditable(false);
					}

				} else {
					showProvinceMessage("You have to choose a province row first");
				}
			}
		});

		btnEditProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					isEditProvince = true;
					btnSaveProvince.setEnabled(true);
					txtProvinceName.setEditable(true);
					txtProvinceName.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "You have to choose a province row first", "Lỗi",
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

		provinceTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditProvince.setEnabled(true);
				btnDeleteProvince.setEnabled(true);
				btnEditProvince.setEnabled(true);
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				txtProvinceID.setText(model.getValueAt(selectedRowIndex, 0).toString());
				txtProvinceName.setText(model.getValueAt(selectedRowIndex, 1).toString());
			}
		});
	}

	private void addRowToProvinceTable(List<ProvinceDTO> provinces) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Province ID");
		model.addColumn("Province Name");
		provinces = provinceBUS.getProvinceList();
		Object provinceTableRowData[] = new Object[2];
		for (ProvinceDTO province : provinces) {
			provinceTableRowData[0] = province.getId();
			provinceTableRowData[1] = province.getName();
			model.addRow(provinceTableRowData);
		}
		provinceTable.setModel(model);
	}

	

	private void showProvinceMessage(String message) {
		txtProvinceMessage.setText(message);
		timer.restart();
	}
}
