import java.io.File;

/**
 * This class is used to check a text document every half a second and notifies the user if it has been modified or not.
 * The thread will stop after 30 seconds.
 * @author Malte
 *
 */
public class DataCheckThread extends Thread {

	/**
	 * Attributes
	 */
	private File txtfile;
	private long timestamp;

	/**
	 * Constructor
	 * @param txtfile
	 */
	DataCheckThread(File txtfile) {
		this.txtfile = txtfile;
		this.timestamp = txtfile.lastModified();
	}

	/**
	 * The thread checks if the original timestamp of the modification is still the same or not an notifies the user.
	 */
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			long timestamp = txtfile.lastModified();

			if (this.timestamp != timestamp) {
				hasChanged(txtfile);
				this.timestamp = timestamp;
			}

			if (this.timestamp == timestamp) {
				notChanged(txtfile);
			}
		
			try {
				DataCheckThread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted!");
				this.interrupt();
			}
		}
		
	}

	/**
	 * Notifies the user if it has been modified.
	 * @param txtfile
	 */
	private void hasChanged(File txtfile) {
		System.out.println("File: " + txtfile.getName() + " has been modified");
	}

	/**
	 * Notifies the user if it has not been modified.
	 * @param txtfile
	 */
	private void notChanged(File txtfile) {
		System.out.println("File: " + txtfile.getName() + " has NOT been modified");
	}

}
