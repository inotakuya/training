package introduction_to_Algorithms_and_Data_Structures;

import java.util.Scanner;

public class ALDS1_05_B_Merge_Sort {
	int count = 0;

	public static void main(String[] args) {
		new ALDS1_05_B_Merge_Sort().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
		}
		mergeSort(num, 0, n);
		System.out.print(num[0]);
		for (int i = 1; i < n; i++) {
			System.out.print(" " + num[i]);
		}
		System.out.println();
		System.out.println(count);
	}

	private void mergeSort(int[] num, int left, int right) {
		if (left + 1 < right) {
			int mid = (left + right) / 2;
			mergeSort(num, left, mid);
			mergeSort(num, mid, right);
			merge(num, left, mid, right);
		}
	}

	private void merge(int[] num, int left, int mid, int right) {
		int n1 = mid - left;
		int n2 = right - mid;
		int[] l = new int[n1 + 1];
		int[] r = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			l[i] = num[left + i];
		}
		for (int i = 0; i < n2; i++) {
			r[i] = num[mid + i];
		}
		l[n1] = Integer.MAX_VALUE;
		r[n2] = Integer.MAX_VALUE;

		int L = 0;
		int R = 0;
		for (int k = left; k < right; k++) {
			if (l[L] <= r[R]) {
				num[k] = l[L++];
			} else {
				num[k] = r[R++];
			}
			count++;
		}
	}
}
