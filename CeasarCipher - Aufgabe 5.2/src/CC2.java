
import Prog1Tools.IOTools;

public class CC2 {



	public static void printMessage(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static char[] readChars(int n, char [] array) {
		for (int i = 0; i < array.length; i++){
			array[i] = IOTools.readChar("Buchstabe eingeben: ");
		}

		return array ;
	}

	public static void shift(int s, char[] array) {
		for (int i = 0; i < array.length; i++) {
			int wert = (int) array[i] + s;
			array[i] = (char) wert;
			

		}
	}

	public static int getCommand() {
		String text;
		text=IOTools.readLine("Bitte shift oder exit eingeben");
		while (true) {
			if (text.toLowerCase().equals("shift")) {
				return 0;
			}	
			if (text.toLowerCase().equals("exit")) {
				return 1;
			}
		}

	}

	public static void main(String[] args) {
		
		System.out.println("Willkommen bei Cisear Cipher");
		int n = IOTools.readInt("Bitte l�nge ihres Wortes eingeben: ");
		char[]array= new char[n];
		readChars(n, array);
		int t=getCommand();
	
		switch (t){
		case 0 : 
			printMessage(array);
			int s = IOTools.readInt("Wert der Verschiebung eingeben:");
			shift(s, array);
			printMessage(array);
			break;
		case 1: 
			System.out.println("ByeBye");
			break;
			
		}
		
	}
}
