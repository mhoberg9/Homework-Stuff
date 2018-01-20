package AD_Aufgabe9_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ListiteratorDemo  {
	
	public static void main (String [] args){
		
		ArrayList <String> list = new ArrayList <> ();
		
		list.add("PETER");
		list.add("GÜNTHER");
		list.add("Wurst");
		
		Iterator<String> it = list.iterator();
		
		String name = "";
		
		while(it.hasNext()){
			name += it.next()+ ";";
		}
		
		System.out.println(name);
	}


}
