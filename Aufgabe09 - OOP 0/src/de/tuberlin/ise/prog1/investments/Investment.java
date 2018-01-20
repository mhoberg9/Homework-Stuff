package de.tuberlin.ise.prog1.investments;

/**
 * @author Malte Hoberg
 *  11/10/2016
 *  
 *  Instances of this class are showing the structure of an investment. An investment contains stock, amount, stockBuyPrice and ID.
 *  The here shown constructor is so far not necessary. With or without you only get memory addresses printed out.
 **/

public class Investment {

	/**
	 * attributes
	 **/
	
	public Stock stock;
	public int amount;
	public double stockBuyPrice;
	public int id;
	public static int nextId = 0;

	/**
	 * Constructor
	 **/
	
	public Investment(Stock stock, int amount, double stockBuyPrice) {
		id = nextId++; 
		this.amount = amount;
		this.stock = stock;
		this.stockBuyPrice = stockBuyPrice;

	}
	
	/**
	 * Getters & Setters
	 **/

	public int getAmount() {
		return amount;
	}

	public int getId() {
		return id;
	}

	public double getStockBuyPrice() {
		return stockBuyPrice;

	}
	public Stock getStock(){
		return stock;
	}
}