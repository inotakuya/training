package introduction_to_programming;
/*
不足しているカードの発見

太郎が花子と一緒にトランプ遊びをしようとしたところ、52枚あるはずのカードが n 枚のカードしか手元にありません。これらの n 枚のカードを入力として、足りないカードを出力するプログラムを作成して下さい。

太郎が最初に持っていたトランプはジョーカーを除く52枚のカードです。

52枚のカードは、スペード、ハート、クラブ、ダイヤの４つの絵柄に分かれており、各絵柄には13のランクがあります。

Input
最初の行に太郎が持っているカードの枚数 n (n ≤ 52)が与えられます。

続いて n 組のカードがそれぞれ１行に与えられます。各組は１つの空白で区切られた文字と整数です。文字はカードの絵柄を表し、スペードが'S'、ハートが'H'、クラブが'C'、ダイヤが'D'で表されています。整数はそのカードのランク(1 ～ 13)を表しています。

Output
足りないカードをそれぞれ1行に出力して下さい。各カードは入力と同様に１つの空白で区切られた文字と整数です。出力するカードの順番は以下のとおりとします：

絵柄がスペード、ハート、クラブ、ダイヤの順番で優先的に出力する。
絵柄が同じ場合は、ランクが小さい順に出力する。
Sample Input
47
S 10
S 11
S 12
S 13
H 1
H 2
S 6
S 7
S 8
S 9
H 6
H 8
H 9
H 10
H 11
H 4
H 5
S 2
S 3
S 4
S 5
H 12
H 13
C 1
C 2
D 1
D 2
D 3
D 4
D 5
D 6
D 7
C 3
C 4
C 5
C 6
C 7
C 8
C 9
C 10
C 11
C 13
D 9
D 10
D 11
D 12
D 13
Sample Output
S 1
H 3
H 7
C 12
D 8
*/

import java.util.Scanner;

public class ITP1_06_B_Finding_Missing_Cards {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[][] array = new int[4][13];
		for (int i = 0; i < a; i++) {
			String b = scanner.next();
			int c = scanner.nextInt();
			if (b.equals("S"))
				array[0][c - 1] = 1;
			else if (b.equals("H"))
				array[1][c - 1] = 1;
			else if (b.equals("C"))
				array[2][c - 1] = 1;
			else
				array[3][c - 1] = 1;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (array[i][j] == 0)
					if (i == 0)
						System.out.println("S " + (j + 1));
					else if (i == 1)
						System.out.println("H " + (j + 1));
					else if (i == 2)
						System.out.println("C " + (j + 1));
					else
						System.out.println("D " + (j + 1));
			}
		}
	}
}
