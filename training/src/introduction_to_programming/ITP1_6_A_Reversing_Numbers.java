package introduction_to_programming;
/*
数列の反転

与えられた数列を逆順に出力するプログラムを作成して下さい。

Input
入力は以下の形式で与えられます：

n
a1 a2 . . . an
n は数列の長さを示し、ai は i 番目の数を表します。

Output
逆順の数列を１行に出力して下さい。数列の要素の間に１つの空白を入れて下さい（最後の数の後に空白は入らないことに注意して下さい）。

Constraints
n ≤ 100 とします。

Sample Input 1
5
1 2 3 4 5
Sample Output 1
5 4 3 2 1
Sample Input 2
8
3 3 4 4 5 8 7 9
Sample Output 2
9 7 8 5 4 4 3 3
*/

import java.util.Scanner;

public class ITP1_6_A_Reversing_Numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] b = new int[a];
		for (int i = 0; i < a; i++)
			b[i] = scanner.nextInt();
		for (int i = b.length - 1; i >= 0; i--) {
			if (i == b.length - 1)
				System.out.print(b[i]);
			else
				System.out.print(" " + b[i]);
		}
		System.out.println();
	}
}
