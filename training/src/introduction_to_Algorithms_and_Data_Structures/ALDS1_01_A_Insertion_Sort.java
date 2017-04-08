package introduction_to_Algorithms_and_Data_Structures;

/*
挿入ソート
挿入ソート（Insertion Sort）は、手持ちのトランプを並び替えるときに使われる、自然で思い付きやすいアルゴリズムの１つです。
片手に持ったトランプを左から小さい順に並べる場合、１枚ずつカードを取り出して、それをその時点ですでにソートされている並びの適切な位置に
挿入していくことによって、カードを並べ替えることができます。

挿入ソートは次のようなアルゴリズムになります。

1 insertionSort(A, N) // N個の要素を含む0-オリジンの配列A
2   for i が 1 から N-1 まで
3     v = A[i]
4     j = i - 1
5     while j >= 0 かつ A[j] > v
6       A[j+1] = A[j]
7       j--
8     A[j+1] = v
N 個の要素を含む数列 A を昇順に並び替える挿入ソートのプログラムを作成してください。上の疑似コードに従いアルゴリズムを実装してください。
アルゴリズムの動作を確認するため、各計算ステップでの配列（入力直後の並びと、各 i の処理が終了した直後の並び）を出力してください。

入力
入力の最初の行に、数列の長さを表す整数 N が与えられます。2 行目に、N 個の整数が空白区切りで与えられます。

出力
出力は N 行からなります。挿入ソートの各計算ステップでの途中結果を 1 行に出力してください。配列の要素は１つの空白で区切って出力してください
。最後の要素の後の空白など、余計な空白や改行を含めると Presentation Error となりますので注意してください。

制約
1 ≤ N ≤ 100
0 ≤ A の要素 ≤ 1,000
入力例 1
6
5 2 4 6 1 3
入力例 1 に対する出力
5 2 4 6 1 3
2 5 4 6 1 3
2 4 5 6 1 3
2 4 5 6 1 3
1 2 4 5 6 3
1 2 3 4 5 6
入力例 2
3
1 2 3
入力例 2 に対する出力
1 2 3
1 2 3
1 2 3
 */
import java.util.Scanner;

public class ALDS1_01_A_Insertion_Sort {
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = scanner.nextInt();

		trace(A, n);

		for (int i = 1; i < n; i++) {
			int v = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > v) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = v;
			trace(A, n);
		}
		System.out.print(builder);
	}

	private static void trace(int[] A, int n) {
		for (int i = 0; i < n; i++) {
			if (i > 0)
				builder.append(" ");
			builder.append(A[i]);
		}
		builder.append("\n");
	}
}