package volume00;

/**
 * 最大公約数と最小公倍数
正の整数 a,b を入力し、a と b の最大公約数と最小公倍数を出力するプログラムを作成して下さい。

Input
複数のデータセットが与えられます。各データセットは１行に a と b が１つのスペースで区切られて与えられます。入力の最後まで処理して下さい。

Constraints
0 < a,b ≤ 2,000,000,000
a と b の最小公倍数は 2,000,000,000 を超えない。
データセットの数は 50 を超えない。
Output
各データセットに対して、最大公約数と最小公倍数を１つのスペースで区切って１行に出力して下さい。

Sample Input
8 6
50000000 30000000
Output for the Sample Input
2 24
10000000 150000000
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0005_GCD_and_LCM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer to;
		String s;
		while ((s = reader.readLine()) != null) {
			to = new StringTokenizer(s);
			int a = Integer.parseInt(to.nextToken());
			int b = Integer.parseInt(to.nextToken());
			int GCD = getGCD(a, b);
			int LCM = getLCM(a, b, GCD);
			builder.append(GCD).append(' ').append(LCM).append('\n');

		}
		System.out.print(builder);
	}

	public static int getGCD(int a, int b) {
		int tmp;
		if (a > b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		while (a != 0) {
			tmp = a;
			a = b % a;
			b = tmp;
		}
		return b;
	}

	public static int getLCM(int a, int b, int GCD) {
		return a / GCD * b;
	}
}
