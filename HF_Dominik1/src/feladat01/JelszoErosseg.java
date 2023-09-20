package feladat01;

public class JelszoErosseg {

	public static void main(String[] args) {
		
		String[] jelszavak = {"Password34", "Valami999", "Ezjolesz77", "erosJelszo76"};
				
		System.out.println("A tömbben lévő érvényes jelszavak száma: "+ervenyes(jelszavak));
		
	}
	

	public static int ervenyes(String[] jelszavak) {
		
		int ervenyesJelszo = 0;
		

		// itt kell megvalósítani a jelszavakat kiíró és az érvényeseket összeszámoló ciklust
		
		for (int i = 0; i < jelszavak.length; i++) {
			if (ellenorzes(jelszavak[i])) {
				ervenyesJelszo++;
				System.out.println(jelszavak[i] + " érvényes");
			}
			else {
				System.out.println(jelszavak[i] + " érvénytelen");
			}
		}
		
		return ervenyesJelszo;
		
	}


	public static boolean ellenorzes(String jelszo) {
		
		if (jelszo.length() == 10
				&& Character.isUpperCase(jelszo.charAt(0)) 
				&& jelszo.substring(1,8).toLowerCase().equals(jelszo.substring(1,8))
				&& Character.isDigit(jelszo.charAt(8))
				&& Character.isDigit(jelszo.charAt(9))				) {
			
			return true;
			
		}
		
		return false;
	}

}
