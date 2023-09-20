package feladat04;

public class Rendeles {
	
	private String szallitoiAzonosito;
	private String megnevezes;
	private int mennyiseg;
	private int osszertek;
	private boolean surgos;


	public Rendeles(String[] csvSor) {
		szallitoiAzonosito = csvSor[0];
		megnevezes = csvSor[1];
		mennyiseg = Integer.parseInt(csvSor[2]);
		osszertek= Integer.parseInt(csvSor[3]);
		surgos = csvSor[4].equals("1");
	}


	public String getSzallitoiAzonosito() {
		return szallitoiAzonosito;
	}


	public String getMegnevezes() {
		return megnevezes;
	}


	public int getMennyiseg() {
		return mennyiseg;
	}


	public int getOsszertek() {
		return osszertek;
	}


	public boolean isSurgos() {
		return surgos;
	}


	@Override
	public String toString() {
		return "Rendeles [szallitoiAzonosito=" + szallitoiAzonosito + ", megnevezes=" + megnevezes + ", mennyiseg="
				+ mennyiseg + ", osszertek=" + osszertek + ", surgos=" + surgos + "]";
	}
	

}
