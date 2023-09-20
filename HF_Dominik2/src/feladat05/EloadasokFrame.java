package feladat05;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EloadasokFrame {

	private JFrame frmEloadasok;
	private JTable table;
	private JButton btnNewButton_1;

	public JFrame getFrmEloadasok() {
		return frmEloadasok;
	}

	public EloadasokFrame() {
		initialize();

	}

	private void initialize() {

		frmEloadasok = new JFrame();
		frmEloadasok.setTitle("Színházi előadások");
		frmEloadasok.setBounds(100, 100, 700, 400);
		frmEloadasok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEloadasok.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 22, 610, 141);
		frmEloadasok.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kilepes();
			}
		});
		btnNewButton.setBounds(525, 315, 121, 38);
		frmEloadasok.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rowIndex = table.getSelectedRow();
				if (rowIndex == -1) {
					JOptionPane.showMessageDialog(frmEloadasok, "Nincs sor kijelölve");;
				}
				else {
					Object data = table.getModel().getValueAt(rowIndex, 3);
					JOptionPane.showMessageDialog(frmEloadasok, data);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(46, 179, 107, 47);
		frmEloadasok.getContentPane().add(btnNewButton_1);
		loadProducts();

	}

	public void kilepes() {
		// TODO Auto-generated method stub
		int a = JOptionPane.showConfirmDialog(frmEloadasok, "Biztosan ki szeretnél lépni?");
		if (a == JOptionPane.YES_OPTION) {
			frmEloadasok.dispose();
		}
	}

	public void loadProducts() {
		Database dbobj = new Database();
		String sql = "SELECT * FROM eloadasok";
		ResultSet rs = dbobj.query(sql);
		tableFillbyRs(rs);

	}

	public void tableFillbyRs(ResultSet rs) {
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "cim", "rendezo", "bemutato", "eloadas_szam" }));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		try {
			while (rs.next()) {
				((DefaultTableModel) table.getModel()).addRow(new Object[] { rs.getString("cim"),
						rs.getString("rendezo"), rs.getString("bemutato"), rs.getString("eloadas_szam") });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
