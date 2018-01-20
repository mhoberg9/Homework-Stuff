public class Spielfigur {    // Beliebige Spielfigur auf einem Schachbrett
  private char xPos;         // x-Koordinate (A - H) der Position der Figur
  private int yPos;          // y-Koordinate (1 - 8) der Position der Figur
  private String farbe;      // Farbe der Spielfigur
  public Spielfigur (char x, int y, String f) {  // Konstruktor
    xPos = x;             // belege x-Position
    yPos = y;             // belege y-Position
    farbe= f;             // belege Farbe
    korrigierePosition(); // korrigiere eventuell falsche Positionsangaben
  }
  private void korrigierePosition () {  // korrigiert die Positionsangaben
    if (xPos < 'A')
      xPos = 'A';
    else if (xPos > 'H')  
      xPos = 'H';
    if (yPos < 1)
      yPos = 1;
    else if (yPos > 8)  
      yPos = 8;
  }
  public char getXpos () {   // liefert den Wert der Instanzvariable xPos
    return xPos;
  }
  public int getYpos () {    // liefert den Wert der Instanzvariable yPos
    return yPos;
  }
  public String getFarbe () { // liefert den Wert der Instanzvariable farbe
    return farbe;
  }
  public void ziehe (int xF, int yF) { // bewegt die Figur
    xPos = (char) (xPos + xF); // um xF Felder nach rechts (<0 nach links)
    yPos = yPos + yF;          // um yF Felder nach oben (<0 nach unten)
    korrigierePosition();      // korrigiere event. falsche Positionsangaben
  }
  public String toString() { // liefert String-Darstellung des Objekts
    return farbe + "e Figur auf dem Feld " + xPos + yPos;
  }
}
