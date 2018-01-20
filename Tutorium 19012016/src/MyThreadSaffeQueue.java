import java.util.*;
public class MyThreadSaffeQueue <T> {
	
	private List <T> queue = new LinkedList <> ();
	private int limit = 10;
	
	
	public MyThreadSaffeQueue(int limit){
		this.limit = limit;
		
	}

	
	public void enqueue (T item) throws QueueFullException{
		synchronized (queue){
		if(queue.size() < limit){
			queue.add(item);
			}else{
				throw new MyThreadSaffeQueue.QueueFullException();
				
			}
		}
	}
	
	


	public T dequeue (){
		T result = null;
		synchronized (queue){
			if (queue.size()>0){
				result = queue.remove(0);
			}
		}
		
		return result;
	}
	
	public static class QueueFullException extends Exception{
		private static final long serialVersionID = 1;
		
	public QueueFullException(){
		super();
;	}
		
	public QueueFullException(String message){
		super(message);
	}
	}
}
