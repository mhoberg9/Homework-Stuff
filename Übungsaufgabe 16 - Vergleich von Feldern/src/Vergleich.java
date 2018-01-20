import java.util.Arrays;

import Prog1Tools.IOTools;

public class Vergleich {
	public static void main (String [] args){
		System.out.println("Willkommen!");
		int l = IOTools.readInt("Länge der Arrays: ");
		int [] a = new int [l];
		int [] b = new int [l];
	
	for (int i = 0; i < a.length ; i++){
		a[i] = IOTools.readInt("Zahl in Array a: ");
	}
	for (int i = 0; i < b.length; i++){
		b[i] = IOTools.readInt("Zahl in Array b: ");
	}
	if (Arrays.equals(a, b)){
		System.out.println("true");
	}else{
		System.out.println("false");
	}
	
	}

}
