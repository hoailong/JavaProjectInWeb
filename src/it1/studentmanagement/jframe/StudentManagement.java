package it1.studentmanagement.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.dao.ProvinceDAO;
import it1.studentmanagement.dto.ProvinceDTO;
import it1.studentmanagement.jdbc.DBUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class StudentManagement {

	private JFrame frame;
	private JTextField txtProvinceID;
	private JTextField txtProvinceName;
	private static ProvinceDAO provinceDAO = new ProvinceDAO();
	private static boolean isEditProvince = false;
	private JTable provinceTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement window = new StudentManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentManagement() {
		initialize();
		addRowToProvinceTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1015, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel studentPanel = new JPanel();
		tabbedPane.addTab("Student", null, studentPanel, null);
		
		JPanel provincePanel = new JPanel();
		tabbedPane.addTab("Province", null, provincePanel, null);
		provincePanel.setLayout(null);
		
		JLabel lblProvinceID = new JLabel("Province ID:");
		lblProvinceID.setBounds(535, 89, 80, 14);
		lblProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(lblProvinceID);
		
		JLabel lblProvinceName = new JLabel("Province Name:");
		lblProvinceName.setBounds(535, 117, 124, 14);
		lblProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(lblProvinceName);
		
		txtProvinceID = new JTextField();
		txtProvinceID.setBounds(669, 86, 225, 20);
		txtProvinceID.setEditable(false);
		txtProvinceID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(txtProvinceID);
		txtProvinceID.setColumns(10);
		
		txtProvinceName = new JTextField();
		txtProvinceName.setBounds(669, 116, 225, 20);
		txtProvinceName.setEditable(false);
		txtProvinceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProvinceName.setColumns(10);
		provincePanel.add(txtProvinceName);
		
		JTextArea txtProvinceError = new JTextArea();
		txtProvinceError.setBounds(535, 11, 359, 58);
		txtProvinceError.setLineWrap(true);
		txtProvinceError.setEditable(false);
		txtProvinceError.setFont(new Font("Courier New", Font.PLAIN, 18));
		txtProvinceError.setForeground(Color.RED);
		provincePanel.add(txtProvinceError);
		
		JButton btnInsertProvince = new JButton("Insert");
		btnInsertProvince.setBounds(535, 174, 89, 23);

		btnInsertProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnInsertProvince);
		
		JButton btnEditProvince = new JButton("Edit");
		btnEditProvince.setBounds(669, 176, 89, 23);
		
		btnEditProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnEditProvince);
		
		JPanel confirmDelProvincePanel = new JPanel();
		confirmDelProvincePanel.setBounds(77, 258, 817, 195);
		provincePanel.add(confirmDelProvincePanel);
		confirmDelProvincePanel.setLayout(null);
		
		JButton btnDeleteProvince = new JButton("Delete");
		btnDeleteProvince.setBounds(805, 176, 89, 23);
	
		btnDeleteProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnDeleteProvince);
		
		JButton btnSaveProvince = new JButton("Save");
		btnSaveProvince.setBounds(535, 222, 89, 23);
		
		btnSaveProvince.setEnabled(false);
		btnSaveProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnSaveProvince);
		
		Timer timer = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceError.setText("");
			}
			
		});
		
		JButton btnCancelProvince = new JButton("Cancel");
		btnCancelProvince.setBounds(669, 224, 89, 23);
		
		
		btnCancelProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincePanel.add(btnCancelProvince);
		
		JButton btnConfirmDel = new JButton("Confirm");
		
		btnConfirmDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmDel.setBounds(250, 140, 117, 23);
		confirmDelProvincePanel.add(btnConfirmDel);
		
		JButton btnCancelDel = new JButton("Cancel");
		btnCancelDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelDel.setBounds(450, 140, 117, 23);
		confirmDelProvincePanel.add(btnCancelDel);
		
		JLabel lblYouAreDeleting = new JLabel("You are deleting province:");
		lblYouAreDeleting.setForeground(Color.RED);
		lblYouAreDeleting.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYouAreDeleting.setBounds(211, 11, 241, 36);
		confirmDelProvincePanel.add(lblYouAreDeleting);
		
		JLabel lblDelProvince = new JLabel("Hồ Chí Minh");
		lblDelProvince.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDelProvince.setBounds(477, 11, 206, 36);
		confirmDelProvincePanel.add(lblDelProvince);
		
		JLabel lblNewLabel = new JLabel("Please choose \"Confirm\" to delete");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(253, 73, 314, 36);
		confirmDelProvincePanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 11, 441, 234);
		provincePanel.add(scrollPane);
		
		provinceTable = new JTable();
		provinceTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Province Name"
			}
		));
		scrollPane.setViewportView(provinceTable);
		
		confirmDelProvincePanel.setVisible(false);
		
		JPanel aboutPanel = new JPanel();
		tabbedPane.addTab("About us", null, aboutPanel, null);
		aboutPanel.setLayout(null);
		
		JLabel lblChngTrnhQun = new JLabel("Chương trình quản lý thí sinh dự thi Đại Học");
		lblChngTrnhQun.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblChngTrnhQun.setHorizontalAlignment(SwingConstants.CENTER);
		lblChngTrnhQun.setBounds(0, 11, 994, 52);
		aboutPanel.add(lblChngTrnhQun);
		
		JLabel lblThyGioB = new JLabel("Nguyễn Trọng Phúc");
		lblThyGioB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThyGioB.setBounds(515, 92, 167, 30);
		aboutPanel.add(lblThyGioB);
		
		JLabel label = new JLabel("Thầy giáo bộ môn:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(233, 92, 167, 30);
		aboutPanel.add(label);
		
		JLabel lblDanhSchSinh = new JLabel("Danh sách sinh viên:");
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSchSinh.setBounds(233, 133, 167, 30);
		aboutPanel.add(lblDanhSchSinh);
		
		JLabel lblPhanVnHoi = new JLabel("Phan Văn Hoài (171203470)");
		lblPhanVnHoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhanVnHoi.setBounds(515, 133, 296, 30);
		aboutPanel.add(lblPhanVnHoi);
		
		JLabel lblPhmNhtNam = new JLabel("Phạm Nhật Nam (171200791)");
		lblPhmNhtNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhmNhtNam.setBounds(515, 174, 296, 30);
		aboutPanel.add(lblPhmNhtNam);
		
		JLabel lblLSnTng = new JLabel("Lê Sơn Tùng (171210160)");
		lblLSnTng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLSnTng.setBounds(515, 215, 296, 30);
		aboutPanel.add(lblLSnTng);
		
		JLabel lblCngNghThng = new JLabel("Công nghệ thông tin 1 - K58");
		lblCngNghThng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCngNghThng.setBounds(515, 256, 296, 30);
		aboutPanel.add(lblCngNghThng);
		
		JLabel lblLp = new JLabel("Lớp:");
		lblLp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLp.setBounds(233, 256, 195, 30);
		aboutPanel.add(lblLp);
		
		JLabel lblTrng = new JLabel("Trường:");
		lblTrng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTrng.setBounds(233, 297, 195, 30);
		aboutPanel.add(lblTrng);
		
		JLabel lbliHcGiao = new JLabel("Đại học Giao Thông Vận Tải");
		lbliHcGiao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbliHcGiao.setBounds(515, 297, 265, 30);
		aboutPanel.add(lbliHcGiao);
		
		btnCancelProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProvinceName.setEditable(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				btnSaveProvince.setEnabled(false);
				confirmDelProvincePanel.setVisible(false);
			}
		});
		
		btnInsertProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				txtProvinceName.setEditable(true);
				txtProvinceName.requestFocus();
				btnSaveProvince.setEnabled(true);
			}
		});
		
		btnEditProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					btnSaveProvince.setEnabled(true);
					isEditProvince = true;
					txtProvinceName.setEditable(true);
					txtProvinceName.requestFocus();
				} else {
					txtProvinceError.setText("You have to choose a province to edit.");
					timer.start();
				}
			}
		});
		
		btnSaveProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtProvinceName.getText().length() == 0) {
					txtProvinceError.setText("Province name can't be null");
					txtProvinceName.requestFocus();
				} else {
					if (!isEditProvince) {
						try {
							provinceDAO.insertProvince(txtProvinceName.getText());
							txtProvinceError.setText("Insert new province success!");
						} catch (SQLException e) {
							txtProvinceError.setText("Insert new province failed! SQL Exception has occured.");
						}
					} else {
						try {
							provinceDAO.updateProvince(txtProvinceName.getText().toString(), Integer.parseInt(txtProvinceID.getText().toString()));
							txtProvinceError.setText("Edit province success!");
						} catch (NumberFormatException e) {
							txtProvinceError.setText("Edit failed! Number Format Exception occured.");
							e.printStackTrace();
						} catch (SQLException e) {
							txtProvinceError.setText("Edit failed! SQL Exception occured.");
							e.printStackTrace();
						}
					}
					addRowToProvinceTable();
					btnSaveProvince.setEnabled(false);
					txtProvinceID.setText("");
					txtProvinceName.setText("");
					txtProvinceName.setEditable(false);
				}
				timer.start();
			}
		});
		
		btnDeleteProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				if (selectedRowIndex != -1) {
					confirmDelProvincePanel.setVisible(true);
					lblDelProvince.setText(model.getValueAt(selectedRowIndex, 1).toString());
				} else {
					txtProvinceError.setText("You have to choose a province to delete.");
					timer.start();
				}
			}
		});
		
		btnConfirmDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					provinceDAO.deleteProvince(Integer.parseInt(txtProvinceID.getText()));
					txtProvinceError.setText("Delete success!");
				} catch (NumberFormatException e1) {
					txtProvinceError.setText("Delete failed! Number Format Exception occured.");
					e1.printStackTrace();
				} catch (SQLException e1) {
					txtProvinceError.setText("Delete failed! SQL Exception occured.");
					e1.printStackTrace();
				}
				addRowToProvinceTable();
				confirmDelProvincePanel.setVisible(false);
				txtProvinceID.setText("");
				txtProvinceName.setText("");
				timer.setRepeats(false);
				timer.start();
			}
		});
		
		btnCancelDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmDelProvincePanel.setVisible(false);
			}
		});
		
		provinceTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) provinceTable.getModel();
				int selectedRowIndex = provinceTable.getSelectedRow();
				txtProvinceID.setText(model.getValueAt(selectedRowIndex, 0).toString());
				txtProvinceName.setText(model.getValueAt(selectedRowIndex, 1).toString());
			}
		});
	}

	private void addRowToProvinceTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Province ID");
		model.addColumn("Province Name");
		List<ProvinceDTO> provinces = new ArrayList<ProvinceDTO>();
		try {
			provinces = provinceDAO.showProvince();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object provinceTableRowData[] = new Object[2];
		for (ProvinceDTO province : provinces) {
			provinceTableRowData[0] = province.getId();
			provinceTableRowData[1] = province.getName();
			model.addRow(provinceTableRowData);
		}
		provinceTable.setModel(model);
	}
}
