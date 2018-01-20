import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

/**
 * This class is used to represent different math formulas with java8.
 * @author Malte
 *
 */
public class Lambda3 {	
	public static void main (String [] args){
		
		DoubleFunction <Double> f = (x) -> 2*x;
		System.out.println(f.apply(10));
		
		BinaryOperator <String> f5;
		
		DoubleFunction <Double> f2 = (x) -> Math.pow(x, 2);
		System.out.println(f2.apply(10));
		
		DoubleBinaryOperator f3 = (x,y) -> x + y;
		System.out.println(f3.applyAsDouble(10, 5));
		
		DoubleBinaryOperator f4 = (x,y) -> Math.sqrt(Math.pow(x, y));
		System.out.println(f4.applyAsDouble(2, 1));
		
	}

}
