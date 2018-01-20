
public class aufgabe4 {
	public static void main(String [] args){
		int SekundenEingabe = 200000;
		int JahresSekunden = 31556926 / SekundenEingabe;
			int JahresTage = JahresSekunden % SekundenEingabe;
		int Tage =JahresTage /86400;
			int TagesStunden = Tage%JahresTage;
		int Hours = 3600/TagesStunden;
			int Stundenminute = Hours%TagesStunden;
		int Minuten = 60/Stundenminute;
			int SekundenSekunden = Minuten%Stundenminute;
		int Sekunden = 	60 / SekundenSekunden ;
		
	System.out.println(JahresSekunden + " Jahren");
	System.out.println(Tage + " Tagen");
	System.out.println(Hours + " Stunden");
	System.out.println(Minuten + " Minuten");
	System.out.println(Sekunden + " Sekunden");	
	
	
	
	
		
	}

}
