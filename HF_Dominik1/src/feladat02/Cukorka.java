package feladat02;

public final class Cukorka extends Edesseg {
	
	private boolean toltott;

	public Cukorka(String megnevezes, int egysegar, int darabszam, boolean toltott) {
		super(megnevezes, egysegar, darabszam);
		this.toltott = toltott;
	}

	public boolean isToltott() {
		return toltott;
	}

	@Override
	public String toString() {
		return "[toltott=" + toltott + ", Megnevezes=" + getMegnevezes() + ", Egysegar="
				+ getEgysegar() + ", Darabszam=" + getDarabszam() + "] Cukorka" ;
	}

}
