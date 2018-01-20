package AD_Synco;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo {
	
	public static  void main (String [] args){
		
		BlockingQueue <String >queue = new LinkedBlockingQueue <>();
		
		Producer p = new Producer (queue);
		p.start();
		
		Consumer c = new Consumer(queue);
		c.start();
		
		
	}

}
