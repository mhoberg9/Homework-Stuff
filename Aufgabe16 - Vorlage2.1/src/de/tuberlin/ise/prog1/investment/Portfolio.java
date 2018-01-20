package de.tuberlin.ise.prog1.investment;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import de.tuberlin.ise.prog1.data.BubbleSort;
import de.tuberlin.ise.prog1.model.Investment;

/**
 * This class is used to store investments and offers different options to view them
 */
public class Portfolio {

    Investment[] investments = new Investment[0];

    double totalCapital = 10E5;
    
    /**
     * generates a strng representation of all investments in this portfolio
     * @param investments
     * @return
     */
    public String generateInvestmentReport(Investment[] investments){
        StringBuilder stringView = new StringBuilder();

        stringView.append("Portfolio Report [").append(new Date()).append("]\n");
        double totalValue = 0.0;
        double totalEarning= 0.0;
        double totalDelta = 0.0;
        stringView.append("List of investments:\n");
        for (Investment investment : investments) {
            stringView.append(String.format("\t%s\n",investment));
            totalValue+=investment.netAssetValue();
            totalEarning+=investment.projectedEarningsPerYear();
            totalDelta+=investment.absolutePriceDelta();
        }
        double ernings = (totalEarning*100/totalValue)-100.0;
        stringView.append(String.format("\nTotal value:%.2f Win/Loss: %.2f projected growth  of: %.2f %% \n " +
                "Your Absolut Capital so far is: %.2f",totalValue,totalDelta,ernings,totalCapital));
        return stringView.toString();
    }

    /**
     * prints all investments and the projected earnings per year
     */
    public String generateProjectedGrowth(){
        return generateInvestmentReport(this.investments);
    }

    /**
     * prints all investments and the projected earnings per year
     */
    public String generateSortedReport(){
        Investment[] sortedInvestments = (Investment[]) BubbleSort.sort(investments);
        return generateInvestmentReport(sortedInvestments);
    }


    /**
     * Inserts a new element in the investments-Array
     * @param investment
     */
    public void buyInvestment(Investment investment){
    	totalCapital -= investment.netAssetValue();
        Investment[] nInvestments = new Investment[this.investments.length + 1];
        System.arraycopy(this.investments, 0, nInvestments, 0, this.investments.length);
        nInvestments[this.investments.length] = investment;
        this.investments = nInvestments;
    }

	public Investment sell(int id) {
		//Ihre Aufgabe
		TreeSet set = new TreeSet();
		
		return null;
	}




}
