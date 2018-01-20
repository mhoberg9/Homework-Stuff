/**
 * 
 */
package de.tuberlin.ise.prog1.onlineshop.products;

import de.tuberlin.ise.prog1.onlineshop.utils.Carrier;
import de.tuberlin.ise.prog1.onlineshop.utils.DeliveryMode;

/**
 * @author jacobeberhardt
 *
 */
public interface Shippable {

	/**
	 * ships a warehouseItem using the specified delivery mode and carrier
	 */
	public void ship(String recipient, DeliveryMode deliveryMode, Carrier carrier, int quantity);

}
