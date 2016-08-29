package introduction_to_Algorithms_and_Data_Structures;

/*
 * 重さがそれぞれ w_i (i = 0, 1, ... n-1) の n 個の荷物が、ベルトコンベアから順番に流れてきます。
 * これらの荷物を k 台のトラックに積みます。各トラックには連続する 0 個以上の荷物を積むことができますが、
 * それらの重さの和がトラックの最大積載量 P を超えてはなりません。最大積載量 P はすべてのトラックで共通です。

n、k、w_i が与えられるので、すべての荷物を積むために必要な最大積載量 P の最小値を求めるプログラムを作成してください。

入力
最初の行に荷物の数 n とトラックの数 k が空白区切りで与えられます。続く n 行に n 個の整数 w_i がそれぞれ１行に与えられます。

出力
P の最小値を１行に出力してください。

制約
1 \leq n \leq 100,000
1 \leq k \leq 100,000
1 \leq w_i \leq 10,000
入力例 1
5 3
8
1
7
3
9
出力例 1
10
１台目のトラックに２つの荷物 \{8, 1\},２台目のトラックに２つの荷物 \{7, 3\}、３台目のトラックに１つの荷物 \{9\} を積んで、
最大積載量の最小値が 10 となります。


入力例 2
4 2
1
2
2
6
出力例 2
6
１台目のトラックに３つの荷物 \{1, 2, 2\},２台目のトラックに１つの荷物 \{6\} を積で、最大積載量の最小値が 6 となります。
 */
import java.util.Scanner;

public class ALDS1_04_D_Allocation {
	public static void main(String[] args) {
		new ALDS1_04_D_Allocation().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] num = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
			sum += num[i];
		}
		int r = sum;
		int l = r / m;
		while (r - l > 1) {
			int mid = (r + l) / 2;
			if (isTrue(mid, num, m, sum)) {
				r = mid;
			} else {
				l = mid;
			}
		}
		System.out.println(isTrue(l, num, m, sum) ? l : r);
	}

	private boolean isTrue(int mid, int[] num, int m, int sum) {
		int i = 0;
		int k = mid;
		while (true) {
			if (m == 0)
				return false;
			if (i == num.length)
				return true;
			if (k - num[i] >= 0) {
				k -= num[i];
				i++;
			} else {
				m--;
				k = mid;
			}
		}
	}
}
