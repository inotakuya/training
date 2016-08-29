package introduction_to_Algorithms_and_Data_Structures;

/*
 * Partition
partition ( A, p, r )は、配列 A[ p..r ] を A[ p..q － 1] の各要素が A[q] 以下で、A[ q +1.. r ] の
各要素が A[ q ] より大きい A[ p..q － 1] と A[q + 1..r ] に分割し、インデックス q を戻り値として返します。

数列 A を読み込み、次の疑似コードに基づいた partition を行うプログラムを作成してください。

1 partition(A, p, r)
2   x = A[r]
3   i = p-1
4   for j = p to r-1
4     if A[j] <= x
5       i = i+1
6       A[i] と A[j] を交換
7   A[i+1] と A[r] を交換
8   return i+1
ここで、r は配列 A の最後の要素を指す添え字で、A[r] を基準として配列を分割することに注意してください。

入力
入力の最初の行に、数列 A の長さを表す整数 n が与えられます。２行目に、n 個の整数が空白区切りで与えられます。

出力
分割された数列を1行に出力してください。数列の連続する要素は１つの空白で区切って出力してください。
また、partition の基準となる要素を [   ]で示してください。

制約
1 \leq n \leq 100,000
0 \leq A_i \leq 100,000
入力例 1
12
13 19 9 5 12 8 7 4 21 2 6 11
出力例 1
9 5 8 7 4 2 6 [11] 21 13 19 12
 */
import java.util.Scanner;

public class ALDS1_06_B_Partition {
	long count = 0;

	public static void main(String[] args) {
		new ALDS1_06_B_Partition().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		int part = partition(A, 0, n - 1);
		for (int i = 0; i < n; i++) {
			if (part == i) {
				System.out.print("[" + A[i] + "]");
			} else {
				System.out.print(A[i]);
			}
			System.out.print(i == n - 1 ? "\n" : " ");
		}
	}

	private int partition(int[] a, int p, int r) {
		int work;
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] <= a[r]) {
				i++;
				work = a[i];
				a[i] = a[j];
				a[j] = work;
			}
		}
		work = a[i + 1];
		a[i + 1] = a[r];
		a[r] = work;
		return i + 1;
	}
}
