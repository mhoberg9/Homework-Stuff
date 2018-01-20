package de.tuberlin.snet.prog2.ue02.scheduling;

import java.util.LinkedList;

/**
 * Created by prog2-team, programmed by you
 * @author Malte
 */
class FIFOScheduler extends Thread implements Scheduler {
	
	/**
	 * Attributes
	 */
	LinkedList<Thread> queue = new LinkedList<>();

	/**
	 * Adds thread to the queue and passes the queue to the FIFO-method.
	 */
	@Override
	public void addThread(Thread thread) {
		queue.add(thread);
		FIFO(queue);
	}
	

	/**
	 * Creates different threads and passes them over to the addThread-method.
	 */
	public void run() {

		Prog2Thread p = new Prog2Thread('O');
		addThread(p);

		PiThread pi2 = new PiThread("name2", 9);
		addThread(pi2);

		PiThread pi = new PiThread("name", 10);
		addThread(pi);

		Prog2Thread p2 = new Prog2Thread('0');
		addThread(p2);
	}

	/**
	 * Receives queue and starts threads.
	 * @param queue
	 */
	public void FIFO(LinkedList<Thread> queue) {
		Thread s = new Thread(queue.poll());
		s.start();
		try {
			s.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
