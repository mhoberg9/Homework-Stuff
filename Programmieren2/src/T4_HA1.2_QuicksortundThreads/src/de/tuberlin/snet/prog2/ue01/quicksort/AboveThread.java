package de.tuberlin.snet.prog2.ue01.quicksort;

import java.util.LinkedList;

public class AboveThread extends Thread {

	/**
	 * Starts to sort the array
	 * @author Malte
	 */
	
	int[] array1;

	public AboveThread(int[] array1) {
		this.array1 = array1;
	}

	private static class QuickRange {
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

			if (pivot - 1 > left) {
				rangeList.add(new QuickRange(left, pivot - 1));
			}

			if (pivot < right) {
				rangeList.add(new QuickRange(pivot, right));
			}
		}
	}

	@Override
	public synchronized void run() {
		quickSort(array1, 0, array1.length - 1);

		 for (int i : array1){
		 System.out.print(i);
		 }
	}

}
