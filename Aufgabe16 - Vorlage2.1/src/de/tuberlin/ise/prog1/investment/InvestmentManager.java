package de.tuberlin.ise.prog1.investment;

import de.tuberlin.ise.prog1.data.TreeData;
import de.tuberlin.ise.prog1.model.Investment;
import de.tuberlin.ise.prog1.model.MarketItem;
import de.tuberlin.ise.prog1.model.Stock;
import de.tuberlin.ise.prog1.model.StockInvestment;

import java.util.ArrayList;

/**
 * Investment Management Class, 
 * used to store stock and investment objects at runtime,
 * offers utility functions for adding, updating and printing
 * 
 * @author Sebastian Werner
 *
 */
public class InvestmentManager {
    private static Portfolio portfolio = new Portfolio();

    static MarketItem[] market = new MarketItem[0];

    /**
     * adds a set of stocks to the stocks array
     * @param stocks
     */
    public static void registerStocks(Stock... stocks){
    	MarketItem[] nMarket = new MarketItem[stocks.length+InvestmentManager.market.length];
        System.arraycopy(InvestmentManager.market,0,nMarket,0,InvestmentManager.market.length);
        System.arraycopy(stocks,0,nMarket,InvestmentManager.market.length,stocks.length);
        InvestmentManager.market = nMarket;
    }

    public static void registerInvestment(Investment investment) {
    	MarketItem[] nMarket = new MarketItem[1+InvestmentManager.market.length];
        System.arraycopy(InvestmentManager.market,0,nMarket,0,InvestmentManager.market.length);
        nMarket[market.length] = investment;
        InvestmentManager.market = nMarket;
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
            portfolio.buyInvestment(new StockInvestment(stock, amount));
        } else {
            printErrorMessage(stockId);
        }
    }

    public static void buyInvestment(int id){
        Investment investment = findInvestmentById(id);
        if(investment != null) {
            portfolio.buyInvestment(investment);
        } else {
            printErrorMessage(id);
        }
    }
    
    private static MarketItem findById(int id){
    	for(MarketItem item:market){
    		if(item.getId() == id){
    			return item;
    		}
    	}
    	return null;
    }
    
    private static Investment findInvestmentById(int id) {
        MarketItem data = findById(id);
        if (data != null && data instanceof Investment) {
            return (Investment) data;
        } else {
            return null;
        }
    }

    /**
     * searches the stocks array for a given id
     * @param id
     * @return
     */
    public static Stock findStockById(int id) {
    	MarketItem data = findById(id);
        if (data != null && data instanceof Stock) {
            return (Stock) data;
        } else {
            return null;
        }
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
        System.out.printf("Element %d was not found\n",stockId);
    }

    /**
     * prints all stock objects of the stocks array
     */
    public static void printMarket() {
        for (MarketItem marketDatum : market) {
            System.out.println(marketDatum);
        }
    }

    public static void printPortfolio() {
        System.out.println(portfolio.generateSortedReport());
    }

    public static ArrayList<Stock> getStockList() {
        TreeData[] marketData = market;
        ArrayList<Stock> stocks = new ArrayList<>();
        for (TreeData marketDatum : marketData) {
            if(marketDatum instanceof Stock){
                stocks.add((Stock) marketDatum);
            }
        }
        return stocks;
    }

    public static void sell(int id) {
        Investment investment = portfolio.sell(id);
        if(investment != null){
            System.out.printf("The investment %s was sold at a win/loss of: %.2f\n",investment,investment.absolutePriceDelta());
        } else {
            System.out.println("Investment could not be found");
        }
    }
}
