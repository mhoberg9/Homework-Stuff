
public class CountUp extends Thread {
	private int counter;
	
	public CountUp(int counter){
		this.counter = counter;
	}
	public void run(){
		for(int i = 1; i <= counter ; i++){
			System.out.println("Current valie: " + i);
		}
	}
}

 
