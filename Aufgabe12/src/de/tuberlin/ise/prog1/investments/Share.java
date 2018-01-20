package de.tuberlin.ise.prog1.investments;
/**
 * this class functions as stock storage
 * @author maltehoberg
 *
 */

public class Share {
	Stock stock;
	float amount;
	
	/**
	 * Constructor
	 * @param stock
	 * @param amount
	 */
	
	Share(Stock stock, float amount){
		this.stock = stock;
		this.amount = amount;
	}
	
	/**
	 * Getters&Setters
	 * @return
	 */

	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * currentValue-Method
	 * @return
	 */
	
	public double currentValue(){
		return stock.getCurrentPrice() * amount;
	}
}
