package it1.studentmanagement.jframe.province;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it1.studentmanagement.dto.ProvinceDTO;

public class ProvinceScrollPane extends JScrollPane {
	protected JTable provinceTable;
	/**
	 * Create the panel.
	 */
	public ProvinceScrollPane() {
		setBounds(61, 62, 415, 474);

		provinceTable = new JTable() {
			@Override
			// users will not to be able to edit the values in cells by double-clicking them
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		provinceTable.setRowHeight(30);
		provinceTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		provinceTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Province Name" }));
		setViewportView(provinceTable);
	}
	
	protected void addRowToProvinceTable(List<ProvinceDTO> provinces) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Province ID");
		model.addColumn("Province Name");
		Object provinceTableRowData[] = new Object[2];
		for (ProvinceDTO province : provinces) {
			provinceTableRowData[0] = province.getId();
			provinceTableRowData[1] = province.getName();
			model.addRow(provinceTableRowData);
		}
		provinceTable.setModel(model);
	}
}
