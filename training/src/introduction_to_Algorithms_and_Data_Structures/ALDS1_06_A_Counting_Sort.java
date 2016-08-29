package introduction_to_Algorithms_and_Data_Structures;

/*
 * 計数ソート
計数ソートは各要素が 0 以上 k 以下である要素数 n の数列に対して線形時間(O(n + k))で動く安定なソーティングアルゴリズムです。

入力数列 A の各要素 A_j について、A_j 以下の要素の数をカウンタ配列 C に記録し、その値を基に出力配列 B における A_j の位置を求めます。
同じ数の要素が複数ある場合を考慮して、要素 A_j を出力（B に入れる）した後にカウンタ C[A_j] は修正する必要があります。
詳しくは以下の疑似コードを参考にしてください。

1 CountingSort(A, B, k)
2     for i = 0 to k
3         C[i] = 0
4
5     /* C[i] に i の出現数を記録する 
6     for j = 1 to n
7         C[A[j]]++
8
9     /* C[i] に i 以下の数の出現数を記録する
10    for i = 1 to k
11        C[i] = C[i] + C[i-1]
12
13    for j = n downto 1
14        B[C[A[j]]] = A[j]
15        C[A[j]]--
数列 A を読み込み、計数ソートのアルゴリズムで昇順に並び替え出力するプログラムを作成してください。上記疑似コードに従ってアルゴリズムを実装してください。

入力
入力の最初の行に、数列 A の長さを表す整数 n が与えられます。２行目に、n 個の整数が空白区切りで与えられます。

出力
整列された数列を1行に出力してください。数列の連続する要素は１つの空白で区切って出力してください。

制約
1 \leq n \leq 2,000,000
0 \leq A[i] \leq 10,000
入力例 1
7
2 5 1 3 2 3 0
出力例 1
0 1 2 2 3 3 5
 */
import java.util.Scanner;

public class ALDS1_06_A_Counting_Sort {
	long count = 0;

	public static void main(String[] args) {
		new ALDS1_06_A_Counting_Sort().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		StringBuilder builder = new StringBuilder();
		int[] A = new int[n];
		int[] B = new int[n];
		int K = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			K = Math.max(K, A[i]);
		}
		CountingSort(A, B, K);
		builder.append(B[0]);
		for (int i = 1; i < n; i++) {
			builder.append(' ').append(B[i]);
		}
		System.out.println(builder);
	}

	private void CountingSort(int[] a, int[] b, int k) {
		int[] C = new int[k + 1];
		for (int i = 0; i < a.length; i++)
			C[a[i]]++;

		for (int i = 1; i <= k; i++)
			C[i] += C[i - 1];

		for (int i = a.length - 1; i >= 0; i--) {
			C[a[i]]--;
			b[C[a[i]]] = a[i];

		}
	}
}
