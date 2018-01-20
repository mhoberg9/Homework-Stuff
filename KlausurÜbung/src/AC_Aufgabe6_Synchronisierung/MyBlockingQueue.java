package AC_Aufgabe6_Synchronisierung;

import java.util.LinkedList;

public class MyBlockingQueue <T>{
	
	LinkedList <T> queue = new LinkedList <> ();
	int limit = 10;
	
	public MyBlockingQueue(int limit ){
		this.limit = limit;
	}
	
	public T enqueue (T o) throws InterruptedException{
		while (queue.size() == limit){
			wait();
		}
		if (queue.size() != limit){ //? == 0 ??
			notifyAll();
		}
		queue.add(o);
		return null;
	}
	
	public T dequeue () throws InterruptedException{
		
		while (queue.size() == 0){
			wait();
		}
		if (queue.size() == limit){
			notifyAll();
		}
		
		
		
		return queue.remove(0);
	}
}
