package de.tuberlin.ise.prog1.onlineshop.products;

import Prog1Tools.IOTools;

public class Book extends Product {
	
	/**
	 * This class represent Books. Books are stored with their information in warehouses.
	 * 
	 * @author Malte Hoberg
	 * created 25/11/2015
	 */
	
	//deklarierung aller Varibalen.
	
	final String author;
	final String title;
	final String publisher;
	final int edition;

	/**
	 * Constructor for books.
	 * @param author
	 * @param title
	 * @param publisher
	 * @param edition
	 * @param price
	 */
	public Book(String author, String title, String publisher, int edition, double price) {
		super(price);
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.edition = edition;

	}

	// Ausgabe von einem Buch mit allen Informationen
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", publisher=" + publisher + ", edition=" + edition
				+ ", price= " + getPrice() + "]";
	}

	/**
	 * createBookFromUserInput is used to generate a Television by user input
	 * @return
	 */
	public static Book createBookFromUserInput() {
		double price = IOTools.readDouble("Enter price: ");
		String author = IOTools.readLine("Enter author: ");
		String title = IOTools.readLine("Enter title: ");
		String publisher = IOTools.readLine("Enter publisher: ");
		int edition = IOTools.readInt("Enter edition: ");

		return new Book(author, title, publisher, edition, price);
	}

}
