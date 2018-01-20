import java.util.concurrent.*;
public class Producer extends Thread {
	
	private BlockingQueue <String> q;
	public void run(){
		while(!Thread.currentThread().isInterrupted()){
			double randomNumber = Math.random();
			String result = randomNumber >= 0.5? "Heads" : "Tails";
			
			//if (randomNumber >=0.5){
			// result = "Head";
			// }else{
			//	result = "Tails";
			
			q.add(result);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e){
				this.interrupt();
			}
		}
	}
	
	public void setQ(BlockingQueue<String> q){
		this.q = q;
	}
	
	
}
