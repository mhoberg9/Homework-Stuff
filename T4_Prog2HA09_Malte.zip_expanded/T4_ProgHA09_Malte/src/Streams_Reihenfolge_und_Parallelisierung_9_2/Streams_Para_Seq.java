package Streams_Reihenfolge_und_Parallelisierung_9_2;

import java.util.stream.Stream;

/**
 * This class is used to show the difference of a parallel and sequential
 * stream.
 * 
 * @author Malte
 *
 */
public class Streams_Para_Seq {
	public static void main(String[] args) {

		/**
		 * Parallel
		 */
		System.out.println("*******Parallel********");
		long start = System.currentTimeMillis();
		
		Stream.of("d2", "a2", "b1", "b3", "c", "a6").limit(2).parallel().map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).filter(s -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("filter: " + s);
			return s.startsWith("A");
		}).forEach(s -> System.out.println("forEach: " + s));
		
		long elapsedTimeMillis2 = System.currentTimeMillis() - start;
		System.out.println("Time:" + elapsedTimeMillis2);

		/**
		 * Sequential
		 */
		System.out.println("*******Sequential********");
		long start2 = System.currentTimeMillis();

		Stream.of("d2", "a2", "b1", "b3", "c", "a6").limit(2).sequential().map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).filter(s -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("filter: " + s);
			return s.startsWith("A");
		}).forEach(s -> System.out.println("forEach: " + s));
		
		long elapsedTimeMillis = System.currentTimeMillis() - start2;
		System.out.println("Time: " + elapsedTimeMillis);

	}
}
