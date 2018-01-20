import Prog1Tools.IOTools;

public class aufgabe3 {
	public static void main (String [] args){
	
		String name = IOTools.readLine("Wie heiﬂen Sie? ");
		int alter = IOTools.readInt("Wie alt sind Sie? ");
		int altertage = alter * 365;
		
	System.out.println("Hallo " +name);
	System.out.println("Sie sind " +altertage + " Tage alt.");
		
	}

}
