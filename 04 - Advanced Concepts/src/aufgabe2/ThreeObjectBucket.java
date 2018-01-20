package aufgabe2;

public class ThreeObjectBucket {
	Object[] objectarray = new Object[3];

	public void add(Object o) throws BucketFullException {
		for (int i = 0; i < 3; i++) {
			if (objectarray[i] == null) {
				objectarray[i] = o;
				System.out.println("Object added, toString(): " + o);
				return;
			}
		}
		throw new BucketFullException(
				"The Bucket is full! Remove entries before adding more new ones.");
	}

	public Object get(int index) {
		return objectarray[index];
	}

	public void remove(int index) {
		objectarray[index] = null;
	}

}