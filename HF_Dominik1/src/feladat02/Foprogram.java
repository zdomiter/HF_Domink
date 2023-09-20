package feladat02;

public class Foprogram {

	public static void main(String[] args) {
		
		// ide kerüljön a tömb feltöltése majd a kiíratás:
		 Edesseg[] edessegek = {
		            new Edesseg("Nápolyi", 100, 20),
		            new Csokolade("Milka", 200, 15, 30),
		            new Cukorka("Mentolos", 50, 50, true)};
		Kiiratas(edessegek);
		 

	}
	
	public static void Kiiratas(Edesseg[] edessegek) {
		 for (Edesseg edesseg : edessegek) {
			System.out.println(edesseg.toString() + " " + edesseg.keszletErtek());
		}
		 
	 }

}
