package aufgabe7a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {	
	
	public static void main(String[] args){
		BlockingQueue<String> q = new LinkedBlockingQueue<>(1);
		Producer p = new Producer();
		p.setQ(q);
		p.start();
		Consumer c = new Consumer();
		c.setQ(q);
		c.start();

	}
}
