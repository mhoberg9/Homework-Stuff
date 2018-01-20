package AD_Aufgabe4_StackmitArray;

public class StackArray {
	
	String line ;
	
	public StackArray (String line){
		this.line = line;
	}
	Object [] array = new Object[10];
	int head = 0;
	
	
	public void push (Object o){
		head = head+1;
		array[head] = o;
	}
	
	public Object pop (){
		head = head -1;
		return array[head+1];
	}
	public Object top (){
		return array[head];
	}
}
