package de.tuberlin.ise.prog1.investments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Prog1Tools.IOTools;

/**
 * CLI Interface for Investment Manager
 * 
 * @author Sebastian Werner & Malte Hoberg
 *
 */
public class Starter {

	/**
	 * dialog to use the updateStockValue function in cli mode
	 */
	private static void updateStockDialog() {
		int stockId = IOTools.readInt("Bitte ID eingeben: ");
		double value = IOTools.readDouble("Bitte neuen Preis eingeben:");
		InvestmentManager.updateStockValue(stockId, value);
	}

	/**
	 * dialog to use the buyStock function in cli mode
	 */
	private static void buyDialog() {
		int stockId = IOTools.readInt("Bitte ID eingeben");
		int amont = IOTools.readInt("Wie viel möchten sie kaufen? ");
		InvestmentManager.buyStock(stockId, amont);
	}

	// Ab hier bitte nichts verÃ¤ndern

	private static final String HELP_TEXT = "1 - Add Stock\n" + "2 - Buy Stock\n" + "4 - show portfolio\n"
			+ "5 - show Stocks\n" + "6 - update Stock\n" + "0 - exit\n" + "Enter Command Number:";

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
