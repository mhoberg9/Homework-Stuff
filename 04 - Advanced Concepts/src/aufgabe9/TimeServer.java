package aufgabe9;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {

	// Simple Date Format Patterns
	// http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept();
		BufferedWriter os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy, kk:mm:ss");
		String result = sdf.format(new Date());
		System.out.println(result);
		os.write(result);
		ss.close();
	}

}
