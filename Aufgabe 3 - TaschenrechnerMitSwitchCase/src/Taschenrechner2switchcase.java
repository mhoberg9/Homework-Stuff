import Prog1Tools.IOTools;



public class Taschenrechner {
	public static void main (String[] args)
	{
		String aktion = IOTools.readString(Befehl);
		
		switch(aktion){
		case "sayHello": System.out.println("Hallo"); break;
		case "sayGoodbye": System.out.println("bye"); break;
		default: System.out.println("ende");
		}
	}
				}
