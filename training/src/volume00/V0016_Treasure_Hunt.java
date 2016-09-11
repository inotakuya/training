package volume00;

/**
 * 宝探し
昨年他界した曽祖父の遺品を整理していたところ、次のような紙がでてきました。




紙の裏には「最初の数だけ前に進んで、次の数の角度だけ右にまわる（負の数は左にまわる）、
それ以降はその繰り返し」とメモがしてあります。祖母によれば「三本松」は、町のちょうど中心にあったそうです。
しかし、今はビルや家が立ち並んでいて、ここに書いてあるとおりに歩くことはできません。そこで、地図の上で宝のある場所を探すことにしました。

1 歩を 1 m とします。入力データには、進む歩数 di と回転する角度 ai が書かれた行が並んでいて、
「0,0」と書かれた行で終了します。最後まで指示どおりに歩いたときに着いた場所を「街の中心から東へ x m, 北へ y m 」のように測り、
その x と y を表示するプログラムを作成して下さい。西および南の場合 x, y は負の値となります。x, y ともに整数部を表示して下さい。

Input
入力は複数の行からなります。各行に歩数を表す整数 di（0 ≤ di ≤ 100）と回転角度を表す整数 ai (-180 ≤ ai ≤ 180) が
半角カンマ区切りで与えられます。 di, ai がともに 0 のとき入力の終わりを示します。

Output
x, y をそれぞれ１行に出力して下さい。

Sample Input
56,65
97,54
64,-4
55,76
42,-27
43,80
87,-86
55,-6
89,34
95,5
0,0
Output for the Sample Input
171
-302
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0016_Treasure_Hunt {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;

		double x = 0;
		double y = 0;
		double ang = 90;
		while (true) {
			String line = reader.readLine();
			if (line.equals("0,0"))
				break;
			tokenizer = new StringTokenizer(line, ",");
			double d = Double.parseDouble(tokenizer.nextToken());
			double red = Math.toRadians(ang);
			x += d * Math.cos(red);
			y += d * Math.sin(red);
			ang -= Double.parseDouble(tokenizer.nextToken());

		}
		System.out.println((int) x);
		System.out.println((int) y);
	}
}
