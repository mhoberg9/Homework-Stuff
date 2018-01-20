package treatment;

import java.util.concurrent.Semaphore;

/**
 * This class is used to create new patient-threads and start them. Since only
 * two people at a time can enter the treatment room, we use a semaphore to
 * ensure this.
 * 
 * @author Malte
 *
 */

public class Behandlungsraum {

	/**
	 * Attributes
	 */
	static int patientenZahl = 100;
	static Behandlungsraum raum = new Behandlungsraum();
	static Semaphore sem = new Semaphore(2);

	/**
	 * Patient is entering a critical area. Only two people at a time can enter.
	 * @param patient
	 * @return
	 */
	public boolean behandeln(Patient patient) {
		try {
			try {
				sem.acquire();
				System.out.println("PatientNr.:" + patient.patientNr + " wird behandelt");
				try {
					Thread.sleep(1000 + (int) (Math.random() * 4000));
				} catch (InterruptedException ie) {
				}
				System.out.println("PatientNr.:" + patient.patientNr + " geht");
				return true;
			} finally {
				sem.release();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Starting and creating threads.
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < patientenZahl; i++) {
			new Patient(i, raum).start();
		}
	}

}
