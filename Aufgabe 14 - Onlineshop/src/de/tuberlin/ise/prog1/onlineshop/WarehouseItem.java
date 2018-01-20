package de.tuberlin.ise.prog1.onlineshop;

import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Shippable;
import de.tuberlin.ise.prog1.onlineshop.utils.Carrier;
import de.tuberlin.ise.prog1.onlineshop.utils.DeliveryMode;

/**
 * Instances of this class can be held in a warehouse. They contain a product and a stock level.
 * @author jacobeberhardt
 *
 */
public class WarehouseItem implements Shippable{
	private Product product;
	private int stock;

	WarehouseItem(Product product, int stock) {
		this.product = product;
		this.stock = stock;
	}

	WarehouseItem(Product product) {
		this(product, 0);
	}

	public WarehouseItem(Product[] products) {
		// TODO Auto-generated constructor stub
	}

	void setStock(int stock) {
		if (stock >= 0) {
			this.stock = stock;
		} else {
			System.out
					.println("Stock value could not be updated. Negative values not allowed.");
		}
	}

	public int getStock() {
		return stock;
	}

	public Product getProduct() {
		return product;
	}

	public void ship(String recipient, DeliveryMode deliveryMode, Carrier carrier, int quantity) {
		if(quantity<=stock){
			stock = stock-quantity;
			System.out.println(quantity + " units of product with id " + product.getId() + " shipped by " + carrier + " to " + recipient + " with delivery mode " + deliveryMode);
			System.out.println("Remaining quantity: " + quantity);
		}else{
			System.out.println("Product could not be shipped, required quantity not in stock.");
		}
		
	}


}
