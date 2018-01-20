package de.tuberlin.ise.tree;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		IntData[]  data = IntData.makeFromIntArray(12,5,18,9,2,20,3);
		
		BinTree tree = new BinTree();
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(tree);
			tree.insert(data[i]);
			
		}
		//int s1 =Scanner ("Enter the first number you want to search for: );
		/*while(true){
			System.out.println("Binary tree menu: "+"\n"+"1- Add int value \n"+ "2. Search for value \n"+"3. EXIT-I am bored ");
			Scanner s = new Scanner(System.in);
			int s1=0;
			
			int i = s.nextInt();
			switch (i){
			case 1: 
				System.out.println("Enter first number");
		int value= s.nextInt();
		IntData[] id = IntData.makeFromIntArray(value);
		tree.insert(id[0]);
		
		break;
			case 2: 
				System.out.println("Enter value that should ne found:");
				s1= s.nextInt();
				tree.find(new IntData(s1));break;
			case 3: System.exit(0);
			}
		
		
		
		
		s.close();
		*}*/
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int s1= s.nextInt();
		System.out.println("Enter second number: ");
		int s2 = s.nextInt();
		s.close();
		System.out.println("Looking for " + s1 + ". Found: " + tree.find(new IntData(s1)));
		
		System.out.println("Looking for " + s2 + ". Found: " + tree.find(new IntData(s2)));
	}
}
