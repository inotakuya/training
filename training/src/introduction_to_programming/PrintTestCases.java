package introduction_to_programming;

/*テストケースの出力

オンラインジャッジでは、提出されたプログラムが複数の入力データそれぞれに対して正しい出力を行っているかを判定するために、１つの入力データファイルに複数のデータセットが含まれているものがあります。この問題は、そのようなデータセットを処理するための練習問題です。

１つの整数 x を読み込み、それをそのまま出力するプログラムを作成して下さい。

ただし、この問題は以下に示すようにいくつかのデータセットが与えられることに注意して下さい。

Input
入力は複数のデータセットから構成されています。各データセットは１つの整数 x を含む１行から構成されています。

x が 0 のとき入力の終わりを示し、このデータセットに対する出力を行ってはいけません。

Output
各データセットごとに、以下の形式で x を出力して下さい：

Case i: x
ここで、i は１から始まるデータセットの番号を示します。Caseと番号 iの間に１つの空白を入れて下さい。また、:（コロン）と整数 x の間に１つの空白を入れて下さい。サンプル入出力を参考にして下さい。

Constraints
1 ≤ x ≤ 10,000
データセットの数は 10,000 を超えない。*/

import java.util.Scanner;

public class PrintTestCases {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 1;
		while (true) {
			int num1 = scanner.nextInt();
			if (num1 == 0)
				break;
			else {
				System.out.println(String.format("Case %s: %s", i, num1));
				i++;
			}
		}
	}
}
