import Prog1Tools.IOTools;
import static java.lang.Math.*;
public class Raviolita {
  public static void main (String[] args) {
    double u, h;

    u = IOTools.readDouble("Laenge des Blechs: u = ");
    h = IOTools.readDouble("Breite des Blechs: h = ");
    
    double lDiag, dBoden, fBoden, fMantel, fGesamt, v;
    lDiag = sqrt(u*u + h*h);
    dBoden = u / PI;
    fBoden = PI * (dBoden/2) * (dBoden/2);
    fMantel = u * h;
    fGesamt = 2 * fBoden + fMantel;
    v = fBoden * h;

    System.out.println("Laenge des Blechs (Umfang der Dose): " + u);
    System.out.println("Breite des Blechs (Hoehe der Dose): " + h);
    System.out.println("Laenge der Diagonalen des Blechs: " + lDiag);
    System.out.println("Durchmesser des Dosenbodens: " + dBoden);
    System.out.println("Flaeche des Dosenbodens: " + fBoden);
    System.out.println("Mantelflaeche der Dose: " + fMantel);
    System.out.println("Gesamtflaeche der Dose: " + fGesamt);
    System.out.println("Volumen der Dose: " + v);
  }
}

