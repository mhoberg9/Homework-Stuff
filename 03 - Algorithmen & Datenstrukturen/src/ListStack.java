
public class ListStack {
	
	DoublyLinkedList dll = new DoublyLinkedList();

	public void push(Object o){
		dll.insertAtHead(o);
	}
	
	public Object pop(){
		Object result = dll.getValue(0);
		dll.deleteValue(result);
		return result;
		
	}
	
	public Object top(){
		return dll.getValue(0);
	}
	
}
