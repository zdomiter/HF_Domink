package kerekparBolt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class App {

	private JFrame frmKerekparBolt;
	private JTable table;
	private JButton btnLegolcsobbHasznaltMtb;
	private JButton btnGyerekKerekparokSzama;
	private JButton btnTrekkingFerfiFajlbaIr;
	private JLabel lblGyerekKerekparokSzama;
	private JButton btnFajlBeolvasas;
	private JButton btnHibasAdatTorlese;
	private JButton btnKilep;
	private List<Kerekpar> kerekparok;
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmKerekparBolt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKerekparBolt = new JFrame();
		frmKerekparBolt.setTitle("Kerekpárbolt");
		frmKerekparBolt.setBounds(100, 100, 1021, 507);
		frmKerekparBolt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKerekparBolt.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 25, 934, 167);
		frmKerekparBolt.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnLegolcsobbHasznaltMtb = new JButton("Legolcsóbb használt MTB");
		btnLegolcsobbHasznaltMtb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Hagyományos progTételes megoldás
//				int min = 999999999;
//				int minIndex = -1;
//				for (int i = 0; i < kerekparok.size(); i++) {
//					if (kerekparok.get(i).getAr()<min && kerekparok.get(i).getHasznalt() && kerekparok.get(i).getTipus().equalsIgnoreCase("mtb")) {
//						min = kerekparok.get(i).getAr();
//						minIndex = i;
//					}
//				}
//				String nevMin = kerekparok.get(minIndex).getNev();
				
				//Stream API
				Kerekpar legolcsobbHasznaltMtb = kerekparok.stream()
						.filter(c->c.getTipus().equalsIgnoreCase("mtb"))
						.filter(x->x.getHasznalt()==true)
						.min(Comparator.comparing(Kerekpar::getAr))
						.orElseThrow(NoSuchElementException::new);

				JOptionPane.showMessageDialog(frmKerekparBolt,
						"Legolcsóbb használt mtb neve és ára: "+legolcsobbHasznaltMtb.getNev()
						+" / "+legolcsobbHasznaltMtb.getAr() + " Ft", 
						"Legolcsóbb használt mtb nev / ár", 
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnLegolcsobbHasznaltMtb.setEnabled(false);
		btnLegolcsobbHasznaltMtb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLegolcsobbHasznaltMtb.setBounds(37, 222, 318, 41);
		frmKerekparBolt.getContentPane().add(btnLegolcsobbHasznaltMtb);
		
		btnGyerekKerekparokSzama = new JButton("Gyerekkerékpárok száma");
		btnGyerekKerekparokSzama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer dbGyerekKerekparokSzama = 0;
				for (Kerekpar kerekpar : kerekparok) {
					if (kerekpar.getKategoriaId() ==3) {
						dbGyerekKerekparokSzama++;
					}
				}
				lblGyerekKerekparokSzama.setText(dbGyerekKerekparokSzama + "");
				lblGyerekKerekparokSzama.setVisible(true);
				
				//Hf. Stream API-val
				
			}
		});
		btnGyerekKerekparokSzama.setEnabled(false);
		btnGyerekKerekparokSzama.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGyerekKerekparokSzama.setBounds(37, 289, 318, 41);
		frmKerekparBolt.getContentPane().add(btnGyerekKerekparokSzama);
		
		btnTrekkingFerfiFajlbaIr = new JButton("Trekking - Férfi fájlba ír");
		btnTrekkingFerfiFajlbaIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//trekking fájlbaírás
				FajlKezelo fkObj = new FajlKezelo();
				fkObj.trekkingFajlBaIr(kerekparok);
				
				JOptionPane.showMessageDialog(frmKerekparBolt,
						"Sikeres művelet: létrejött a trekking_ferfi.csv", 
						"Fájl létrehozása",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnTrekkingFerfiFajlbaIr.setEnabled(false);
		btnTrekkingFerfiFajlbaIr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTrekkingFerfiFajlbaIr.setBounds(37, 357, 318, 41);
		frmKerekparBolt.getContentPane().add(btnTrekkingFerfiFajlbaIr);
		
		btnFajlBeolvasas = new JButton("Fájlbeolvasás");
		btnFajlBeolvasas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FajlKezelo fkObj = new FajlKezelo();
				kerekparok = fkObj.fajlBeolvas("kerekparok.csv");
				
				DefaultTableModel model = new DefaultTableModel(
						new Object[] {
								"Cikkszám",
								"Név",
								"Típus",
								"Ár (ft)",
								"Használt",
								"Kategória",
								"Rögzítés dátuma"},0);
				for (Kerekpar kerekpar : kerekparok) {
					model.addRow(new Object[] {
							kerekpar.getCikkSzam(),
							kerekpar.getNev(),
							kerekpar.getTipus(),
							kerekpar.getAr(),
							kerekpar.getHasznaltSzoveg(),
							kerekpar.getKategoriaSzoveg(),
							kerekpar.getRogzitesDatuma(),
					});
				}
				table.setModel(model);
				
				DefaultTableCellRenderer kozepreIgazito = new DefaultTableCellRenderer();
				kozepreIgazito.setHorizontalAlignment(JLabel.CENTER);
				for (int i = 0; i < model.getColumnCount(); i++) {
					table.getColumnModel().getColumn(i).setCellRenderer(kozepreIgazito);;
				}
				//Gombok engedélyezése és tiltása
				btnHibasAdatTorlese.setEnabled(true);
				btnFajlBeolvasas.setEnabled(false);
			}
		});
		btnFajlBeolvasas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFajlBeolvasas.setBounds(653, 222, 318, 41);
		frmKerekparBolt.getContentPane().add(btnFajlBeolvasas);
		
		btnHibasAdatTorlese = new JButton("Hibás adat törlése");
		btnHibasAdatTorlese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hibasIndex = -1;
				for (int i = 0; i < kerekparok.size(); i++) {
					if (kerekparok.get(i).getCikkSzam().toString().length() !=6) {
						hibasIndex = i;
					}
				}
				
				//Adatszerkezetből törlés (lista)
				kerekparok.remove(hibasIndex);
				
				//Felületről törlés - modelből
				((DefaultTableModel)table.getModel()).removeRow(hibasIndex);
			
				//gombok engedélyezése és tiltása
				btnHibasAdatTorlese.setEnabled(false);
				btnLegolcsobbHasznaltMtb.setEnabled(true);
				btnGyerekKerekparokSzama.setEnabled(true);
				btnTrekkingFerfiFajlbaIr.setEnabled(true);
			}
		});
		btnHibasAdatTorlese.setEnabled(false);
		btnHibasAdatTorlese.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHibasAdatTorlese.setBounds(653, 289, 318, 41);
		frmKerekparBolt.getContentPane().add(btnHibasAdatTorlese);
		
		btnKilep = new JButton("KILÉP");
		btnKilep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKilep.setForeground(Color.WHITE);
		btnKilep.setBackground(Color.RED);
		btnKilep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKilep.setBounds(811, 357, 160, 69);
		frmKerekparBolt.getContentPane().add(btnKilep);
		
		lblGyerekKerekparokSzama = new JLabel("");
		lblGyerekKerekparokSzama.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGyerekKerekparokSzama.setVisible(false);
		lblGyerekKerekparokSzama.setOpaque(true);
		lblGyerekKerekparokSzama.setBackground(new Color(50, 205, 50));
		lblGyerekKerekparokSzama.setHorizontalAlignment(SwingConstants.CENTER);
		lblGyerekKerekparokSzama.setBounds(384, 289, 188, 41);
		frmKerekparBolt.getContentPane().add(lblGyerekKerekparokSzama);
		
//		FajlKezelo fkObj = new FajlKezelo();
//		System.out.println(fkObj.fajlBeolvas("kerekparok.csv").size());
		
//		FajlKezelo fkObj = new FajlKezelo();
//		System.out.println(fkObj.fajlBeolvas("kerekparok.csv").get(0).getCikkSzam());
		
		
	}
}
