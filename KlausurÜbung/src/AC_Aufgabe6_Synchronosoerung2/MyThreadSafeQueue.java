package AC_Aufgabe6_Synchronosoerung2;

import java.util.ArrayList;

public class MyThreadSafeQueue <T>{
	
	ArrayList<T> queue = new ArrayList <>();
	int limit;
	public void enqueue(T o) throws QueueFUllException{
		synchronized(queue){
		if (queue.size() <= limit){
			queue.add(o);
		} else {
			throw new QueueFUllException();
		}
		}
	
	}

	
	public T dequeue(T o){
		synchronized(queue){
		T result = null;	
		if(queue.size() < 0){
			result = queue.remove(0);
			return result;
		}
		
		}
		return null;
		
	}
}
