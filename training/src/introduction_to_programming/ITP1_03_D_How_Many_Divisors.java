package introduction_to_programming;
/*
約数の数

３つの整数 aa、bb、cc を読み込み、aa から bb までの整数の中に、cc の約数がいくつあるかを求めるプログラムを作成してください。

Input
aa、bb、cc が１つの空白区切りで１行に与えられます。

Output
約数の数を１行に出力してください。

Constraints
1≤a,b,c≤100001≤a,b,c≤10000
a≤ba≤b
Sample Input
5 14 80
Sample Output
3
*/
import java.util.Scanner;

public class ITP1_03_D_How_Many_Divisors {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		int count = 0;
		for (int i = num1; i <= num2; i++) {
			if (num3 % i == 0)
				count++;
		}
		System.out.println(count);
	}
}
