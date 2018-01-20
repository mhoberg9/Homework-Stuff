package ECHOSERVER2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Echoserver {

	public static void main(String[] args) {

		ArrayList<String> array = new ArrayList<>();

		try {
			System.out.println("Server started!");
			ServerSocket server = new ServerSocket(8080);
			Socket client = server.accept();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter outputpath:" );
			String path = sc.nextLine().replace("\'", "/");
			sc.close();
			
			if (client.isConnected()) {
				System.out.println("Client connected");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

			PrintWriter writer = new PrintWriter(
					new FileOutputStream(path));
			writer.println(br.readLine());
			writer.flush();
			System.out.println("File saved at:" + path );

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
