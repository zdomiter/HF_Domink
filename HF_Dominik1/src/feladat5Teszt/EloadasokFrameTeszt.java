package feladat5Teszt;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import feladat05.EloadasokFrame;

class EloadasokFrameTeszt {

	@Test
	void initializeTeszt() {
		
		EloadasokFrame foAblak = new EloadasokFrame();
		
		// normál kilépés beállításának ellenőrzése:
		assertTrue(foAblak.getFrmEloadasok().getDefaultCloseOperation()==JFrame.EXIT_ON_CLOSE);

	}

}
