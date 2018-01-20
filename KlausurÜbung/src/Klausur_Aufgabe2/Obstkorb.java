package Klausur_Aufgabe2;

import java.util.ArrayList;

public class Obstkorb implements Essbar {
	
	ArrayList <Obst> arraylist = new ArrayList<>();
	
	public void main (){
		arraylist.add(new Apfel());
		arraylist.add(new Birne());
	}
}
