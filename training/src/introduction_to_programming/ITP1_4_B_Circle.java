package introduction_to_programming;
/*
円の面積と円周

半径 r の円の面積と円周の長さを求めるプログラムを作成して下さい。

Input
１つの実数 r が与えられます。

Output
面積と円周の長さを１つの空白で区切って１行に出力して下さい。出力は浮動小数点数とし、0.00001 以下の誤差を含んでもよいものとします。

Constraints
0 < r < 10,000
Sample Input
2
Sample Output
12.566371 12.566371
*/

import java.util.Scanner;

public class ITP1_4_B_Circle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1 = scanner.nextDouble();
		System.out.println(String.format("%.6f %.6f", Math.pow(num1, 2) * Math.PI, num1 * 2 * Math.PI));
	}
}
