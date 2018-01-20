package Klausur_Aufgabe7_Streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FileStream {
	
	
	
	public static void main (String [] args){
		
		
	ArrayList <String> list = new ArrayList<> ();
	
	try{
	BufferedReader br = new BufferedReader(new FileReader("C:/Users/maltehoberg/Desktop/server19/uploadfile.txt"));
	//FileWriter writer = new FileWriter("C:/Users/maltehoberg/Desktop/uploadfile12");
	
	String line;
	while ((line = br.readLine()) != null){
		list.add(line);
	}
	
	for (String e : list){
		System.out.println(e);
	}
	
	br.close();
	
	}catch(IOException e ){
		e.printStackTrace();
		throw new RuntimeException();
	}
	
		
		
	}
	
	public static void foo(List <? extends Number> list){
		
	}
}
