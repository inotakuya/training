package introduction_to_programming;

/*
割り算

２つの整数 a と b を読み込んで、以下の値を計算するプログラムを作成して下さい：

a ÷ b ： d (整数)
a ÷ b の余り ： r (整数)
a ÷ b ： f (浮動小数点数)
Input
1行に２つの整数 a, b が与えられます。

Output
d, r, f を１つの空白で区切って１行に出力して下さい。fについては、0.00001以下の誤差があってもよいものとします。

Constraints
1 ≤ a, b ≤ 109
Sample Input
3 2
Sample Output
1 1 1.50000
*/

import java.util.Scanner;

public class ITP1_04_A_A_divided_by_B_Problem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		System.out.println(String.format("%s %s %.5f", num1 / num2, num1 % num2, (double) num1 / num2));
	}
}
