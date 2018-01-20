package aufgabe5ceasarcipher;

import Prog1Tools.IOTools;

public class cc {
	
	public static void main(String [] args){
		char [] nachricht = new char [3];
		printMessage(nachricht);
		int i = IOTools.readInt("geben sie eine länge ein");
		char [] text = readChars(5);
		shift(message, i );
		
		
	}
	
	
	public static void printMessage (char []  message ){
		for(int i = 0; i < message.length; i++){
			System.out.print(message[i]);
			
		}
		System.out.print(" ");
	}
	
	public static char [] readChars(int rueckgabe){
		char [] message = new char[rueckgabe];
		for(int i = 0; i < rueckgabe; i++){
			message[i] = IOTools.readChar("Bitte geben sie ein char an der Position ein" + i +"ein");
		}
		return null;
		
	}
	
	public static void shift (char [] messages,int zahler){
		for(int i = 0; i < messages.length; i++);
		int wert = (int)messages[i];
		wert = wert + zahler;
		messages[i] = (char)(messages[i]+zahler);
	
		printMessage(messages);
		
		}
	
	public static int getCommand(){
		String str = IOTools.readLine();
				
	while(!str.equals("shift")) str.equals("exit"))){
		
	}
	}
}
