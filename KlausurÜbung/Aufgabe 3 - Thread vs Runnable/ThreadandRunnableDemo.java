
public class ThreadandRunnableDemo {
	
	public static void main (String [] args){
		
		SimpleThread t = new SimpleThread();
		t.start(); //erm�glicht parallele Ausf�rhung, mehrere Thread wenn n�tig.
		//t.run()  f�hr NICHT parallel den Code der run()-Methode aus.		
					
		Thread c = new Thread (new SimpleRunnable());
		c.start();
	}

}
