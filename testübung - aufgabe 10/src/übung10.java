import Prog1Tools.IOTools;
public class übung10 {
	public static void main (String [] args){
		
		int t = IOTools.readInt("Bitte einen Tag eingeben: ");
		int m = IOTools.readInt("Bitte einen Monat eingeben ");
		int j = IOTools.readInt("Bitte ein Jahr eingeben: ");
		int m2 = 0;
		int j2 = 0;
		int c = j/100;
		int y = j%100;
			
	if (m <= 2){
		m2 = m + 10;
		j2 = j - 1;
			
	} else {
		m2 = m - 2;
		
		int h = (((26 * m2 - 2) / 10) + t + y + (y/4) + (c/4) - 2 * c)%7;
		int h2= 0;
		
	if (h < 0){
		h2 = h +7;
		System.out.println(h2);
		if (h2 == 0){
			System.out.println( " ist ein Sonntag");
		} else if (h2 == 1){
			System.out.println(" ist ein Montag");
		} else if (h2 == 2){
			System.out.println( " ist ein Dienstag");
		} else if (h2 == 3){
			System.out.println(" ist ein Mittwoch");
		} else if (h2 == 4){
			System.out.println(" ist ein Donnerstag");
		} else if (h2 == 5) {
			System.out.println(" ist ein Freitag");
		} else  { 
			System.out.println(" ist ein Samstag");
			
		}
		
	} else {
		if (h2 == 0){
			System.out.println( " ist ein Sonntag");
		} else if (h == 1){
			System.out.println(" ist ein Montag");
		} else if (h == 2){
			System.out.println( " ist ein Dienstag");
		} else if (h == 3){
			System.out.println(" ist ein Mittwoch");
		} else if (h == 4){
			System.out.println(" ist ein Donnerstag");
		} else if (h == 5) {
			System.out.println(" ist ein Freitag");
		} else  { 
			System.out.println(" ist ein Samstag");
	}
	}	
		
	

	
	}
		
		
	}
}

