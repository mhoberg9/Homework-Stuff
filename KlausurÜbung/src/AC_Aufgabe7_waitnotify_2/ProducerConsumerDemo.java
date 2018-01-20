package AC_Aufgabe7_waitnotify_2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {


	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();

		Producer t = new Producer(queue);
		t.start();

		Consumer c = new Consumer(queue);
		c.start();
	
	}
}
