package HA6_2_Standard_Functional_Interfaces;

/**
 * This interface represents an operation upon three object operators.
 * @author Malte
 *
 * @param <T>
 */
public interface TriConsumer <T>{
	
	void apply (T a, T b, T c);
	

}
