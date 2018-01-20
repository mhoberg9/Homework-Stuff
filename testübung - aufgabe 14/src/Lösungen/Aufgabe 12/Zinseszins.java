import Prog1Tools.IOTools;
public class Zinseszins {
  public static void main(String [] args) {
    double anlage=IOTools.readDouble("Anzulegender Geldbetrag in Euro:");
    double zins=IOTools.readDouble("Jahreszins (z. B. 0.1 fuer 10 Prozent):");
    int lz=IOTools.readInteger("Laufzeit (in Jahren):");
    double endbetrag=anlage;
    for (int i=1;i<=lz;i++) {
      endbetrag=endbetrag*(1+zins);
      System.out.println("Wert nach " + i + " Jahren: " + endbetrag);
    }
  }
}
