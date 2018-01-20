package AC_Aufgabe6_Synchronisierung;

public class Consumer extends Thread{

	MyThreadSafeQueue <Object> queue = new MyThreadSafeQueue<>(1);
	public void run () {
		
		while (!Thread.currentThread().isInterrupted()){
			
			while (queue.limit == 1){
				queue.dequeue();
			}
			
			System.out.println("Im a consumer!");
		}
		
	}
	
}
