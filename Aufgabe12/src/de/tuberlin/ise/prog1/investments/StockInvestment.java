package de.tuberlin.ise.prog1.investments;
/**
 * This class represents a invested stock.
 * It also is used to track the stock development of the stock price.
 */
public  class StockInvestment extends Investment{
	//reference to the stock that war bought
    private final Share   share;

    //represents the number of stock that was bought
    private final float    amount;
  //represents the price of the shares at the time they were bought
    private final double stockBuyPrice;

    /**
     * creates a new StockInvestment
     * @param amount 
     *
     * @param stock - Stock object that was bought
     * @param amount - amount of stocks that was bought
     */
    public StockInvestment(Stock stock, int amount) {
    	super();
        share= new Share (stock, amount);
        this.amount = share.getAmount();
        this.stockBuyPrice = share.getStock().getCurrentPrice();
    }
    /**
     * Calculates the value of this investment by
     * multiplying the amount by the current value of the brought stock
     * @return value of this investment
     */
    @Override
    public double netAssetValue(){
        return share.getStock().getCurrentPrice() *amount;
    }

    /**
     * Gewinnentwicklung
     */
    public  double projectedEarningPerYear(){
    	return netAssetValue();
    }
    

    /**
     * Calculates the differences between 
     * the current value of this investment and the initial value of this investment
     * @return
     */
    public double absolutPriceDelta(){
        return netAssetValue() - amount* stockBuyPrice;
    }
/**
 * toString
 */
    
	@Override
	public String toString() {
		return "StockInvestment [id=" + getId() + ", of:Share [Stock:" + share.getStock().getName() +", Amount: " + share.getAmount() + ", valued at: " + netAssetValue()
				+ ", bought at: " + stockBuyPrice+ "]";
	}
	
   
}
