package de.tuberlin.ise.prog1.investments;

import Prog1Tools.IOTools;

public class Stock {

	//unique id counter
    private static int nextId = 0x0;
    private final int id;
    private final String name;
    private static double currentPrice;

    public Stock(double currentPrice, String name) {
		id = nextId++;
    	this.currentPrice = currentPrice;
		this.name = name;
	}
    
    public String getName(){
    	return name;
    }
    
    public int getId(){
    	return id;
    }
    
    public static double getCurrentPrice(){
    	return currentPrice;
    }
    
    public double setCurrentPrice(){
    	return currentPrice;
    }
    
	public static Stock createStockDialog() {
		System.out.println("Stock ersstellen");
		String name = IOTools.readLine("Bitte Name eingeben: ");
		double currentPrice = IOTools.readDouble("Bitte Preis eingeben: ");
		return new Stock (currentPrice, name);   //why new?
	}
	
	public String toString(){
		return name + id + currentPrice;
	}
}
