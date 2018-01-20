package Aufgabe5_WartenaufThreads;

public class Demo {
	
	public static void main(String [] args){
		int limit = 100;
		CountDown t = new CountDown(limit);
		CountUp u = new CountUp(limit);
		
		t.start();
		try {
			t.join();
			u.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
