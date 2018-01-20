package de.tuberlin.ise.prog1.onlineshop.utils;

import de.tuberlin.ise.prog1.onlineshop.products.*;
import de.tuberlin.ise.prog1.onlineshop.*;

/**
 * 
 * Instances of this enum represent MenuOption. MenuOption adds options to the
 * Main Menu.
 * 
 * 
 * @author malte hoberg
 *
 */

// Erstellen des Enums MenuOption mit der Methode optionsForNumber. Diese
// Methode weist jeder Option eine Number zu.
public enum MenuOption {

	LIST, ADJUST_STOCK, REGISTER, SHIP, EXIT;

	public static MenuOption optionsForNumber(int number) {
		switch (number) {
		case 0:
			return LIST;
		case 1:
			return REGISTER;
		case 2:
			return ADJUST_STOCK;
		case 3:
			return SHIP;
		case 4:
			return EXIT;
		default:
			return null;
		}

	}

}
