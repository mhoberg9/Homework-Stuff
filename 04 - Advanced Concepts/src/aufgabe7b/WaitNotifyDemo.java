package aufgabe7b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WaitNotifyDemo {	
	
	public static void main(String[] args) throws InterruptedException{
		BlockingQueue<String> q = new LinkedBlockingQueue<>();
		Producer p = new Producer();
		p.setQ(q);
		p.start();
		Consumer c = new Consumer();
		c.setQ(q);
		c.start();
		
		Thread.sleep(10000);
		p.interrupt();
		c.interrupt();

	}
}
