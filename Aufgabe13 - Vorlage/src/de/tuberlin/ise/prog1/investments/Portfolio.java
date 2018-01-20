package de.tuberlin.ise.prog1.investments;

import java.util.Date;

/**
 * This class is used to store investments and offers different options to view them
 */
public class Portfolio {

    Investment[] investments = new Investment[0];


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
        stringView.append("List of investments:\n");
        for (Investment investment : investments) {
            stringView.append(String.format("\t%s\n",investment));
            totalValue+=investment.netAssetValue();
            totalEarning+=investment.projectedEarningsPerYear();
        }
        
        double ernings = (totalEarning*100/totalValue)-100.0;
        stringView.append(String.format("\nTotal value:%.2f projected growth  of: %.2f %% \n",totalValue,ernings));
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
    	//Investment [] inv = 
    	return generateInvestmentReport(BubbleSort.sort(investments));
      //return generateInvestmentReport(inv);
    }


    /**
     * Inserts a new element in the investments-Array
     * @param investment
     */
    public void addInvestment(Investment investment){
        Investment[] nInvestments = new Investment[this.investments.length + 1];
        System.arraycopy(this.investments, 0, nInvestments, 0, this.investments.length);
        nInvestments[this.investments.length] = investment;
        this.investments = nInvestments;
    }




}
