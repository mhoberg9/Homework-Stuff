import Prog1Tools.IOTools;
public class Texteingabe 
{
  public static void main(String [] args)
  {
    System.out.print("Gib Deinen Namen ein: ");
    String name=IOTools.readLine();
    System.out.print("Gib Dein Alter ein: ");
    int alter=IOTools.readInteger();
    System.out.print("Hallo " + name + ", Du bist mindestens " + alter*365);
    System.out.println(" Tage alt.");
  }
}
