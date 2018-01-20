/**
 * 
 */
package de.tuberlin.ise.prog1.onlineshop.utils;

/**
 * @author jacobeberhardt
 *
 */
public enum MenuOption {
	LIST, REGISTER, ADJUST_STOCK, SHIP, EXIT;

	public static MenuOption optionForNumber(int ordinal) {
		if (MenuOption.values().length <= ordinal || ordinal < 0)
			return null;
		else
			return MenuOption.values()[ordinal];
	}
}