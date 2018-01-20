package de.tub.ise.chat.client;

import java.io.PrintWriter;

public class HeartBeat implements Runnable {
	
	/**
	 * This class is used to send empty messages to prevent getting disconnected from the server.
	 * @author maltehoberg
	 */

	PrintWriter writer;
	
	/**
	 * Constructor
	 * @param writer
	 */
	public HeartBeat(PrintWriter writer){
		this.writer = writer;
	}
	
	/**
	 * Sending empty messages to the server.
	 */
	@Override
	public void run() {
		
		System.out.println("TESTTEST");
		writer.println("\n");
		writer.flush();
		
	}
}
