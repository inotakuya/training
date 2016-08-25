package introduction_to_programming;

/*時計
秒単位の時間 SS が与えられるので、hh:mm:ss の形式へ変換して出力してください。ここで、hh は時間、mm は 60 未満の分、ss は 60 未満の秒とします。

Input
SS が１行に与えられます。

Output
hh、mm、ss を :（コロン）区切りで１行に出力してください。数値が１桁の場合、0 を付けて２桁表示をする必要はありません。

Constraints
0≤S<864000≤S<86400
Sample Input
46979
Sample Output
13:2:59*/

import java.util.Scanner;

public class Watch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = num1 / 3600;
		int num3 = num1 % 3600 / 60;
		int num4 = num1 % 60;
		System.out.println(String.format("%s:%s:%s", num2, num3, num4));
	}
}
