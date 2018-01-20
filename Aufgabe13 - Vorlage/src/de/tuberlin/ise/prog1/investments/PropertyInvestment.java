package de.tuberlin.ise.prog1.investments;

import java.util.TimeZone;

/**
 * This investment stores properties with a fixed interest rate.
 */
public class PropertyInvestment extends Investment {

    private final String name;
    //value of this investment when it was purchased
    private final double value;
    //interest of this investment in percentile (0.01) = 1%
    private final double interest;

    //date of purchase
    private final long purchaseDate;

    /**
     * full constructor of PropertyInvestment sets all attributes
     * @param name
     * @param value
     * @param interest
     * @param purchaseDate
     */
    public PropertyInvestment(String name,double value, double interest, long purchaseDate) {
        super();
        this.name = name;
        this.value = value;
        this.interest = interest;
        this.purchaseDate = purchaseDate;
    }

    /**
     * sets all attributes with given vaules and uses currentTime for purchaseDate
     * @param name
     * @param value
     * @param interest
     */
    public PropertyInvestment(String name,double value, double interest) {
        this(name,value,interest,System.currentTimeMillis());
    }

    /**
     * calculates the years form a currentTimeMillis value
     * @param time
     * @return
     */
    private long yearsFromSystemTime(long time){
        //adjust for timeZones
        long localTime = time + TimeZone.getDefault().getOffset(time);
        //gets years since 1970
        long year = (localTime) / 1000 / 3600 / 24 / 366 + 1970;
        return year;
    }

    /**
     * calculates the difference between this year and the year stored in purchaseDate {@link #purchaseDate}
     * @return years since purchase
     */
    private long yearsSincePurchase(){
        long thisYear = yearsFromSystemTime(System.currentTimeMillis());
        long yearOfPurchae = yearsFromSystemTime(purchaseDate);

        return thisYear-yearOfPurchae;
    }


    /**
     * Berechnung von Zinseszins 
     * @return
     */
    
    private double interestofinterest(){
        double total=value;
        for (int i = 1; i<= yearsSincePurchase(); i++) {
            total=total*(1+interest);
        }
        return total;
    }

    @Override
    public double netAssetValue() {
        return interestofinterest();
    }

    @Override
    public double absolutePriceDelta() {
        return netAssetValue()-value;
    }

    @Override
    public double projectedEarningsPerYear() {
        return netAssetValue()*(1+interest);
    }

    @Override
    public String toString() {
        return String.format("PropertyInvestment [id=%d name=%s value~= %.2f delta=%.2f%%]",
                getId(),
                name,
                netAssetValue(),
                (absolutePriceDelta()*100/value));
    }
}
