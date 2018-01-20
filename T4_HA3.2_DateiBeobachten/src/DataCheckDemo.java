import java.io.File;

/**
 * This class contains the main method which creates and starts the two threads
 * to check the text document.
 * 
 * @author Malte
 * 
 */
public class DataCheckDemo {

	public static void main(String[] args) throws InterruptedException {

		File txt = new File("C:/Users/Malte/Desktop/prog2testThread.docx");
		DataCheckThread t = new DataCheckThread(txt);
		t.start();

		File txt2 = new File("C:/Users/Malte/Desktop/prog2testRunnable.docx");
		Thread r = new Thread(new DataCheckRunnable(txt2));
		r.start();

		Thread.currentThread();
		Thread.sleep(10000);
		
		t.interrupt();
		r.interrupt();

	}
}
