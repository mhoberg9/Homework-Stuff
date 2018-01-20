package übung2;

import Prog1Tools.IOTools;

public class übung2 {
	public static void main(String [] args){
		int Sekunden = IOTools.readInt("Bitte Sekunden-Wert eingeben");
		int Jahre = Sekunden/31556926;
			int Jahrestage = Sekunden%31556926;
		int Tage = Jahrestage/86400;
			int Tagesstunden= Jahrestage%86400;
		int Stunden = Tagesstunden / 3600;
			int Tagesminuten = Tagesstunden%3600;
		int Minuten = Tagesminuten/60;
				int Tagessekunden = Tagesminuten%60;
		int	Sekunden2 = Tagessekunden;
		
	System.out.println( Jahre + " Jahre");
	System.out.println( Tage + " Tage");
	System.out.println( Stunden +" Stunden");
	System.out.println( Minuten +" Minuten");
	System.out.println( Sekunden2 +" Sekunden");
	
	
			
	}

}
