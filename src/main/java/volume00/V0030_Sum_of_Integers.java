package volume00;

/**
 * 整数の和
0 から 9 の数字から異なる n 個の数を取り出して合計が s となる組み合わせの数を出力するプログラムを作成してください。
n 個の数はおのおの 0 から 9 までとし、１つの組み合わせに同じ数字は使えません。たとえば、
n が 3 で s が 6 のとき、3 個の数字の合計が 6 になる組み合わせは、

1 + 2 + 3 = 6
0 + 1 + 5 = 6
0 + 2 + 4 = 6

の 3 通りとなります。

Input
複数のデータセットが与えられます。各データセットに n (1 ≤ n ≤ 9) と s (0 ≤ s ≤ 100) が１つのスペースで区切られて１行に与えられます。
n と s が共に 0 のとき入力の最後とします（この場合は処理せずにプログラムを終了する）。

データセットの数は 50 を超えません。

Output
各データセットに対して、n 個の整数の和が s になる組み合わせの数を１行に出力して下さい。

Sample Input
3 6
3 1
0 0
Output for the Sample Input
3
0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class V0030_Sum_of_Integers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		while (true) {
			String line = reader.readLine();
			if (line.equals("0 0")) {
				break;
			}
			StringTokenizer tokenizer = new StringTokenizer(line);
			int n = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());

			Map<int[], Integer> memo = new HashMap<int[], Integer>();
			memo.put(new int[0], 0);
			int count = 0;
			for (int i = 0; i < 10; i++) {
				Map<int[], Integer> memotmp = new HashMap<int[], Integer>();
				memotmp.putAll(memo);

				for (Entry<int[], Integer> entry : memo.entrySet()) {
					if (entry.getKey().length == n || entry.getValue() + i > s) {
						continue;
					}
					int[] nearray = Arrays.copyOf(entry.getKey(), entry.getKey().length + 1);
					nearray[nearray.length - 1] = i;
					int sum = entry.getValue() + i;

					memotmp.put(nearray, sum);
					if (nearray.length == n && sum == s) {
						count++;
					}

				}
				memo = memotmp;
			}
			/*
			 * memo.entrySet().forEach( l ->
			 * System.out.println(Arrays.toString(l.getKey()) + " -> " +
			 * l.getValue()));
			 */
			System.out.println(count);
		}
	}
}
