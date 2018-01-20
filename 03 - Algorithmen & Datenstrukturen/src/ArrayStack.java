
public class ArrayStack {

	Object[] array = new Object[10];
	private int head = 0 ; // Stackpointer
	
	public void push(Object o){
		head=head+1;
		array[head] = o;
	}
	public Object pop(){
		head=head-1;
		return array[head+1];
		
	}
	
	public Object top(){
		return array[head];
	}
	
}
