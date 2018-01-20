package de.tuberlin.snet.prog2.ue04.philosophers;

import java.util.Random;

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
 */
public class Philosopher implements Runnable {
	
	/**
	 * Attributes
	 */
	Chopstick leftChopstick;
	Chopstick rightChopstick;
	String name;
	Random random = new Random();

	/**
	 * Constructor
	 * @param name
	 * @param leftChopstick
	 * @param rightChopstick
	 */
	public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick) {
		this.name = name;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
	}

	/**
	 * Thread is executing all his tasks and getting into a deadlock.
	 */
	@Override
	public void run() {
		while (true) {
			try{
				leftChopstick.pickUp();
				System.out.println(this + " picks up his left chopstick");
				// to provoke a deadlock:
				//Thread.yield();
				rightChopstick.pickUp();
				System.out.println(this + " picks up his right chopstick");
				eat();
				rightChopstick.putDown();
				System.out.println(this + " puts down his right chopstick");
				leftChopstick.putDown();
				System.out.println(this + " puts down his left chopstick");

			think();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			

	}

	/**
	 * Thread is sleeping.
	 * @throws InterruptedException
	 */
	private void think() throws InterruptedException {
		System.out.println(this + " is thinking");
		Thread.sleep(random.nextInt(10000));
	}

	/**
	 * Thread is sleeping.
	 * @throws InterruptedException
	 */
	private void eat() throws InterruptedException {
		System.out.println(this + " is eating");
		Thread.sleep(random.nextInt(10000));
	}

	/**
	 * to-String
	 */
	public String toString() {
		return name;
	}

}
