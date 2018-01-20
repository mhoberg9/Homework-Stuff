package Aufgabe7_wAITnotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
	
	BlockingQueue <String> queue;
	int count = 0;
	int consumercounter = 0;

	public Consumer (BlockingQueue <String> queue){
		this.queue = queue;
	}
	@Override
	public void run (){
		while(!Thread.currentThread().isInterrupted()){
			synchronized(queue){
//			for (String i : queue){
//				if (i.equals("Head))
//			}
			if (queue.poll().equals("Head")){
				count++;
			}
			System.out.println(count);
			
		}
			consumercounter++;
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				System.out.println("Ccounter:" +consumercounter);
				e.printStackTrace();
			}
		}
		
	}

	
	
}
