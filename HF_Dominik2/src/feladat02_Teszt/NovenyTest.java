package feladat02_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import feladat02.Noveny;

class NovenyTest {

	@Test
	void hanyEveLatogathatoTeszt(){
		
		int bekerulesEve = 2003;
		int aktualisEv = LocalDate.now().getYear();
		int elvartEredmeny = (aktualisEv-bekerulesEve)*12;
		
		Noveny novenyObj = new Noveny("0001","magyar rózsa", bekerulesEve);
		
		assertEquals(elvartEredmeny, novenyObj.hanyHonapjaLatogathato());
		
	}
	@Test
	void toStringTeszt() {
		Noveny novenyObj = new Noveny("0001","magyar rózsa", 2022);
		
		assertEquals("[azonosito=0001, megnevezes=magyar rózsa, bekerulesEve=2022] Noveny", novenyObj.toString());
	}
	
	
	

}
