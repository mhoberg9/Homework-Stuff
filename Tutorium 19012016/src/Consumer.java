import java.util.concurrent.*;
public class Consumer extends Thread{
	private BlockingQueue<String> q;
	private int heads = 0;
	private int tails = 0;
	
	public void run() {
		while (!(Thread.currentThread().isInterrupted())){
			String s = q.poll();
			if (s != null){
				System.out.println(s);
			}if (s.equals("heads")){
				heads++;
			}else{
				tails++;
			}
			double  ergebnis = Math.round(heads/(heads+tails)*100)/100.0;
			System.out.println("Relative Häufigkeit von Kopf: " + ergebnis);
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			this.interrupt();
		}
		}
	}
	
	public void setQ(BlockingQueue<String>q){
		this.q = q;
	}
	
	
}
