package AD_Aufgabe4_StackmitArray;

import java.util.LinkedList;

public class StackList {
	
	LinkedList <Object> list = new LinkedList<>();
	int head = 0;

	
	public void push(Object o){
		list.addFirst(o);
		
	}

	public Object pop(){
		
		return list.poll();
	}

	public Object top(){
		return list.getFirst();
	}

}
