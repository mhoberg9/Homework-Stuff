package de.tuberlin.ise.prog1.investments;

public class Investment{
	//unique id counter
	
	static int nextId = 0x0;

    private final int  id;

    public int getId() {
        return id;
    }
    public Investment() {
    	this.id = nextId++;
 
    }

    /**
     * Calculates the value of this investment by
     * multiplying the amount by the current value of the brought stock
     * @return value of this investment
     */
    public double currentValue(){
    	System.out.println("Error");
        return 0;
    }

    /**
     * Calculates the differences between 
     * the current value of this investment and the initial value of this investment
     * @return
     */
    public double absolutPriceDelta(){
    	System.out.println("Error");
        return 0;
    }
    
}

