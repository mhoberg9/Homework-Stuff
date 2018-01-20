package Echoserver3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	@SuppressWarnings("resource")
	public static void main (String [] args ){
		
		ServerSocket server;
		try {
			
			System.out.println("Server started!");
			server = new ServerSocket(8080);
			Socket client = server.accept();
			
			if (client.isConnected()){
				System.out.println("Client connected!");
			}
			
			
			BufferedReader br =  new BufferedReader(new InputStreamReader (client.getInputStream()));
			
		
			PrintWriter writer = new PrintWriter (new BufferedOutputStream(new FileOutputStream("C:/Users/maltehoberg/Desktop/75847.txt")));
			
			String line;
			while ((line = br.readLine()) != null){
				writer.println(line);
				writer.flush();
				
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
