package introduction_to_Algorithms_and_Data_Structures;

/*
 * n 個の整数を含む数列 S と、q 個の異なる整数を含む数列 T を読み込み、T に含まれる整数の中で S に含まれるものの個数 C を
 * 出力するプログラムを作成してください。

入力
１行目に n、２行目に S を表す n 個の整数、３行目に q、４行目に T を表す q 個の整数が与えられます。

出力
C を１行に出力してください。

制約
n \leq 10,000
q \leq 500
0 \leq Sの要素 \leq 10^9
0 \leq Tの要素 \leq 10^9
T の要素は互いに異なる
入力例 1
5
1 2 3 4 5
3
3 4 1
出力例 1
3
入力例 2
3
3 1 2
1
5
出力例 2
0
 */
import java.util.Scanner;

public class ALDS1_04_A_Linear_Search {
	public static void main(String[] args) {
		new ALDS1_04_A_Linear_Search().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int count = 0;
		while (m-- > 0) {
			int a = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				if (a == num[i]) {
					count++;
					break;
				}

			}
		}
		System.out.println(count);
	}
}
