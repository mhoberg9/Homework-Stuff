package de.tuberlin.ise.prog1.investments;

public class FondInvestment extends Investment {

	private final Stock[] stockArray;
	private final double price;

	/**
	 * Constructor
	 * @param price
	 * @param stocks
	 */
	public FondInvestment(double price, Stock... stocks) {
		this.price = price;
		this.stockArray = stocks;

	}

	public Stock[] getStockArray() {
		return stockArray;
	}

	public double getPrice() {
		return price;
	}

	/**
	 * currentValue-Method
	 */
	@Override
	public double currentValue() {
		double sum = 0;
		for (int i = 0; i < stockArray.length; i++) {
			sum += stockArray[i].getCurrentPrice();
		}
		return sum;
	}

	/*
	 * absolutPriceDelta
	 * (non-Javadoc)
	 * @see de.tuberlin.ise.prog1.investments.Investment#absolutPriceDelta()
	 */
	
	@Override
	public double absolutPriceDelta() {
		return price - currentValue();
	}

	/**
	 * toString-Methode
	 */
	
	public String toString(){
		return "FondInvestment: CurrentValue: " + currentValue() + " ;AbsolutPriceDelta: " + absolutPriceDelta() + " ;ID: " + getId();
	}
}