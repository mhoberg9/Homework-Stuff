package de.tuberlin.ise.prog1.onlineshop;

import Prog1Tools.IOTools;
import de.tuberlin.ise.prog1.onlineshop.products.Book;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Television;
import de.tuberlin.ise.prog1.onlineshop.utils.Carrier;
import de.tuberlin.ise.prog1.onlineshop.utils.DeliveryMode;
import de.tuberlin.ise.prog1.onlineshop.utils.MenuOption;

public class ProductManager {

	/**
	 * Provides a command line interface to interact with the product management
	 * system for an online shop
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.registerProducts(Warehouse.preloadInitialDataSet());
		System.out.println("Welcome to the online shop product management");
		boolean running = true;
		while (running) {
			System.out.println("Please, enter one of the following commands:" + "\n" + MenuOption.LIST.ordinal()
					+ " to list all products" + "\n" + MenuOption.REGISTER.ordinal() + " to register a new product"
					+ "\n" + MenuOption.ADJUST_STOCK.ordinal() + " to adjust stock levels" + "\n"
					+ MenuOption.SHIP.ordinal() + " to ship a product" + "\n" + MenuOption.EXIT.ordinal()
					+ " to exit.");
			MenuOption menuOption = MenuOption.optionForNumber(IOTools.readInt());
			switch (menuOption) {
			case LIST:
				warehouse.printInventory();
				break;
			
			/**
			 * This case is used to ship products. Its also checks the entered quantity if its negative or more than the actual stock.
			 */
			
			case SHIP: {
				int id = IOTools.readInt("Please, enter product id:");
				int qty = IOTools.readInt("Please, enter quantity of products for shipping:");
				String recipient = IOTools.readLine("Please enter the recipient's name:");
				DeliveryMode deliveryMode = DeliveryMode.valueOf(IOTools.readString("Please, enter a Delivery Mode:"));
				Carrier carrier = Carrier.valueOf(IOTools.readString("Please, enter a Carrier:"));
				WarehouseItem w = warehouse.getWarehouseItemByProductId(id);
				// get's the current stock & quantity and adds it to the "addpositive" method.
				int stock = w.getStock();
				try {
					addPositives(qty, stock);
					main(args);
				} catch (IllegalArgumentException e) {
					System.out.println("Eingabefehler:" + e);
					main(args);
				}
				w.ship(recipient, deliveryMode, carrier, qty);
				break;
			}
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
			case EXIT:
				running = false;
				break;
			default:
				System.out.println("Unknown command.");
				break;
			}
		}
		System.out.println("Byebye!");
	}

	/**
	 * The following method gets the stock and quantity and checks if its a negative number or higher than the current stock. If so its give out an IllegalArgumentException.
	*/
	
	public static int addPositives(int qty, int stock) {
		if (qty < 0) {
			throw new IllegalArgumentException("Ihre Zahl ist negativ");
		}
		if (qty > stock) {
			throw new IllegalArgumentException(
					"Ihre gwünschte Anzahl ist höher als der momentane Lagerbestand. Der momentante Lagerbestand ist:"
							+ stock);

		}
		return qty + stock;
	}
}
