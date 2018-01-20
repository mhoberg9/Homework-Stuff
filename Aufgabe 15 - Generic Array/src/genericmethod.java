/**
 * This class is used to create a generic array and a put/get method.
 * @author maltehoberg
 *
 * @param <T>
 */



public class genericmethod <T>{

	
	public T [] array; 
	
	@SuppressWarnings("unchecked")
	public genericmethod (int length){
		this.array = (T[]) new Object[length];		
	}
	
	
	/**
	 * This method is used to get an object from a specific position of the array
	 * @param indexsearch
	 * @return
	 */
	public T get(int indexsearch){
		
		return array[indexsearch];

	}
	
	
	/**
	 * This method is used to add an Object to the generic Array
	 * @param arrayelement
	 * @param index
	 */
	public void put (T arrayelement, int index){
		
		array[index] = arrayelement;
	}
	
}

