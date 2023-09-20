package feladat02;

public final class Csokolade extends Edesseg {
	
	private double kakaotartalom;

	public Csokolade(String megnevezes, int egysegar, int darabszam, double kakaotartalom) {
		super(megnevezes, egysegar, darabszam);
		this.kakaotartalom = kakaotartalom;
	}

	public double getKakaotartalom() {
		return kakaotartalom;
	}

	@Override
	public String toString() {
		return "[kakaotartalom=" + kakaotartalom + ", Megnevezes=" + getMegnevezes() + ", Egysegar="
				+ getEgysegar() + ", Darabszam=" + getDarabszam() + "] Csokolade";
	}

	

	


}
