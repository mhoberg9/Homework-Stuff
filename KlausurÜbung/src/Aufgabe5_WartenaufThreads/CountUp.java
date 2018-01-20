package Aufgabe5_WartenaufThreads;

public class CountUp extends Thread{
	
	int limit;
	
	public CountUp(int limit){
		this.limit = limit;
	}

	public void run(){
		
		//while(!Thread.currentThread().isInterrupted()){
			
			for(int i = 1 ; i <= limit ; i++){
				System.out.println(i);
			}
		//}
		
		
	}
}
