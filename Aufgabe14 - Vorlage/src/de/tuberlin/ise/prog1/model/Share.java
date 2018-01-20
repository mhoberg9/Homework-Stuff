package de.tuberlin.ise.prog1.model;

/**
 * This class represents a number of bought Stocks.
 */
public class Share {
    //Stock reference
    private final Stock stock;
    //amount of Stocks
    private final float amount;

    /**
     * Creates a new Share out of a Stock and the amount
     * @param stock
     * @param amount
     */
    public Share(Stock stock, float amount) {
        this.stock = stock;
        this.amount = amount;
    }

    public Stock getStock() {
        return stock;
    }

    public float getAmount() {
        return amount;
    }

    /**
     * calculates the value of this Share by multipoint th currentPrice( of the Stcok and the amount.
     * @return the value of this Share
     */
    public double currentValue(){
        return stock.getCurrentPrice()*amount;
    }

    @Override
    public String toString() {
        return "Share[Stock:"+stock.getName()+", Amount:"+amount+"]";
    }
}
