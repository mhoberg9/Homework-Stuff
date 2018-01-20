import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class is used to create new Patient-threads,set the BlockingQueue and
 * start threads.
 * 
 * @author Malte
 *
 */
public class Behandlungsraum1 {

	/**
	 * Attributes
	 */
	static BlockingQueue<Thread> behandlungsraum = new LinkedBlockingQueue<>(1);

	/**
	 * Creating and stating threads
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("Size:" + behandlungsraum.size());

		Patient p = new Patient();
		p.setQ(behandlungsraum);
		p.start();

		Patient p1 = new Patient();
		p1.setQ(behandlungsraum);
		p1.start();

		Patient p2 = new Patient();
		p2.setQ(behandlungsraum);
		p2.start();

		Patient p3 = new Patient();
		p3.setQ(behandlungsraum);
		p3.start();

		Patient p4 = new Patient();
		p4.setQ(behandlungsraum);
		p4.start();
	}
}
