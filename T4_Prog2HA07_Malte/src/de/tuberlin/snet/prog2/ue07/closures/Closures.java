package de.tuberlin.snet.prog2.ue07.closures;

import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Closures {

	
	static void greetings(String name){
		/**
		 *  TODO Implementieren des Functional Interface
		 */
		Function <String, String> greeter = (s) -> s+name + "!";
		welcomeMessage(greeter);
	}
	
	static void welcomeMessage(Function<String, String> greeter){
		/**
		 *  TODO Aufrufen des Functional Interfaces
		 */
		
	
		
		System.out.println();
	}
	
	public static void main (String args[]){
		System.out.println("What's your name?");
		Scanner scanner = new Scanner(System.in);
		String greeting = scanner.nextLine();
		greetings(greeting);
		scanner.close();
		
		
		
	BinaryOperator <Double> sumUp = Double::sum;
	System.out.println(sumUp.apply(1.3, 2.3));
	
	 Consumer<Object> println = System.out::println;
	 println.accept("Hallo");

	}
	
	
}
