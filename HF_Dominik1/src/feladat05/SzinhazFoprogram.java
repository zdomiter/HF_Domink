package feladat05;

import java.util.List;


public class SzinhazFoprogram {

	public static void main(String[] args) {
		
		EloadasokFrame foAblak = new EloadasokFrame();
		foAblak.getFrmEloadasok().setVisible(true);

		AdatbazisKapcsolat adatbazisKapcsolat = new AdatbazisKapcsolat();
		
		List<Eloadas> eloadasok = adatbazisKapcsolat.eloadasokLekerdezese();

		for (Eloadas eloadas : eloadasok) {
			System.out.println(eloadas);

		}
		
	}

}
