import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * This class is used to read and search through a csv.
 * It contains a main-, read- and search-method.
 * @author Malte
 *
 */
public class DataEinlesen {

	/**
	 * InputStream
	 */
	static BufferedReader br;

	
	public static void main(String[] args) {
		read();
	}

	/**
	 * This method is reading a csv, creating a new "Eintrag" and adding it to an ArrayList.
	 */
	public static void read() {
		try {
			
			br = new BufferedReader(new FileReader("C:/Users/Malte/Downloads/EWR_Ortsteile_Berlin_2015.csv"));
			ArrayList<Eintrag> list = new ArrayList<>();
			String line;

			while ((line = br.readLine()) != null) {
				String[] split = line.split(";");

				if (split[0].equals("Bezirk")) {
					
				} else {
					Eintrag newEintrag = new Eintrag(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]),
							split[3], Integer.parseInt(split[4]), split[5], split[6],
							Double.parseDouble(split[7].replaceAll(",", ".")));
					list.add(newEintrag);
				}
			}
			search(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is searching through the ArrayList.
	 * @param list
	 */
	public static void search(ArrayList<Eintrag> list) {
	double h = 0;
		for (Eintrag n : list) {
			if (n.geschlecht == 2 && n.ortsteil == 105 && n.altergruppe.equals("20_25")
					&& n.geschlecht == 2 && n.staatsangehörigkeit.equals("D")) {
				h += n.haeufigkeit;
				System.out.println(n.toString());
				System.out.println("Haeufikeit: " + h);
			}
		}
	}
}