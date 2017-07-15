package introduction_to_Algorithms_and_Data_Structures;

/*
 *安定なソート
トランプのカードを整列しましょう。ここでは、４つの絵柄(S, H, C, D)と９つの数字(1, 2, ..., 9)から構成される計 36 枚のカードを用います。
例えば、ハートの 8 は"H8"、ダイヤの 1 は"D1"と表します。

バブルソート及び選択ソートのアルゴリズムを用いて、与えられた N 枚のカードをそれらの数字を基準に昇順に整列するプログラムを作成してください。
アルゴリズムはそれぞれ以下に示す疑似コードに従うものとします。数列の要素は 0 オリジンで記述されています。

1 BubbleSort(C, N)
2   for i = 0 to N-1
3     for j = N-1 downto i+1
4       if C[j].value < C[j-1].value
5         C[j] と C[j-1] を交換
6
7 SelectionSort(C, N)
8   for i = 0 to N-1
9     minj = i
10    for j = i to N-1
11      if C[j].value < C[minj].value
12        minj = j
13    C[i] と C[minj] を交換
また、各アルゴリズムについて、与えられた入力に対して安定な出力を行っているか報告してください。
ここでは、同じ数字を持つカードが複数ある場合それらが入力に出現する順序で出力されることを、「安定な出力」と呼ぶことにします。
（※常に安定な出力を行うソートのアルゴリズムを安定なソートアルゴリズムと言います。）

入力
1 行目にカードの枚数 N が与えられます。 2 行目に N 枚のカードが与えられます。各カードは絵柄と数字のペアを表す２文字であり、
隣合うカードは１つの空白で区切られています。

出力
1 行目に、バブルソートによって整列されたカードを順番に出力してください。隣合うカードは１つの空白で区切ってください。
2 行目に、この出力が安定か否か（Stable またはNot stable）を出力してください。
3 行目に、選択ソートによって整列されたカードを順番に出力してください。隣合うカードは１つの空白で区切ってください。
4 行目に、この出力が安定か否か（Stable またはNot stable）を出力してください。

制約
1 ≤ N ≤ 36
入力例 1
5
H4 C9 S4 D2 C3
出力例 1
D2 C3 H4 S4 C9
Stable
D2 C3 S4 H4 C9
Not stable
入力例 2
2
S1 H1
出力例 2
S1 H1
Stable
S1 H1
Stable
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ALDS1_02_C_Stable_Sort {
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] a = reader.readLine().split(" ");

		String[] b = Arrays.copyOf(a, a.length);
		bubble(a, n);
		append(a, n);
		builder.append("Stable\n");
		selection(b, n);
		append(b, n);
		builder.append(Arrays.equals(a, b) ? "Stable\n" : "Not stable\n");
		System.out.print(builder);
	}

	public static void selection(String[] a, int n) {

		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i + 1; j < n; j++) {
				if (toInt(a, j) < toInt(a, minj)) {
					minj = j;
				}

			}
			if (i != minj) {
				String tmp = a[i];
				a[i] = a[minj];
				a[minj] = tmp;
			}
		}
	}

	public static void bubble(String[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j >= i + 1; j--) {
				if (toInt(a, j) < toInt(a, j - 1)) {
					String temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}

	public static int toInt(String[] a, int j) {
		return a[j].charAt(1);
	}

	public static void append(String[] a, int n) {
		for (int k = 0; k < n; k++) {
			if (k > 0)
				builder.append(" ");
			builder.append(a[k]);
		}
		builder.append("\n");
	}
}
