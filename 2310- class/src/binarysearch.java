
public class binarysearch {
	public static void main (String [] args) {
		int [] array = {1,2,3,4,5,6};
		search(array, 0, array.length -1,5 );
	}
	public static void search (int [] array, int anfang , int ende, int zahl){
		int grenzen = anfang + ((ende -anfang) /2);
		
		if (array.length == 0){
			System.out.println("array leer");
			return;
		}
		if (grenzen > array.length){
			System.out.println("außerhalb des arrays");
			return;
		}
		if (zahl > array[grenzen]){
			search (array, grenzen+1, ende, zahl);
			
		}
		else if (zahl < array[grenzen]){
			search (array, anfang, grenzen -1 , zahl);
		
		}
		else if (zahl == array[grenzen]){
			System.out.println("Zahl gefunden and position: " + grenzen);
		}else{
			System.out.println("nict enthalten");
		}
			
	}
	
	
}
