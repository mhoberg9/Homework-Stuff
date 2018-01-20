package AC_Aufgabe2_CheckedExceptions;

public class BucketFullException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public BucketFullException(String line){
		super(line);
	}
}
