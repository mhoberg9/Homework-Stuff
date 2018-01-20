import Prog1Tools.*;
public class Tannenbaum {
  public static void main (String[] args) {
    int i,j,k;
    int blaetter = 0;
    int hoehe = IOTools.readInteger("Anzahl der Zeilen: ");
    for (i=1; i<=hoehe; i++) {
      for (j=1; j<=hoehe-i; j++)
        System.out.print(" ");
      for (j=1; j<=(2*i-1); j++)
        System.out.print("*");
      System.out.println();
    }
    for (i=1; i<hoehe; i++)
      System.out.print(" ");
    System.out.println("I");
  }
}
