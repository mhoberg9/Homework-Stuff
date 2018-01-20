import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.ArrayList;

public class FileInput {
	


	public static void main (String [] args){
		read();
		
	
	}
	
	
	public static void read (){
		BufferedReader br;
		ArrayList <Message> list = new ArrayList<>();
		
		File upload;
		try{
		String txt = "C:/Users/maltehoberg/Desktop/server19/uploadfile.txt";
		upload = new File(txt);
		br = new BufferedReader(new FileReader(upload));
		String line = null;
		while ((line = br.readLine()) !=null){
			list.add(new Message(line));
		}
		for (Message i: list){
			System.out.println(i.line);
		}
		br.close();
		

		}catch (Exception e){
			e.printStackTrace();
		} 
	
		
	}
	

}
