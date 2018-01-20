

import Prog1Tools.IOTools;

public class PrintTools {
	public static void main(String[] args) {

		double d = IOTools.readDouble("Welche Zahl möchten sie in Prozent angeben? ");
		int a = IOTools.readInt("Wie viele Nachkommastellen? ");
		
		String prozent = alsProzent(d, a);
		System.out.println(prozent + "%" + " Methoc1");

		String prozent2 = alsProzent(a,d);
		System.out.println(prozent2 + "%" + " Method2");
		
		String prozent3 = alsProzent(d);
		System.out.println(prozent3 + "%" + " Method3");

	}

	public static String alsProzent(double d, int a) {

		double b = d * 100;
		String wort = String.valueOf(b);
		String punkt = wort.replace('.', ',');
		int komma = punkt.indexOf(',');

		String vorkomma = wort.substring(0, komma);
		String nachkomma = wort.substring(komma, komma + 1 + a);

		String Prozent = vorkomma + nachkomma;
		return Prozent;
	}
	
	public static String alsProzent(int a, double...d ){
		
		for (int i = 0 ; i < d.length; i++){
		double b = d[i] * 100;
		String wort = String.valueOf(b);
		String punkt = wort.replace('.', ',');
		int komma = punkt.indexOf(',');
		
		String vorkomma = wort.substring(0, komma);
		String nachkomma = wort.substring(komma, komma + 1 + a);

		String Prozent = vorkomma + nachkomma;
		return Prozent;
		
		}
		return null;
	}
	public static String alsProzent(double d){
		double b = d*100;
		String wort = String.valueOf(b);
		String punkt = wort.replace('.', ',');
		int komma = punkt.indexOf(',');
		
		String vorkomma = wort.substring(0, komma);
		String nachkomma = wort.substring(komma, komma +1 + 2);
		String Prozent = vorkomma + nachkomma;
		
	return Prozent;	
	}
}
