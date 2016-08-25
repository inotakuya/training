package introduction_to_programming;
/*
以下のような、たてH cm よこ W cm の枠を描くプログラムを作成して下さい。

##########
#........#
#........#
#........#
#........#
##########
上図は、たて 6 cm よこ 10 cm の枠を表しています。

Input
入力は複数のデータセットから構成されています。各データセットの形式は以下のとおりです：

H W

H, W がともに 0 のとき、入力の終わりとします。

審判データに用いられる入力の条件は、3 ≤ H, W ≤ 100 です。

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
####
#..#
####

######
#....#
#....#
#....#
######

###
#.#
###

##
##

#
*/

import java.util.Scanner;

public class ITP1_5_B_Print_a_Frame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if (a == 0 & b == 0)
				break;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					if (i == 0 || i == a - 1)
						System.out.print("#");
					else if (j == 0 || j == b - 1)
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
