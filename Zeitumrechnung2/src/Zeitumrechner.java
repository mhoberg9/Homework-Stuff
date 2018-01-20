import Prog1Tools.IOTools;

public class Zeitumrechner {
	public static void main(String[] args) {
		
		System.out.println("Willkommen im Zeitumrechner!");
		long sekunde = IOTools.readLong("Bitte geben Sie einen Wert in Sekunden an: ");
		System.out.println("Ihr Wert in Sekunden entspicht: ");

		long sekundezujahr =sekunde / 31536000 ;
		System.out.print(sekundezujahr + " Jahr(e)," + '\t');
		long sekundezujahr2 =  sekunde % 31536000;
		
		long jahrezutage = sekundezujahr2 / 86400;
		System.out.print(jahrezutage + " Tag(e)," + '\t');
		long jahrezutage2 = sekundezujahr2 % 86400  ;
		
		long tagezustunden = jahrezutage2 / 3600;
		System.out.print(tagezustunden + " Stunde(n)," + '\t');
		long tagezustunden2 = jahrezutage2 % 3600;
		
		long stundenzuminuten = tagezustunden2 / 60;
		System.out.print(stundenzuminuten + " Minute(n)," + '\t');
		long stundenzuminuten2 = tagezustunden2 % 60 ;
		
		long minutenzuskeunden = stundenzuminuten2 / 60;
		System.out.print(stundenzuminuten2 + " Sekunde(n)");

}
}
