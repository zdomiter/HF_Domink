package feladat04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PapirBoltFoprogram {

	public static void main(String[] args) throws IOException {
		
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		FajlKezeles fajlObj = new FajlKezeles();
		
		System.out.println("Fájl beolvasva. Hibás tételek száma: "+fajlObj.beolvas(rendelesek,"SzallitoiRendelesek.csv"));
		
		for (Rendeles rendeles : rendelesek) {
			System.out.println(rendeles.toString());
		}
		
		String[] ujtetel1 = new String[] {"S0008","Cerkatartó", "100", "10000", "1"};
		String[] ujtetel2 = new String[] {"S0009","Radír", "10", "300", "0"};
		
		
		rendelesek.add(new Rendeles(ujtetel1));
		rendelesek.add(new Rendeles(ujtetel2));
		
		fajlObj.Kiiratas("SzallitoiRendelesek.csv", rendelesek);

	}

}
