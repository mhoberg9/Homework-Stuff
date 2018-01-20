package de.tuberlin.snet.prog2.ue04.philosophers;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * This class represents a philosopher. He is doing the following (in this
 * order):
 * <ul>
 * <li>thinking for 0-1 seconds</li>
 * <li>picks up his left chopstick (or waits until it is free)</li>
 * <li>picks up his right chopstick (or waits until it is free)</li>
 * <li>eats for 0-1 seconds</li>
 * <li>puts down his right chopstick</li>
 * <li>puts down his left chopstick</li>
 * </ul>
 * and repeats this.
 * 
 * @author prog2-team
 * @author Malte
 */
public class Philosopher implements Runnable {

	/**
	 * Attributes
	 */
	Chopstick leftChopstick;
	Chopstick rightChopstick;
	String name;
	Random random = new Random();
	static Semaphore sem = new Semaphore(1);

	/**
	 * Constructor
	 */
	public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick) {
		this.name = name;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
	}

	/**
	 * Thread is getting into the critical area and executes all his tasks.
	 * Afterwards the thread is leaving the critical area and allows another to get in.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				try {
					sem.acquire();
					leftChopstick.pickUp();
					System.out.println(this + " picks up his left chopstick");
					// to provoke a deadlock:
					// Thread.yield();
					rightChopstick.pickUp();
					System.out.println(this + " picks up his right chopstick");
					eat();
					rightChopstick.putDown();
					System.out.println(this + " puts down his right chopstick");
					leftChopstick.putDown();
					System.out.println(this + " puts down his left chopstick");
				} finally {
					sem.release();
				}
				think();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Philosopher is thinking and thread is sleeping for this time.
	 * @throws InterruptedException
	 */
	private void think() throws InterruptedException {
		System.out.println(this + " is thinking");
		Thread.sleep(random.nextInt(10));
	}

	/**
	 * Philosopher is eating and and thread is sleeping for this time.
	 * @throws InterruptedException
	 */
	private void eat() throws InterruptedException {
		System.out.println(this + " is eating");
		Thread.sleep(random.nextInt(10));
	}

	/**
	 * to-String
	 */
	public String toString() {
		return name;
	}

}
