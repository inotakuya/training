package introduction_to_programming;

/*2 つの数の交換

２つの整数 x, y を読み込み、それらを値が小さい順に出力するプログラムを作成して下さい。

ただし、この問題は以下に示すようにいくつかのデータセットが与えられることに注意して下さい。

Input
入力は複数のデータセットから構成されています。各データセットは空白で区切られた２つの整数 x, y を含む１行から構成されています。

x と y がともに 0 のとき入力の終わりを示し、このデータセットに対する出力を行ってはいけません。

Output
各データセットごとに、x と y を小さい順に並べたものを１行に出力して下さい。x と y の間には１つの空白を入れて下さい。

Constraints
0 ≤ x, y ≤ 10,000
データセットの数は 3,000 を超えない。
Sample Input
3 2
2 2
5 3
0 0
Sample Output
2 3
2 2
3 5*/

import java.util.Scanner;

public class ITP1_3_C_Swapping_Two_Numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			if (num1 == 0 && num2 == 0)
				break;
			else {
				if (num1 < num2)
					System.out.println(String.format("%s %s", num1, num2));
				else
					System.out.println(String.format("%s %s", num2, num1));
			}
		}
	}
}
