package de.tuberlin.ise.prog1.model;

public abstract class Investment extends MarketItem implements Sortable  {
	
    
    public Investment() {
    	//this.id = nextId++;
    }

    /**
     * Calculates the value of this investment
     * @return value of this investment
     */
    public abstract double netAssetValue();

    /**
     * Calculates the differences between 
     * the current value of this investment and the initial value of this investment
     * @return absolutePriceDelta
     */
    public abstract double absolutePriceDelta();


    /**
     * Calculates the value increas that is expected within a year,
     * can be the same as netAssetValue if the investment dose not payout any profits
     * @return projectedEarningsPerYear
     */
    public abstract double projectedEarningsPerYear();

    /**
     * This method uses netAssetValue to compare investments and
     * absolutePriceDelta in case the netAssetValue are equal.
     * @param l left instance of the investment object
     * @param r right instance of the investment object
     * @return the comparison result
     */
    @Override
    public int compareTo(Investment l,Investment r){
        //einige der bedinungen sind eigentlich ueberfluessing,
        //aber machen den code hier verständlicher
        if(r == null && l == null) {
            return 0;
        } else if(l == null && r != null) {
            return -1;
        } else if(l != null && r == null) {
            return 1;
        } else { //r != null && l != null
            double lvalue = l.netAssetValue();
            double rvalue = r.netAssetValue();
            int cmp = Double.compare(lvalue,rvalue);
            if(cmp != 0){
                return cmp;
            } else {
                double ldelta = l.absolutePriceDelta();
                double rdelta = r.absolutePriceDelta();

                return Double.compare(ldelta,rdelta);
            }
        }

    }


    @Override
    public int compareTo(Investment r) {
        return compareTo(this,r);
    }
}
