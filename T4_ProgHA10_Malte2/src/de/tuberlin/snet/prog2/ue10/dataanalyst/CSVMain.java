package de.tuberlin.snet.prog2.ue10.dataanalyst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.security.auth.kerberos.KerberosKey;

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
		CSVManager csvManager = new CSVManager("resources/EWR_Ortsteile_Berlin_2015.csv");
		ArrayList<CSVDataEntry> csvData = new ArrayList<CSVDataEntry>();
		try {
			csvData = csvManager.readCSV();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stream<CSVDataEntry> streamDataset = csvManager.getDatasetStream();

		final Comparator<? super CSVDataEntry> comp = (a1, a2) -> Double.compare(a1.getHauefigkeit(),
				a2.getHauefigkeit());

		/**
		 * Grundschule
		 */
		System.out.println("Grundschule: "
				+ csvManager.getDatasetStream().filter(i -> i.getAltersgruppe().equals("05_10")).max(comp).get());
		
	
		/**
		 * Sprachenschule
		 */
		csvManager.getDatasetStream()
				.filter(i -> i.getStaatsangeh().equals("A") || i.getAltersgruppe().equals("05_10")
						|| i.getAltersgruppe().equals("10_15"))
				.collect(Collectors.groupingBy(b -> b.getBezirksname(),
						Collectors.summarizingDouble(CSVDataEntry::getHauefigkeit)))
				.forEach((a, b) -> System.out.println("Sprachenschule: " + a + ": " + b.getSum()));

		/**
		 * Club
		 */
		// System.out.println("Club: "
		// + csvManager.getDatasetStream().filter(i ->
		// i.getAltersgruppe().equals("20_25")).max(comp).get());
		// WIE addiert man verschiedene Werte?

		csvManager.getDatasetStream()
				.filter(i -> i.getAltersgruppe().equals("20_25") || i.getAltersgruppe().equals("25_30"))
				.collect(Collectors.groupingBy(b -> b.getBezirksname(),
						Collectors.summarizingDouble(CSVDataEntry::getHauefigkeit)))
				.forEach((a, b) -> System.out.println("Club: " + a + ": " + b.getSum()));

	}
}
