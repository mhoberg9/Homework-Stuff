package de.tuberlin.ise.prog1.model;

public class MarketItem implements TreeData{

	private static int nextID;
	public final int id;
	
	/**
	 * Constructor
	 */
	
	public MarketItem (){
		this.id = nextID++;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public int getId(){
		return id;
	}

	/**
	 * Generate ID
	 */
	
	@Override
	public int getIntValue() {
		return id;
	}
	
	
	
}
