package �bung3;
import Prog1Tools.IOTools;
import java.math.*;

public class �bung3 {
	public static void main(String[] args){
		
	double u = IOTools.readDouble("Umfang eingeben: ");
	double h = IOTools.readDouble("H�he eingeben: ");
	double l = Math.sqrt(Math.pow(u, 2)+ Math.pow(h, 2));
	double d = u / Math.PI;
	double fboden = Math.PI * Math.pow(d/2,2);
	double fmantel = u * h;
	double fgesamt = 2 * fboden + fmantel;
	double v = fboden * h;
	
	System.out.println("L�nge der Diagonalen des BlechSt�cks: " +l);
	System.out.println("Durchmesser des Dosenbodens: " +d);
	System.out.println("Fl�che des Dosenbodens: " +fboden);
	System.out.println("Mantelf�che der Dose: " +fmantel);
	System.out.println("Gesamtfl�che der Dose: " +fgesamt);
	System.out.println("Volumen der Dose: " +v);
	
	
	}
}
