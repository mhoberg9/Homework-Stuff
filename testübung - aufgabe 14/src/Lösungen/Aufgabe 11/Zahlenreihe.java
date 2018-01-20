import Prog1Tools.IOTools;
public class Zahlenreihe {
  public static void main(String [] args) {
    System.out.print("Geben Sie eine Zahl ein: ");
    int i=IOTools.readInteger();
    System.out.print("Die Vielfachen: ");
    for (int j=1;j<=10;j++) {
        System.out.print(j*i + " ");
    }
    System.out.println();
  }
}
