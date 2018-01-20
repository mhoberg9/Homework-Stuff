package de.tuberlin.ise.prog1.investments;

public class Investment{
	//unique id counter
    static int nextId = 0;

    private final int  id;
    private final Stock   stock;
    private final int     amount;
    private double stockBuyPrice;

   Investment (Stock stock, int amount, double stockBuyPrice){
	 id = nextId++;
	 this.stock = stock;
	 this.amount = amount;
	 this.stockBuyPrice = stockBuyPrice;
 }

   public Stock getStock(){
	   return stock;
   }
   
   public int getId(){
	   return id;
   }
   
   public int getAmount(){
	   return amount;
   }
   
   public double getstockBuyPrice(){
	   return stockBuyPrice;
   }
   
   public double setstockBuyPrice(){
	   return stockBuyPrice= Stock.getCurrentPrice();
   }
   
   

	public double currentValue(int amount, double stockBuyPrice){
		double wert = amount * stockBuyPrice;
		return wert	;
	}
	
	public double absolutPriceDelta(double wert, double stockBuyPrice, int amount){
		double differenz = (wert / stockBuyPrice) * amount;
		return differenz;
	}

	public String toString(String name, double wert, double differenz){
		return amount + name + wert + differenz;
	}
}