package feladat04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FajlKezeles {
	
	public int beolvas(List<Rendeles> rendelesek, String fajlnev) throws IOException {
		
		int hibasTetelekSzama = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		
		while (br.ready()) {
			
			String csvSor[] = br.readLine().split(";");
			
			if (ellenoriz(csvSor)) {
				
				rendelesek.add(new Rendeles(csvSor));
				
			}
			else {
				
				hibasTetelekSzama++;
				
			}
			
		}
		
		br.close();
		return hibasTetelekSzama;
		
	}

	
	public boolean ellenoriz(String[] csvSor) {
		
		return csvSor.length == 5 && csvSor[0].length() >= 5;
		
	}
	public void Kiiratas(String fajlnev, List<Rendeles> rendelesek) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fajlnev,true))) {
			for (Rendeles rendeles : rendelesek) {
				String sor = rendeles.getSzallitoiAzonosito() + ";" + rendeles.getMegnevezes() + ";" + rendeles.getMennyiseg()
				+ ";" + rendeles.getOsszertek() + ";" + (rendeles.isSurgos() ? "1" : "0");
				bw.close();
				bw.newLine();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
