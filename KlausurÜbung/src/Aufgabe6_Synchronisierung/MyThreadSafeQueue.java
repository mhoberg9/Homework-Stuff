package Aufgabe6_Synchronisierung;

import java.util.LinkedList;

public class MyThreadSafeQueue<T> {

	LinkedList<T> list = new LinkedList<T>();
	int limit = 10;

	public MyThreadSafeQueue(int limit) {
		this.limit = limit;
	}

	public void enqueue(T item) throws QueueFullException {
		synchronized (list) {
			if (list.size() < limit) {
				list.add(item);
			} else {
				throw new QueueFullException();
			}
		}
	}

	public T dequeue(T item) {
		synchronized (list) {
			T result = null;
			if (list.size() > 0) {
				result = list.remove(0);
			}
			return result;
		}
	}

}
