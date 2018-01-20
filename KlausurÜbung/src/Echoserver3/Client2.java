package Echoserver3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	static Socket s;
	
	
	public static void main (String [] args) {
		
		try {
			s = new Socket ("Localhost" , 9999);
			
			BufferedReader br = new BufferedReader (new FileReader (""));
			
			String line;
			
			while ((line=br.readLine()) != null) {
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				pw.write(line);
			}
			br.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
