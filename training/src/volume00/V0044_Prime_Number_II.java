package volume00;

/**
 * 素数 II
素数というのは、1 よりも大きくそれ自身か 1 でしか割りきれない整数をいいます。
例えば、2 は、2 と 1 でしか割り切れないので素数ですが、12 は、12 と 1 のほかに、2, 3, 4, 6 で割りきれる数なので素数ではありません。

整数 n を入力したとき、n より小さい素数のうち最も大きいものと、n より大きい素数のうち最も小さいものを出力するプログラムを作成してください。

Input
複数のデータセットが与えられます。各データセットに n (3 ≤ n ≤ 50,000) が１行に与えられます。

データセットの数は 50 を超えません。

Output
各データセットに対して、n より小さい素数のうち最大のものと、n より大きい素数のうち最小のものを１つのスペースで区切って１行に出力して下さい。

Sample Input
19
3517
Output for the Sample Input
17 23
3511 3527
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0044_Prime_Number_II {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			int a = Integer.parseInt(line);
			int[] num = new int[25];
			int max = 51000;
			int min = 0;
			int m = a - 72 < 2 ? 2 : a - 72;
			for (int i = m; i < a + 72; i++) {
				if (isPrime(i))
					if (i < a) {
						min = Math.max(min, i);
					} else if (i > a) {
						max = Math.min(max, i);
					}
			}
			builder.append(min).append(' ').append(max).append('\n');

		}
		System.out.print(builder);
	}

	private static boolean isPrime(int a) {
		if (a == 2)
			return true;
		if (a % 2 == 0)
			return false;
		if (a < 8)
			return true;
		if (a % 3 == 0)
			return false;
		for (int i = 5; a >= i * i; i += 6) {
			if (a % i == 0)
				return false;
			if (a % (i + 2) == 0)
				return false;
		}

		return true;
	}
}
