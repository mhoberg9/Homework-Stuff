package de.tuberlin.ise.prog1.onlineshop;

/**
 * Instanced of this class represent WarehoueItem. WarehouseItems are stored
 * products in warehouses with information of their stock.
 * 
 * @author Malte Hoberg
 *
 *         created 22/11/2015
 */

public class WarehouseItem {
	// deklarieren aller nötigen Variablen
	private Product product;
	public int stock;

	// setter-/getter-Methoden
	public int getStock() {
		return stock;

	}

	/*
	 * Lagerbestand (stock) wird durch neue Werte überschritten außer der neue
	 * Wert ist negativ. Dann bleibt der Lagerbestand unverändert und es wird
	 * eine Nachricht ausgegeben
	 */
	public void setStock(int stock) {
		if (stock < 0) {
			System.out.println("Nicht mehr auf Lager");
		} else {
			this.stock = stock;
		}
	}

	public Product getProduct() {
		return product;
	}

	// Kontruktor für ein Produkt im Warehouse (WarehouseItem) wird erstellt
	public WarehouseItem(Product product, int stock) {

		this.product = product;
		this.stock = stock;
	}

	public WarehouseItem(Product product) {
		this.product = product;
		this.stock = 0;
	}

}