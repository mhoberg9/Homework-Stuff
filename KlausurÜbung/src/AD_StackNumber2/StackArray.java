package AD_StackNumber2;

public class StackArray {
	
	
	Object [] stack = new Object [10];
	int head = 0;
	
	
	public void  push(Object o){
		head = head+1;
		stack[head] = o;
		
	}

	public Object pop (Object o){
		head = head -1;
		
		return stack [head+1];
	}
	
	
	public Object top (){
		
		
		return stack [head];
	}
	
	
}
