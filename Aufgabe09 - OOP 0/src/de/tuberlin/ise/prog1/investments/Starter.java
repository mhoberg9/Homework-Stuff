package de.tuberlin.ise.prog1.investments;

public class Starter {
	public static void main(String[] args) {
		
		/**
		 * Adding new stocks and investments
		 **/
		
		InvestmentManager.registerStocks(new Stock(null, 0));
		InvestmentManager.registerStocks(new Stock(null, 0));
		InvestmentManager.registerStocks(new Stock(null, 0));
		InvestmentManager.registerStocks(new Stock(null, 0));
		InvestmentManager.registerStocks(new Stock(null, 0));
		
		InvestmentManager.addInvestment(new Investment(null, 0, 0));
		InvestmentManager.addInvestment(new Investment(null, 0, 0));
		InvestmentManager.addInvestment(new Investment(null, 0, 0));
		InvestmentManager.addInvestment(new Investment(null, 0, 0));
		InvestmentManager.addInvestment(new Investment(null, 0, 0));
		
		
		InvestmentManager.printInvestments();
		InvestmentManager.printStocks();
		
	}
}
