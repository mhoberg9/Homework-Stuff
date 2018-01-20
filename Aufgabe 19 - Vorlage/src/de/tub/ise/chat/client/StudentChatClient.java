package de.tub.ise.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import de.tub.ise.chat.ChatMessage;

public class StudentChatClient extends ChatClient implements ChatInterface {
	
	/**
	 * This class is used to establish a connection to the server, send new messages and close the connection.
	 * @author maltehoberg
	 */

	Collection<ChatMessage> newcollection;
	Socket s;

	/**
	 * Constructor
	 * @param username
	 * @param hostIP
	 * @param port
	 */
	public StudentChatClient(String username, String hostIP, int port) {
		super(username, hostIP, port);
	}

	/**
	 * Establishes a new connection
	 * @throws Exception
	 */
	public void connect() throws Exception {

		try {
			s = new Socket(host, port);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			Thread t = new Thread(new ReadThread(br, newcollection));
			t.start();

			PrintWriter pwriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));
			Thread t2 = new Thread(new HeartBeat(pwriter));
			ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
			exe.scheduleAtFixedRate(t2, 28, 28, TimeUnit.SECONDS);

			if (isConnected == true) {
				notifyConnect();
			}

			if (isConnected == false) {
				notifyDisconnect();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends messages to the server 
	 * @param text
	 * @throws Exception
	 */
	
	@Override
	public void onSend(String text) throws Exception {

		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));
		if (text.equals("GIVEMEHISTORY!#!#*#!")) {
			String h = ChatMessage.serialize(new ChatMessage(username, "", "SEND_HISTORY"));
			writer.println(h + "\n");
			writer.flush();
		} else {
			String n = ChatMessage.serialize(new ChatMessage(username, text));
			writer.println(n + "\n");
			writer.flush();
		}

	}

	/**
	 * sets RegisterMessageQueue
	 * @param messages
	 */
	
	@Override
	public void registerMessageQueue(Collection<ChatMessage> messages) {
		messages.add(new ChatMessage("System", "Hallo, wie gehts?"));
		this.newcollection = messages;
	}
	
	/**
	 * Closes the connection
	 */
	
	@Override
	public void close() {
		Thread.currentThread().interrupt();
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
