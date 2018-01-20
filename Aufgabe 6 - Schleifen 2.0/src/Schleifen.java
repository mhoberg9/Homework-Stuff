
import Prog1Tools.IOTools;

public class Schleifen {
	public static void main(String[] args) {
		System.out.println("Willkommen");
		int l = IOTools.readInt("Länge des Arrays eingeben: ");
		int[] array = new int[l];
		for (int i = 0; i < array.length; i++) {
			array[i] = IOTools.readInt("Welche Zahl soll der Array beinhalten? ");
		}
		int r = IOTools.readInt("Gesuchte Zahl: ");

		int suche = sucheFor(r, array);
		int suche2 = sucheWhile(r, array);
		int suche3 = sucheDoWhile(r, array);

		if (suche != -1 || suche2 != -1 || suche3 != -1) {
			System.out.println("For Position: " + suche + ", While Position: " + suche2 + ", DoWhile Position: " + suche3);
		}
		if (suche == -1 || suche2 == -1 || suche3 == -1) {
			System.out.println("Nicht im Array enthalten");
		}
	}

	public static int sucheFor(int r, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == r) {
				return i;
			}
		}
		return -1;

	}

	public static int sucheWhile(int r, int[] array) {
		int i = 0;
		while (i < array.length) {
			if (array[i] == r) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static int sucheDoWhile(int r, int[] array) {
		int i = 0;
		do {
			if (array[i] == r) {
				return i;
			}
			i++;
		} while (i < array.length);

		return -1;
	}
}
