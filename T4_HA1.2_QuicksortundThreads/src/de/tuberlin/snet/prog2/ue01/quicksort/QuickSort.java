package de.tuberlin.snet.prog2.ue01.quicksort;

import java.util.LinkedList;

/**
 * itarative quicksort algorithm
 * 
 * @author prog2-team
 *
 */
public class QuickSort {

	/**
	 * internal class for ranges
	 */
	public static class QuickRange {
		public int left;
		public int right;

		public QuickRange(int left, int right) {
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return "[" + left + "," + right + "]";
		}
	}

	static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static int partition(int[] list, int left, int right) {
		int pivot = list[left + (right - left) / 2];
		while (list[left] < pivot) {
			left++;
		}
		while (list[right] > pivot) {
			right--;
		}
		if (left <= right) {
			swap(list, left, right);
			left++;
			right--;
		}

		return left;
	}

	private static void quickSort(int[] list, int left, int right) {
		LinkedList<QuickRange> rangeList = new LinkedList<QuickRange>();
		if (left >= right)
			return;

		rangeList.add(new QuickRange(left, right));

		while (true) {
			if (rangeList.size() == 0)
				break;
			left = rangeList.get(0).left;
			right = rangeList.get(0).right;
			rangeList.remove(0);

			int pivot = partition(list, left, right);
			;

			if (pivot - 1 > left) {
				rangeList.add(new QuickRange(left, pivot - 1));
			}

			if (pivot < right) {
				rangeList.add(new QuickRange(pivot, right));
			}
		}
	}

	public static void sort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static void main(String[] args) {
		int[] newList = { 5, 7, 23, 87, 11, 0, 5, 33, 30 };
		for (int i : newList) {
			System.out.print(i + " ");
		}
		System.out.println();
		sort(newList);
		for (int i : newList) {
			System.out.print(i + " ");
		}
		
		sortMultithreaded1(newList);
	}
	
	/**
	 * Separating array into two and starts Thread
	 * @param arr2
	 */

	public static void sortMultithreaded1(int[] arr2) {

		partition(arr2, 0, arr2.length - 1);
		int pivot = partition(arr2, 0, arr2.length - 1);

		int[] array1 = new int[pivot];
		int[] array2 = new int[(arr2.length - array1.length)];

		for (int i = 0; i < pivot; i++) {
			array1[i] = arr2[i];
		}

		for (int h = pivot; h < arr2.length; h++) {
			array2[h - pivot] = arr2[h];
		}

		Thread b = new BelowThread(array1);
		b.start();

		Thread t = new AboveThread(array2);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
