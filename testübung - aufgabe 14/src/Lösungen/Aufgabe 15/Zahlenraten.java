import Prog1Tools.IOTools;
public class Zahlenraten  {
  public static void main(String[] args) {
    int obergrenze=100, untergrenze=0, zaehler=0, eingabe;
    System.out.println(" *** Zahlenraten\n");
    System.out.print("Ich denke mir eine Zahl zwischen "+untergrenze+" und");
    System.out.println(" "+obergrenze+". Rate diese Zahl!\n");
    int zufall=(int)(Math.random()*(obergrenze-untergrenze-1)+untergrenze+1);
    do {
      zaehler++;
      System.out.print(zaehler+". Versuch: ");
      eingabe=IOTools.readInteger();
      if (eingabe < zufall)
        System.out.println("Meine Zahl ist groesser!");
      if (eingabe > zufall)
        System.out.println("Meine Zahl ist kleiner!");
    } while (eingabe!=zufall);
    System.out.println("Du hast die Zahl beim "+zaehler+". Versuch erraten.");
  }
}






