import Prog1Tools.IOTools;
public class aufgabe14 {
	public static void main(String [] args){
		
		int einlese = IOTools.readInt("Bitte geben sie eine positive Zahl ein: ");
		int counter = 0;
		int counter2 = 0;
		String ziffer = "";
		
		while(einlese != 0){
			counter = einlese % 10;
			einlese = einlese / 10;
		
		}
		
		
		switch(counter){
		case 1 : ziffer  = "eins";
		case 2 : ziffer = "zwei";
		case 3 : ziffer = "drei";
		
		}
		System.out.println(ziffer);	
		 
		}
	}


