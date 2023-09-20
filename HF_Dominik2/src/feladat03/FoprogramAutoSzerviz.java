package feladat03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoprogramAutoSzerviz {

	public static void main(String[] args) {
		
		int oradij = 8000;
		
		AdatKezeles ak = new AdatKezeles();
		List<SzervizMunka> adatok = new ArrayList<SzervizMunka>();
		
		ak.adatbekeres(adatok);
		ak.leghosszabbTevekenyseg(adatok);
		
		HashMap<String, Integer> adatszerkezet = new HashMap<String, Integer>();
		
		hashMapFeltoltese(adatok,adatszerkezet,oradij);
		
		
		
	}
	
	public static void hashMapFeltoltese(List<SzervizMunka> adatok, HashMap<String, Integer> adatszerkezet, int oradij) {
		
		for (SzervizMunka szervizMunka : adatok) {
			if (!szervizMunka.equals("")) {
				adatszerkezet.put(szervizMunka.getSzervizTevekenyseg(), szervizMunka.arKepzes(oradij));
			}
		
		}
		System.out.println(adatszerkezet);
		
		
	}

}
