package kerekparBolt;

import java.time.LocalDate;

public class Kerekpar {

	private Integer cikkSzam;
	private String nev;
	private String tipus;
	private Integer ar;
	private Boolean hasznalt;
	private Byte kategoriaId;
	private LocalDate rogzitesDatuma;

	public Kerekpar(Integer cikkSzam, String nev, String tipus, Integer ar, Boolean hasznalt, Byte kategoriaId,
			LocalDate rogzitesDatuma) {
		this.cikkSzam = cikkSzam;
		this.nev = nev;
		this.tipus = tipus;
		this.ar = ar;
		this.hasznalt = hasznalt;
		this.kategoriaId = kategoriaId;
		this.rogzitesDatuma = rogzitesDatuma;
	}

	public Integer getCikkSzam() {
		return cikkSzam;
	}

	public String getNev() {
		return nev;
	}

	public String getTipus() {
		return tipus;
	}

	public Integer getAr() {
		return ar;
	}

	public Boolean getHasznalt() {
		return hasznalt;
	}

	public Byte getKategoriaId() {
		return kategoriaId;
	}

	public LocalDate getRogzitesDatuma() {
		return rogzitesDatuma;
	}

	public String getHasznaltSzoveg() {
		String valasz = "új";
		if (this.hasznalt) {
			valasz = "használt";
		}
		return valasz;
	}

	//ENUM megoldás talán szebb lenne
	public String getKategoriaSzoveg() {
		String kategoriaSzoveg = null;
			switch (this.kategoriaId) {
				case 1: kategoriaSzoveg = "férfi";
					break;
				case 2: kategoriaSzoveg = "női";
					break;
				case 3: kategoriaSzoveg = "gyermek";
					break;
				default: kategoriaSzoveg = "hibás adat";
					break;
				}
		return kategoriaSzoveg;
	}
}
