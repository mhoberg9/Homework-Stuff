
public class NumberManipulation {
	public static void main(String[] args) {

		int n = 1;
		int m = 2;
		double d = 3;
		int[] var;
		var = generateNumbers(n, m);

		double[] foo;
		foo = divideNumbers(var, d);

		printArray(foo, "Value");

	}

	public static int[] generateNumbers(int n, int m) {

		if (m == 1) {
			return null;
		}
		int[] result = new int[n + 1];
		for (int i = 0; i < result.length; i++) {
			if (i % (m - 1) == 0) {
				result[i] = i;
			} else {
				result[i]= 0;
			}

		}

		return result;

	}

	public static double[] divideNumbers(int[] var, double d) {
		
		double [] results2 = new double[var.length];
		int i=0;
		do {
		results2[i] = var[i] / d;
		
		i++;	
		return results2;	
		}while (i < var.length);
		
	}

	public static void printArray(double [] bar, String string) {
		if (bar == null){
			return;
		}
		if (bar != null){
			for (int i=0; i < bar.length; i++){
				System.out.print(bar[i] + string +"," + '\t');
			}
		}
	}
}
