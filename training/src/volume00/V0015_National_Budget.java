package volume00;

/**
 * 国家予算
ある国の国家予算は 81 兆 7891 億もあります。このような大きな額の計算を行いたいと思うのですが、
プログラムで普通に使われている 32 ビットの符号付の整数では最大 21 億 4748 万 3647 までしか表すことが出来ません。

0 以上の整数を２つ入力し、その数の和を出力するプログラムを作成して下さい。
ただし、与えられた数やその和が 10 進数の正の整数で 80 桁を超える場合は、overflow と表示して下さい。

Input
複数のデータセットが与えられます。１行目にデータセットの数 N (1 ≤ N ≤ 50) が与えられます。
続いて N 個のデータセットが与えられます。各データセットは次のように２行から構成されています。

１つ目の数　（整数文字列）
２つ目の数　（整数文字列）
文字列の文字数は 100 を超えません。

Output
各データセットに対して、与えられた２つの和を一行に整数文字列として出力して下さい。

Sample Input
2
1000
800
9999999999999999999999999999999999999999
1
Output for the Sample Input
1800
10000000000000000000000000000000000000000
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class V0015_National_Budget {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;

		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			String s1 = reader.readLine();
			String s2 = reader.readLine();
			if (s1.length() > 80 && s2.length() > 80) {
				System.out.println("overflow");
			} else {
				BigInteger b1 = new BigInteger(s1);
				BigInteger b2 = new BigInteger(s2);
				String b = String.valueOf(b1.add(b2));
				System.out.println(b.length() > 80 ? "overflow" : b);
			}
		}
	}
}
