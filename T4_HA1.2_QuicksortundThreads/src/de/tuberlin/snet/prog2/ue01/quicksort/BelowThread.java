package de.tuberlin.snet.prog2.ue01.quicksort;

import java.util.LinkedList;

/**
 * Starts to sort the array
 * @author Malte
 *
 */

public class BelowThread extends Thread {

	int[] array2;

	public BelowThread(int[] array2) {
		this.array2 = array2;
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

		quickSort(array2, 0, array2.length - 1);

		 for (int i : array2){
		 System.out.print(i);
		 }
	}

}
