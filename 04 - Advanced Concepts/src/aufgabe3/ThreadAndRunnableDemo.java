package aufgabe3;

public class ThreadAndRunnableDemo {

	public static void main(String[] args) {
		new SimpleThread().start();
		new Thread(new SimpleRunnable()).start();
	}
}
