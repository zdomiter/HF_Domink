package feladat02;

import java.time.LocalDate;


public class Noveny {
	
	private String azonosito;
	private String megnevezes;
	private Integer bekerulesEve;
	
	
	public Noveny(String azonosito, String megnevezes, Integer felfedezesEve) {
		
		this.azonosito = azonosito;
		this.megnevezes = megnevezes;
		this.bekerulesEve = felfedezesEve;
		
	}
	

	public String getAzonosito() {
		return azonosito;
	}


	public String getMegnevezes() {
		return megnevezes;
	}


	public Integer getBekerulesEve() {
		return bekerulesEve;
	}


	@Override
	public String toString() {
		return "[azonosito=" + azonosito + ", megnevezes=" + megnevezes + ", bekerulesEve=" + bekerulesEve + "] Noveny";
	}


	public int hanyHonapjaLatogathato() {
		
		int now = LocalDate.now().getYear();
		return (now-bekerulesEve)*12;
		
	}
	

}
