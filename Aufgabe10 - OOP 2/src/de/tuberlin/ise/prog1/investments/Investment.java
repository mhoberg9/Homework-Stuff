package de.tuberlin.ise.prog1.investments;

/**
 * The following instances represent an investment.
 * It contains a constructor, a toString method as well as getters & setters.
 * @author maltehoberg
 *
 */

public class Investment {
	// unique id counter
	static int nextId = 0;

	private final int id;
	private final Stock stock;
	private final int amount;
	private double stockBuyPrice;
	
	/**
	 * Constructor
	 * @param stock
	 * @param amount
	 */
	
	Investment(Stock stock, int amount) {
		this.stock = stock;
		this.amount = amount;
		id = stock.getId();
		stockBuyPrice = stock.getCurrentPrice();
	}
	
	/**
	 * Getters & setters
	 * @return
	 */
	
	public double currentValue(){
		return amount * stockBuyPrice;
	
	}
	
	public double absolutPriceDelta(){
		return (stock.getCurrentPrice() - stockBuyPrice) * amount ;
	}
	

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Investment.nextId = nextId;
	}

	public int getId() {
		return id;
	}

	public Stock getStock() {
		return stock;
	}

	public int getAmount() {
		return amount;
	}

	public double getStockBuyPrice() {
		return stockBuyPrice;
	}

	/**
	 * toString-Method 
	 */
	
	public String toString(){
		return "Name: " + stock.getName() + " Amount: " +amount + " CurrentValue: " + currentValue() + " AbsolutPriceDelta: " + absolutPriceDelta();
	}
}
