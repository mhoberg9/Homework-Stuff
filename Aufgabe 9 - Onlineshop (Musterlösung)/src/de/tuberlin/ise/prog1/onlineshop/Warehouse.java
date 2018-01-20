package de.tuberlin.ise.prog1.onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Instances of this class represent warehouses. Warehouses store products and provide means for insertion and retrieval.
 * 
 * @author jacobeberhardt
 *
 */
public class Warehouse {

	private WarehouseItem[] warehouseContent = new WarehouseItem[0];

	/**
	 * This method registers products in the warehouse. The stock value is set to 0
	 * @param products
	 */
	public void registerProducts(Product... products) {
		WarehouseItem[] updatedWarehouseContent = new WarehouseItem[warehouseContent.length
				+ products.length];
		int i = 0;
		for (; i < warehouseContent.length; i++) {
			updatedWarehouseContent[i] = warehouseContent[i];
		}
		for (; i < updatedWarehouseContent.length; i++) {
			updatedWarehouseContent[i] = new WarehouseItem(products[i - warehouseContent.length]);
		}	
		warehouseContent=updatedWarehouseContent;
	}
	
	
	/**
	 * Sets the stock of the product with specified id. Stock can not be negative
	 * @param id, stock
	 */
	public void setStockForProductById(int id, int stock) {
		for (WarehouseItem w : warehouseContent) {
			if (w.getProduct().getId() == id) {
				w.setStock(stock);
			}
		}
	}
	

	/**
	 * Prints an inventory list in the form [product id, productname, price, stock] 
	 */
	public void printInventory(){
		for (WarehouseItem w : warehouseContent) {
			System.out.println("id: " +  w.getProduct().getId()+ ", name: " + w.getProduct().getName() + ", price: " + w.getProduct().getPrice() + "€, stock: " +  w.getStock());
		}
	}
	
	
	/**
	 * loads an initial data set from the file inputdata.csv
	 * 
	 * * @return a Product[], will never be null but may have length 0
	 */
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
			System.out
					.println("There was an error while trying to load the initial data set:");
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
