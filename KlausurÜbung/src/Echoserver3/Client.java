package Echoserver3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	static Socket s;
	
	
	public static void main (String [] args){
		//ArrayList <String> list = new ArrayList <>(); 
		
		try {
			s = new Socket ("localhost", 8080);
			
			BufferedReader br = new BufferedReader (new FileReader("C:/Users/maltehoberg/Desktop/server19/75847.txt"));
			
			String line;
			while ((line=br.readLine()) != null){
				PrintWriter writer = new PrintWriter (s.getOutputStream());
				writer.println(line);
				System.out.println("Sending: " + line);
			}
			
		br.close();
		s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
