package feladat3Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import feladat03.FoprogramRendszamok;

class FoprogramRendszamokTeszt {

	@Test
	void behajthatTeszt() {
		
		Set<String> rendszamok = new HashSet<String>();
		rendszamok.add("ABC-123");
		rendszamok.add("DEF-456");
		
		assertTrue(FoprogramRendszamok.behajthat(rendszamok, "ABC-123"));
		
	}
	  @Test
	    void adatfelvitelTest() {
	        Set<String> rendszamok = new HashSet<String>();
	        int felvitt = FoprogramRendszamok.adatfelvitel(rendszamok);

	        assertEquals(3, felvitt);

	        assertTrue(rendszamok.contains("ABC123"));
	        assertTrue(rendszamok.contains("XYZ987"));
	        assertTrue(rendszamok.contains("DEF456"));
	        assertFalse(rendszamok.contains("VÉGE"));

	        int ujRendszamokDarabszam = FoprogramRendszamok.adatfelvitel(rendszamok);
	        assertEquals(0, ujRendszamokDarabszam);
	    }

}
