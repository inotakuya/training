package introduction_to_Algorithms_and_Data_Structures;

/*
 * Minimum Cost Sort
重さ w_i (i = 0, 1, ..., n-1) の n 個の荷物が１列に並んでいます。これらの荷物をロボットアームを用いて並べ替えます。
１度の操作でロボットアームは荷物 i と荷物 j を持ち上げ、それらの位置を交換することができますが、w_i + w_j のコストがかかります。
ロボットアームは何度でも操作することができます。

与えられた荷物の列を重さの昇順に整列するコストの総和の最小値を求めてください。

入力
１行目に整数 n が与えられます。２行目に n 個の整数 w_i (i = 0, 1, 2, ... n-1) が空白区切りで与えられます。

出力
最小値を１行に出力してください。

制約
1 \leq n \leq 1,000
0 \leq w_i\leq 10^4
w_i は全て異なる値
入力例 1
5
1 5 3 4 2
出力例 1
7

入力例 2
4
4 3 2 1
出力例 2
10
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ALDS1_06_D_Minimum_Cost_Sort {
	public static void main(String[] args) {
		new ALDS1_06_D_Minimum_Cost_Sort().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = 0;
		int min = 1 << 16;
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			int t = scanner.nextInt();
			num[i] = t;
			max = Math.max(max, t);
			min = Math.min(min, t);
		}
		boolean[] b = new boolean[n];
		int[] sortnum = Arrays.copyOf(num, n);
		Arrays.sort(sortnum);
		List<Integer> list = new ArrayList<Integer>();
		for (int t : sortnum)
			list.add(t);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int s = 0;
			int an = 0;
			int cur = i;
			int m = max;
			while (true) {
				b[cur] = true;
				an++;
				int v = num[cur];
				m = Math.min(m, v);
				s += v;
				cur = list.indexOf(v);
				if (b[cur])
					break;
			}
			int aa = s + (an - 2) * m;
			int bb = s + m + (an + 1) * min;
			ans += Math.min(aa, bb);
		}
		System.out.println(ans);
	}
}
