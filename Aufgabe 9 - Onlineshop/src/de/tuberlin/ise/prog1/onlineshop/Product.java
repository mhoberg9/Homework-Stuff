package de.tuberlin.ise.prog1.onlineshop;

import Prog1Tools.IOTools;

/**
 * Instanced of this class represent products. Products are stored in warehouses
 * and contain information of their name, price and description.
 *
 * @author Malte Hoberg
 *
 *         created 22/11/2015
 */

public class Product {
	// deklarierung aller Variablen
	private final String name;
	private final String description;
	private final double price;
	private int id = nextID++;
	private static int nextID = 0;

	// Konstruktor für Produkt erstellen
	public Product(String name, String description, double price) {

		this.name = name;
		this.description = description;
		this.price = price;
	}

	// setter-/getter-Methoden
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getId() {
		return id;
	}

	// Ausgabe der Produktvariablen durch toString
	@Override
	public String toString() {
		return "Product [Name=" + name + ", Beschreibung=" + description + ", Preis=" + price + "]";
	}

	// einlesen & rückgabe eines neuen Produktes
	static Product createProductFromUserinput() {

		String name = IOTools.readLine("Bitte Namen eingeben");
		String description = IOTools.readLine("Bitte Beschreibung eingeben");
		double price = IOTools.readDouble("Bitte Preis eingeben");

		return new Product(name, description, price);

	}

}
