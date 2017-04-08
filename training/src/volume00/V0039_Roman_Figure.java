package volume00;
/**
 * ローマ数字
古代ローマでは数を数えることは難しい仕事でした。アラビア数字の 0,1,2,3,…, 9 はまだ流布していませんでした。
その代わり次のような記号が使われていました。

アラビア数字	ローマ数字	アラビア数字	ローマ数字	アラビア数字	ローマ数字
1	I	11	XI	30	XXX	
2	II	12	XII	40	XL	
3	III	13	XIII	50	L	
4	IV	14	XIV	60	LX	
5	V	15	XV	70	LXX	
6	VI	16	XVI	80	LXXX	
7	VII	17	XVII	90	XC	
8	VIII	18	XVIII	100	C	
9	IX	19	XIX	500	D	
10	X	20	XX	1000	M	

I は 1、 V は 5、 X は 10、 L は 50、 C は 100、 D は 500、 M は 1000、 他の例は上の表を見てください。
小さい数が大きい数に続いている、つまり右側にあるときは足し算をします。小さい数が大きい数の前に、つまり左にあるときは、
大きい数から小さい数を引きます。大きい数字の前にあって引き算を表す小さな数字は一回の引き算あたりひとつしかありません。

ローマ数字をアラビア数字（通常の数字）の表記（10 進表示）に変換して出力するプログラムを作成してください
。ただし、与えられるローマ数字は上記のルールにのみ従っています(実際のローマ数字の表記にはもっと細かいルールがありますが、
ここでは考慮する必要はありません。たとえば、実際のローマ数字ではI はV かX から、X はL かC から、C はD かM からしか引き算しませんし
、同じローマ数字は４つ以上（または５つ以上）足し並べることはありません。)

Input
複数のデータセットが与えられます。それぞれのデータセットにローマ数字
（半角大文字のI, V, X, L, C, D ,M で表される連続した文字列）が１行に与えられます。
与えられるローマ数字の文字列の長さはおのおの 100 以下です。

データセットの数は 50 を超えません。

Output
各データセットに対し、アラビア数字（整数）を１行に出力して下さい。

Sample Input
IV
CCCCLXXXXVIIII
CDXCIX
Output for the Sample Input
4
499
499
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0039_Roman_Figure {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();

		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			int a = Integer.MAX_VALUE;
			int sum = 0;
			for (int i = 0; i < line.length(); i++) {
				int b = getNum(line.charAt(i));
				if (a >= b) {
					sum += b;
				} else {
					sum = sum - a * 2 + b;
				}
				a = b;
			}
			builder.append(sum).append('\n');
		}
		System.out.print(builder);
	}

	private static int getNum(char charAt) {
		switch (charAt) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		default:
			return 1000;
		}
	}
}
