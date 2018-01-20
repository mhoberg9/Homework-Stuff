package de.tuberlin.snet.prog2.ue05.buergeramt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Represents an Office with a limited number of workplaces for handling a
 * {@link Kunde}
 * 
 * @author prog2-team
 * @author Malte
 *
 */
public class Amt {

	/**
	 * Represents the number of workplaces for handling a {@link Kunde}
	 */
	static private int arbeitsplaetze = 5;

	/**
	 * Possible concerns that can be handled by the {@link Amt}
	 * 
	 * @author prog2-team
	 *
	 */
	enum Anliegen {
		Ummeldung, Fuehrerschein, Personalausweis
	}

	/**
	 * Creates new workplaces for handling a {@link Amt} with some workplaces
	 * and starts the work.
	 */
	public static void main(String[] args) throws InterruptedException {

		Anliegen [] list = {Anliegen.Ummeldung, Anliegen.Fuehrerschein, Anliegen.Personalausweis};

		ExecutorService exe = Executors.newFixedThreadPool(arbeitsplaetze);

		for (int i = 1; i <= 40; i++) {
			Runnable Kunde = new Kunde(i, list[(int) (Math.random()*3)]);
			exe.execute(Kunde);
		}
		
		exe.awaitTermination(8, TimeUnit.SECONDS);
		exe.shutdownNow();
		System.out.println("Wir haben geschlossen!");

	}
}
