package AD_DatenStruktur_DoublyLinked_List;

public class DoublyLinked {

	private ListEntry head;

	public void insertAtHead(Object value) {
		if (head == null) {
			head = new ListEntry();
			head.value = value;
			return;
		}
		ListEntry newHead = new ListEntry();
		newHead.value = value;
		newHead.next = head;
		head.prev = newHead;
		head = newHead;
	}

	public void appened(Object value) {
		if (head == null) {
			head = new ListEntry();
			head.value = value;
		}
		ListEntry current = head;
		ListEntry last = head;

		while (current != null) {
			last = current;
			current = current.next;
		}
		current = new ListEntry();
		current.value = value;
		current.prev = last;
		last.next = current;
	}
	
	
	public void insertAfter(Object value, Object after){
		if (head == null){
			head = new ListEntry();
			head.value = value;
		}
		
		ListEntry newOne = new ListEntry();
		newOne.value = value;
		
		ListEntry current = head;
		
		while(current.value != after && current.next != null){
			current = current.next;
		}
		ListEntry temp = current.next;
		newOne.prev = current.prev;
		newOne.next = temp;
		current.next = newOne;
		
	}
	
	public Object getValue(int position){
		
		int counter= 0;
		ListEntry current = head;
		while(current.next != null && position != counter++){
			current = current.next;
		}
		if (current.next == null){
			return null;
		}
		return current.value;
	}
	
	public void deleteValue (Object value){
		ListEntry current = head;
		
		if (head.value == value){
			
		}
		
		while(current.next.value != value){
			current = current.next;
		}
		
		current.next = current.next.next;
		current.next.next.prev = current;
	}

		
	public ListEntry getHead() {
		return head;
	}

	public void setHead(ListEntry head) {
		this.head = head;
	}

}
