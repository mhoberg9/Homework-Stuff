import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	
	static Socket serverclient;
	
	public static void main (String [] args) {
		ServerSocket chatserver;
		
		Socket client;
		
		try {
			
			chatserver= new ServerSocket(9929);
			System.out.println("Server started");
			client= chatserver.accept();
			
			if(client.isConnected()) {
				System.out.println("New client (" + client.getInetAddress() + ") connected!");
				BufferedWriter pw= new BufferedWriter(new PrintWriter (client.getOutputStream()));
				pw.write("Hello Client");
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			String line;
			while ((line=br.readLine()) != null) {
				System.out.println(line);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
