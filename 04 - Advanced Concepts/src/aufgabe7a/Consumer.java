package aufgabe7a;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
	private BlockingQueue<String> q;

	private int heads = 0;
	private int tails = 0;

	public void run() {
		while (!(Thread.currentThread().isInterrupted())) {
			String s = q.poll();
			if (s != null) {
				System.out.println(s);
				if (s.equals("Heads")) {
					heads++;
				} else {
					tails++;
				}
				System.out.println("Relative frequency of heads = " + Math.round(((double)heads
						/ (heads + tails))*100)/100.0);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					this.interrupt();
				}
			}
		}
	}

	public void setQ(BlockingQueue<String> q) {
		this.q = q;
	}
}
