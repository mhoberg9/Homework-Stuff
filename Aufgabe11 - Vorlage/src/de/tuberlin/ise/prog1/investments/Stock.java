package de.tuberlin.ise.prog1.investments;

import Prog1Tools.IOTools;

public class Stock {

	/**
	 * method to create a Stock object in cli mode
	 * @return
	 */
    public static Stock createStockDialog() {
        System.out.println("Name:");
        String name = IOTools.readLine();

        System.out.println("currentPrice:");
        double price = IOTools.readDouble();

        return new Stock(price,name);
    }

    //unique id counter
    private static int nextId = 0x0;
    
    private final int id;
    private final String name;
    private double currentPrice;

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
                ", currentPrice=" + currentPrice +
                '}';
    }
}
