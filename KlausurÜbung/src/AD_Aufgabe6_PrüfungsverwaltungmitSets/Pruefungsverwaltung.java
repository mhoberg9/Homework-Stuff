package AD_Aufgabe6_PrüfungsverwaltungmitSets;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Pruefungsverwaltung {

	public static void main (String [] args){
		
		Set <Student> list = new HashSet <>();
	
		//Scanner sc2 = new Scanner (System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Was wollen sie tun? 1 - ADD, 2- SEARCH");
		int command = sc.nextInt() ;
		sc.close();
		
		
		switch (command){
		
		case 1: 
		sc= new Scanner(System.in);	
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter QISPOS: ");
		String QISPOS = sc.nextLine();
		System.out.println("Enter phys Schein: ");
		String phys = sc.nextLine();
		System.out.println("Enter if allowed: ");
		String zugelassen = sc.nextLine();
		sc.close();
		
		list.add(new Student(name,QISPOS,phys,zugelassen));
		
		
		for (Student i : list){
			System.out.println("Name: " + i.Name +" Phys: " + i.phys + " QISPOS:" + i.QISPOS + " Zugelassen:" + i.zugelassen);
		}
		
		main(args);
		break;
		case 2:
			search("YES", list);
			
			break;
	}}
	
	public static String search(String text, Set <Student> list){
		
		for (Student i : list){
			if (i.zugelassen.equals(text)){
				System.out.println(i.Name + i.zugelassen);
				
				
			}
		}
		
		
		return null;
		
		
		
	}
	
	
	
}
