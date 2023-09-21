package kerekparBolt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FajlKezelo {

	private static String fejlec ="";
	
	public List<Kerekpar> fajlBeolvas(String fajlNev){
		List<Kerekpar> kerekparok = new ArrayList<Kerekpar>();
			
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fajlNev), "UTF-8"));
			
			fejlec = br.readLine();
			while (br.ready()) {
				String sor = br.readLine();
				String[] sorAdatok = sor.split(";");
				
				Boolean hasznaltTemp = sorAdatok[4].equals("1");
				
				Kerekpar ujKerekparObj = new Kerekpar(
						Integer.parseInt(sorAdatok[0]),
						sorAdatok[1],
						sorAdatok[2],
						Integer.parseInt(sorAdatok[3]),
						hasznaltTemp,
						Byte.parseByte(sorAdatok[5]),
						LocalDate.parse(sorAdatok[6], DateTimeFormatter.ofPattern("yyyy.MM.dd"))
				);
				kerekparok.add(ujKerekparObj);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kerekparok;
	}
	
	public void trekkingFajlBaIr(List<Kerekpar> kerekparok) {
		try {
			FileOutputStream fs = new FileOutputStream("trekking_ferfi.csv", false);
			OutputStreamWriter out = new OutputStreamWriter(fs, "UTF-8");
			//out.write("cikkszám;név;típus;ár;használt;kategóriaId;rögzítésDátuma");
			out.write(fejlec);
			out.write("\n");
			for (Kerekpar kerekpar : kerekparok) {
				if (kerekpar.getTipus().equalsIgnoreCase("trekking")) {
					out.write(kerekpar.getCikkSzam().toString());
					out.write(";");
					out.write(kerekpar.getNev());
					out.write(";");
					out.write(kerekpar.getTipus());
					out.write(";");
					out.write(kerekpar.getAr().toString());
					out.write(";");
					out.write(kerekpar.getHasznalt() ? "1" :"0");
					out.write(";");
					out.write(kerekpar.getKategoriaId().toString());
					out.write(";");
					out.write(kerekpar.getRogzitesDatuma().toString().replace("-", "."));
					out.write("\n");
				}
			}
			out.close();
			fs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
