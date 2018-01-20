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
    static Portfolio portfolio = new Portfolio();
    static Stock[] stocks = new Stock[0];




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
            portfolio.addInvestment(new StockInvestment(stock, amount));
        } else {
            printErrorMessage(stockId);
        }
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
     * Updates the netAssetValue of a stock with the specified stocksId.
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
        System.out.printf("Stock %d was not found\n",stockId);
    }

    /**
     * prints all stock objects of the stocks array
     */
    public static void printStocks() {
        System.out.println("List of Stocks:");
        for (Stock stock : stocks) {
            System.out.printf("\t%s\n",stock);
        }
    }


    public static void addInvestment(Investment investment) {
        portfolio.addInvestment(investment);
    }

    public static void projectedEarningsPerYear() {
        System.out.println(portfolio.generateProjectedGrowth());
    }

    public static void printSortedReport() {
        System.out.println(portfolio.generateSortedReport());
    }
}
