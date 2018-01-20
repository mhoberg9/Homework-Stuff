
/**
 * This class is used to represent a Thread with java8.
 * @author Malte
 *
 */

public class Lambda {
	public static void main (String [] args){
	Runnable runnableOutput =  ()->
			{System.out.println("This Thread is running with Runnable Interface in JDK8 format");};
			Thread t = new Thread (runnableOutput);
			t.start();
			
	}

}