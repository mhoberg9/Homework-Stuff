
public class CountingDown extends Thread{
	private int counter;
	
	public CountingDown(int counter){
		this.counter = counter;
	}
	public void run(){
		for(int i = counter ; i > 0; i--){
			System.out.println("Current value: " + i);
		}
	}
	
}
