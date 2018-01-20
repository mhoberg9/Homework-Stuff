package AD_Synco;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (queue) {
				if (queue.size() == 10) {
					for (String i : queue) {
						System.out.println(i);
					}
					queue.removeAll(queue);
					System.out.println("EMpty");

				} else {
					queue.notify();
				}

			}

		}

	}

}
