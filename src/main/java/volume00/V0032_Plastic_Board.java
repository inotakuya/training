package volume00;

/**
 * プラスティック板
機械に辺・対角線の長さのデータを入力し、プラスティック板の型抜きをしている工場があります。この工場では、
サイズは様々ですが、平行四辺形の型のみを切り出しています。あなたは、切り出される平行四辺形のうち、長方形とひし形の製造個数を数えるように上司から命じられました。

「機械に入力するデータ」を読み込んで、長方形とひし形の製造個数を出力するプログラムを作成してください。



Input
入力は以下の形式で与えられます。

a1,b1,c1
a2,b2,c2
:
機械に入力するデータが複数行に与えられます。i 行目に i 番目の平行四辺形の隣り合う２辺の長さを表す整数 
ai, bi と対角線の長さを表す整数 ci がカンマ区切りで与えられます (1 ≤ ai,bi,ci ≤ 1000, ai+bi > ci)。
データの数は 100 件を超えません。

Output
１行目に長方形の製造個数、２行目ひし形の製造個数を出力します。

Sample Input
3,4,5
5,5,8
4,4,4
5,4,3
Output for the Sample Input
1
2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0032_Plastic_Board {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		int rectangles = 0;
		int lozenges = 0;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			if (a == b) {
				lozenges++;
			} else if (a * a + b * b == c * c) {
				rectangles++;
			}

		}
		System.out.println(rectangles);
		System.out.println(lozenges);
	}
}
