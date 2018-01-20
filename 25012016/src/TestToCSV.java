import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestToCSV {
	private static String inputpath = "/user/fkol/tish/txt";
	private static String outputpatch = "/user/lki/tish/output.csv";
	
	
	public static void main (String [] args)throws IOException {
		BufferedReader br = new BufferedReader (new FileReader ( new File ( inputpath)));
		BufferedWriter bw = new BufferedWriter (new FileWriter (new File (outputpatch)));
		
		
		String line;
		while ((line = br.readLine()) != null){
			if (line.trim().length() == 0){
				bw.write("\n");
			}else {
				bw.write(line + ";");
			}
		}
	}
	
}
