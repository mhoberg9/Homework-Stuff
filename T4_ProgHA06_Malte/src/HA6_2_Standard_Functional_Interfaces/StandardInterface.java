package HA6_2_Standard_Functional_Interfaces;

import java.time.LocalDateTime;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;


/**
 * This class shows different functional interfaces. 
 * @author Malte
 *
 */

public class StandardInterface {

	public static void main(String[] args) {

		BiPredicate<String, String> stringcompare = (s1, s2) -> s1.length() > s2.length() ? true : false;

		DoubleUnaryOperator d = (x) -> x * x;

		DoubleBinaryOperator i = (x, y) -> x * y * Math.PI;

		Consumer c = (cs) -> {
			String str = cs.toString();
			String[] strarr = str.split(".");
			System.out.println(strarr.length);
		};

		TriConsumer z = (a, b, y) -> System.out.println(a.toString() + b.toString() + y.toString());

		BooleanSupplier u = () -> {
			LocalDateTime time = LocalDateTime.now();
			int minute = time.getMinute();
			if (minute % 2 == 1)
				return true;
			else
				return false;
		};

	}
}
