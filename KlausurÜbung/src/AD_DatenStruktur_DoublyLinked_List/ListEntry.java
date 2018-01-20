package AD_DatenStruktur_DoublyLinked_List;

public class ListEntry {
	
	
	
	public Object value;
	public ListEntry next;
	public ListEntry prev;
	
	
	
//	public ListEntry (Object value, ListEntry next, ListEntry prev){
//		this.value = value;
//		this.next = next;
//		this.prev = prev;
//	}
	
	public ListEntry getPrev() {
		return prev;
	}
	public void setPrev(ListEntry prev) {
		this.prev = prev;
	}
	public ListEntry getNext() {
		return next;
	}
	public void setNext(ListEntry next) {
		this.next = next;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

}
