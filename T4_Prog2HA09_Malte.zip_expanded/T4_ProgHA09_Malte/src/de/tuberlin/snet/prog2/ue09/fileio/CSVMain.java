package de.tuberlin.snet.prog2.ue09.fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import de.tuberlin.snet.prog2.ue09.fileio.CSVDataEntry;

/**
 * class containing the main method that runs CSVManager
 *
 */
public class CSVMain {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		CSVManager csvManager = new CSVManager("resources/EWR_Ortsteile_Berlin_2015_utf8.csv");

		ArrayList<CSVDataEntry> csvData = new ArrayList<CSVDataEntry>();
		try {
			csvData = csvManager.readCSV();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<CSVDataEntry> streamDataset = csvManager.getDatasetStream();

		/**
		 * Taxi-Data
		 */
		String path2 = "resources/yellow_tripdata_2016-12.csv";
		File f = new File(path2);
		try {
			Files.lines(f.toPath()).skip(1).limit(10).forEach(t -> System.out.println(t));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/**
		 * Population
		 */
		double count3 = csvManager.getDatasetStream().stream().mapToDouble(z -> z.getHauefigkeit()).reduce(Double::sum)
				.getAsDouble();
		System.out.println("Bevölkerung:" + count3);

		double count;
		try {
			count = csvManager.getStreamCSV().mapToDouble(t -> t.getHauefigkeit()).reduce(Double::sum).getAsDouble();
			System.out.println("Stream_Bevölkerung: " + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * Woman in Berlin
		 */
		double countwoman1;
		try {
			countwoman1 = csvManager.getStreamCSV().parallel().filter(o -> o.getGeschlecht() == 1)
					.mapToDouble(i -> i.getHauefigkeit()).reduce(Double::sum).getAsDouble();
			System.out.println("Woman_Berlin_Parallel: " + countwoman1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double countwoman12;
		try {
			countwoman12 = csvManager.getStreamCSV().sequential().filter(o -> o.getGeschlecht() == 1)
					.mapToDouble(i -> i.getHauefigkeit()).reduce(Double::sum).getAsDouble();
			System.out.println("Woman_Berlin_Sequential: " + countwoman12);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
