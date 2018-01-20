import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BItstream {
			
	public static void main (String [] args){
		read();
	}
	
	public static void read(){
		String pathin = "C:/Users/maltehoberg/Desktop/server19/uploadfile.txt";
		String pathout = "C:/Users/maltehoberg/Desktop/server19/downloadfile.txt";
		try {
			FileInputStream in = new FileInputStream(pathin);
			FileOutputStream out = new FileOutputStream(pathout);
			
			while (in != null){
				try {
					int i = in.read();
					out.write(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
