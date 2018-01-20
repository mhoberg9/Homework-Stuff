package de.tuberlin.ise.prog1.onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Instances of this class represent warehouses. Warehouses store products and
 * provide means for insertion and retrieval.
 * 
 * @author jacobeberhardt
 *
 */
public class Warehouse {

	/**
	 * loads an initial data set from the file inputdata.csv
	 * 
	 * * @return a Product[], will never be null but may have length 0
	 */
	// Erstellen von neuem Array mit Namen warehouse
	private WarehouseItem[] warehouse = new WarehouseItem[0];

	/*
	 * Erstellen von Methode registerProducts zum überegeben von Produkten an
	 * warehouse
	 */
	public void registerProducts(Product... product) {

		/*
		 * Da alter Array warehouse zu klein wird ein neuer Array, der alle
		 * Daten von warehouse übernimmt und mit der Anzahl der neuen Produkten
		 * ergänzt
		 */
		WarehouseItem[] neuerArray = new WarehouseItem[warehouse.length + product.length];
		/*
		 * Mit Hilfe der for-Schleife arbeiten wir uns durch den Array und
		 * kopieren alle Werte in den Neuen
		 */
		for (int i = 0; i < warehouse.length; i++) {
			neuerArray[i] = warehouse[i];
		}
		/*
		 * neue Produkte werden zu dem neuen Array hinzugefügt. Wir fangen hier
		 * nun bei der Länge des alten Arrays warehouse an und fügen neue
		 * Produkte hinzu. Der Helper wird benötigt das wir noch keine Produkte
		 * haben und wir bei 0 anfangen möchten.
		 */
		int helper = 0;
		for (int j = warehouse.length; j < neuerArray.length; j++) {
			neuerArray[j] = new WarehouseItem(product[helper]);
			helper++;
		}

		warehouse = neuerArray;
		// Werte von warehouse werden durch die den neuen Array ersetzt

	}

	/*
	 * Produkte werden durch die ID bestimmt und der Lagerbestand wird
	 * ausgegeben
	 */
	public void setStockForProductById(int stock, int id) {
		/*
		 * Die Schleife arbeitet sich durch den Array, holt sich nötige
		 * Informationen von dem Produkt und bestimmt den Lagerbestand
		 */
		for (int u = 0; u < warehouse.length; u++) {
			if (id == warehouse[u].getProduct().getId()) {
				warehouse[u].setStock(stock);
			}
		}

	}

	// Gesamter Lagerbestand wird ausgegeben
	public void printInventory() {

		for (int p = 0; p < warehouse.length; p++) {
			System.out.println("Name= " + warehouse[p].getProduct().getName() + "Beschreibung= "
					+ warehouse[p].getProduct().getDescription() + "Preis= " + warehouse[p].getProduct().getPrice()
					+ "Anzahl= " + warehouse[p].getStock());

		}
	}

	public static Product[] preloadInitialDataSet() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("inputdata.csv"));
			ArrayList<Product> p = new ArrayList<Product>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] splits = line.split(";");
				if (splits.length == 3) {
					p.add(new Product(splits[0], splits[1], Double.parseDouble(splits[2])));
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
