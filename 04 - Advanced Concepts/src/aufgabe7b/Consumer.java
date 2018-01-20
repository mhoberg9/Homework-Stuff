package aufgabe7b;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private static long execCounter = 0;
	private static long printCounter = 0; // 163763

	private BlockingQueue<String> q;

	private int heads = 0;
	private int tails = 0;

	public void run() {
		while (!(Thread.currentThread().isInterrupted())) {
			String s = q.poll();
			synchronized (q) {
				if (s == null) {
					try {
						q.wait();
					} catch (InterruptedException e) {
						this.interrupt();
					}
				}
			}
			if (s != null) {
				if (s.equals("Heads")) {
					heads++;
				} else {
					tails++;
				}
				System.out.println("Relative frequency of heads = "
						+ Math.round(((double) heads / (heads + tails)) * 100)
						/ 100.0);
				printCounter++;
			}
			execCounter++;
		}
		System.out.println("Number of consumer executions: " + execCounter);
		System.out.println("Number of consumer prints: " + printCounter);
	}

	public void setQ(BlockingQueue<String> q) {
		this.q = q;
	}
}
