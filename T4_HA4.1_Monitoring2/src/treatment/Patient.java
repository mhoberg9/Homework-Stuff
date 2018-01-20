package treatment;

/**
 * This class contains all attributes a patient needs, the constructor and a run
 * method.
 * 
 * @author Malte
 *
 */
public class Patient extends Thread {

	/**
	 * Attributes
	 */
	int patientNr;
	Behandlungsraum raum;

	/**
	 * Constructor
	 * 
	 * @param nr
	 * @param raum
	 */
	Patient(int nr, Behandlungsraum raum) {
		this.patientNr = nr;
		this.raum = raum;
	}

	/**
	 * run-Method
	 */
	public void run() {
		while (!raum.behandeln(this)) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
