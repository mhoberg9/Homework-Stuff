package de.tuberlin.ise.prog1.model;

/**
 * This class represents a invested stock.
 * It also is used to track the stock development of the stock price.
 */
public class StockInvestment extends Investment{

    //represents the number of stock that was bought
    private final Share share;
    //represents the price of the shares at the time they were bought
    private final double stockBuyPrice;

    /**
     * creates a new StockInvestment by creating a new Share object
     *
     * the stockBuyPrice is calcuated using the @{@link Share#currentValue()}-Methode
     *
     * @param stock - Stock object that was bought
     * @param amount - amount of stocks that was bought
     */
    public StockInvestment( Stock stock, int amount) {
    	super();
        this.share = new Share(stock,amount);
        this.stockBuyPrice = share.currentValue();
    }

    public Stock getStock() {
        return share.getStock();
    }


    public int getAmount() {
        return Math.round(share.getAmount());
    }



    public double getStockBuyPrice() {
        return stockBuyPrice;
    }

    /**
     * Calculates the value of this investment by
     * multiplying the amount by the current value of the brought stock
     * @return value of this investment
     */
    @Override
    public double netAssetValue(){
        return share.currentValue();
    }

    /**
     * Calculates the differences between 
     * the current value of this investment and the initial value of this investment
     * @return
     */
    @Override
    public double absolutePriceDelta(){
        return netAssetValue() - stockBuyPrice;
    }

    /**
     * Since the change in price of the stock cannot be predicted we assume that the value stays constant.
     * @return
     */
    @Override
    public double projectedEarningsPerYear() {
        return netAssetValue();
    }

    @Override
	public String toString() {
		return "StockInvestment [id=" +
                getId() +", of:"+
                share +
                String.format(", valued at: %.2f, bought at:%.2f",netAssetValue(),stockBuyPrice);

	}

   
}
