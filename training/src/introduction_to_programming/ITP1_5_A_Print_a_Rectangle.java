package introduction_to_programming;
/*
長方形の描画

たてH cm よこ W cm の長方形を描くプログラムを作成して下さい。

1 cm × 1cm の長方形を '#'で表します。

Input
入力は複数のデータセットから構成されています。各データセットの形式は以下のとおりです：

H W

H, W がともに 0 のとき、入力の終わりとします。

Output
各データセットについて、H × W 個の '#' で描かれた長方形を出力して下さい。

各データセットの後に、１つの空行を入れて下さい。

Constraints
H, W ≤ 300

Sample Input
3 4
5 6
2 2
0 0
Sample Output
####
####
####

######
######
######
######
######

##
##
*/

import java.util.Scanner;

public class ITP1_5_A_Print_a_Rectangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if (a == 0 & b == 0)
				break;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					System.out.print("#");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
