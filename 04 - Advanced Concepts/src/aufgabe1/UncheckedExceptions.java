package aufgabe1;

import java.util.Scanner;

public class UncheckedExceptions {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a: ");
		int a = in.nextInt();
		System.out.print("Enter b: ");
		int b = in.nextInt();
		try {
			System.out.println("a+b = " + addPositive(a, b));
			main(args);
		} catch (IllegalArgumentException e) {
			System.out.println("Negative arguments entered. Please enter positive ones.");
			main(args);
		}
		in.close();
	}

	/**
	 * adds two positive integer numbers. 0 is allowed. Negative values cause IllegalArgumentExcpetions.
	 * 
	 * @param a
	 * @param b
	 * @return sum of positive integers
	 */
	private static int addPositive(int a, int b){
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException(
					"Only positive numbers are allowed");
		}
		return a + b;
	}

}
