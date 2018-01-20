
public class Demo {
	public static void main (String [] args)throws InterruptedException{
		// SimpleThread st = new SimppleThread();
		// st.start();
		
		Thread r = new Thread(new Simplerunnable());
		r.start();
		
		//new SimpleThread().start();
		//new Thread (new Simplerunnable()).start();
		Thread.sleep(1000);
		r.interrupt();
	}
}
