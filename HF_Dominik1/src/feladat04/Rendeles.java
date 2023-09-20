package feladat04;

public class Rendeles {

	private String szallitoiAzonosito;
	private String megnevezes;
	private int mennyiseg;
	private int osszertek;
	private boolean surgos;
	


	public Rendeles(String[] csvSor) {
		this.szallitoiAzonosito = csvSor[0];
		this.megnevezes = csvSor[1];
		this.mennyiseg = Integer.parseInt(csvSor[2]);
		this.osszertek = Integer.parseInt(csvSor[3]);
		this.surgos = csvSor[4].equals("1");
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


	public String surgosText() {
		
		return surgos ? "Igen" : "Nem"; 
	}

	@Override
	public String toString() {
		return "Rendeles [szallitoiAzonosito=" + szallitoiAzonosito + ", megnevezes=" + megnevezes + ", mennyiseg="
				+ mennyiseg + ", osszertek=" + osszertek + ", surgos=" + surgosText() + "]";
	}

}
