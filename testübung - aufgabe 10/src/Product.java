

import Prog1Tools.IOTools;

/**
 * Instanced of this class represent products. Products are stored in warehouses
 * and contain information of their name, price and description.
 *
 * @author Malte Hoberg
 *
 *         created 22/11/2015
 */

public class Product extends übung10 {
	// deklarierung aller Variablen
	
	private final double price;
	private int id = nextID++;
	private static int nextID = 0;

	// Konstruktor für Produkt erstellen
	public Product(double price) {
		this.price = price;
	}

	// setter-/getter-Methoden
	public double getPrice() {
		return price;
	}

	public int getId() {
		return id;
	}

	// Ausgabe der Produktvariablen durch toString
	@Override
	public String toString() {
		return "Product [Preis=" + price + "]";
	}

	// einlesen & rückgabe eines neuen Produktes
	static Product createProductFromUserinput() {

		double price = IOTools.readDouble("Bitte Preis eingeben");

		return new Product(name, description, price);

	}

}
