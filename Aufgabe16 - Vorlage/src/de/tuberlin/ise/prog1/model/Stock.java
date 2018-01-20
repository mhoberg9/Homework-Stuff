package de.tuberlin.ise.prog1.model;

/**
 * This class represents a Stock
 */
public class Stock extends MarketItem {

    //name of the stock
    private final String name;
    //current price of the stock
    private double currentPrice;

    /**
     * creates a new stock object using currentPrice and name,
     * the id is generated.
     * @param currentPrice starting price of the stock
     * @param name name of the stock
     */
    public Stock(double currentPrice, String name) {
        this.currentPrice = currentPrice;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return String.format("Stock{id=%d, name=%s, price=%.2f",id,name,getCurrentPrice());
    }

}
