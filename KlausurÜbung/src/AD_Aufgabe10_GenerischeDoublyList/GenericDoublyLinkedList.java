package AD_Aufgabe10_GenerischeDoublyList;

public class GenericDoublyLinkedList<T> {

	GenericEntry<T> head;

	public void insertAtHead(T value) {
		if (head == null) {
			head = new GenericEntry<T>();
			head.value = value;
			return;
		}

		GenericEntry<T> newOne = new GenericEntry<>();
		newOne.value = value;
		newOne.next = head;
		head.prev = newOne;
		head = newOne;
	}

	public void append(T value) {

		if (head == null) {
			head = new GenericEntry<T>();
			head.value = value;
			return;
		}

		GenericEntry<T> current = head;
		GenericEntry<T> last = head;

		while (current != null) {
			last = current;
			current = current.next;
		}

		current = new GenericEntry<T>();
		current.value = value;
		current.prev = last;
		last.next = current;
	}

	public void insertAfter (T value, T after){
		if (head == null){
			head = new GenericEntry<T>();
			head.value = value;
			return;
		}
		
		GenericEntry <T> current = head;
		GenericEntry <T> newOne = new GenericEntry <> ();
		newOne.value = value;
		
		while (current.value != after && current.next != null){
			current = current.next;
		}
		
		GenericEntry <T> temp = current.next;
		newOne.prev = current;
		current.next= newOne;
		newOne.next = temp;		
		
	}
	
	public T getValue (int pos){
		if (head == null){
			return null;
		}
		GenericEntry <T> current = head;
		
		int counter = 0;
		while (current != null && pos != counter++){
			current = current.next;
		}
		
		if (current == null){
			return null;
		} else {
			return current.value;
		}
	}
	
	public void deleteValue(T value){
		if (head == null){
			return;
		}
		if (head.value == value){
			head = head.next;
			return;
		}
		
		GenericEntry <T> current = head;
		
		while (current.value != value && current != null){
			current = current.next;
		}
		
		current.prev.next = current.next;
		if (current.next != null){
		current.next.prev = current.prev;
		}
		
		
	}
	
}
