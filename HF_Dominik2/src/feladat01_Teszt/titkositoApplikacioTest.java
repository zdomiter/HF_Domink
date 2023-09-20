package feladat01_Teszt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import feladat01.titkositoApplikacio;

class titkositoApplikacioTest {

	@Test
	void titkositTeszt() {
		
		String titkositando = "Tesztszöveg ellenőrzése";
		String elvartEredmeny = "7T73z53zöv7g07ll7nőrzé3";
		assertEquals(elvartEredmeny, titkositoApplikacio.titkosit(titkositando));
		
	}
	@Test
	void dekodolasTeszt() {
		
		String titkositando = "7T73z53zöv7g07ll7nőrzé3";
		String elvartEredmeny = "Tesztszöveg ellenőrzése";
		assertEquals(elvartEredmeny, titkositoApplikacio.dekodolas(titkositando));	
	}
}
