package de.tuberlin.snet.prog2.ue05.sportreporter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Represents a server consuming comments of sport reporters, updating the
 * output.
 * 
 * @author prog2-team
 * @author Malte
 */
public class LiveTicker implements Runnable {

	/**
	 * Attributes
	 * 
	 */
	static BlockingQueue<String> eventList = new LinkedBlockingQueue<String>();

	/**
	 * This method is posting all the events in the eventList and removes them
	 * from the list afterwards. If the eventList is empty, the thread will wait
	 * until there are objects in the list.
	 */
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (eventList) {
				while (eventList.isEmpty()) {
					try {
						eventList.wait();
					} catch (Exception e) {
					}
				}
				for (String p : eventList) {
					p = eventList.remove();
					System.out.println(p);
				}
				eventList.notifyAll();

				try {
					Thread.currentThread();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return returns the list containing the comments
	 */
	public BlockingQueue<String> getEventList() {

		return eventList;
	}

	/**
	 * This method is used to create new Threads and to start them.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LiveTicker liveTicker = new LiveTicker();
		Thread t1 = new Thread(new LiveTicker());
		int maxSize = 1;
		Thread reporter1 = new Thread(new SportReporter("München vs. Dortmund", liveTicker.getEventList(), maxSize));
		Thread reporter2 = new Thread(new SportReporter("Berlin vs. Hamburg", liveTicker.getEventList(), maxSize));
		Thread reporter3 = new Thread(new SportReporter("Stuttgart vs. Köln", liveTicker.getEventList(), maxSize));

		t1.start();
		reporter1.start();
		reporter2.start();
		reporter3.start();
	}

}
