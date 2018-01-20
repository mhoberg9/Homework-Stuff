package AC_Aufgabe7_waitnotify_2;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()){
		synchronized (queue) {
			if (queue.size() != 10) {
				double result = Math.random();
					if (result <= 0.5) {
						queue.add("Head");
					} else {
						queue.add("Tails");
					}
				}
			}
			
		
		while (queue.size() == 10){
			try {
			queue.wait();
			} catch (Exception e){
				
			}
		}
	}
	}
}
