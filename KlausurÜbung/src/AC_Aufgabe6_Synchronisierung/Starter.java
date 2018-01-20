package AC_Aufgabe6_Synchronisierung;

public class Starter {
	
	public static void main (String [] args ){
		
		
		//MyBlockingQueue <T> queue = new MyBlockingQueue <>(10);
		//MyThreadSafeQueue queue = new MyThreadSafeQueue<>(1);
		Consumer t = new Consumer ();
		t.start();
		
		Producer p = new Producer ();
	
	
		p.start();
	
	
		
		
		
		
	}

}
