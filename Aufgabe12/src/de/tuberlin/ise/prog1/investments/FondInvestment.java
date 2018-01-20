package de.tuberlin.ise.prog1.investments;


/**
 * This calls stores a set of bought shares
 */
public class FondInvestment extends Investment{
	
	//all stocks that are managed in this fond
    private final Share[]   shareArray;
    
    //the original price of this fond
    private final double price;
    
    /**
     * Creates a FondInvestment using a stocks-Array and price
     * @param price
     * @param stocks
     * @return 
     */
    
    public FondInvestment(Share...shares){
    	this.shareArray=shares;
    	double sum = 0;
    	for (Share share1 : shares){
    		sum += share1.currentValue();
    	}
    	this.price = sum;
    }
    
    public FondInvestment(double price, Share ... shares) {
		super();
    	this.price = price;
    	this.shareArray = shares;
	}
    
    /**
     * Calculates the value of this investment by
     * multiplying the amount by the current value of the brought stock
     * @return value of this investment
     */
    
    @Override
    public double netAssetValue(){
        double value = 0;
        for(Share s:shareArray){
        	value+=s.getStock().getCurrentPrice();
        }
        return value;
    }
    
    /**
     * Gewinnentwicklung
     */
    public double projectedEarningPerYear(){
    	return netAssetValue();
    }

    /**
     * Calculates the differences between 
     * the current value of this investment and the initial value of this investment
     * @return
     */
    
    public double absolutPriceDelta(){
        return price - netAssetValue();
    }

	@Override
	public String toString() {
		return "FondInvestment [id=" + getId() + " consisting of " + shareArray.length + ", bought at a price of:" + price
				+ " with a value of:" +  netAssetValue() + "]";
	}

   
}
