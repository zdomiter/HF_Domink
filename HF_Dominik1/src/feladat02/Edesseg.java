package feladat02;

public class Edesseg {
	
	private String megnevezes;
	private int egysegar;
	private int darabszam;
	
	
	public Edesseg(String megnevezes, int egysegar, int darabszam) {
		super();
		this.megnevezes = megnevezes;
		this.egysegar = egysegar;
		this.darabszam = darabszam;
	}
	



	public String getMegnevezes() {
		return megnevezes;
	}




	public int getEgysegar() {
		return egysegar;
	}




	public int getDarabszam() {
		return darabszam;
	}




	public int keszletErtek() {

		
		return darabszam * egysegar ;
				
	}



	@Override
	public String toString() {
		return "[megnevezes=" + megnevezes + ", egysegar=" + egysegar + ", darabszam=" + darabszam + "] Edesseg";
	}
	
}
