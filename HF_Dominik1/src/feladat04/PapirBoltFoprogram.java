package feladat04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PapirBoltFoprogram {

	public static void main(String[] args) throws IOException {
		
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		FajlKezeles fajlObj = new FajlKezeles();
		
		System.out.println("Fájl beolvasva. Hibás tételek száma: "+fajlObj.beolvas(rendelesek,"SzallitoiRendelesek.csv"));
		
		Collections.reverse(rendelesek);
		for (Rendeles rendeles : rendelesek) {
			System.out.println(rendeles.toString());
		}
		String[] rendeles1adatok = new String[] {"S123456","Papír","20","120","0"};
		String[] rendeles2adatok = new String[] {"S789012", "Toll", "50", "70", "1"};
	   
	     rendelesek.add(new Rendeles(rendeles1adatok));
	     rendelesek.add(new Rendeles(rendeles2adatok));
	     
	     FajlKezeles.kiir("SzallitoiRendelesek.csv", rendelesek);
	}

}
