
public class SimpleThreadInterrupt implements Runnable {

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
	
			System.out.println("Im a simple Runnable!");
		
			try {

				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
				}
	


	}
}
}