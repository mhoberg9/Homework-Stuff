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

	/**
	 * dialog to use the updateStockValue function in cli mode
	 */
	private static void updateStockDialog() {
		InvestmentManager.printStocks();
		int id = IOTools.readInt("Select Stock:");
		double nValue = IOTools.readDouble("New Value?:");
		InvestmentManager.updateStockValue(id, nValue);
	}

	/**
	 * dialog to use the buyStock function in cli mode
	 */
	private static void buyDialog() {
		InvestmentManager.printStocks();
		System.out.print("Enter Stock Number:");
		int stockID = IOTools.readInt();
		System.out.print("How much do you want to buy:");
		int amount = IOTools.readInt();

		InvestmentManager.buyStock(stockID, amount);
	}

	/**
	 * BuyFond methode
	 */
	private static void buyFond() {
		int anzahl = IOTools.readInt("Wie viele Stocks wollen sie kaufen? ");
		int[] fond = new int[anzahl];
		for (int i = 0; i < fond.length; i++) {
			InvestmentManager.printStocks();
			fond[i] = IOTools.readInt("Welchen Stock wollen sie kaufen? ");
		} h
		double price = IOTools.readDouble("Wie viel ist der Fond wert?");
		InvestmentManager.buyFond((int) price, fond);
		System.out.println("Gekauft");
	}

	// Ab hier bitte nichts verändern

	private static final String HELP_TEXT = "1 - Add Stock\n" + "2 - Buy Stock\n" + "3 - BuyFond \n"
			+ "4 - show portfolio\n" + "5 - show Stocks\n" + "6 - update Stock\n" + "0 - exit\n"
			+ "Enter Command Number:";

	public static void main(String[] args) {
		readDatabaseFromFile("stocks.txt");

		boolean exit = false;
		do {
			System.out.print(HELP_TEXT);
			try {
				exit = commandLoopDialog();
			} catch (Exception e) {
				System.out.println("Es ist ein Fehler aufgetreten :(\n Probiere es nochmal.");
			}
		} while (!exit);

	}

	/**
	 * the command loop (switch case)
	 */
	private static boolean commandLoopDialog() {
		int command = IOTools.readInt();
		switch (command) {
		case 0:
			return true;
		case 1:
			InvestmentManager.registerStocks(Stock.createStockDialog());
			break;
		case 2:
			buyDialog();
			break;
		case 4:
			InvestmentManager.printPortfolio();
			break;
		case 5:
			InvestmentManager.printStocks();
			break;
		case 6:
			updateStockDialog();
			break;
		case 3:
			buyFond();
			break;

		}
		return false;
	}

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
