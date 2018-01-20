package de.tuberlin.ise.prog1.cli;

import Prog1Tools.IOTools;
import de.tuberlin.ise.prog1.investment.InvestmentManager;
import de.tuberlin.ise.prog1.model.*;

/**
 * CLI Interface for Investment Manager
 * @author Sebastian Werner
 *
 */
public class Starter {


 
    private static final String HELP_TEXT =  
    						"You can use the following Command:\n" +
                            Command.toHelpString()+
                            "Enter Command Id:";

	/**
     * the command loop (switch case)
     */
    private static boolean commandLoopDialogue(){
        Command command = Command.fromOrdinal(IOTools.readInt());
        System.out.println("Running Command - "+command);
        switch (command) {
            case EXIT:
                return true;
            case ADD_STOCK:
                InvestmentManager.registerStocks(createStockDialog());
                break;
            case BUY_STOCK:
                buyStockDialogue();
                break;
            case CREATE_FOND:
                createNewFondInvestment();
                break;
            case CREATE_PROPERTY:
                createNewPropertyInvestment();
            case SHOW_PORTFOLIO:
                InvestmentManager.printPortfolio();
                break;
            case BUY_INVESTMENT:
                buyInvestmentDialog();
            case SHOW_MARKET:
                InvestmentManager.printMarket();
                break;
            case UPDATE_STOCK_VALUE:
                updateStockValueDialogue();
                break;
            case SELL:
                sellInvestmentDialog();
                break;

            default:
                System.out.println("You Entered an unknown command, try again.");

        }
        return false;
    }

    private static void sellInvestmentDialog() {
        System.out.println("What Investment do you want to sell?\nSelecting Investment number the following List:");
        InvestmentManager.printPortfolio();
        int id = IOTools.readInt(">");
        InvestmentManager.sell(id);
    }


    // Ab hier bitte nichts verändern

    public static void main(String[] args) {
        readDatabaseFromFile("stocks.txt");
        //StockUpdater updater = new StockUpdater();
      //  updater.start();
        boolean exit = false;
        do {
            System.out.print(HELP_TEXT);
            try {
                exit = commandLoopDialogue();
                System.out.println();
            } catch (Exception e){
                System.out.println("Es ist ein Fehler aufgetreten :(\n Probiere es nochmal.");
                e.printStackTrace();
            }
        } while (!exit);
      //  updater.stop();
    }

    private static void createNewPropertyInvestment() {
        System.out.println("You are now creating a new PropertyInvestment...");

        String name = IOTools.readLine("Enter the Address or Name of the Property?:\n");
        double value = IOTools.readDouble("Enter the market value of "+name+":\n");
        double intereset = IOTools.readDouble("Enter the interest:\n");


        PropertyInvestment investment = new PropertyInvestment(name,value,intereset);
        System.out.println("The following investment was created:\n"+investment+"\n");
        InvestmentManager.registerInvestment(investment);
    }

    /**
     * CLI-Method to create and Buy a  new fond Investment
     */
    private static void createNewFondInvestment() {
        System.out.println("You are now creating a new FondInvestment ...");
        int fondSize = IOTools.readInt("Enter the number of different stocks, that this fond is made of:");
        Share[] shares = new Share[fondSize];
        for (int i = 0; i < shares.length; i++) {
            System.out.println("Selecting Share number #"+i+"\nSelect a Stock form the following List:");
            Stock s = null;
            while(s == null){
                InvestmentManager.printMarket();
                int id = IOTools.readInt("Enter Stock Id:");
                s = InvestmentManager.findStockById(id);

                if(s == null){
                    System.out.println("Wrong selection, try again!");
                }
            }
            float amount = IOTools.readFloat("How many Shares do you want to by of "+s.getName()+" ?");
            shares[i] = new Share(s,amount);
        }
        FondInvestment investment = new FondInvestment(shares);
        System.out.println("The following investment was created:\n"+investment+"\n");
        InvestmentManager.registerInvestment(investment);
    }

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

    /**
     * dialog to use the updateStockValue function in cli mode
     */
    private static void updateStockValueDialogue() {
        System.out.println("Updating stock value:\n");
        InvestmentManager.printMarket();
        int id = IOTools.readInt("Enter Stock Id of the Stock that you want to update:");
        double nValue = IOTools.readDouble("Enter new value for this stock:");
        InvestmentManager.updateStockValue(id, nValue);
        System.out.println("Value of stock with id:"+id+" was updated.\n");
    }

    /**
     * dialog to use the buyStock function in cli mode
     */
    private static void buyStockDialogue() {
        System.out.println("Buy a Stock:");
        InvestmentManager.printMarket();

        int stockID = IOTools.readInt("Enter Stock Id of the Stock you want to buy:");
        int amount = IOTools.readInt("How many shares do you want to buy of this Stock?:");

        InvestmentManager.buyStock(stockID,amount);
        System.out.println("\n");
    }

    private static void buyInvestmentDialog() {
        System.out.println("Buy A Investment:");
        InvestmentManager.printMarket();

        int id = IOTools.readInt("Enter Id of the Investment you want to buy:");
        InvestmentManager.buyInvestment(id);
        System.out.println("\n");

    }

    /**
     * This Method reads differnt objects from a text file and stores them in the {@link InvestmentManager}
     * @param path
     */
	private static void readDatabaseFromFile(String path) {
		DatabaseReader.read(path);
	}
}
