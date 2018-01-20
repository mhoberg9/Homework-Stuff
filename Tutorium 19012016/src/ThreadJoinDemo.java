import java.util.*;

public class ThreadJoinDemo {
	
	
	public static void main (String [] args) throws InterruptedException{
		System.out.println("Cunting up");
		Thread cu = new CountUp(100);
	
		cu.start();
		cu.join();
		
		System.out.println("Counting down");
		Thread cd = new CountingDown(100);
		
	
	
	}


	


		

}
