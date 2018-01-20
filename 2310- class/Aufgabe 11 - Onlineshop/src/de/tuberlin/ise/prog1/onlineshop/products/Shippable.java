package de.tuberlin.ise.prog1.onlineshop.products;

import de.tuberlin.ise.prog1.onlineshop.utils.*;
import de.tuberlin.ise.prog1.onlineshop.*;
 /**
  * Instances of this interface represent Shippable. Shippable adds different options to a product.
  *
  *@author malte hoberg
  */


// Erstellen der Methode ship mit allen nötigen Parametern.
public interface Shippable {

	public void ship(String recipient, DeliveryMode deliveryMode, Carrier carrier, int quantity);

}
