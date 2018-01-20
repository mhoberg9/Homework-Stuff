import Prog1Tools.IOTools;

public class helloworldmitprog1tools {
	public static void main(String[] args) {
		System.out.println("Willkommen bei Hello World");
		
		String name = IOTools.readLine("Wie ist ihr Name? ");

		System.out.println("Hello " + name);
	}
}
