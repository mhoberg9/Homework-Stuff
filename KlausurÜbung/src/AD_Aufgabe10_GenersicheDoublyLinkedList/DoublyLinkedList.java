package AD_Aufgabe10_GenersicheDoublyLinkedList;

public class DoublyLinkedList <T>{
	
	private GenericListEntry <T> head;

	public void insertAtHead (T value){
		if (head == null){
			head = new GenericListEntry<T>();
			head.value = value;
		}
		GenericListEntry <T> newhead = new GenericListEntry<T>();
		newhead.value = value;
		newhead.next = head;
		head.prev = newhead;
		head = newhead;
	}
	
	public void append(T value){
		if (head == null){
			head = new GenericListEntry <T>();
			head.value = value;
		}
		
		GenericListEntry<T> current = head;
		GenericListEntry<T> last = head;
		while(current.next != null){
			last = current;
			current = current.next;
		}
		current = new GenericListEntry<T> ();
		current.value = value;
		current.prev = last;
		last.next = current;		
		
	}
	
	public void insertAfter(T value, T after){
			if(head == null){
				head = new GenericListEntry<T>();
				head.value=value;
			}
			
			GenericListEntry<T> current = head;
			
			GenericListEntry<T> newOne = new GenericListEntry<>();
			
			while(current.value != after && current.next != null){
				current = current.next;
				
			}
			GenericListEntry <T> temp = current.next;
			newOne.value = value;
			current.next = newOne;
			newOne.prev = current;
			newOne.next = temp;
			
	}
	
	public Object getValue(int pos){
		
		if(head == null){
			return null;
		}
		
		int counter = 0;
		GenericListEntry <T> current = head;
		
		while(current.next != null && counter++ !=pos){
			current = current.next;
		}
		if(current.next == null){
			return null;
		}
		
		
		
		
		return current.value;
	}
	
	public void deleteValue(T value){
		if (head == null){
			return;
		}
		
		
		GenericListEntry <T> current = head;
		GenericListEntry<T> last = head;
		while(current.value != value){
			last = current;
			current = current.next;
		}
		if (current.value == value){
		last.next = current.next;
		current.next.prev = last;
		}
		
		if(current.value != value){
			return;
		}
	}
	
	
	
	
	public GenericListEntry <T> getHead() {
		return head;
	}

	public void setHead(GenericListEntry <T> head) {
		this.head = head;
	}
	
	
	

}
