import Prog1Tools.IOTools;
public class Dreieck {
  public static void main(String [] args) {
    int n = IOTools.readInteger("Anzahl der Zeilen:");
    for (int i=1;i<=n;i++) {
      for (int j=1;j<=i;j++)
        System.out.print("*");
      System.out.println("");
    }
  }
}
