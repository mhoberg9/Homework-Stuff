package de.tub.ise.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;
import de.tub.ise.chat.ChatMessage;

public class ReadThread implements Runnable {
	
	/**
	 * This class is used to read all incoming messages and add them to the collection.
	 */

	Collection<ChatMessage> newcollection;
	BufferedReader br;
	
	/**
	 * Constructor
	 * @param br
	 * @param newcollection
	 */
	
	public ReadThread(BufferedReader br, Collection<ChatMessage> newcollection) {
		this.br = br;
		this.newcollection = newcollection;
	}

	/**
	 * Gets incoming messages and adds them to a collection
	 */
	@Override
	public void run() {
		try {
			String line;
			while ((line = br.readLine()) != null) {
				newcollection.add(ChatMessage.deserialize(line));
				
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
