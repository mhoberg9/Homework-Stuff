package de.tuberlin.ise.prog1.investments;

public class StockInvestment extends Investment {
	// unique id counter

	private final Stock stock;
	private final int amount;
	private final double stockBuyPrice;

	/**
	 * Constructor
	 * 
	 * @param stock
	 * @param amount
	 */
	public StockInvestment(Stock stock, int amount) {
		this.stock = stock;
		this.amount = amount;
		this.stockBuyPrice = stock.getCurrentPrice();
	}

	/**
	 * Getterts&Setters
	 * @return
	 */
	
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
	 * Calculates the value of this investment by multiplying the amount by the
	 * current value of the brought stock
	 * 
	 * @return value of this investment
	 */
	public double currentValue() {
		return stock.getCurrentPrice() * amount;
	}

	/**
	 * Calculates the differences between the current value of this investment
	 * and the initial value of this investment
	 * 
	 * @return
	 */
	public double absolutPriceDelta() {
		return currentValue() - amount * stockBuyPrice;
	}

	/**
	 * toString-Methode
	 */
	@Override
	public String toString() {
		return "StockInvestment [id=" + getId() + ", getAmount()=" + getAmount() + ", currentValue()=" + currentValue()
				+ ", absolutPriceDelta()=" + absolutPriceDelta() + "]";
	}

}
