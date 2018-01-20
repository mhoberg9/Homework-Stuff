package de.tuberlin.ise.prog1.investments;

/**
 * This calls stores a set of bought shares
 */
public class FondInvestment extends Investment{

    //all shares that are collected in this fond
    private final Share[]   shares;
    //the original price of this fond
    private final double     price;

    /**
     * Creates a FondInvestment using a Share-Array
     *
     * Sets the price of the investment by summing the .currentValue of each Share.
     * @param shares
     */
    public FondInvestment(Share ... shares) {
        double price = 0;
        if(shares == null){
        	this.shares = new Share[0];
        } else {
	        for (Share share : shares) {
	            price+=share.currentValue();
	        }
        
        	this.shares = shares;
        }
        this.price = price;
    }


    /**
     * Creates a FondInvestment using a Share-Array and price
     * @param price
     * @param shares
     */
    public FondInvestment(double price, Share ... shares) {
    	this.price = price;
    	if(shares == null){
        	this.shares = new Share[0];
        } else {
	        this.shares = shares;
        }
	}
    
    /**
     * Calculates the value of this investment by
     * multiplying the amount by the current value of the brought stock
     * @return value of this investment
     */
    @Override
    public double netAssetValue(){
        double value = 0;
        for(Share s:shares){
        	value+=s.currentValue();
        }
        return value;
    }

    /**
     * Calculates the differences between 
     * the current value of this investment and the initial value of this investment
     * @return
     */
    @Override
    public double absolutePriceDelta(){
        return netAssetValue() - price;
    }

	@Override
	public String toString() {
		return "FondInvestment [id=" + getId() + "consisting of "+shares.length+" shares, bought at a price of: "+price+" with a value of:"+netAssetValue()+"]";
	}

    /**
     * Since the change in price of the stocks cannot be predicted we assume that the value stays constant.
     * @return
     */
    @Override
    public double projectedEarningsPerYear() {
        return netAssetValue();
    }

   
}
