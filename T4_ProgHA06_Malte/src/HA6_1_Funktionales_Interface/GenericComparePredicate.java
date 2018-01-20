package HA6_1_Funktionales_Interface;

/**
 * This generic interface represents a boolean compare-operator that can be used by other classes.
 * @author Malte
 *
 * @param <T>
 */
public interface GenericComparePredicate <T>{
	boolean genbetter(T a, T b);

}
