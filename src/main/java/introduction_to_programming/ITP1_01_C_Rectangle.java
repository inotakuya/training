package introduction_to_programming;

/*長方形の面積と周の長さ

たて a cm よこ b cm の長方形の面積と周の長さを求めるプログラムを作成して下さい。

Input
a と b が１つの空白で区切られて与えられます。

Output
面積と周の長さを１つの空白で区切って１行に出力して下さい。

Constraints
1 ≤ a, b ≤ 100
Sample Input
3 5
Sample Output
15 16*/

import java.util.Scanner;

public class ITP1_01_C_Rectangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		int num1 = Integer.parseInt(line[0]);
		int num2 = Integer.parseInt(line[1]);

		System.out.println(String.format("%s %s", num1 * num2, 2 * (num1 + num2)));
	}
}
