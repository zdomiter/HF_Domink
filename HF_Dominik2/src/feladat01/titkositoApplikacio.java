package feladat01;

import java.util.Scanner;

public class titkositoApplikacio {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Adja meg a titkositani kivant szót!");
		String titkositando = sc.nextLine();
		System.out.println(titkosit(titkositando));
		System.out.println(dekodolas(titkosit(titkositando)));
		
		
	}

	
	public static String titkosit(String titkositando) {
		
		String mitKellCserelni = "kstea ";
		String mireKellCserelni = "135790";
		String eredmeny = titkositando;
		
	    for (int i = 0; i < mitKellCserelni.length(); i++)
        {
            eredmeny = eredmeny.replace(mitKellCserelni.charAt(i), mireKellCserelni.charAt(i));
        }

	    if (eredmeny.length() > 1) {
	    		    	
	    	eredmeny = eredmeny.charAt(eredmeny.length()-1)+eredmeny.substring(0,eredmeny.length()-1);
	    	
	    }	    
		
		return eredmeny;
		
	}
	public static String dekodolas(String dekodolando) {
		
		String mitKellCserelni = "kstea ";
		String mireKellCserelni = "135790";
		
	    for (int i = 0; i < mitKellCserelni.length(); i++)
        {
            dekodolando = dekodolando.replace(mireKellCserelni.charAt(i), mitKellCserelni.charAt(i));
        }

	    if (dekodolando.length() > 1) {
	    		    	
	    	dekodolando = dekodolando.substring(1,dekodolando.length())+dekodolando.charAt(0);
	    	
	    }	    
		
		return dekodolando;
		
	}

}
