import Prog1Tools.IOTools;

public class Rekursionstest {

	public static void main (String[]args){
	
		int n = IOTools.readInt("Zahl:");
		printZahl(n);	
	}
	
	public static int printZahl(int n){
		if (n == 1){
			System.out.println(n);
			return 1;
		} else {
			System.out.println(n);
			return (n * printZahl(n-1));
		}
	}
}
