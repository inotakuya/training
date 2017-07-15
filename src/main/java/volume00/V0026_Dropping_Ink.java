package volume00;
/**
 * インキ
図のようなマス目の「紙」があり、(1, 2) のように x, y の値の対でその上の位置を示すことにします。値は 0 から始まる整数とします。

この「紙」にインキを滴下します。インキ滴には「大」「中」「小」３つのサイズがあり、インキ滴の落ちた地点を中心に図のように周囲も色がつきます。
図で☆が中心、○が色の滲む範囲です。



「紙」は、最初は「まっしろ」つまり、どのマスも色の濃さを示す値が 0 とします。インキ滴が落ちるごとに値が 1 ずつ増えていきます。
「小の滴」が (1, 2)、「中の滴」が (3, 2) に落ちた場合、各マスの値は次図の左部のようになります。なお空白は値 0 を示します。
滲む範囲が紙の外にもおよぶ場合は、紙の外部を無視して下さい。

例えば、白紙に、「小の滴」を (8, 0) に落とした場合は、次図の右部のように y = -1 に相当する部分を無視することになります。
同じ場所に複数のインキ滴が落ちることもありえます。



「落とすインキ滴」の位置 (x, y) とサイズ（小 = 1, 中 = 2, 大 = 3）を入力として読み込んで、
色のついてない部分（まだ滲んでこない部分）のマス目の個数と、一番濃いマス目の濃さを出力するプログラムを作成して下さい。
なお、「紙」の大きさを 10 × 10 とします。

Input
入力は以下の形式で与えられる。

x1,y1,s1
x2,y2,s2
  :
  :
xi (0 ≤ xi < 10), y1 (0 ≤ yi < 10), s1 (1 ≤ si ≤ 3 ) は i 番目に落とされるインキの位置 (x, y) とそのサイズを表す。
落とされるインキの数は 50 を超えない。

Output
色のついていない部分のマス目の個数を第１行目に、１番濃いマス目の濃さを第２行目に出力して下さい。

Sample Input
2,5,3
3,6,1
3,4,2
4,5,2
3,6,3
2,4,1
Output for the Sample Input
77
5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0026_Dropping_Ink {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String data;
		int[][] nums = new int[10][10];
		while ((data = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(data, ",");
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			int size = Integer.parseInt(tokenizer.nextToken());
			if (size == 1) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (0 <= i + x - 1 && i + x - 1 <= 9 && 0 <= j + y - 1 && j + y - 1 <= 9) {
							if ((i == 1 && j == 1) || (i + j) % 2 == 1) {
								nums[i - 1 + x][j - 1 + y]++;
							}
						}
					}
				}
			} else if (size == 2) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (0 <= i + x - 1 && i + x - 1 <= 9 && 0 <= j + y - 1 && j + y - 1 <= 9) {
							nums[i - 1 + x][j - 1 + y]++;
						}
					}
				}
			} else {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (0 <= i + x - 2 && i + x - 2 <= 9 && 0 <= j + y - 2 && j + y - 2 <= 9) {
							if (i == 2 || j == 2 || (i == 1 && j == 1) || i * j == 3 || (i * j == 9)) {
								nums[i - 2 + x][j - 2 + y]++;
							}
						}
					}
				}
			}
		}
		int count = 0;
		int max = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				max = Math.max(max, nums[i][j]);
				if (nums[i][j] == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}
}
