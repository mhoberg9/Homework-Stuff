package AC_Aufgabe1_UncheckedExceptions;

import java.util.Scanner;

public class UncheckedExceptions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value for a:");
		int a = sc.nextInt();
		System.out.println("Enter value for b:");
		int b = sc.nextInt();

		try{
			addPositive(a, b);
			main(args);
		}catch(IllegalArgumentException e){
			main(args);
		}
		sc.close();

	}

	public static void addPositive(int a, int b) {

		if (a < 0 || b < 0) {
			System.out.println("Nur postive Zahlen!");
			throw new IllegalArgumentException();
		}
		int c = a + b;
		System.out.println("Result:" + c);

	}

}
