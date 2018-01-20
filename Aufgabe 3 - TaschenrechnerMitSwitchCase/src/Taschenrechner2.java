import Prog1Tools.IOTools;



public class Taschenrechner {
	public static void main (String[] args)
	{
				
		System.out.println("Willkommen im Taschenrechner");
		
		String name = IOTools.readLine("Gebe hier deinen Namen ein:");
		// variable wird nun durch IOTools erkannt
		
		System.out.println("Hello "+name);
		// name wird ausgegeben
		
		int zahl = IOTools.readInt("Bitte eine Zahl eingeben:");
		int zahl2 = IOTools.readInt("Bitte eine zweite Zahl eingeben:");
		char operator = IOTools.readChar("Bitte Operator +,-,*,/,% eingeben:");
		int ergebnis = 0;
		
		if (operator== '+' )
		{ergebnis = zahl + zahl2;
		System.out.println(Aufgabe 3 - Taschenrechnerzahl+ "+"+ zahl2+ "=" +ergebnis);
		} 
		else if (operator== '-')
		{ergebnis = zahl - zahl2;
		System.out.println(zahl+ "-"+ zahl2+ "=" +ergebnis);
		}
		else if (operator== '*')
		{ergebnis = zahl * zahl2;
		System.out.println(zahl+ "*"+ zahl2+ "=" +ergebnis);
		} 
		else if (operator== '/')
		{ergebnis = zahl / zahl2;
		System.out.println(zahl+ "/"+ zahl2+ "=" +ergebnis);
		} 
		else if (operator== '%')
		{ergebnis = zahl % zahl2;
		System.out.println(zahl+ "%"+ zahl2+ "=" +ergebnis);
		} else {
			System.out.println("Bitte geben Sie einen Operator ein! (+,-,*,/,%)");
		} 
		
		
	}

}
