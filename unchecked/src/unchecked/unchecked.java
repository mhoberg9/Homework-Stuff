package unchecked;

import java.util.Scanner;

public class unchecked {
		public static void main (String []args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		
		try {
			System.out.println("ergebnis" + addPositives(a,b));
			main (args);
		} catch (IllegalArgumentException e){
			System.out.println("Negative Zahlen nicht erlaubt");
			System.out.println(e);
			main (args);
			
		}
		in.close();
		}


public static int addPositives(int a, int b){
	if (a<0|| b<0){
		throw new IllegalArgumentException("Nur positive zahlen");
	}
	return a+b;
	}

	
}
