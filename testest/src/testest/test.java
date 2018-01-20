package testest;

public class test {
	static Baumhaus bauHaus(int hoehe, int breite) {
		Baumhaus b = new Baumhaus();
		b.hoehe = hoehe;
		b.breite = breite;
		return b;
	}

	static Baumhaus machBreiter(Baumhaus b) {
		Baumhaus bb = new Baumhaus();
		bb.hoehe = b.hoehe;
		bb.breite = b.breite + 1;
		return bb;
	}

	static Baumhaus machHoeher(Baumhaus b) {
		b.hoehe++;
		return b;
	}

	public static void main(String[] args) {
		Baumhaus b = bauHaus(2, 3);
		Baumhaus c = machBreiter(b);
		c.nachbar = b;
		Baumhaus d = machHoeher(b);
		d.nachbar = b;
		++c.hoehe;
		Baumhaus e = machHoeher(b);
		e.nachbar = c;
		e.breite = b.breite - 1;
		
		c.hoehe++;
		c.breite -= 2;
		boolean bUndCBenachbart = (b.nachbar == c || c.nachbar == b);
		
		System.out.println("b.breit" + b.breite);
		System.out.println("b.hohe" + b.hoehe);
		System.out.println("c.breite " + c.breite);
		System.out.println("c.höhe" + c.hoehe);
		System.out.println("d.breite " + d.breite);
		System.out.println("d.höhe " + d.hoehe);
		System.out.println("e.breite " + e.breite);
		System.out.println("e.höhe " + e.hoehe);
		System.out.println(bUndCBenachbart);
		System.out.println(Baumhaus.naechsteNummer);
		
		
		// hier
	}
}

class Baumhaus {
	public int hoehe;
	public int breite;
	public Baumhaus nachbar;
	public int nummer = ++naechsteNummer;
	static int naechsteNummer = 0;
}