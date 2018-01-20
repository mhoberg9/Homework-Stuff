package de.tuberlin.snet.prog2.ue02.debugging;

public class WrongPassword extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongPassword(String message){
		super(message);
	}

}
