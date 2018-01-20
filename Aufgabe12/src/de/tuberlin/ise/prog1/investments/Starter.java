package de.tuberlin.ise.prog1.investments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Prog1Tools.IOTools;

/**
 * CLI Interface for Investment Manager
 * 
 * @author Sebastian Werner
 *
 */
public class Starter {
	private static void buyAndCreateNewFondInvestment() {
		System.out.println("You are now creating a new FondInvestment to buy...");

		int fondSize = IOTools.readInt("Enter the number of different stocks, that this fond is made of:");

		Share[] share = new Share[fondSize];
		for (int i = 0; i < share.length; i++) {
			System.out.println("Selecting Share number #" + i + "\nSelect a Stock form the following List:");

			Stock s = null;
			while (s == null) {
				InvestmentManager.printStocks();
				int id = IOTools.readInt("Enter Stock Id:");

				while (InvestmentManager.findStockById(id) == null) {
					System.out.println("Wrong selection, try again");
					InvestmentManager.printStocks();
					id = IOTools.readInt("Enter Stock Id:");

				}
				s = InvestmentManager.findStockById(id);
			}

			float amount = IOTools.readFloat("How many Shares do you want to buy of " + s.getName() + "?");
			share[i] = new Share(s, amount);

		}
		FondInvestment investment = new FondInvestment(share);
		System.out.println("The following investment was created:\n" + investment + "\n");
		InvestmentManager.addInvestmet(investment);
	}

	/**
	 * dialog to use the updateStockValue function in cli mode
	 */
	private static void updateStockValueDialog() {
		System.out.println("Updating stock value:\n");
		InvestmentManager.printStocks();
		int id = IOTools.readInt("Enter Stock Id of the Stock that you want to update:");
		double nValue = IOTools.readDouble("Enter new value for this stock:");
		InvestmentManager.updateStockValue(id, nValue);
		System.out.println("Value of stock with id:" + id + " was updated.\n");
	}

	/**
	 * dialog to use the buyStock function in cli mode
	 */
	private static void buyStockDialog() {
		System.out.println("Buy a Stock:");
		InvestmentManager.printStocks();

		int stockID = IOTools.readInt("Enter Stock Id of the Stock you want to buy:");
		int amount = IOTools.readInt("How many shares do you want to buy of this Stock?:");

		InvestmentManager.buyStock(stockID, amount);
		System.out.println("\n");
	}

	private static final String HELP_TEXT = "You can use the following Commands:\n" + "1 - Add Stock\n"
			+ "2 - Buy Stock\n" + "3 - Create And Buy a Fond\n" + "4 - show portfolio\n" + "5 - show list of Stocks\n"
			+ "6 - update Stock value\n" + "0 - exit\n" + "Enter Command Id:";

	public static void main(String[] args) {
		readDatabaseFromFile("stocks.txt");

		boolean exit = false;
		do {
			System.out.print(HELP_TEXT);
			try {
				exit = commandLoopDialog();
				System.out.println();
			} catch (Exception e) {
				System.out.println("Es ist ein Fehler aufgetreten :(\n Probiere es nochmal.");
				e.printStackTrace();
			}
		} while (!exit);

	}

	/**
	 * the command loop (switch case)
	 */
	private static boolean commandLoopDialog() {
		int command = IOTools.readInt();
		System.out.println("Running Command - " + command);
		switch (command) {
		case 0:
			return true;
		case 1:
			InvestmentManager.registerStocks(Stock.createStockDialog());
			break;
		case 2:
			buyStockDialog();
			break;
		case 3:
			buyAndCreateNewFondInvestment();
			break;
		case 4:
			InvestmentManager.printProjectedEarnings();
			break;
		case 5:
			InvestmentManager.printStocks();
			break;
		case 6:
			updateStockValueDialog();
			break;

		}
		return false;
	}

	// Ab hier bitte nichts verändern

	private static void readDatabaseFromFile(String path) {
		File databaseFile = new File(path);
		if (databaseFile.exists()) {

			try (BufferedReader r = new BufferedReader(new FileReader(databaseFile))) {
				String line;
				while ((line = r.readLine()) != null) {
					// check if we have a stock
					if (line.startsWith("ST")) {
						String[] fileds = line.split(";");
						// check if syntax fits
						if (fileds.length < 3) {
							continue;
						}
						// create stock (if possible)
						Stock stock = new Stock(Double.parseDouble(fileds[2]), fileds[1]);
						InvestmentManager.registerStocks(stock);
					}
				}
			} catch (Exception ignored) {
			}

		}
	}
}
