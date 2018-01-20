import Prog1Tools.IOTools;
public class Wochentag {
  public static void main (String[] args) {
    int t, m, j, c, y, h;

    t = IOTools.readInteger ("Tag = ");
    m = IOTools.readInteger ("Monat = ");
    j = IOTools.readInteger ("Jahr = ");

    System.out.print("Der " + t + "." + m + "." + j + " ist ein ");

    if (m <= 2)
    {
      m = m + 10;
      j = j - 1;
    }
    else
      m = m - 2;
    c = j/100;
    y = j%100;
    h = (((26*m - 2)/10) + t + y +y/4 +c/4 -2*c) % 7;
    if (h < 0)
      h = h + 7;

    if (h == 0)
      System.out.println("Sonntag.");
    else if (h == 1)
      System.out.println("Montag.");
    else if (h == 2)
      System.out.println("Dienstag.");
    else if (h == 3)
      System.out.println("Mittwoch.");
    else if (h == 4)
      System.out.println("Donnerstag.");
    else if (h == 5)
      System.out.println("Freitag.");
    else
      System.out.println("Samstag.");
  }
}
