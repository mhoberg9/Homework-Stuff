package de.tuberlin.ise.prog1.investments;

import Prog1Tools.IOTools;

/**
 * The following instances represent a stock. It contains a constructor, a toString method and a method to create a new stock.
 * @author maltehoberg
 *
 */

public class Stock {

	//unique id counter
    private static int nextId = 0x0;
    
    private final int id;
    private final String name;
    private double currentPrice;

    
    /**
     * Constructor 
     * @param currentPrice
     * @param name
     */
    
    public Stock(double currentPrice, String name) {
    	id = nextId++;
    	this.currentPrice = currentPrice;
		this.name = name;
	}
    
    /**
     * Getters & Setters
     * @return
     */
    
	public double getCurrentPrice() {
		return currentPrice;
	}


	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}


	public static int getNextId() {
		return nextId;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	/**
	 * Method to create a new Stock. It gets the name, price and returns a new stock.
	 */

	public static Stock createStockDialog() {
		String name = IOTools.readLine("Name eingeben: ");
		double currentPrice = IOTools.readDouble("Preis eingeben: ");
		return new Stock(currentPrice, name);
	}
	
	/**
	 * to-String method
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public String toString(){
		return "Name: " + name +" ID: " + id + " CurrentPrice: " +currentPrice;
	}
  
}
