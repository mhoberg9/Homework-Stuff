package AC_Aufgabe7_waitnotify_2;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	BlockingQueue<String> queue;

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
					System.out.println(queue.size());

				} else {
					queue.notifyAll();
				}

			}
		}
	}
}
