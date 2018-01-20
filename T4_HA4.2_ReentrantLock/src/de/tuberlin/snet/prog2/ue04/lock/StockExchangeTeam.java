package de.tuberlin.snet.prog2.ue04.lock;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Represents a NewsTeam gathering stock exchange related news.
 *
 */
public class StockExchangeTeam extends NewsTeam {
	DecimalFormat df = new DecimalFormat();
	String[] companies = { "PiedPiper", "Hooli", "InferTron", "EndFrame", "BachManity" };

	/**
	 * Constructs a new StockExchangeTeam that will post to a given Ticker
	 * 
	 * @param t
	 *            the ticker to post to
	 */
	public StockExchangeTeam(NewsTicker t) {
		super(t);
		df.setMaximumFractionDigits(2);
		df.setPositivePrefix("+");
	}

	@Override
	protected String getLatestNews() {
		Random r = new Random();
		String company = companies[r.nextInt(companies.length)];
		boolean up = r.nextBoolean();
		float percent = up ? r.nextFloat() * 20 : r.nextFloat() * -20;
		String action = up ? " on the rise " : " is crashing ";

		String message = "Latest stock news: " + company + action + " : " + df.format(percent) + "%";

		return message;
	}

}
