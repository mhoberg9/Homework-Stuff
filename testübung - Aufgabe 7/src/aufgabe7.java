import Prog1Tools.IOTools;

public class aufgabe7 {
	public static void main(String [] args) {
		double a, b, c, d, e;
		 a = 1;
		 b = 4;
		 c = 2;
		 d = 3;
		
		if (a > b){
			e = a;
		}else{
			e = b;
		}
		if (c > d){
			e = c;
		} else {
			e = d;
		}
		if (d > a){
			e = d;
		}else{
			e = a;
		}
		
		
		System.out.println("e = " + e);
	}

}
