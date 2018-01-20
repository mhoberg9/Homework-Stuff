

public class GenericDoublyLinkedListEntry<T> {

	/**value of this list entry*/
	public T value;
	
	/**references to the successor and predecessor of this list entry*/
	public GenericDoublyLinkedListEntry<T> next;
	public GenericDoublyLinkedListEntry<T> prev; 
}
