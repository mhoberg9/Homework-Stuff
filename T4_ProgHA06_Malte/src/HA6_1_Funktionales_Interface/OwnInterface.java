package HA6_1_Funktionales_Interface;

/**
 * This class contains a main-method, two methods to compare Strings and a count method.
 * @author Malte
 *
 */


public class OwnInterface {
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		ComparePredicate compare = (String a, String b) -> true;
		System.out.println(BetterString("hallo", "peter", compare));

		ComparePredicate length = (String a,
				String b) -> (a.length() > b.length() == true || a.length() < b.length() == false);
		System.out.println(BetterString("hallo", "hallo124", length));

		ComparePredicate upperCase = (String a, String b) -> CountUpperCase(a) > CountUpperCase(b) == true
				|| CountUpperCase(a) < CountUpperCase(b) == false || CountUpperCase(a) == CountUpperCase(b) == true;
		System.out.println(BetterString("hAllo", "PeteR", upperCase));

		/**
		 * Generics
		 */

		GenericComparePredicate compare2 = (Object a, Object b) -> true;
		System.out.println(GenbetterString("hallo", "peter", compare2) + " GENERIC");

		GenericComparePredicate<String> length2 = (a, b) -> a.length() > b.length() == true
				|| a.length() < b.length() == false;
		System.out.println(GenbetterString("hallo", "hallo124", length2) + " GENERIC");

		GenericComparePredicate<String> upperCase2 = (a, b) -> CountUpperCase(a) > CountUpperCase(b) == true
				|| CountUpperCase(a) < CountUpperCase(b) == false || CountUpperCase(a) == CountUpperCase(b) == true;
		;
		System.out.println(GenbetterString("hAllo", "PeteR", upperCase2) + " GENERIC");

		GenericComparePredicate<Integer> icomp = (a, b) -> a > b ? true : false;
		System.out.println(GenbetterString(2, 4, icomp) + " GENERIC");

		GenericComparePredicate<Object[]> oarray = (a, b) -> a.length < b.length ? true : false;
		System.out.println(
				GenbetterString(new Object[] { "Halllllo", "Peter" }, new Object[] { 1, 2, 3 }, oarray) + " GENERIC");
	}

	/**
	 * This method is applying the given compare-predicate to the two given Strings.
	 * It returns the first String if the boolean is true or otherwise the second.
	 * @param a
	 * @param b
	 * @param compare
	 * @return
	 */
	
	private static String BetterString(String a, String b, ComparePredicate compare) {
		if (compare.better(a, b)) {
			return a;
		} else {
			return b;
		}
	}


	/**
	 * This method is applying the given compare-predicate to the two given objects.
	 * It returns the first object if the boolean is true or otherwise the second.
	 * @param a
	 * @param b
	 * @param gencompare
	 * @return
	 */
	private static <T> Object GenbetterString(T a, T b, GenericComparePredicate<T> gencompare) {
		if (gencompare.genbetter(a, b)) {
			return a;
		} else {
			return b;
		}
	}

	/**
	 * This method is used to count the uppercase letters.
	 * @param i
	 * @return
	 */
	private static int CountUpperCase(String i) {
		int result = 0;
		char[] count = i.toCharArray();

		for (char h : count)
			if (Character.isUpperCase(h)) {
				result++;
			}
		return result;
	}
}
