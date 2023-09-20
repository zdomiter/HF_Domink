package feladat02;

public class Virag extends Noveny{
	
	private String szin;

	public Virag(String azonosito, String megnevezes, Integer felfedezesEve, String szin) {
		super(azonosito, megnevezes, felfedezesEve);
		this.szin = szin;
	}

	public String getSzin() {
		return szin;
	}

	@Override
	public String toString() {
		return "[szin=" + szin + ", Azonosito=" + getAzonosito() + ", Megnevezes=" + getMegnevezes()
				+ ", BekerulesEve=" + getBekerulesEve() + "] Virag ";
	}
	
	

}
