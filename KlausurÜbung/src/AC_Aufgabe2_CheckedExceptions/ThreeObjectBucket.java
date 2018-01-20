package AC_Aufgabe2_CheckedExceptions;

public class ThreeObjectBucket {

	Object[] oarray = new Object[3];
	

	public Object add(Object o) throws BucketFullException {
		for (int i = 0; i < oarray.length; i++) {
			
				if (oarray[i] == null) {
					oarray[i] = o;
					System.out.println("added: " + o);
					return oarray;
				
				}
			
			
		}
		throw new BucketFullException("BUCKET FULL");

	
	}

	public Object find(int index) {
		return oarray[index];
	}

	public Object delete(int index) {

		oarray[index] = null;
		return oarray;
	}

}
