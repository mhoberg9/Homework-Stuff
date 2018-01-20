package Aufgabe7_wAITnotify;

import java.util.concurrent.BlockingQueue;
public class Producer extends Thread {

	BlockingQueue <String> queue;
	int producercounter = 0;
	public Producer(BlockingQueue <String> queue){
		this.queue = queue;
	}
	
	
	@Override
	public void run (){
		while(!Thread.currentThread().isInterrupted()){
			synchronized(queue){
			//String result = Math.random() <= 0.5 ? "Head": "Tails";
			if (Math.random() <= 0.5){
				queue.add("Head");
			} else { 
				queue.add("Tails");
			}
			producercounter++;
		
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				System.out.println("Pcounter:" + producercounter);
				Thread.currentThread().interrupt();
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}


	
}
