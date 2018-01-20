package aufgabe2;

public class CheckedException {
	
	public static void main(String[] args){
		ThreeObjectBucket ob = new ThreeObjectBucket();
		try{
		ob.add("Hello");
		ob.add(new Object());
		ob.add("Hossa");
		ob.remove(1);
		ob.add("Yes");
		ob.add("No");
		}catch(BucketFullException e){
			System.out.println(e.getMessage());
		}
		
	}
}

