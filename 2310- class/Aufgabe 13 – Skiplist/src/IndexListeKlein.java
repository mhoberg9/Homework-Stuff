
public class IndexListeKlein {

	// doubly linked list
	// Nach unten und nach rechts  Sprich: next und down
	public IndexListeKlein next;
	public IndexListeGroß down;
	private int value;
	private int id;
	
	IndexListeKlein(IndexListeKlein next, IndexListeGroß down, int value){
		this.next = next;
		this.down = down;
		this.value = value;
		
		
	}

	public IndexListeKlein getNext() {
		return next;
	}

	public IndexListeGroß getDown() {
		return down;
	}

	public int getValue() {
		return value;
	}

	public int getId() {
		return id;
	}

	public void setNext(IndexListeKlein next) {
		this.next = next;
	}

	public void setDown(IndexListeGroß down) {
		this.down = down;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	
	
	
}
