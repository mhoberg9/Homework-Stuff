package unchecked;

public class ThreeObjectBucket {
			Object [] objectarray = new Object[3];
			
			
			public void add(Object o) throws BucketFullleExeption{
				
				for(int i = 0; i < 3 ; i++){
					if(objectarray[i] == null){
						objectarray[i] = o;
						System.out.println("Object added");
						return;
					}
				}
				throw new BucketFullleExeption("Bucket is fulll");
			}
			public Object get(int index){
				return objectarray[index];
			}
			public void remove(int index){
				objectarray[index] = null;
				
			}


}


