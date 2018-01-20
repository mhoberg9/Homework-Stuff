package HA6_1_Funktionales_Interface;

/**
 * This interface represents a boolean compare-operator that can be used by other classes.
 * @author Malte
 *
 */
public interface ComparePredicate {
	boolean better(String a, String b);
}
