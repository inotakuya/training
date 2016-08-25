package introduction_to_programming;

/*大小関係

２つの整数 a, b を読み込んで、a と b の大小関係を出力するプログラムを作成して下さい。

Input
入力は空白で区切られた２つの整数 a, b から構成されています。

Output
a より b の方が大きければ

a < b
a より b の方が小さければ、

a > b
a と b が等しければ、

a == b
と出力して下さい。

Constraints
-1,000 ≤ a, b ≤ 1,000
Sample Input 1
1 2
Sample Output 1
a < b
Sample Input 2
4 3
Sample Output 2
a > b
Sample Input 3
5 5
Sample Output 3
a == b*/

import java.util.Scanner;

public class ITP1_2_A_Small_Large_orEqual {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();

		if (num1 > num2)
			System.out.println("a > b");
		else if (num1 < num2)
			System.out.println("a < b");
		else
			System.out.println("a == b");
	}
}
