package de.tuberlin.ise.prog1.investments;

import Prog1Tools.IOTools;

/**
 * This class represents a Stock
 */
public class Stock {

	/**
	 * method to create a Stock object in cli mode
	 * @return
	 */
    public static Stock createStockDialog() {
        System.out.println("Enter Stock name:");
        String name = IOTools.readLine();

        System.out.println("Enter Stock price:");
        double price = IOTools.readDouble();

        Stock stock =  new Stock(price,name);
        System.out.println("The following Stock has been created:\n"+stock+"\n");
        return stock;
    }

    //unique id counter
    private static int nextId = 0x0;

    //id field to make stocks findable
    private final int id;
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
    Stock(double currentPrice, String name) {
        this.id = nextId++;
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
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + currentPrice +
                '}';
    }
}
