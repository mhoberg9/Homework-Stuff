package unchecked;

public class CheckedExeption {
	public static void main (String []args){
		ThreeObjectBucket ob = new ThreeObjectBucket();
		
		try{
			ob.add("jeööp");
			ob.add(123);
			
			ob.remove(1);
			ob.add(12);
			
		}catch (BucketFullleExeption e){
			System.out.println(e.getMessage());
		}
	}
}
