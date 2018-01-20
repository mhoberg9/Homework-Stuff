package de.tuberlin.ise.prog1.onlineshop;

import de.tuberlin.ise.prog1.onlineshop.utils.*;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Shippable;

/**
 * Instances of this class can be held in a warehouse. They contain a product
 * and a stock level.
 * 
 * @author jacobeberhardt, Malte Hoberg
 *
 */
public class WarehouseItem implements Shippable {

	private Product product;
	private int stock;

	WarehouseItem(Product product, int stock) {
		this.product = product;
		this.stock = stock;
	}

	WarehouseItem(Product product) {
		this(product, 0);
	}

	void setStock(int stock) {
		if (stock >= 0) {
			this.stock = stock;
		} else {
			System.out.println("Stock value could not be updated. Negative values not allowed.");
		}
	}

	public int getStock() {
		return stock;
	}

	public Product getProduct() {
		return product;
	}

	// Implementieren des Interface Shippable mit einer Bedingung. Sofern
	// Lagerbestand groß genug für die angeforderte Menge ist, wird der
	// Lagerbestand um diese Menge reduziert. Ansonsten wird eine Fehlermeldung
	// ausgegeben.

	@Override
	public void ship(String recipient, DeliveryMode deliveryMode, Carrier carrier, int quantity) {
		if (stock >= quantity) {
			stock = stock - quantity;
			System.out.println("Ihre Bestellung war erfolgreich!" + "Empfäger: " + recipient + "Produkt ID: "
					+ getProduct().getId() + "Menge: " + quantity + "Transportdienstleister: " + carrier
					+ "Zustellungsart: " + deliveryMode);
		} else {
			System.out.println("Lagerbestand zu gering! Bestellung fehlgeschlagen!");
		}

	}

}
