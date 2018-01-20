
public class ThreadandRunnableDemo {
	
	public static void main (String [] args){
		
		SimpleThread t = new SimpleThread();
		t.start(); //ermöglicht parallele Ausfürhung, mehrere Thread wenn nötig.
		//t.run()  führ NICHT parallel den Code der run()-Methode aus.		
					
		Thread c = new Thread (new SimpleRunnable());
		c.start();
	}

}
