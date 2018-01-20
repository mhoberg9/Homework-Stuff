package de.tuberlin.snet.prog2.ue05.sportreporter;

import java.util.concurrent.BlockingQueue;

/**
 * Represents a reporter posting comments of the current match to his live
 * ticker.
 * 
 * @author prog2-team
 *
 */
public class SportReporter implements Runnable {

	/**
	 * Attributes
	 */
	String match;
	BlockingQueue<String> eventList;
	int maxSize;

	/**
	 * Sport reporter used for comment a match.
	 * 
	 * @param match
	 *            name of the match (e.g. names of the playing teams)
	 * @param eventList
	 *            list for posting the comments
	 */
	public SportReporter(String match, BlockingQueue<String> eventList, int maxSize) {
		this.match = match;
		this.eventList = eventList;
		this.maxSize = maxSize;

	}

	/**
	 * This method is used to create & add new events to the eventList. If the
	 * eventList is full, the thread will wait until there is space.
	 */
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (eventList) {
				while (eventList.size() == maxSize) {
					try {

						eventList.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				switch ((int) (Math.random() * 4)) {
				case 1:
					eventList.add(match + ": " + SoccerEvent.CORNER.getCatchword());
					break;
				case 2:
					eventList.add(match + ": " + SoccerEvent.CORNER.getCatchword());
					break;
				case 3:
					eventList.add(match + ": " + SoccerEvent.GOAL.getCatchword());
					break;
				case 4:
					eventList.add(match + ": " + SoccerEvent.OFFSIDE.getCatchword());
					break;
				case 0:
					eventList.add(match + ": " + SoccerEvent.TACKLING.getCatchword());
					break;
				}
				eventList.notifyAll();
				try {
					Thread.currentThread();
					Thread.sleep((long) (Math.random() * 6000));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
		}

	}
}
