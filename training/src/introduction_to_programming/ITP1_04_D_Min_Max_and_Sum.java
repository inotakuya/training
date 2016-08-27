package introduction_to_programming;
/*
最小値、最大値、合計値

nn 個の整数 ai(i=1,2,...n)ai(i=1,2,...n)を入力し、それらの最小値、最大値、合計値を求めるプログラムを作成してください。

Input
１行目に整数の数 nn が与えられます。２行目に nn 個の整数 aiai が空白区切りで与えられます。

Output
最小値、最大値、合計値を空白区切りで１行に出力してください。

Constraints
0<n≤100000<n≤10000
−1000000≤ai≤1000000−1000000≤ai≤1000000
Sample Input
5
10 1 5 4 17
Sample Output
1 17 37
*/

import java.util.Scanner;

public class ITP1_04_D_Min_Max_and_Sum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] b = new int[a];
		int c = Integer.MAX_VALUE;
		int d = Integer.MIN_VALUE;
		long e = 0;
		for (int i = 0; i < a; i++) {
			int f = scanner.nextInt();
			c = Math.min(c, f);
			d = Math.max(d, f);
			e += f;
		}
		System.out.println(String.format("%d %d %d", c, d, e));

	}
}
