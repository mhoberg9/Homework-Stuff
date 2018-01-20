package AC_Aufgabe6_Synchronisierung;

import java.util.LinkedList;

public class MyThreadSafeQueue <T> {

	LinkedList <T> list = new LinkedList <> ();
	int limit;
	public MyThreadSafeQueue(int limit){
		this.limit = limit;
	}
	
	public T enqueue(T o) throws QueueFullException{
		
		if (list.size() != limit){
			list.add(o);
		} else {
			throw new QueueFullException();
		}
		return o;
	}
	
	public T dequeue (){
		
		T result = null;
		if (list.size() > 0){
			result = list.remove(0);
		}
		
		
		return result;
	}

}
