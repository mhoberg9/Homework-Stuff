package �bung;
import Prog1Tools.IOTools;


public class �bung {
	public static void main(String [] args){
		
		System.out.println("Hello");
		String name = IOTools.readString("Wie hei�en sie?");
		int alter = IOTools.readInt("Wie alt sind sie? in Jahren");
		int alter2 = alter * 365;
		System.out.println("Hallo" +name);
		System.out.println("Sie sind also " +alter2+ " Tage alt");
	}

}
