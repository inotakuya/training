package introduction_to_Algorithms_and_Data_Structures;

/*
 * 最長共通部分列
最長共通部分列問題 (Longest Common Subsequence problem: LCS)は、
２つの与えられた列 X = \{x_1, x_2, ..., x_m\} と Y = \{y_1, y_2, ..., y_n\} の最長共通部分列を求める問題です。

ある列 Z が X と Y 両方の部分列であるとき、Z を X と Y の共通部分列と言います。
例えば、X = \{a,b,c,b,d,a,b\}, Y = \{b,d,c,a,b,a\} とすると、列 \{b,c,a\} は X と Y の共通部分列です。
一方、列 \{b,c,a\} は X と Y の最長共通部分列ではありません。なぜなら、その長さは 3 であり、
長さ 4 の共通部分列 \{b,c,b,a\} が存在するからです。長さが 5 以上の共通部分列が存在しないので、
列 \{b,c,b,a\} は X と Y の最長共通部分列の１つです。

与えられた２つの文字列 X、Yに対して、最長共通部分列 Z の長さを出力するプログラムを作成してください。
与えられる文字列は英文字のみで構成されています。

入力
複数のデータセットが与えられます。最初の行にデータセットの数 q が与えられます。続く 2 \times q 行にデータセットが与えられます。
各データセットでは２つの文字列 X, Y がそれぞれ１行に与えられます。

出力
各データセットについて X, Y の最長共通部分列 Z の長さを１行に出力してください。

制約
1 \leq q \leq 150
1 \leq X, Yの長さ \leq 1,000
X または Y の長さが 100 を超えるデータセットが含まれる場合、q は 20 以下である。
入力例 1
3
abcbdab
bdcaba
abc
abc
abc
bc
出力例 1
4
3
2
 */
import java.util.Scanner;

public class ALDS1_10_C_Longest_Common_Subsequence {
	public static void main(String[] args) {
		new ALDS1_10_C_Longest_Common_Subsequence().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while (n-- > 0) {
			String s1 = scanner.next();
			String s2 = scanner.next();
			System.out.println(lcs(s1, s2));
		}
	}

	private int lcs(String x, String y) {
		int max = Math.max(x.length(), y.length());
		int[][] c = new int[max + 1][max + 1];
		int m = x.length();
		int n = y.length();
		int maxl = 0;
		x = ' ' + x;
		y = ' ' + y;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i) == y.charAt(j)) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
				maxl = Math.max(maxl, c[i][j]);
			}
		}
		return maxl;
	}
}
