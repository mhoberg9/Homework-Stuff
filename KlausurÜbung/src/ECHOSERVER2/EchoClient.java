package ECHOSERVER2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<>();
		try {
			Socket s = new Socket("localhost", 8080);
			
			if(s.isConnected()){
				System.out.println("Connected to server!");
			}
			
			Scanner sc= new Scanner(System.in);
			System.out.println("Please enter filelocation:");
			String path = sc.nextLine().replace(" \' " , " / ");
			sc.close();
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				array.add(line);
			}

			PrintWriter writer = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));
			writer.println(array);
			writer.flush();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
