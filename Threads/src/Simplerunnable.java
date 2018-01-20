
public class Simplerunnable  implements Runnable{
	@Override
	public void run (){
		
		
		while(!Thread.currentThread().isInterrupted()){
			
		
		System.out.println("Im a simplerunnable");
		
		try{
			Thread.sleep(100);
			
		}catch (InterruptedException e){
			System.out.println("Simplerunnable interruped");
			Thread.currentThread().interrupt();
		}
		
		
		}
		}
	
}
