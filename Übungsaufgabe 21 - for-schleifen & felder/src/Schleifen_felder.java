import Prog1Tools.IOTools;

public class Schleifen_felder {
	public static void main (String [] args){
		
		int count = IOTools.readInt ("Bitte Länge von Zahl eingeben:");
		int [] zahl = new int [count];
		for (int i = 0; i < zahl.length; i++){
			zahl[i] = IOTools.readInt(" Bitte Zahl eingeben: ");
		}
		
		for (int i = 0; i < count -1 ; i++){
			int j = 0;
				while(j < count - 1){
					if (zahl[j] > zahl[j+1]){
						int zahlhelper = zahl[j];
						zahl[j] = zahl[j+1];
						zahl[j+1] = zahlhelper;
					}
				j++;	
				}
				for (int i1 = 0; i1 < zahl.length; i1++){
					System.out.println(zahl[i1]);	
				}
		}
	
	}
}

