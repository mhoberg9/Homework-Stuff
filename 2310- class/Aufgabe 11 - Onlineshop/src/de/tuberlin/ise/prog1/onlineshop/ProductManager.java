package de.tuberlin.ise.prog1.onlineshop;

import de.tuberlin.ise.prog1.onlineshop.utils.*;
import Prog1Tools.IOTools;
import de.tuberlin.ise.prog1.onlineshop.products.Book;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Shippable;
import de.tuberlin.ise.prog1.onlineshop.products.Television;
import de.tuberlin.ise.prog1.onlineshop.utils.MenuOption;

public class ProductManager {

	/**
	 * Provides a command line interface to interact with the product management
	 * system for an online shop
	 * 
	 * @author malte hoberg
	 * @param args
	 */
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.registerProducts(Warehouse.preloadInitialDataSet());
		System.out.println("Welcome to the online shop product management");
		boolean running = true;
		while (running) {
			System.out.println("Please, enter one of the following commands:" + "\n0 to list all products"
					+ "\n1 to register a new product" + "\n2 to adjust stock levels" + "\n3 to create shipping order"
					+ "\n4 to exit.");
			int command = IOTools.readInt();
			switch (MenuOption.optionsForNumber(command)) {
			case LIST:
				warehouse.printInventory();
				break;
			case REGISTER:
				Product p;
				switch (IOTools.readChar("Do you want to add a book (b) or a television (t)?")) {
				case 'b':
				case 'B':
					p = Book.createBookFromUserinput();
					break;
				case 't':
				case 'T':
					p = Television.createTelevisionFromUserinput();
					break;
				default:
					continue;
				}
				warehouse.registerProducts(p);
				System.out.println("The following product has been added to the catalog:\n" + p.toString());
				break;
			case ADJUST_STOCK:
				int id = IOTools.readInt("Please, enter product id:");
				int stock = IOTools.readInt("Please, enter new stock level:");
				warehouse.setStockForProductById(id, stock);
				break;
			case SHIP:
				// Einfügen von der Menü Option SHIP im Hauptmenü.
				// Produkt ID wird eingelesen und daran das Produkt mit allen
				// nötigen Informationen ermittelt. Anschließend werden die
				// Informationen für das Versenden eingelesen.
				int id1 = IOTools.readInt("Bitte ID des Produktes eingeben: ");
				WarehouseItem shippingproduct = warehouse.getWarehouseItemByProductId(id1);
				String recipient = IOTools.readLine("Empfänger eingeben: ");
				String deliveryMode = IOTools
						.readLine("Versandmethode  eingeben: (EXPRESS,LOW_COST,OVERNIGHT,STANDARD)");
				String carrier = IOTools.readLine("Bitte Transportunternehmen eingeben: (DHL,DPD,FEDEX,HERMES,UPS)");
				int quantity = IOTools.readInt("Bitte Menge angeben: ");
				shippingproduct.ship(recipient, DeliveryMode.valueOf(deliveryMode), Carrier.valueOf(carrier), quantity);
				break;
			case EXIT:
				running = false;
				break;
			default:
				System.out.println("Unknown command: " + command);
				break;
			}
		}
		System.out.println("Byebye!");
	}

}
