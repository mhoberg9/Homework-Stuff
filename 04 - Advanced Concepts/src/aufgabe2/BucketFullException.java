package aufgabe2;

class BucketFullException extends Exception {

	private static final long serialVersionUID = -5059495685587788623L;

	//Parameterless Constructor
    public BucketFullException() {}

    //Constructor that accepts a message
    public BucketFullException(String message)
    {
       super(message);
    }
}