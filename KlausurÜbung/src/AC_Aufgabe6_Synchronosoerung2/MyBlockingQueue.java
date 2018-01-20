package AC_Aufgabe6_Synchronosoerung2;
import java.util.LinkedList;

public class MyBlockingQueue <T>{
	
	LinkedList<T> queue = new LinkedList<>();
	
	int limit = 10;
	
	
	
	public void enqueue(T o) throws InterruptedException{
		synchronized(queue){
		if(queue.size() == 0){
			notifyAll();
			
		}
		
		while (queue.size() == limit){
			wait();
		}
		
		this.queue.add(o);
	}
	}
	
	
	
	public T dequeue (T o) throws InterruptedException{
		synchronized(queue){
		
		T result = null;
		
		while(queue.size() == 0){
			wait ();
		}
		
		if (queue.size() == limit){
			notifyAll();
		}
		
		result = queue.removeFirst();
		return result;
		}
	}
	
	

}
