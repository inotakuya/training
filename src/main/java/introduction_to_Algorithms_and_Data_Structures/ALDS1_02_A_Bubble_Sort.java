package introduction_to_Algorithms_and_Data_Structures;

/*
 * バブルソート
バブルソートはその名前が表すように、泡（Bubble）が水面に上がっていくように配列の要素が動いていきます。
バブルソートは次のようなアルゴリズムで数列を昇順に並び変えます。

1 bubbleSort(A, N) // N 個の要素を含む 0-オリジンの配列 A
2   flag = 1 // 逆の隣接要素が存在する
3   while flag
4     flag = 0
5     for j が N-1 から 1 まで
6       if A[j] < A[j-1]
7         A[j] と A[j-1] を交換
8         flag = 1
数列 A を読み込み、バブルソートで昇順に並び変え出力するプログラムを作成してください。また、バブルソートで行われた要素の交換回数も報告してください。

入力
入力の最初の行に、数列の長さを表す整数 N が与えられます。２行目に、N 個の整数が空白区切りで与えられます。

出力
出力は 2 行からなります。１行目に整列された数列を 1 行に出力してください。数列の連続する要素は１つの空白で区切って出力してください。
2 行目に交換回数を出力してください。

制約
1 ≤ N ≤ 100
0 ≤ A の要素 ≤ 100
入力例 1
5
5 3 2 4 1
出力例 1
1 2 3 4 5
8

入力例 2
6
5 2 4 6 1 3
出力例 2
1 2 3 4 5 6
9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALDS1_02_A_Bubble_Sort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] s = reader.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j >= i + 1; j--) {
				if (a[j] < a[j - 1]) {
					sum++;
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int k = 0; k < n; k++) {
			if (k > 0)
				builder.append(" ");
			builder.append(a[k]);
		}
		builder.append("\n").append(sum);
		System.out.println(builder);

	}
}
