
public class SortAlgorithms {

	public static void selectionSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int index = indexOfSmallestAbove(array, i);
			swap(array, i, index);
		}

	}

	public static void insertionSort(int[] array) {
		int[] copy = array.clone();

		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		for (int i = 0; i < copy.length; i++) {
			insert(array, copy[i]);
		}
	}

	private static void insert(int[] array, int value) {
		int i = 0;
		while ((array[i] != 0) & (value > array[i]) & (i < array.length - 1)) {
			i++;
		}
		shiftRightIncluding(array, i);
		array[i] = value;
	}

	private static void shiftRightIncluding(int[] array, int i) {
		for (int j = array.length - 1; j > i; j--) {
			swap(array, j, j - 1);
		}

	}

	private static int indexOfSmallestAbove(int[] array, int position) {
		int index = position;
		int smallest = array[position];
		for (int i = position; i < array.length; i++) {
			if (array[i] < smallest) {
				smallest = array[i];
				index = i;
			}
		}
		return index;

	}

	private static void swap(int[] array, int a, int b) {
		int helper = array[a];
		array[a] = array[b];
		array[b] = helper;
	}

}
