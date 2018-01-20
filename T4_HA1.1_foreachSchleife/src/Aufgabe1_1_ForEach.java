import java.util.Vector;

public class Aufgabe1_1_ForEach {

	public static void forLoop1A(String[] names) {
	
		for (String i : names) {
			System.out.println("1A: " + i);
		}

	}

	public static void forLoop2A(Vector<String> names) {
	
		for (String z : names) {
			System.out.println("2A: " + z);
		}
	}

	private static void forLoop3B(int n) {
		int[] arrNumbers = new int[n];

		int c = 0;
		for (int i : arrNumbers) {
			i = c + 4;
			c++;
		}

		for (int h = 0; h < arrNumbers.length; h++) {
			System.out.println("3B: " + arrNumbers[h]);
		}

	}
}
