package aufgabe6;

import java.util.LinkedList;
import java.util.List;

public class MyThreadSafeQueue<T> {

	private List<T> queue = new LinkedList<>();
	private int limit = 10;

	public MyThreadSafeQueue(int limit) {
		this.limit = limit;
	}

	public void enqueue(T item) throws QueueFullException {
		synchronized (queue) {
			if (queue.size() < limit)
				queue.add(item);
			else {
				throw new MyThreadSafeQueue.QueueFullException();
			}
		}
	}

	public T dequeue() {
		T result = null;
		synchronized (queue) {
			if (queue.size() > 0) {
				result = queue.remove(0);
			}
		}
		return result;
	}

	public static class QueueFullException extends Exception {

		private static final long serialVersionUID = 6542023862330764753L;

		public QueueFullException() {
			super();
		}

		public QueueFullException(String message) {
			super(message);
		}

		public QueueFullException(String message, Throwable cause) {
			super(message, cause);
		}

		public QueueFullException(Throwable cause) {
			super(cause);
		}
	}

}
