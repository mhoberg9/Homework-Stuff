package aufgabe4;

public class InterruptRunnableDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new SimpleRunnable());
		t.start();
		Thread.sleep(1000);
		t.interrupt();
	}
}
