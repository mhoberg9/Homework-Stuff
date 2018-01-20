package Aufgabe9_Zeitserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
	
	
	public static void main (String [] args) {
	
		
		
		try {
			Socket s =  new Socket("localhost", 8080);
			s.getOutputStream().write(42);
	
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line;
			while((line = br.readLine()) != null){
			System.out.println(line);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	

}
