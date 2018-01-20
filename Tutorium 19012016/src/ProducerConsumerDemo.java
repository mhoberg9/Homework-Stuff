import java.util.concurrent.*;

public class ProducerConsumerDemo {
	public static void main (String [] args){
		BlockingQueue<String> q = new LinkedBlockingQueue <>();
		
		Producer p = new Producer();
		p.setQ(q);
		p.start();
		
		Consumer c =  new Consumer();
		c.setQ(q);
		c.start();
	}
}
