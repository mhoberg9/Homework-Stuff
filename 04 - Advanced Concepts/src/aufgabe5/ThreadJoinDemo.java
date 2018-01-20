package aufgabe5;

public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Counting up");
		Thread cu = new CountUp(100);
		cu.start();
		cu.join();
		
		System.out.println("Counting down");
		Thread cd = new CountDown(100);
		cd.start();
		cd.join();
		
		System.out.println("Done.");

	}

}
