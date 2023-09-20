package feladat4Teszt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import feladat04.FajlKezeles;
import feladat04.Rendeles;


class FajlKezelesTeszt {

	@Test
	void ellenorizTeszt() {
		
		FajlKezeles fajlObj = new FajlKezeles();
		String[] tesztCsvSor = {"S00008","toll","100","4000","1"};
		
		assertTrue(fajlObj.ellenoriz(tesztCsvSor));
		
		
	}
	@Test
	void toStringTeszt() {
		
		String[] rendelesTeszt = new String[] {"S00002","Flipchart tábla 80x105","3","67000","0"};
		Rendeles rendelesObj = new Rendeles(rendelesTeszt);
		
		assertEquals("Rendeles [szallitoiAzonosito=S00002, megnevezes=Flipchart tábla 80x105, mennyiseg=3, osszertek=67000, surgos=Nem]", rendelesObj.toString());
	}
}
