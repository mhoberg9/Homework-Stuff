package de.tub.ise.chat.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.Collection;
import java.util.LinkedList;

import de.tub.ise.chat.ChatMessage;

public class StudentChatClient extends ChatClient implements ChatInterface {

	LinkedList<ChatMessage> messagelist = new LinkedList<>();;
	Socket s = null;

	public StudentChatClient(String username, String hostIP, int port) {
		super(username, hostIP, port);
	}

	public void connect() throws Exception {
		try {
			s = new Socket(host, port);
			if (s.isConnected()) {
				System.out.println("Connected succesfully");
				Thread t = new Thread(new ReadRunnableThread(s, messagelist, host, port));
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onSend(String text) throws Exception {

		while (s.isConnected()) {
			PrintWriter pwout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));
			pwout.println(ChatMessage.serialize(new ChatMessage(username, text)));
			pwout.println("\n");
			pwout.flush();
			pwout.close();
		}

		// TODO send data to outputstream
		// use a printWriter to send data to the socket
		// create a ChatMessage object form the imput and parameter
		// use the ChatMessage.serialize() Method to generate the right Message
		// format

	}

	@Override
	public void registerMessageQueue(Collection<ChatMessage> messages) {
		messages.add(new ChatMessage(username, "Hallo"));
		messages = new LinkedList<ChatMessage>();
	}

	@Override
	public void close() {

		Thread.currentThread().interrupt();
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO close socket and kill all threads
	}
}
