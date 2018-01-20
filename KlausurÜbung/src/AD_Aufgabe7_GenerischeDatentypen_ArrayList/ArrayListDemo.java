package AD_Aufgabe7_GenerischeDatentypen_ArrayList;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main (String [] args ){
	ArrayList <String> list = new ArrayList <>();
	
	list.add("PETER");
	list.add("HANS");
	list.add("Günther");
	
	for ( String i : list){
		System.out.print(i + ";");
	}
	
	
	}
}
