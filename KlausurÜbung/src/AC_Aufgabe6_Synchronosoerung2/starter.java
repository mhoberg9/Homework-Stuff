package AC_Aufgabe6_Synchronosoerung2;

public class starter {
	
	
	public static void main (String [] args) throws InterruptedException{
		MyBlockingQueue<String> queue = new MyBlockingQueue<String>();
		
		queue.enqueue("HI");
		queue.enqueue("2");	
		queue.enqueue("2");	
		queue.enqueue("2");	
		queue.enqueue("2");	
		queue.enqueue("2");	
		
		queue.enqueue("2");	
		queue.enqueue("2");	
		queue.enqueue("2");	
		queue.enqueue("10");	
		
		
	}

}
