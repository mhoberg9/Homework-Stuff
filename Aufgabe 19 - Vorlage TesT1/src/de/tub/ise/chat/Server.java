package de.tub.ise.chat;

import java.io.IOException;

import de.tub.ise.chat.server.ChatServer;

public class Server {
	public static void main(String[] args) {
		try {
			ChatServer.main(new String[]{"verbose"});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
