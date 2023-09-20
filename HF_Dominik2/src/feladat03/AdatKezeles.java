package feladat03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class AdatKezeles {
	
	static Scanner sc = new Scanner(System.in);
	
	
	public void adatbekeres(List<SzervizMunka> adatok) {
		
		String tevekenyseg = null;
		int munkaora = 0;
		
		do {
			System.out.println("Adja meg a szervíz tevékenységet, amennyiben kiszeretne lépni nyomjon ENTER-t");
			tevekenyseg = sc.nextLine();
			if (!tevekenyseg.equals("")) {
				System.out.println("Adja meg a tevékenység alatt eltelt munkaidőt");
				munkaora = Integer.parseInt(sc.nextLine());
			}
			
			adatok.add(new SzervizMunka(tevekenyseg, munkaora));
			
		} while (!tevekenyseg.equals(""));
		
		
	}
	public void leghosszabbTevekenyseg(List<SzervizMunka> adatok) {
		
		int legtobbido = adatok.get(0).getMunkaOra();
		int index = -1;

		for (int i = 0; i < adatok.size(); i++) {
			if (adatok.get(i).getMunkaOra() > legtobbido) {
				legtobbido = adatok.get(i).getMunkaOra();
				index = i;
			}
		}
		if (index != -1) {
			System.out.println(adatok.get(index).getSzervizTevekenyseg() + " tart a leghosszabb ideig");
		}
		else {
			System.out.println("Nem vett fel új tevékenységet");
		}

		
	}


}
