package introduction_to_Algorithms_and_Data_Structures;

/*
 * 総当たり
長さ n の数列 A と整数 m に対して、A の要素の中のいくつかの要素を足しあわせて m が作れるかどうかを判定するプログラムを作成してください。
A の各要素は１度だけ使うことができます。

数列 A が与えられたうえで、質問として q 個の m_i が与えれるので、それぞれについて "yes" または "no" と出力してください。

入力
１行目に n、２行目に A を表す n 個の整数、３行目に q、４行目に q 個の整数 m_iが与えられます。

出力
各質問について A の要素を足しあわせて m_i を作ることができれば yes と、できなければ no と出力してください。

制約
n \leq 20
q \leq 200
1 \leq Aの要素 \leq 2,000
1 \leq m_i \leq 2,000
入力例 1
5
1 5 7 10 21
4
2 4 17 8
出力例 1
no
no
yes
yes
 */
import java.util.Scanner;

public class ALDS1_05_A_Exhaustive_Search {
	public static void main(String[] args) {
		new ALDS1_05_A_Exhaustive_Search().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] num = new int[n];
		int s = 0;
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
			s += num[i];
		}
		boolean[] map = new boolean[s + 1];

		slove(0, 0, num, map);
		int m = scanner.nextInt();
		while (m-- > 0) {
			int a = scanner.nextInt();
			System.out.println(a <= s && map[a] ? "yes" : "no");
		}

	}

	private void slove(int i, int sum, int[] num, boolean[] map) {
		map[sum] = true;
		if (i == num.length)
			return;

		slove(i + 1, sum + num[i], num, map);
		slove(i + 1, sum, num, map);
	}
}
