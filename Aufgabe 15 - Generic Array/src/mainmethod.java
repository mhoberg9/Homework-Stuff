/**
 * This class contains examples of object that the generic array contains.
 * @author maltehoberg
 *
 */


public class mainmethod {

@SuppressWarnings("unchecked")
public static void main (String [] args){

	genericmethod testarray = new genericmethod(10);
	
	/**
	 * Examples for "put"
	 */
	
	testarray.put("testest" , 0);
	testarray.put(10.2 , 1);
	testarray.put(2, 2);
	testarray.put(true, 3);

	/**
	*  Examples for "get"
	 */
	
	System.out.println(testarray.get(0));
	System.out.println(testarray.get(1));
	System.out.println(testarray.get(2));
	System.out.println(testarray.get(3));
	
}
}
