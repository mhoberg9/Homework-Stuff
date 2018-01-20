package de.tuberlin.ise.prog1.onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Receiver;

import org.omg.PortableInterceptor.ACTIVE;

import de.tuberlin.ise.prog1.onlineshop.products.Book;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Television;

import java.io.BufferedReader;

/**
 * Instances of this class represent warehouses. Warehouses store products and
 * provide means for insertion and retrieval.
 * 
 * @author jacobeberhardt, Malte Hoberg
 *
 */
public class Warehouse {

	private WarehouseItem[] warehouseContent = new WarehouseItem[0];

	/**
	 * This method registers products in the warehouse. The stock value is set
	 * to 0
	 * 
	 * @param products
	 */
	public void registerProducts(Product... products) {
		WarehouseItem[] updatedWarehouseContent = new WarehouseItem[warehouseContent.length + products.length];
		int i = 0;
		for (; i < warehouseContent.length; i++) {
			updatedWarehouseContent[i] = warehouseContent[i];
		}
		for (; i < updatedWarehouseContent.length; i++) {
			updatedWarehouseContent[i] = new WarehouseItem(products[i - warehouseContent.length]);
		}
		warehouseContent = updatedWarehouseContent;
	}

	/**
	 * Sets the stock of the product with specified id. Stock can not be
	 * negative
	 * 
	 * @param id,
	 *            stock
	 */
	public void setStockForProductById(int id, int stock) {
		for (WarehouseItem w : warehouseContent) {
			if (w.getProduct().getId() == id) {
				w.setStock(stock);
			}
		}
	}

	/**
	 * Prints an inventory list
	 */
	public void printInventory() {
		for (WarehouseItem w : warehouseContent) {
			System.out.println("id: " + w.getProduct().getId() + "Info: " + w.getProduct().toString() + "â‚¬, stock: "
					+ w.getStock());
			// Ausgabe der Produkte mit deren Informationen.
		}
	}

	/**
	 * loads an initial data set from the file inputdata.csv
	 * 
	 * * @return a Product[], will never be null but may have length 0
	 * 
	 * @param <Book>
	 */
	public static Product[] preloadInitialDataSet() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("inputdata.csv"));
			ArrayList<Product> p = new ArrayList<Product>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] splits = line.split(";");
				if (splits.length == 6) { // System liest die Datei
											// inputdata.csv aus und überprüft
											// ob die Eingabe 6 Informationen
											// enthält. Sofern dies der Fall ist
											// weiß das System , dass es sich um
											// ein Buch handelt.

					Book b;
					b = new Book(splits[1], splits[2], splits[3], Integer.parseInt(splits[4]),
							Double.parseDouble(splits[5]));

					// System liest die verschiedenen "Blöcke" aus der
					// inputdata.csv Datei aus.

					p.add(b);

				} else if (splits.length == 5) { // System liest die Datei
					// inputdata.csv aus und überprüft
					// ob die Eingabe 5 Informationen
					// enthält. Sofern dies der Fall ist
					// weiß das System , dass es sich um
					// ein Buch handelt

					Television t;
					t = new Television(splits[1], Integer.parseInt(splits[2]), Boolean.parseBoolean(splits[3]),
							Double.parseDouble(splits[4]));
					// System liest die verschiedenen "Blöcke" aus der
					// inputdata.csv Datei aus.

					p.add(t);
				} else {
					System.out.println("Could not process line:" + line);
				}
			}

			return p.toArray(new Product[p.size()]);

		} catch (Exception e) {
			System.out.println("There was an error while trying to load the initial data set:");
			e.printStackTrace();
			return new Product[0];
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}

}
