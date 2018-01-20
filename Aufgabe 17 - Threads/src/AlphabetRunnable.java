/**
 * This class contains one method. It's used to run threads.
 * @author maltehoberg
 *
 */


public class AlphabetRunnable implements Runnable {
	
	/**
	 * The following method runs the thread. The thread runs for 100 seconds till its interrupted. It gives out the alphabet backwards.
	 * Its a checked exception because it needs a try/catch block. 
	 */

	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {
			for (char alphabet = 'Z'; alphabet >= 'A'; alphabet--) {
				System.out.println("R: " + alphabet);
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Runnable interruped");
			Thread.currentThread().interrupt();
		}

	}
}
