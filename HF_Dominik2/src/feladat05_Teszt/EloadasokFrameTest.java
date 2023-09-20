package feladat05_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat05.EloadasokFrame;

class EloadasokFrameTest {

	@Test
	void initializeTeszt() {
		
		EloadasokFrame foAblak = new EloadasokFrame();
		
		// ablak fejléc címének  ellenőrzése:
		assertTrue(foAblak.getFrmEloadasok().getTitle().equals("Színházi előadások"));

	}

}
