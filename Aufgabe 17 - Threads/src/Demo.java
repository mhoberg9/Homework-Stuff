/**
 * This class contains the main method.  It is used to start and stop threads.
 * Its a checked exception because it needs a try/catch block. 
 * @author maltehoberg
 *
 */


public class Demo {
	

	public static void main(String[] args) throws InterruptedException {
		
		//beide threads werden gestartet.
		AlphabetThread a = new AlphabetThread();
		a.start();
		Thread t = new Thread(new AlphabetRunnable());
		t.start();

		//beide threads werden nach 1 Sekunde unterbrochen.
		Thread.sleep(100);
		t.interrupt();

		a.interrupt();

	}

}
