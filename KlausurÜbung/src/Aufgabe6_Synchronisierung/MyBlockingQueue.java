package Aufgabe6_Synchronisierung;

import java.util.LinkedList;

public class MyBlockingQueue <T> {
	
	LinkedList<T> list = new LinkedList<>();
	int limit = 10;
	
	public MyBlockingQueue(int limit){
		this.limit = limit;
	}
	
	public void enqueue(T item) throws InterruptedException{
		synchronized(list){
			while (list.size() == this.limit){
				wait();
			}
			if (list.size() == 0){
				notifyAll();
			}
			this.list.add(item);
		}
	}
	
	public T dequeue(T item) throws InterruptedException{
		while (list.size()== 0){
			wait();
		}
		if (list.size()== this.limit){
			notifyAll();
		}
		return this.list.removeFirst();
	}
}
