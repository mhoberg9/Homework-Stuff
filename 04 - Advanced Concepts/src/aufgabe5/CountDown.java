package aufgabe5;

public class CountDown extends Thread {

	private int counter;
	
	public CountDown(int counter){
		this.counter = counter;
	}

	public void run() {

		for (int i = counter; i > 0; i--) {
			System.out.println("current value: " + i);
		}
	}

}
