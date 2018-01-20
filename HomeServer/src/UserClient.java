import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UserClient {

	public static void main(String[] args) {
		System.out.println("Hello User");
		System.out.println("What do you wanna do?");
		System.out.println("Menu:");
		System.out.println("1- Login");
		System.out.println("2- Exit");
		Scanner sc = new Scanner(System.in);
		int commant = sc.nextInt();
		sc.close();

		switch (commant) {
		case 1:
			try {
				Socket client = new Socket("localhost", 9929);
				BufferedWriter bw = new BufferedWriter(new PrintWriter(client.getOutputStream()));
				bw.write("Piss dich");
				
				BufferedReader br = new BufferedReader 
						( new InputStreamReader (client.getInputStream()))1;
				
				String line;
				while((line = br.readLine()) != null) {
					System.out.println(line);
					
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.exit(commant);
		}	
	}
}
