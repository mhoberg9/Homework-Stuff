import Prog1Tools.IOTools;

public class HellloWorld {
	public static void main (String[] args)
	{
				
		System.out.println("Hello World");
		
		String name = IOTools.readLine("Gebe hier deinen Namen ein:");
		// variable wird nun durch IOTools erkannt
		
		System.out.println("Hello "+name);
		// name wird ausgegeben
		
		
	}

}
