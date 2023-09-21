package progTetelek;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ProgTetelek {

	private JFrame frmProgTetelek;
	private JButton btnKilep;
	private JButton btnHarommalOszthato;
	private JButton btnRendezCsokkeno;
	private JButton btnRendezNovekvo;
	private JButton btnMax;
	private JButton btnMin;
	private JButton btnAtlag;
	private JButton btnOsszeg;
	private JButton btnVelSzamokGeneral;
	@SuppressWarnings("rawtypes")
	private JList listVelSzamok;
	private JLabel lblAtlagEredmeny;
	List<Integer> velSzamok = new ArrayList<Integer>();
	DefaultListModel<Integer> listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgTetelek window = new ProgTetelek();
					window.frmProgTetelek.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgTetelek() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frmProgTetelek = new JFrame();
		frmProgTetelek.setTitle("Programozási tételek - Stream API");
		frmProgTetelek.setBounds(100, 100, 1098, 673);
		frmProgTetelek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgTetelek.getContentPane().setLayout(null);
		
		btnVelSzamokGeneral = new JButton("Véletlen számok");
		btnVelSzamokGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. lépés: JList-ben jelenjenek meg a számok (20 db véletlen szám 1-100)
				listaFeltolt();
				
				// 2. lépés: gombok engedélyezése / tiltása
				btnVelSzamokGeneral.setEnabled(false);
				
				btnOsszeg.setEnabled(true);
				btnAtlag.setEnabled(true);
				btnMin.setEnabled(true);
				btnMax.setEnabled(true);
				btnRendezNovekvo.setEnabled(true);
				btnRendezCsokkeno.setEnabled(true);
				btnHarommalOszthato.setEnabled(true);
				
			}
		});
		btnVelSzamokGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVelSzamokGeneral.setBounds(253, 38, 300, 45);
		frmProgTetelek.getContentPane().add(btnVelSzamokGeneral);
		
		btnRendezNovekvo = new JButton("Rendezés növekvő");
		btnRendezNovekvo.setEnabled(false);
		btnRendezNovekvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rendezNovekvo(velSzamok);
				listModelFeltoltEsJListhezRendel();
			}
		});
		btnRendezNovekvo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRendezNovekvo.setBounds(651, 38, 319, 45);
		frmProgTetelek.getContentPane().add(btnRendezNovekvo);
		
		btnOsszeg = new JButton("Összeg");
		btnOsszeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				String eredmeny = listaOsszegMeghataroz(velSzamok) + "";
				JOptionPane.showMessageDialog(frmProgTetelek, 
						"A lista összege: "+eredmeny, 
						"Összeg",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnOsszeg.setEnabled(false);
		btnOsszeg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOsszeg.setBounds(253, 111, 300, 45);
		frmProgTetelek.getContentPane().add(btnOsszeg);
		
		btnAtlag = new JButton("Átlag");
		btnAtlag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAtlagEredmeny.setVisible(true);
				lblAtlagEredmeny.setText("Átlag: "+listaAtlagMeghataroz(velSzamok).getAsDouble());
			}
		});
		btnAtlag.setEnabled(false);
		btnAtlag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtlag.setBounds(253, 185, 300, 45);
		frmProgTetelek.getContentPane().add(btnAtlag);
		
		btnRendezCsokkeno = new JButton("Rendezés csökkenő");
		btnRendezCsokkeno.setEnabled(false);
		btnRendezCsokkeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rendezCsokkeno(velSzamok);
				listModelFeltoltEsJListhezRendel();
			}
		});
		btnRendezCsokkeno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRendezCsokkeno.setBounds(651, 111, 319, 45);
		frmProgTetelek.getContentPane().add(btnRendezCsokkeno);
		
		btnHarommalOszthato = new JButton("3-mal osztható");
		btnHarommalOszthato.setEnabled(false);
		btnHarommalOszthato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eredmeny =  harommalOszthatoDbMeghataroz(velSzamok) + "";
				JOptionPane.showMessageDialog(frmProgTetelek, 
						"A hárommal oszthatóak darabszáma: "+eredmeny, 
						"Hárommal m.n oszthatóak darabszáma",
						JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		btnHarommalOszthato.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHarommalOszthato.setBounds(651, 185, 319, 45);
		frmProgTetelek.getContentPane().add(btnHarommalOszthato);
		
		btnMin = new JButton("Legkisebb elem értéke / indexe");
		btnMin.setEnabled(false);
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eredmeny = listaMinMeghataroz(velSzamok) + ", index: "
						+ ""+velSzamok.lastIndexOf(listaMinMeghataroz(velSzamok));
				JOptionPane.showMessageDialog(frmProgTetelek, 
						"Legkisebb érték: "+eredmeny, 
						"Legkisebb érték / index",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnMin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMin.setBounds(253, 328, 300, 45);
		frmProgTetelek.getContentPane().add(btnMin);
		
		btnKilep = new JButton("KILÉP");
		btnKilep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKilep.setForeground(Color.WHITE);
		btnKilep.setBackground(Color.RED);
		btnKilep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKilep.setBounds(914, 538, 143, 63);
		frmProgTetelek.getContentPane().add(btnKilep);
		
		btnMax = new JButton("Legnagyobb elem értéke / indexe");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eredmeny = listaMaxMeghataroz(velSzamok) + ", index: "
						+ ""+velSzamok.lastIndexOf(listaMaxMeghataroz(velSzamok));
				JOptionPane.showMessageDialog(frmProgTetelek, 
						"Legnagyobb érték: "+eredmeny, 
						"Legnagyobb érték / index",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnMax.setEnabled(false);
		btnMax.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMax.setBounds(253, 403, 300, 45);
		frmProgTetelek.getContentPane().add(btnMax);
		
		lblAtlagEredmeny = new JLabel("");
		lblAtlagEredmeny.setVisible(false);
		lblAtlagEredmeny.setOpaque(true);
		lblAtlagEredmeny.setBackground(new Color(144, 238, 144));
		lblAtlagEredmeny.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAtlagEredmeny.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtlagEredmeny.setBounds(253, 251, 300, 54);
		frmProgTetelek.getContentPane().add(lblAtlagEredmeny);
		
		listVelSzamok = new JList();
		listVelSzamok.setBounds(28, 35, 165, 566);
		frmProgTetelek.getContentPane().add(listVelSzamok);
	}
	

	private void listaFeltolt() {
		//1. lépés: ArrayList feltöltése véletlen számokkal (20db, 1-100 között)
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			int velSzam = r.nextInt(100)+1;
			velSzamok.add(velSzam);
		}
		
		//2. lépés: ListModel feltöltése az ArrayList adataival
		//3. lépés: Hozzárendeljük a feltöltött Listmodel-t a gui komponenshez (JList-hez - listVelSzamok)
		listModelFeltoltEsJListhezRendel();
	}
	
	// Hagyományos, eddig tanult progtételek alapján
//	private Integer listaOsszegMeghataroz(List<Integer> lista) {
//		int osszeg = 0;
//		for (Integer item : lista) {
//			osszeg+=item;
//		}
//		return osszeg;
//	}
	
	@SuppressWarnings("unchecked")
	private void listModelFeltoltEsJListhezRendel() {
		listModel = new DefaultListModel<Integer>();
		for (Integer item : velSzamok) {
			listModel.addElement(item);
		}
		listVelSzamok.setModel(listModel);
	}
	
	private Integer listaOsszegMeghataroz(List<Integer> lista) {
		return lista.stream().mapToInt(x->x.intValue()).sum();
	}
	
	private void rendezNovekvo(List<Integer> lista) {
		Collections.sort(lista); // mergesort
	}
	
	private void rendezCsokkeno(List<Integer> lista) {
//		Collections.sort(lista);
//		Collections.reverse(lista); // sorrendjét megcseréli
		Collections.sort(lista, Collections.reverseOrder());
	}
	
	private OptionalDouble listaAtlagMeghataroz(List<Integer> lista) {
		return lista.stream().mapToDouble(x->x.intValue()).average();
	}
	
	private Integer listaMinMeghataroz(List<Integer> lista) {
		return lista.stream().mapToInt(x->x.intValue()).min().getAsInt();
	}
	
	private Integer listaMaxMeghataroz(List<Integer> lista) {
		return lista.stream().mapToInt(x->x.intValue()).max().getAsInt();
	}
	
	private Integer harommalOszthatoDbMeghataroz(List<Integer> lista) {
		// arrow operator -> lamda kifejezések (predicate, lambda - később) 
		// -> legyen
		return (int)lista.stream().filter(i->i%3==0).count();
	}
	
}
