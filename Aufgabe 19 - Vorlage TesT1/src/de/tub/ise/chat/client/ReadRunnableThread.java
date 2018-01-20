package de.tub.ise.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;

import de.tub.ise.chat.ChatMessage;

public class ReadRunnableThread implements Runnable {

	//
	private LinkedList<ChatMessage> messagelist = null;
	private Socket s = null;
	private String hostIP;
	private int port;

	public ReadRunnableThread(Socket s, LinkedList<ChatMessage> messagelist, String hostIP, int port) {
		this.messagelist = messagelist;
		this.hostIP = hostIP;
		this.port = port;
		this.s = s;

	}

	@Override
	public void run() {
		while (s.isConnected()) {
			try {
				s = new Socket(hostIP, port);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line = null;
				line = br.readLine();
				if (line != null) {
					messagelist.add(ChatMessage.deserialize(line));
					br.close();
					for (ChatMessage i : messagelist) {
						System.out.println(i.getBody());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}
}
