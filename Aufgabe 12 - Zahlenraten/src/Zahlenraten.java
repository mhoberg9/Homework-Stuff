


import Prog1Tools.IOTools;

public class Zahlenraten {

	/**
	 * Instances of this class are used to guess a number . They contain method to calculate the guessed number.
	 * 
	 * @author Malte Hoberg
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		/**
		 * This method is used to declare all variables and fill an array with the difference between high and low.
		 */
		
		System.out.println("Willkommen beim Zahlenraten.");
		int low = IOTools.readInt("Bitte untere Grenze eingeben: ");
		int high = IOTools.readInt("Bitte obere Grenze eingeben: ");
		int lang = ((high - low) + 1);
		int helper1 = 0;
		int[] laenge = new int[lang];
		for (int j = low; j <= laenge.length; j++) {
			laenge[helper1] = j;
		}
		helper1++;

		search(laenge, low, high);
	}

	public static void search(int[] laenge, int low, int high) {
		
		/**
		 * This method is used to calculate the guessed number.  
		 */
		
		int middle = low + ((high - low) / 2);
		boolean guess = true;
		//Alle n�tigen variablen werden definiert. Der Mittelwert wird f�rs auschlie�en von Bereichen des Arrays benutzt.
		
		do {
			// Diese Schleife wird so lange ausgef�hrt bis der Mittelwert der unteren oder oberen Grenze entspricht.
			int number = IOTools.readInt("Ist ihre Zahl groe�er als: " + middle + "?" + " Dr�cke 1 f�r 'Ja' und 2 f�r 'Nein'.");
			if (middle != low && middle != high){
			switch (number) {
			// Es wird der Mittelwert ausgerechnet und je nach dem ob die gedachte Zahl gr��er oder kleiner ist, wird die untere oder obere Grenze �berschrieben.
			case 1:
				search(laenge, middle + 1, high);
				break;
				
			case 2:
				search(laenge, low, middle-1); 
				break;
			default:
				break;
			}
			} else {
				// Sofern der Mittelwert der gedachten Zahl entspricht , wird die Schleife abgebrochen und der Wert Ausgegeben.
				if (number == 0){
					System.out.println("Ihre gedachte Zahl ist: " + high);
					guess = true;
					} else {
						System.out.println("Ihre gedachte Zahl ist : " +low);
					guess = true;
					}
			}
		} while (guess == false);	
	}
}
