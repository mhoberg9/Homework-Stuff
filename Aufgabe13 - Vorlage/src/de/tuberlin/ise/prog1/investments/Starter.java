package de.tuberlin.ise.prog1.investments;
import Prog1Tools.IOTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * CLI Interface for Investment Manager
 * @author Sebastian Werner
 * @author maltehoberg
 *
 */
public class Starter {


 
    private static final String HELP_TEXT = Command.toHelpString();
    
    						/** "You can use the following Command:\n" +
							Command.ADD_STOCK.ordinal()+" - Add Stock\n" +
                            Command.BUY_STOCK.ordinal() + " - Buy Stock\n" +
    						Command.CREATE_FOND.ordinal() +" - Create And Buy a Fond\n" +
                            Command.SHOW_PORTFOLIO.ordinal() + " - show portfolio\n" +
                            Command. + " - show list of Stocks\n" +
                            Command.UPDATE_STOCK_VALUE.ordinal() + " - update Stock value\n" +
                            Menuenum.SORTED_STOCK.ordinal() + " - Show Sorted Portfolio\n"+
                            Menuenum.EXIT.ordinal() + " - exit\n" +
                            "Enter Command: ";
                            */

	/**
     * the command loop (switch case)
     */
    private static boolean commandLoopDialogue(){
    	Command menuOption = Command.formOrdinal(IOTools.readInt());
    	//int command = IOTools.readInt();
        System.out.println("Running Command - "+ menuOption);
        switch (menuOption) {
            case ADD_STOCK:
                InvestmentManager.registerStocks(Stock.createStockDialogue());
                break;
            case BUY_STOCK:
                buyStockDialogue();
                break;
            case CREATE_FOND:
                buyAndCreateNewFondInvestment();
                break;
            case CREATE_PROPERTY:
            	buyAndCreateNewPropertyInvestment();
            	break;
            case SHOW_PORTFOLIO:
                InvestmentManager.projectedEarningsPerYear();
                break;
            case SHOW_STOCKS:
                InvestmentManager.printStocks();
                break;
            case SHOW_SORTED_PORTFOLIO:
            	InvestmentManager.printSortedReport();
            	break;
            case UPDATE_STOCK_VALUE:
                updateStockValueDialogue();
                break;
            case EXIT:
            	return true;
		default:
			break;

        }
        return false;
    }

    // Ab hier bitte nichts verändern

    public static void main(String[] args) {
        readDatabaseFromFile("stocks.txt");


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

    }

    private static void buyAndCreateNewPropertyInvestment() {
        System.out.println("You are now creating a new PropertyInvestment to buy...");

        String name = IOTools.readLine("Enter the Address or Name of the Property?:\n");
        double value = IOTools.readDouble("Enter the market value of "+name+":\n");
        double intereset = IOTools.readDouble("Enter the interest:\n");


        PropertyInvestment investment = new PropertyInvestment(name,value,intereset);
        System.out.println("The following investment was created:\n"+investment+"\n");
        InvestmentManager.addInvestment(investment);
    }

    /**
     * CLI-Method to create and Buy a  new fond Investment
     */
    private static void buyAndCreateNewFondInvestment() {
        System.out.println("You are now creating a new FondInvestment to buy...");
        int fondSize = IOTools.readInt("Enter the number of different stocks, that this fond is made of:");
        Share[] shares = new Share[fondSize];
        for (int i = 0; i < shares.length; i++) {
            System.out.println("Selecting Share number #"+i+"\nSelect a Stock form the following List:");
            Stock s = null;
            while(s == null){
                InvestmentManager.printStocks();
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
        InvestmentManager.addInvestment(investment);
    }



    /**
     * dialog to use the updateStockValue function in cli mode
     */
    private static void updateStockValueDialogue() {
        System.out.println("Updating stock value:\n");
        InvestmentManager.printStocks();
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
        InvestmentManager.printStocks();

        int stockID = IOTools.readInt("Enter Stock Id of the Stock you want to buy:");
        int amount = IOTools.readInt("How many shares do you want to buy of this Stock?:");

        InvestmentManager.buyStock(stockID,amount);
        System.out.println("\n");
    }

    /**
     * This Method reads differnt objects from a text file and stores them in the {@link InvestmentManager}
     * @param path
     */
	private static void readDatabaseFromFile(String path) {
		File databaseFile = new File(path);
		if(databaseFile.exists()){
			//reading the file
			try(BufferedReader r = new BufferedReader(new FileReader(databaseFile))){
				String line;
				//reading each line
				while((line = r.readLine()) != null){
                    String[] fileds = line.split(";");
                    //parsing the line
					switch (fileds[0]){
                        case "ST": //stock prefix
                            //check if syntax fits
                            if(fileds.length < 3){
                                continue;
                            }
                            // create stock (if possible)
                            Stock stock = new Stock(Double.parseDouble(fileds[2]), fileds[1]);
                            InvestmentManager.registerStocks(stock);
                            break;
                        case "PI": //PropertyInvestment prefix
                            //check if syntax
                            if(fileds.length < 5){
                                continue;
                            }

                            String name = fileds[4];
                            long buyDate = Long.parseLong(fileds[3]);
                            double value = Double.parseDouble(fileds[1]);
                            double interest = Double.parseDouble(fileds[2]);
                            InvestmentManager.addInvestment(new PropertyInvestment(name,value,interest,buyDate));
                            break;
					}
				}
			} catch (Exception ignored) {}
			
		}
	}
}
