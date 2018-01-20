package aufgabe8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextToCSV {

	private static String INPUTPATH = "/Users/jacobeberhardt/Desktop/input.txt";
	private static String OUTPUTPATH = "/Users/jacobeberhardt/Desktop/output.csv";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(
				INPUTPATH)));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
				OUTPUTPATH)));

		String line;
		while ((line = br.readLine()) != null) {
			if (line.trim().length() == 0) {
				bw.write("\n");
			} else {
				bw.write(line + ";");
			}
		}

		br.close();
		bw.close();
	}

}
