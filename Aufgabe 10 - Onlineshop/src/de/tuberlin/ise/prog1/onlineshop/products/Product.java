
package de.tuberlin.ise.prog1.onlineshop.products;

import Prog1Tools.IOTools;

/**
 * This class implements a product
 * 
 * @author jacobeberhardt
 *
 */
public class Product {
	/**
	 * class variable as helper for Id generation
	 */
	private static int nextId = 0;
	
	/**
	 * id of the product
	 */
	private final int id;
	
	/**
	 * price of the product
	 */
	private final double price;

	/**
	 * Constructor for product. Id is automatically generated.
	 * @param name
	 * @param description
	 * @param price
	 */
	Product(double price) {
		id = nextId++;
		
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Product [id=" + id + " price=" + getPrice() + "€" + "]";
	}

	public static Product createProductFromUserinput() {
		System.out.println("Product creation:");
	
		double price = IOTools.readDouble("Enter the product's price in €: ");
		return new Product(price);
	}
}
