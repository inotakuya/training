package volume00;

/**
 * 格子上の経路
上から見ると図 1 のような形の格子状の広場があります。この格子の各辺に「壁」があるかないかを 0 と 1 の並びで表します。
点 A に立って壁に右手をつき、壁に右手をついたまま、矢印の方向に歩き続けて再び点 A に戻ってくるまでの経路を出力するプログラムを作成してください。


図1

Input
以下の図 2 に示すように、入力は壁がある場合を 1、ない場合を 0 として、以下の形式で与えられます。 

1 行目は一番上の横線の壁の有無を左から 0 と 1 で表した文字列
2 行目はその下の縦線の壁の有無を左から0 と1 で表した文字列
3 行目は上から2 本目の横線の壁の有無を左から0 と1 で表した文字列
...
9 行目は一番下の横線の壁の有無を左から0 と1 で表した文字列

図2 (壁あるところを太線で表しています)　　(対応する数字のならび)

ただし、図１の太線に示すように、点 A から右に 1 区画分は必ず壁があるものとします。すなわち、1 行目の 1 文字目は常に 1 です。

Output
「図の左方向に一区画分進む」を 'L'、「図の右方向に一区画分進む」を 'R'、「図の上方向に一区画分進む」を 'U'、
「図の下方向に一区画分進む」を 'D' で表わし、進む順に 'L', 'R', 'U', 'D' を１行に並べて出力します。

Sample Input
1111
00001
0110
01011
0010
01111
0010
01001
0111
Output for the Sample Input
RRRRDDDDLLLUUURRDDLURULLDDDRRRUUUULLLL
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0037_Path_on_a_Grid {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();

		String[] a = new String[5];
		String[] b = new String[4];

		for (int i = 0; i < 4; i++) {
			a[i] = reader.readLine();
			b[i] = reader.readLine();
		}
		a[4] = reader.readLine();
		int x = 0;
		int y = 0;
		char direction = 'R';
		while (true) {

			if (direction == 'R') {
				if (x > 0 && b[x - 1].charAt(y) == '1') {
					direction = 'U';
					x--;
				} else if (y < 4 && a[x].charAt(y) == '1') {
					y++;
				} else if (b[x].charAt(y) == '1') {
					direction = 'D';
					x++;
				} else {
					direction = 'L';
					y--;
				}
			} else if (direction == 'D') {
				if (y < 4 && a[x].charAt(y) == '1') {
					direction = 'R';
					y++;
				} else if (x < 4 && b[x].charAt(y) == '1') {
					x++;
				} else if (y > 0 && a[x].charAt(y - 1) == '1') {
					direction = 'L';
					y--;
				} else {
					direction = 'U';
					x--;
				}
			} else if (direction == 'L') {
				if (x < 4 && b[x].charAt(y) == '1') {
					direction = 'D';
					x++;
				} else if (y > 0 && a[x].charAt(y - 1) == '1') {
					y--;
				} else if (x > 0 && b[x - 1].charAt(y) == '1') {
					direction = 'U';
					x--;
				} else {
					direction = 'R';
					y++;
				}
			} else {
				if (y > 0 && a[x].charAt(y - 1) == '1') {
					direction = 'L';
					y--;
				} else if (x > 0 && b[x - 1].charAt(y) == '1') {
					x--;
				} else if (a[x].charAt(y) == '1') {
					direction = 'R';
					y++;
				} else {
					direction = 'D';
					x++;
				}

			}
			builder.append(direction);
			if (x == 0 && y == 0) {
				break;
			}

		}
		System.out.println(builder);
	}
}
