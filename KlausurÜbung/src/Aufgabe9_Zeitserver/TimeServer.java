package Aufgabe9_Zeitserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer{
	
	public static void main (String [] args) {
		ServerSocket server;
		Socket client;
		LocalDateTime i = LocalDateTime.now();
		try {
			server = new ServerSocket (8080);
			client = server.accept();
			
			if (client.isConnected()){
				System.out.println("CONNECTED");
			}
			
		
				PrintWriter pw = new PrintWriter(client.getOutputStream());
				pw.println(i);
				pw.flush();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
