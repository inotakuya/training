package introduction_to_Algorithms_and_Data_Structures;

/*
 * 反転数

数列 A = \{a_0, a_1, ... a_{n-1}\} について、a_i > a_j かつ i < j である組 (i, j) の個数を反転数と言います。
反転数は次のバブルソートの交換回数と等しくなります。

bubbleSort(A)
  cnt = 0 // 反転数
  for i = 0 to A.length-1
    for j = A.length-1 downto i+1
      if A[j] < A[j-1]
	swap(A[j], A[j-1])
	cnt++

  return cnt
数列 A が与えられるので、A の反転数を求めてください。上の疑似コードのアルゴリズムをそのまま実装すると
Time Limit Exceeded になることに注意してください。

入力
１行目に数列 A の長さ n が与えられます。２行目に a_i (i = 0, 1, .. n-1) が空白区切りで与えられます。

出力
反転数を１行に出力してください。

制約
1 \leq n \leq 200,000
0 \leq a_i \leq 10^9
a_i はすべて異なる値である
入力例 1
5
3 5 2 1 4
出力例 1
6
入力例 2
3
3 1 2
出力例 2
2
 */
import java.util.Scanner;

public class ALDS1_05_D_The_Number_of_Inversions {
	long count = 0;

	public static void main(String[] args) {
		new ALDS1_05_D_The_Number_of_Inversions().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
		}
		mergeSort(num, 0, n);
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
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			L[i] = num[left + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = num[mid + i];
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int l = 0;
		int r = 0;
		for (int k = left; k < right; k++) {
			if (L[l] < R[r]) {
				num[k] = L[l++];
				count += r;
			} else {
				num[k] = R[r++];
			}
		}

	}
}
