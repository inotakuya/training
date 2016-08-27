package introduction_to_programming;

/*範囲

３つの整数a, b, cを読み込み、それらが a < b < cの条件を満たすならば"Yes"を、満たさないならば"No"を出力するプログラムを作成して下さい。

Input
３つの整数が空白で区切られて与えられます。

Output
YesまたはNoを１行に出力して下さい。

Constraints
0 ≤ a, b, c ≤ 100
Sample Input 1
1 3 8
Sample Output 1
Yes
Sample Input 2
3 8 1
Sample Output 2
No*/

import java.util.Scanner;

public class ITP1_02_B_Range {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();

		if (num1 < num2 && num2 < num3)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
