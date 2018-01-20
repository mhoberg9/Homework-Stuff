import Prog1Tools.IOTools;

public class DSpiel {

	public static void main(String [] args){
		DameFigur beute, jaeger;
		
		char spaltenPos, richtung;
		int zeilenPos, anzahl;
		String farbe;
		
		System.out.println("Positionieren Sie die Beute");
		spaltenPos =  IOTools.readChar("Spalte: ");
		zeilenPos = IOTools.readInt("Zeilen: "))
		beute = new DameFigur(spaltenPos, zeilenPos, farbe){
		
		Bildschirm.loeschen();	
		
		System.out.println("Positionieren Sie den Jäger");
		spaltenPos =  IOTools.readChar("Spalte: ");
		zeilenPos = IOTools.readInt("Zeilen: ");
		jaeger = new DameFigur(spaltenPos, zeilenPos, farbe);
		
		if(jaeger.trifft(beute)){
			System.out.println("Jäger hat gewonnen");
		}else {
			System.out.println("Beute nicht gefunden. 10 Züge um die Beute zu finden.");
			
			for(int i = 1; i<=10; i++){
				richtung = IOTools.readChar("waagerecht - oder" + "senkrecht | oder diagonal /, \\");
				jaeger.ziehe(richtung, anzahl);
			
			}
		}
			
			
		}
	}
}
