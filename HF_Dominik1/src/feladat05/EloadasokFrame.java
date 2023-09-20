package feladat05;

import javax.swing.JFrame;
import javax.swing.JList;

public class EloadasokFrame {

	private JFrame frmEloadasok;
	

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
		frmEloadasok.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmEloadasok.getContentPane().setLayout(null);
		
	    JList list = new JList();	
		list.setBounds(129, 42, 417, 217);
		frmEloadasok.getContentPane().add(list);
		
	}
}
