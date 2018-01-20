package Aufgabe5_WartenaufThreads;

public class CountDown extends Thread{

	int limit;
	
	public CountDown(int limit){
		this.limit = limit;
		
	}
	
	@Override
	public void run() {
//		try {
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//while(!Thread.currentThread().isInterrupted()){
		//int i = limit;
			for (int i = limit; i >= 1 ; i--){
				System.out.println(i);
			}
		}
		
	//}
	
	

}
