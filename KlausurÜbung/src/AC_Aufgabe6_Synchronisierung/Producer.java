package AC_Aufgabe6_Synchronisierung;

public class Producer extends Thread{
	
	MyThreadSafeQueue <Object> queue = new MyThreadSafeQueue<>(1);
	
	
	public void run (){
	
		while (!Thread.currentThread().isInterrupted()){
			Producer p = new Producer();
			
			try {
				queue.enqueue(p);
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Im a Producer");
			
		}
		
		
	}

}
