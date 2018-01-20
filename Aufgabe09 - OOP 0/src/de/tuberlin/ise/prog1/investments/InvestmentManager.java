package de.tuberlin.ise.prog1.investments;



/**
 * Investment Management Class, 
 * used to store stock and investment objects at runtime,
 * offers utility functions for adding, updating and printing
 * 
 * @author Sebastian Werner
 *
 */
public class InvestmentManager {

    static Stock[] stocks1 = new Stock [0];
    static Investment[] investments1 = new Investment [0];

    /**
     * adds a set of stocks to the stocks array
     * @param stocks
     */
    public static void registerStocks(Stock ... stocks){
    	Stock [] stocks2 = new Stock [stocks.length + stocks1.length];
    	for (int helper = 0; helper < stocks1.length; helper++){
    		stocks2[helper] =  stocks1 [helper];
    	}
    	for (int helper = stocks1.length ; helper < stocks2.length; helper++){
    		stocks2[helper] = stocks[helper - stocks1.length];
    	}
    	stocks1 = stocks2;
    	
    }

    /**
     * adds a  investment to the investments array
     * @param investment
     */
    public static void addInvestment(Investment investment) {
    	Investment [] investments2 = new Investment [investments1.length +1];
    	for (int i = 0; i < investments1.length ; i++){
    		investments2[i] = investments1[i];
    		
    	}
    	investments2[investments1.length] = investment;
    	investments1 = investments2;
	}

    /**
     * prints all stock objects of the stocks array
     */
    public static void printStocks() {
        for (Stock stock : stocks1) {
            System.out.println(stock);
        }
    }
    
    /**
     * prints all stock objects of the stocks array
     */
    public static void printInvestments() {
        for (Investment investment : investments1) {
            System.out.println(investment);
        }
    }
}
