
public class DameFigur extends Spielfigur {

	public DameFigur(char x, int y, String f) {
	 final String name = "Dame";
		super(x, y, f);
		// TODO Auto-generated constructor stub
	}

	public void ziehe(char richtung, int anzahl) {
		if (richtung == '-') {
			ziehe(anzahl, 0);
		} else if (richtung == '|') {
			ziehe(0, anzahl);
		} else if (richtung == '/') {
			ziehe(anzahl, anzahl);
		} else if (richtung == '\\') {
			ziehe(anzahl, -anzahl);
		}
	}

	public boolean trifft(DameFigur andere) {
		return (getXpos() == andere.getXpos() && getYpos() == andere.getYpos());
	}

	public String toString() {
		return getFarbe() + "e Dame auf dem Feld" + getXpos() + getYpos();

	}
}
