package Echoserver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	static ServerSocket server;
	
	public static void main(String [] args) {
		
		try {
			server = new ServerSocket (9999);
			Socket client = server.accept();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			
			String line;
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
