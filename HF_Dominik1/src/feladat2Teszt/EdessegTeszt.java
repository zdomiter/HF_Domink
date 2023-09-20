package feladat2Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat02.Csokolade;
import feladat02.Edesseg;

class EdessegTeszt {

	@Test
	void keszletErtekTeszt() {
		
		Edesseg edessegObj = new Edesseg("keksz", 390, 30);
		int elvartKeszletErtek = 390*30;
		
		assertEquals(elvartKeszletErtek, edessegObj.keszletErtek());
		
	}
	
	@Test
    public void csokoladeToStringTest() {
        Csokolade csokoladeObj = new Csokolade("Tibicsoki", 250, 20, 50.0);
        assertEquals("[kakaotartalom=50.0, Megnevezes=Tibicsoki, Egysegar=250, Darabszam=20] Csokolade", csokoladeObj.toString());
    }

}
