import Prog1Tools.IOTools;
public class ImperativeProgrammierung {
	public static void main (String [] args){
		
		//Lesen Sie zwei int n , int m von Tastatur ein
		
		int n = IOTools.readInt("Wert eingeben");
		int m = IOTools.readInt("Wert eingeben");
		
		// Lesen Sie eine double-Variable d von der Tastatur ein
		
		double d = IOTools.readDouble("Wert eingeben");
		
		//Deklarieren Sie eine variable var, die die Rückgabe der methode gernate numbers speichern kann
		
		int [] var ;
		
		//Rufen Sie generate Numbers auf
		
		var = generateNumbers( n  , m);
		
		//Deklarieren Sie eine variable foo, die das Ergebnis von divideNumbers speichern kann. Rufen sie dann die methode divideNumbers mit den parametern var, d auf.
		
		double [] foo = divideNumbers( var , d);
		
		//Rufen sie die Methode printarray mit den parametern Foo unnd dem angebebnen String auf
			
		printArray( foo , "Value");
		
		
	}
	
	public static int [] generateNumbers(int n, int m){
		
		/* Geben Sie alle Zahlen von 0 bis n (inkl.) als Array zurück. Ersetzen Sie in diesem Array aber alle Zahlen, 
		 * die nicht durch (m-1) ganzzahlig teilbar sind, durch den Wert 0. Geben Sie im Fall m=1 bitte null zurück. Falls 
		 * Sie eine Schleife benötigen, verwenden Sie bitte die for-Schleife. */
		
		
		if (m== 1){
			return null;
		}
		int [] result = new int [n+1];
		for (int i = 0; i < result.length; i++){
			if (i % (m-1) == 0){
				result [i ] = i;
			} else {
				result [i] = 0;
			}
			
			
		}
		return result;
	}
	
	public static double [] divideNumbers(int [] ints, double d){
		/* Teilen Sie alle Werte des übergebenen Parameters ints durch die Zahl d. 
		 * Wählen Sie einen geeigneten Rückgabetyp und stellen Sie sicher, dass die Werte im Array ints 
		 * selbst nicht verändert werden. Falls Sie eine Schleife benötigen, verwenden Sie bitte die do-while-Schleife.*/ 
		double [] result2 = new double [ints.length];
		int i = 0;
		do {
			result2 [i] = ints[i]/d;
		i++;
		}while ( i < ints.length);
		return result2;
		
	}
	
	
 public static void  printArray ( double [] bar, String string){
		/* Ergänzen Sie den Rest des Methodenkopfes basierend auf Ihren Eintragungen in main, 
		 * die Methode soll keinen Rückgabewert haben. Nennen Sie den ersten Parameter bar, den zweiten string.
		 *  Terminieren Sie als erste Anweisung die Methode, falls bar den Wert null hat. Anderenfalls nutzen Sie bitte die
		 *   vereinfachte for-Schleife, um alle Werte von bar auszugeben. Stellen Sie dabei sicher, dass alle Werte in einer Zeile 
		 *   ausgegeben werden und mit Kommata getrennt werden. Geben Sie vor jedem Eintrag jeweils den Parameter string aus. D.h. für 
		 *   einen Eintrag „7“ in bar und einen Wert „ex“ in string, müsste die Ausgabe für diesen Wert „7ex,“ lauten. */ 
		
		
	 for(double d : bar){
		 System.out.println(string + bar + ",");
		
		
	}

}

}