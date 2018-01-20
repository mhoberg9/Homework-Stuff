import Prog1Tools.IOTools;

public class 
  public static void main(String [] args) {
    int zahl = IOTools.readInteger("Positive ganze Zahl: ");
    
    String vorwaerts = ""; 
  
    System.out.print("Zerlegt rueckwaerts: ");
    
    while (zahl != 0) {
      int rest = zahl % 10;
      zahl = zahl / 10;
      String ziffer = "";
      switch (rest) {
        case 1: ziffer = "eins"; break;
        case 2: ziffer = "zwei"; break;
        case 3: ziffer = "drei"; break;
        case 4: ziffer = "vier"; break;
        case 5: ziffer = "fuenf"; break;
        case 6: ziffer = "sechs"; break;
        case 7: ziffer = "sieben"; break;
        case 8: ziffer = "acht"; break;
        case 9: ziffer = "neun"; break;
        case 0: ziffer = "null"; break;
      }
      System.out.print(ziffer + " ");
      
      vorwaerts = ziffer + " " + vorwaerts;
    }
    System.out.println();
    System.out.print("Zerlegt vorwaerts: ");
    System.out.println(vorwaerts);
  }
}
