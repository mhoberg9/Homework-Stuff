package Aufgabe7_wAITnotify;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		Producer t = new Producer(queue);

		t.start();
	
		Consumer c = new Consumer(queue);
		c.start();

		try {
			t.sleep(1000);
			c.sleep(1000);
			t.interrupt();
			c.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
