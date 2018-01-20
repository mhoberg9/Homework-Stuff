
public class SimpleDemo {
	
	public static void main (String [] args){
		Thread t = new Thread (new SimpleThreadInterrupt());
		t.start();
		
		try{
			t.sleep(10000);
			t.interrupt();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	
	}

}
