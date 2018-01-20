package AC_Aufgabe2_CheckedExceptions;

public class starter {
	
	public static void main (String [] args){
		ThreeObjectBucket tob = new ThreeObjectBucket ();
		try {
			
			tob.add("a");
			tob.add(1);
			tob.add("l");
			tob.add(3);
			tob.add("%");
		} catch (BucketFullException e) {
			e.printStackTrace();
		}
	
			
			
		
		
		
	}

}
