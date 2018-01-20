package de.tuberlin.ise.prog1.investments;

import java.util.Date;

/**
 * Investment Management Class, 
 * used to store stock and investment objects at runtime,
 * offers utility functions for adding, updating and printing
 * 
 * @author Sebastian Werner & Malte Hoberg
 *
 */
public class InvestmentManager {

    static Stock[] stocks = new Stock[0];
    static Investment[] investments = new Investment[0];

    
    /**
     * This methods creates a new Investment object and adds it to the investments array.
     * The Investment object will consist of a stock with the specified id and the amount.
     * The stock must be present within the stocks array. 
     * A error message will be displayed, should the stock not be present.
     * 
     * @param stockId
     * @param amount
     */
    public static void buyStock(int stockId, int amount){
    	Stock id = findStockById(stockId);
    	addInvestment(new Investment(id, amount));
    }
   
    
    /**
     * searches the stocks array for a given id
     * @param id
     * @return
     */
    public static Stock findStockById(int id) {
        for (int i = 0; i < stocks.length; i++){
        	if (stocks[i].getId()==id){
        		return stocks[i];
        	}
        }
    	return null;
    }
    
 // Ab hier bitte nichts verändern
    
    /**
     * adds a set of stocks to the stocks array
     * @param stocks
     */
    public static void registerStocks(Stock ... stocks){
    	
    	if(stocks == null || stocks.length < 0){
    		return;
    	}
    	
    	Stock[] mergedStockArray = new Stock[InvestmentManager.stocks.length+ stocks.length];
    	for (int i = 0; i < InvestmentManager.stocks.length; i++) {
			//kopieren der alten Werte
    		mergedStockArray[i] = InvestmentManager.stocks[i];
		}
    	for (int i = 0; i < stocks.length; i++) {
			//kopieren der neuen Werte
    		mergedStockArray[i+InvestmentManager.stocks.length] = stocks[i];
		}
    	InvestmentManager.stocks = mergedStockArray;
    }


    /**
     * adds a  investment to the investments array
     * @param investment
     */
    public static void addInvestment(Investment investment) {
    	Investment[] mergedInvestmetns = new Investment[InvestmentManager.investments.length + 1];
    	for (int i = 0; i < InvestmentManager.investments.length; i++) {
			//kopieren der alten Werte
    		mergedInvestmetns[i] = InvestmentManager.investments[i];
		}
    	//speichern des neuen Elements
    	mergedInvestmetns[InvestmentManager.investments.length] = investment;
    	InvestmentManager.investments = mergedInvestmetns;
	}
    
    /**
     * Updates the currentValue of a stock with the specified stocksId.
     * The stock must be present within the stocks array. 
     * A error message will be displayed, should the stock not be present.
     * @param stockId
     * @param value
     */
    public static void updateStockValue(int stockId,double value){
        Stock stock = findStockById(stockId);
        if (stock != null) {
            stock.setCurrentPrice(value);
        } else {
            printErrorMessage(stockId);
        }
    }



    /**
     * prints an error message with the given stockId
     * @param stockId
     */
    private static void printErrorMessage(int stockId) {
        System.out.printf("Stock %d nicht gefunden",stockId);
    }

    /**
     * prints all stock objects of the stocks array
     */
    public static void printStocks() {
        for (Stock stock : stocks) {
            System.out.println(stock.toString());
        }
    }

    /**
     * Prints all the investment objects of the investments array. 
     * It also calculates and prints the total currentValue of all investments
     */
    public static void printPortfolio(){
        System.out.println("Portfolio Report: "+(new Date()));
        double totalValue = 0.0;
        for (Investment investment : investments) {
            System.out.println(investment.toString());
            totalValue+=investment.currentValue(); 
        }
        System.out.printf("Total Value:%.2f\n",totalValue);

    }

}
