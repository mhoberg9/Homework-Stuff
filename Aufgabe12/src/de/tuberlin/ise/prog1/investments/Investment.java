package de.tuberlin.ise.prog1.investments;

public abstract class Investment{
	//unique id counter
    static int nextId = 0;
    //unique identifier of this investments
    private final int  id;

    public int getId() {
        return id;
    }
    
    /**
     * default constructor, generates unique id and stores it in the id propertie.
     */
    public Investment() {
    	this.id = nextId++;
    }

    /**
     * Calculates the value of this investment
     * @return value of this investment
     */
   public abstract double netAssetValue();

    /**
     * Calculates the differences between 
     * the current value of this investment and the initial value of this investment
     * @return
     */
    public abstract double absolutPriceDelta();
    
    public abstract double projectedEarningPerYear();
    
   
}
