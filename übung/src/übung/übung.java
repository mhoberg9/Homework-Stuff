package übung;
import Prog1Tools.IOTools;


public class übung {
	public static void main(String [] args){
		
		System.out.println("Hello");
		String name = IOTools.readString("Wie heißen sie?");
		int alter = IOTools.readInt("Wie alt sind sie? in Jahren");
		int alter2 = alter * 365;
		System.out.println("Hallo" +name);
		System.out.println("Sie sind also " +alter2+ " Tage alt");
	}

}
