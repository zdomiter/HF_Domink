package feladat1Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat01.JelszoErosseg;

class JelszoErossegTeszt {

	@Test
	void ellenorzesTest() {
		
		String jelszo = "Jojelszo45";
		assertTrue(JelszoErosseg.ellenorzes(jelszo));
		
	}
	
	@Test
	void ervenyesTest() {
		
		String[] jelszavak = {"Password34", "Valami999", "Ezjolesz77", "erosJelszo76"};
		int darabszam = 2;
		assertEquals(JelszoErosseg.ervenyes(jelszavak), darabszam);
		
	}
	
	

}
