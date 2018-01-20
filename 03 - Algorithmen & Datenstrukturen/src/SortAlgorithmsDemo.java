import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortAlgorithmsDemo {

	public static void main(String[] args) {
		
		// Test selectionSort
		int[] selectionArray = { 1, 4, 5, 2, 7, 3, 2, 9 };
		selectionArray = shuffle(selectionArray);
		System.out.println("Pre applying selectionSort" + Arrays.toString(selectionArray));
		SortAlgorithms.selectionSort(selectionArray);
		System.out.println("Post applying selectionSort" + Arrays.toString(selectionArray));
		
		// Test insertionSort
		int[] insertionArray = { 1, 4, 5, 2, 7, 3, 2, 9 };
		
		insertionArray = shuffle(insertionArray);
		System.out.println("Pre applying insertionSort" + Arrays.toString(insertionArray));
		SortAlgorithms.insertionSort(insertionArray);
		System.out.println("Post applying insertionSort" + Arrays.toString(insertionArray));
	}

	public static int[] shuffle(int[] array){

		List<Integer>  list = new ArrayList<>(array.length);
		for(int x : array){
			list.add(x);
		}
		
		Collections.shuffle(list);
		
		array = new int[list.size()];
		int i = 0;
		for(int l:list){
			array[i++] = l;
		}
		
		return array;
	}
	
}
