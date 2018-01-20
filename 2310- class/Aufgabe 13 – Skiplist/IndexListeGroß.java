
public class IndexListeGroß {

	// Singly Linked List
	public IndexListeGroß next;
	public int value;
	private static int nextId = 0;
	private final int id;
	
	IndexListeGroß(int value){
		this.value = value;
		this.id = nextId++;
		
	}

	public IndexListeGroß getNext() {
		return next;
	}

	public int getValue() {
		return value;
	}

	public void setNext(IndexListeGroß next) {
		this.next = next;
	}
	
	public int getId() {
		return id;
	}
	
}
