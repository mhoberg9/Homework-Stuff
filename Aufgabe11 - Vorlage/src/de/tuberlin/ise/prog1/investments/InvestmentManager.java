package de.tuberlin.ise.prog1.investments;
import java.util.Date;

/**
 * Investment Management Class, 
 * used to store stock and investment objects at runtime,
 * offers utility functions for adding, updating and printing
 * 
 * @author Sebastian Werner
 *
 */
public class InvestmentManager {

    static Stock[] stocks = new Stock[0];
    static Investment[] investments = new Investment[0];

    /**
     * adds a set of stocks to the stocks array
     * @param stocks
     */
    public static void registerStocks(Stock ... stocks){
        Stock[] nStocks = new Stock[stocks.length+InvestmentManager.stocks.length];
        System.arraycopy(InvestmentManager.stocks,0,nStocks,0,InvestmentManager.stocks.length);
        System.arraycopy(stocks,0,nStocks,InvestmentManager.stocks.length,stocks.length);
        InvestmentManager.stocks = nStocks;
    }
    
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
        Stock stock = findStockById(stockId);
        if(stock != null) {
        	addInvestmet(new StockInvestment(stock, amount));
        } else {
            printErrorMessage(stockId);
        }
    }
        
    /**
     * 
     * Buyfond methode
     * @param price
     * @param fonds
     */
    
     public static void buyFond(int price, int... fonds){
           Stock [] stock = new Stock[fonds.length];
            
            for (int i = 0; i < fonds.length; i++){
            	stock[i] = findStockById(fonds[i]);
            }	
            
            addInvestmet(new FondInvestment(price, stock));
    }
     
     
    
    /**
     * searches the stocks array for a given id
     * @param id
     * @return
     */
    public static Stock findStockById(int id) {
        for (Stock stock : stocks) {
            if(stock.getId() == id){
                return stock;
            }
        }
        return null;
    }

    /**
     * Inserts a new element in the investments-Array
     * @param investment
     */
    public static void addInvestmet(Investment investment){
    	Investment[] nInvestments = new Investment[investments.length + 1];
        System.arraycopy(InvestmentManager.investments, 0, nInvestments, 0, InvestmentManager.investments.length);
        nInvestments[investments.length] = investment;
        investments = nInvestments;
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
            System.out.println(stock);
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
            System.out.println(investment);
            totalValue+=investment.currentValue();
        }
        System.out.printf("Total Value:%.2f\n",totalValue);
    }
}
