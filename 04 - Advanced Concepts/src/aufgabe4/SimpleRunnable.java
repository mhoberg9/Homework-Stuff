package aufgabe4;

public class SimpleRunnable implements Runnable {

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("I'm a simple Runnable.");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				System.out.println("SimpleRunnable interrupted!");
//				Thread.currentThread().interrupt(); // why is this important?
//													// remove and test!
//			}
		}
	}

}
