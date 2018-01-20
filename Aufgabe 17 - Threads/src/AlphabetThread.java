/**
 * This class contains one method. It's used to run threads.
 * @author maltehoberg
 *
 */

public class AlphabetThread extends Thread {
	
	
	/**
	 * The following method runs the thread. The thread runs for 100 seconds till its interrupted. It gives out the alphabet from A to Z. 
	 *	Its a checked exception because it needs a try/catch block. 
	 */
	
	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {

			for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
				System.out.println("T: " + alphabet);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
				Thread.currentThread().interrupt();
			}
		}
	}
}
