package feladat02;


public class botanikusKertApplikacio {

	public static void main(String[] args) {
		
		Noveny[] novenyek = {
			new Noveny("0002", "Dinnye", 1960),
			new Noveny("0003", "Tök", 1877),
			new Virag("0004", "Pitypang", 2001, "fehér"),
			new Virag("0005", "Tulipan", 1722, "piros")
		};
		
		for (Noveny noveny : novenyek) {
			System.out.println(noveny.toString() + " " + noveny.hanyHonapjaLatogathato() + " hónapja látogatható");
		}

	}



}
