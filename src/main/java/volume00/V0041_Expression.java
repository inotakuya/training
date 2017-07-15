package volume00;

/**
 * 式
与えられた 4 つの 1 から 9 の整数を使って、答えが 10 になる式をつくります。 4 つの整数 a,b,c,d を入力したとき、
下記の条件に従い、答えが 10 になる式を出力するプログラムを作成してください。また、答えが複数ある時は
、最初に見つかった答えだけを出力するものとします。答えがない時は、0 と出力してください。

演算子として、加算 (+)、減算 (-)、乗算 (*) だけを使います。除算 (/) は使いません。使用できる演算子は３個です。
数を4つとも使わなければいけません。
4つの数の順番は自由に入れ換えてかまいません。
カッコを使ってもかまいません。使用できるカッコは３組（６個）以下です。
Input
複数のデータセットが与えられます。各データセットの形式は以下のとおり：

a b c d
入力は４つの 0 で終了します。データセットの数は 40 を超えません。

Output
各データセットについて、与えられた 4 つの整数と上記の演算記号およびカッコを組み合わせて値が 10 となる式または 0 を
１行に出力してください。式の文字列が 1024 文字を超えてはいけません。

Sample Input
8 7 9 9
4 4 4 4
5 5 7 5
0 0 0 0
Output for the Sample Input
((9 * (9 - 7)) - 8)
0
((7 * 5) - (5 * 5))
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0041_Expression {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		while (true) {
			String line = reader.readLine();
			if (line.equals("0 0 0 0")) {
				break;
			}
			int[] num = new int[4];
			StringTokenizer tokenizer = new StringTokenizer(line);
			for (int i = 0; i < 4; i++) {
				num[i] = Integer.parseInt(tokenizer.nextToken());
			}
			boolean flag = false;
			loop: for (int i = 0; i < 4; i++) {
				for (int j = i + 1; j < i + 4; j++) {
					for (int k = 0; k < 4; k++) {
						if (i == k || j % 4 == k) {
							continue;
						}
						for (int l = 0; l < 1; l++) {
							if (check(num[i], num[j % 4], num[k], num[6 - (i + j % 4 + k)])) {
								flag = true;
								break loop;
							}
						}
					}

				}
			}
			if (!flag) {
				System.out.println(0);
			}
		}

	}

	private static boolean check(int a, int b, int c, int d) {
		char[] chs = { '+', '-', '*' };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (cal(cal(cal(a, chs[i], b), chs[j], c), chs[k], d) == 10) {
						System.out.println(
								String.format("(((%d %s %d) %s %d) %s %d)", a, chs[i], b, chs[j], c, chs[k], d));
						return true;
					} else if (cal(cal(a, chs[i], b), chs[j], cal(c, chs[k], d)) == 10) {
						System.out.println(
								String.format("((%d %s %d) %s (%d %s %d))", a, chs[i], b, chs[j], c, chs[k], d));
						return true;
					}
				}
			}
		}
		return false;
	}

	private static int cal(int a, char c, int b) {
		switch (c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		default:
			return a * b;
		}
	}
}
