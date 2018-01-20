import java.util.concurrent.BlockingQueue;

/**
 * This class is used to add threads to the queue and calculate the time of
 * every Patient in the "Behandlungsraum".
 * 
 * @author Malte
 *
 */

public class Patient extends Thread {
	
	/**
	 * Attributes
	 */
	BlockingQueue<Thread> behandlungsraum;
	static int x = 0;

	/**
	 * Adding threads to the queue, calculating the time before being interrupted and removing threads from the queue.
	 */
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			behandlungsraum.add(this);

			String patient = "Patient " + x;
			System.out.println("Betritt: " + patient);
			x++;

			System.out.println("Personen im Behandlungsraum: " + behandlungsraum.size());

			try {
				Thread.currentThread();
				Thread.sleep((long) (Math.random() * 10000));
			} catch (InterruptedException e) {
				this.interrupt();
			}

			behandlungsraum.poll();
			System.out.println("Verlässt: " + patient);
		}
	}

	/**
	 * Setting the BlockingQueue
	 * @param behandlungsraum
	 */
	public void setQ(BlockingQueue<Thread> behandlungsraum) {
		this.behandlungsraum = behandlungsraum;
	}

}
