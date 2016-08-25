package introduction_to_programming;

/*3 つの数の整列

３つの整数を読み込み、それらを値が小さい順に並べて出力するプログラムを作成して下さい。

Input
３つの整数が空白で区切られて与えられます。

Output
小さい順に並べ替えた３つの整数を１行に出力して下さい。整数の間に１つの空白を入れて下さい。

Constraints
1 ≤ ３つの整数 ≤ 10,000
Sample Input
3 8 1
Sample Output
1 3 8*/

import java.util.Arrays;
import java.util.Scanner;

public class SortingThreeNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		int[] nums = { num1, num2, num3 };
		Arrays.sort(nums);

		System.out.println(String.format("%s %s %s", nums[0], nums[1], nums[2]));

	}
}
