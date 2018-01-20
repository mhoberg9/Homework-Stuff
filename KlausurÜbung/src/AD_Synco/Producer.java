package AD_Synco;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	private BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

			if (queue.size() != 10) {
				queue.add("Producer!!!");
			}


			}
		while (queue.size() == 10) {
			try {
				queue.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
