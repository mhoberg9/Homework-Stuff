package AD_Aufgabe1_SorlectionSort;

public class SortAlgrorithmus {

	public static void main(String[] args) {

//		int i = 0;
//		while (i < 5){
//			System.out.println("1/i =" + (1/i++));
//			i -= 1;
//		}
		
		
		int [] array = {3,7,6,2,8,1,10,11,15,17,71,89,0};
		int [] sorted = swap(array);
		for(int c = 0; c < sorted.length; c++){
		System.out.println(sorted[c]);
		}
	}
	

	public static int [] swap(int[] array) {
		
		for (int i = 0 ; i < array.length; i++){
			for (int j = 0 ; j < array.length-1; j++){
				if (array[j] > array[j+1]){
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					}
				}
		
		
			
		}
		return array;}
	
	public static int [] insertsort(int [] array){
		
		int [] insertsort = new int[array.length];
		
		for (int i = 0; i < array.length; i++){
			if (insertsort[i] > array[i]){
				insertsort[i+1] = array[i];
			}
			else if (insertsort[i] < array[i]){
				int temp = insertsort[i];
				insertsort[i] = array[i];
				insertsort[i+1] = temp;
			}
		}
		
		
		return insertsort;
		
	}
	
		
		

	}


