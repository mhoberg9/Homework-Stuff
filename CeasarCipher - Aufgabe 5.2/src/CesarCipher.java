import Prog1Tools.IOTools;

public class CesarCipher {
	public static void main(String[] args) {
		int länge = IOTools.readInt("Länge eingeben: ");
		char [] array = new char[länge];
		readChars(länge, array);
		int shiftwert = IOTools.readInt("Bitte Verschiebung eingeben! ");
		
		}
	


	public static void printMessage(char[] array) {
		for (int i = 0; i <= array.length; i++) {
			System.out.println(i);
		}
	}

	public static  char[] readChars(int länge, char []  array) {
		char text = IOTools.readChar("text");
		for (int i = 0; i <= array.length; i++) {
			array[i] = text;
		}
		return array;
	}
	public static void shift (int shiftwert, char [] array){
		for (int c = 0; c<= array.length; c++){
			int wert = (int)array[c];
			int wertneu = wert + shiftwert;
			
			for (int z = 0; z <= array.length; z++){
				array[z] = (char) wertneu;
			}
		}
	}
	public static int getCommand () {
		
		String Eingabe = IOTools.readLine("Bitte shift oder exit eingeben");
		while(true){
			if (Eingabe.equals("shift")){
				
			return 0;	
			}
			if (Eingabe.equals("exit")){
			return 1;	
			}
		}
		
	}
}

