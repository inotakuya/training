package volume00;

/**
 * 泥棒
宝物がたくさん収蔵されている博物館に、泥棒が大きな風呂敷を一つだけ持って忍び込みました。
盗み出したいものはたくさんありますが、風呂敷が耐えられる重さが限られており、これを超えると風呂敷が破れてしまいます。
そこで泥棒は、用意した風呂敷を破らず且つ最も価値が高くなるようなお宝の組み合わせを考えなくてはなりません。

風呂敷が耐えられる重さ W、および博物館にある個々のお宝の価値と重さを読み込んで、
重さの総和が W を超えない範囲で価値の総和が最大になるときの、お宝の価値総和と重さの総和を出力するプログラムを作成してください。
ただし、価値の総和が最大になる組み合わせが複数あるときは、重さの総和が小さいものを出力することとします。

Input
複数のデータセットが与えられます。各データセットは以下のような形式で与えられます。

W
N
v1,w1
v2,w2
:
vN,wN
１行目に風呂敷の耐えられる重さを表す整数 W (W ≤ 1,000)、２行目にお宝の数 N (1 ≤ N ≤ 1,000) が与えられます。
続く N 行に i 番目のお宝の価値を表す整数 vi (0 ≤ vi ≤ 10,000) とその重さを表す整数 wi (0 ≤ wi ≤ W) の組がそれぞれ１行に与えられます。

W が 0 のとき入力の最後とします。データセットの数は 50 を超えません。

Output
各データセットに対して以下のように出力して下さい。

Case データセットの番号:
風呂敷に入れたお宝の価値総和
そのときのお宝の重さの総和
Sample Input
50
5
60,10
100,20
120,30
210,45
10,4
50
5
60,10
100,20
120,30
210,45
10,4
0
Output for the Sample Input
Case 1:
220
49
Case 2:
220
49
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class V0042_A_Thief {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int count = 1;
		while (true) {
			String line = reader.readLine();
			if (line.equals("0")) {
				break;
			}
			int w = Integer.parseInt(line);
			int n = Integer.parseInt(reader.readLine());
			int[] v = new int[n];
			int[] k = new int[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), ",");
				v[i] = Integer.parseInt(tokenizer.nextToken());
				k[i] = Integer.parseInt(tokenizer.nextToken());
			}
			int max = 0;
			Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
			memo.put(0, 0);
			for (int i = 0; i < n; i++) {
				Map<Integer, Integer> memotmp = new HashMap<Integer, Integer>();
				memotmp.putAll(memo);
				for (Entry<Integer, Integer> entry : memo.entrySet()) {
					int newK = entry.getKey() + k[i];
					int newV = entry.getValue() + v[i];
					if (newK > w) {
						continue;
					}
					if (memotmp.get(newK) == null) {
						memotmp.put(newK, newV);

					} else {
						int oldV = memotmp.get(newK);
						if (oldV < newV) {
							memotmp.put(newK, newV);
						}
					}
					if (newK <= w) {
						if (memotmp.get(max) < newV) {
							max = newK;
						} else if (memotmp.get(max) == newV) {
							if (max > newK) {
								max = newK;
							}
						}
					}
				}
				memo = memotmp;
			}
			System.out.println(String.format("Case %d:", count));
			System.out.println(memo.get(max));
			System.out.println(max);
			count++;

		}
	}
}
