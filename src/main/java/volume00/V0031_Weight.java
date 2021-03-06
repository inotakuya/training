package volume00;

/**
 * Weight


祖母が天秤を使っています。天秤は、二つの皿の両方に同じ目方のものを載せると釣合い、そうでない場合には、重い方に傾きます。
10 個の分銅の重さは、軽い順に 1g, 2g, 4g, 8g, 16g, 32g, 64g, 128g, 256g, 512g です。

祖母は、「1kg くらいまでグラム単位で量れるのよ。」と言います。「じゃあ、試しに、ここにあるジュースの重さを量ってよ」と言ってみると、
祖母は左の皿にジュースを、右の皿に 8g と64g と128g の分銅を載せて釣合わせてから、「分銅の目方の合計は 200g だから、
ジュースの目方は 200g ね。どう、正しいでしょう？」と答えました。

左の皿に載せる品物の重さを与えるので、天秤で与えられた重みの品物と釣合わせるときに、
右の皿に載せる分銅を軽い順に出力するプログラムを作成して下さい。ただし、量るべき品物の重さは、
すべての分銅の重さの合計 (=1023g) 以下とします。

Input
複数のデータセットが与えられます。各データセットに、左の皿に載せる品物の重さが１行に与えられます。
入力の最後まで処理して下さい。データセットの数は 50 を超えません。

Output
各データセットに対して、右の皿に載せる分銅（昇順）を１つの空白で区切って、１行に出力して下さい。

Sample Input
5
7
127
Output for the Sample Input
1 4
1 2 4
1 2 4 8 16 32 64
Hint
分銅の重さは 2 の n 乗 ( n = 0, 1, .... 9 )g です。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0031_Weight {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			int n = Integer.parseInt(line);
			char[] a = new StringBuilder(Integer.toBinaryString(n)).reverse().toString().toCharArray();
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != '0') {
					if (count != 0) {
						builder.append(' ');
					}
					builder.append((int) Math.pow(2, i));
					count++;
				}
			}
			builder.append('\n');
		}
		System.out.print(builder);
	}
}
