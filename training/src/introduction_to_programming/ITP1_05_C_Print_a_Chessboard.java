package introduction_to_programming;
/*
チェスボードの描画

以下のような、たてH cm よこ W cm のチェック柄の長方形を描くプログラムを作成して下さい。

#.#.#.#.#.
.#.#.#.#.#
#.#.#.#.#.
.#.#.#.#.#
#.#.#.#.#.
.#.#.#.#.#
上図は、たて 6 cm よこ 10 cm の長方形を表しています。

長方形の左上が "#" となるように描いて下さい。

Input
入力は複数のデータセットから構成されています。各データセットの形式は以下のとおりです：

H W

H, W がともに 0 のとき、入力の終わりとします。

Output
各データセットについて、たて H cm よこ W cm の枠を出力して下さい。

各データセットの後に、１つの空行を入れて下さい。

Constraints
H, W ≤ 300

Sample Input
3 4
5 6
3 3
2 2
1 1
0 0
Sample Output
#.#.
.#.#
#.#.

#.#.#.
.#.#.#
#.#.#.
.#.#.#
#.#.#.

#.#
.#.
#.#

#.
.#

#
*/

import java.util.Scanner;

public class ITP1_05_C_Print_a_Chessboard {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if (a == 0 & b == 0)
				break;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1)
						System.out.print("#");
					else
						System.out.print(".");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
