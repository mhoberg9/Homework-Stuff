package de.tuberlin.ise.prog1.investments;

/**
 * The following instances represent the structure of a stock. It contains name, currentPrice and the ID.
 * The constructor in this class is not really necessary at the moment. With or without you only get memory addresses printed out.
 * @author Malte Hoberg
 * 11/11/2016
 **/

public class Stock {

	/**
	 * Attributes
	 **/
	
	//klassen oder instanz = final/public/static/
	public String name;
	public double currentPrice;
	public static int nextId = 0;
	public int id;

	/**
	 * constructor
	 **/
	
	Stock(String name, double currentPrice) {
		id = nextId++;
		this.name = name;
		this.currentPrice = currentPrice;

	}
	
	/**
	 *  getters & setters
	 **/

	public int getId() {
		return id;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public String name() {
		return name;
	}

}

