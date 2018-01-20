import java.util.Comparator;

/**
 * This class is used to represent a comparator with java8.
 * @author Malte
 *
 */
public class Lambda2 {
	public static void main (String []args){
		
	
	//	Comparator<String> compareByStringLength = (String o1, String o2) -> o1.compareTo(o2);
		
	 Comparator<String> compareByStringLength2 = ( o1,  o2) -> Integer.compare(o1.length(), o2.length());
	 
	}		
}
