package de.tuberlin.snet.prog2.ue04.philosophers;

import java.util.concurrent.Semaphore;

/**
 * Represents a chopstick used by the philosophers. If a philosopher holds the
 * chopstick and another wants to pick it up he has to wait until the chopstick
 * is free.
 * 
 * @author prog2-team
 * @author Malte
 *
 */
public class Chopstick {

	/** flag showing whether the chopstick is in use */
	boolean inUse;
	static Semaphore sem = new Semaphore(1);

	/**
	 * Waits until the chopstick is free and picks it up.
	 * 
	 * @throws InterruptedException
	 */
	public void pickUp() throws InterruptedException {
		try {
			sem.acquire();
			while (isInUse()) {
				Thread.sleep(100);
			}
			setInUse(true);
		} finally {
			sem.release();
		}

	}

	/**
	 * Puts the chopstick down so i can be used by another philosopher.
	 */
	public void putDown() {
				setInUse(false);
	}

	/**
	 * Sets the {@link #inUse} variable.
	 * 
	 * @param newValue
	 */
	private void setInUse(boolean newValue) {
		inUse = newValue;
	}

	/**
	 * @return true, if the chopstick is in use, otherwise false
	 */
	private boolean isInUse() {
		return inUse;
	}

}
