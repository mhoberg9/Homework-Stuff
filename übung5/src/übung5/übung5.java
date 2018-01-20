package übung5;
import Prog1Tools.IOTools;


public class übung5 {
	public static void main(String [] args){
	
	int t = IOTools.readInt("Tag eingeben");
	int m = IOTools.readInt("Monat eingeben");
	int j = IOTools.readInt("Jahr eingeben");
	double c = j/100;
	double y = j%100;
	double h = (((26 * m - 2) / 10) + t + y+ y + (y / 4) + (c / 4) - 2 * c) % 7;
	int ergebnis = 0;
	int ergebnis2 = 0;
	double ergebnis3 = 0;
	
if (m <= 2)
{ergebnis = m + 10;
 ergebnis2 = j - 1;
 	System.out.println(ergebnis);
 	System.out.println(ergebnis2);
} 
else if (h < 0)
{ergebnis3 = h + 7;
	System.out.println(ergebnis3);
	
} else {
	ergebnis = m - 2;
	System.out.println(ergebnis);
	
}

		
		
		}
}




