package aufgabe7b;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	private static long execCounter = 0;

	private BlockingQueue<String> q;

	public void run() {
		while (!(Thread.currentThread().isInterrupted())) {
			double randomNumber = Math.random();
			String result = randomNumber >= 0.5 ? "Heads" : "Tails";
			synchronized (q) {
				q.add(result);
				q.notifyAll();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				this.interrupt();
			}
			execCounter++;
		}
		System.out.println("Number of producer executions: " + execCounter);
	}

	public void setQ(BlockingQueue<String> q) {
		this.q = q;
	}
}
