package de.tuberlin.ise.prog1.onlineshop.products;

import Prog1Tools.IOTools;


public class Television extends Product {

	/**
	 * This class represent Televisions. Televisions are stored with their information in warehouses.
	 * 
	 * @author Malte Hoberg
	 * created 25/11/2015
	 */
	
	//deklarierung der Variablen
	
	final String manufacturer;
	final int screensize;
	final boolean receiver;

	/**
	 *Constructor for a Television. 
	 *
	 * @param manufacturer
	 * @param screensize
	 * @param receiver
	 * @param price
	 */
	
	public Television(String manufacturer, int screensize, boolean receiver, double price) {
		super(price);
		this.manufacturer = manufacturer;
		this.screensize = screensize;
		this.receiver = receiver;

	}

	//Ausgabe eines Televisions mit allen Informationen
	@Override
	public String toString() {
		return "Television [manufacturer=" + manufacturer + ", screensize=" + screensize + ", receiver=" + receiver
				+ "Price: " + getPrice() + "]";
	}

	/**
	 * createTelevisionFromUserInput is used to generate a Television by user input
	 * @return
	 */
	
	public static Television createTelevisionFromUserInput() {
		String manufacturer = IOTools.readLine("Enter manufacturer: ");
		int screensize = IOTools.readInt("Enter screensize: ");
		boolean receiver = IOTools.readBoolean("Receiver included: ");
		double price = IOTools.readDouble("Enter price: ");

		return new Television(manufacturer, screensize, receiver, price);

	}

}
