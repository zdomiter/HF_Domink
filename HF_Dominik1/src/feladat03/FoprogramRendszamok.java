package feladat03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FoprogramRendszamok {

	static Scanner sc = new Scanner(System.in);
	
	static int felvitt =0;

	public static void main(String[] args) {
		
		Set<String> rendszamok = new HashSet<String>();
		
		int behajt = 0;
		int nemhajtbe = 0;
		
		
		String menupont = null;
		do {
			
			System.out.println("Válasszon menüpontot:");
			System.out.println("1. Adatfelvitel");
			System.out.println("2. Behajtás ellenőrzés");
			System.out.println("3. Kilépés");
			menupont = sc.nextLine();
			
			switch (menupont) {
			
			case "1":
				
				System.out.println(adatfelvitel(rendszamok)+" új rendszámot vitt fel a rendszerbe");				
				break;
				
			case "2":
				System.out.print("Adja meg a behajtani óhajtó autó rendszámát: ");
				String rendszam = sc.nextLine().toUpperCase();
				if (behajthat(rendszamok,rendszam)) {
					
					System.out.println("Az autó behajthat a parkolóba!");
					behajt++;
				}
				else {
					
					System.out.println("Az autó nem hajthat be a parkolóba!");
					nemhajtbe++;
				}
				break;
			case "3":
				break;
				
			default:
				System.out.println("Nem jo");
			}
			
			
			
		}while(!menupont.equals("3"));
		
		// TODO Ide kerüljön  a statisztika kiíratása
		System.out.println("Újonnan sikeresen felvitt rendszamok száma: " + felvitt + ", behajtott autók száma: " + behajt
				+ ", nem engedélyezett behajtások száma: " + nemhajtbe);
		
		
	}

	public static int adatfelvitel(Set<String> rendszamok) {

		int ujRendszamokDarabszam = 0;
		String rendszam = "";

		do {
			System.out.println(
					"Kérem adja meg a rendszámot (pl:ABC123), amennyiben ki szeretne lépni írja azt, hogy: VÉGE");
			rendszam = sc.nextLine().toUpperCase();
			if (!rendszam.equalsIgnoreCase("VÉGE")) {
				if (!rendszamok.contains(rendszam)) {
					ujRendszamokDarabszam++;

				}
				rendszamok.add(rendszam);

			}

		} while (!rendszam.equalsIgnoreCase("VÉGE"));
		
		felvitt = ujRendszamokDarabszam;
		return ujRendszamokDarabszam;

	}

	public static boolean behajthat(Set<String> rendszamok, String rendszam) {

		return rendszamok.contains(rendszam);

	}

}
