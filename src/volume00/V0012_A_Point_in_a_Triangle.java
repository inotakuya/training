package volume00;

/**
 * 三角形と点
平面上に (x1,y1), (x2,y2), (x3,y3) を頂点とした三角形と点 P(xp,yp) があります。点 P が
三角形の内部(三角形の頂点や辺上は含まない)にある場合 "YES"を、
三角形の外部にある場合 "NO" を出力するプログラムを作成して下さい。

Input
複数のデータセットが与えられます。各データセットは以下の形式で与えられます。

x1 y1 x2 y2 x3 y3 xp yp

与えられる入力は全て実数です。入力の最後まで処理して下さい。

データセットの数は 100 を超えません。

Constraints
入力は次の条件を満たします：

−100≤x1,y1,x2,y2,x3,y3,xp,yp≤100
三角形の辺の長さは 1.0 以上である
三角形の辺と点 P の距離が 0.001 より小さくなることはない
Output
各データセットに対して、YES または NO を１行に出力して下さい。

Sample Input
0.0 0.0 2.0 0.0 2.0 2.0 1.5 0.5
0.0 0.0 1.0 4.0 5.0 3.0 -1.0 3.0
Output for the Sample Input
YES
NO
 */
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0012_A_Point_in_a_Triangle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;
		String s;
		while ((s = reader.readLine()) != null) {
			Path2D.Double sank = new Path2D.Double();
			tokenizer = new StringTokenizer(s);
			double[] z = new double[8];
			for (int i = 0; i < 8; i++) {
				z[i] = Double.parseDouble(tokenizer.nextToken());
			}
			sank.moveTo(z[0], z[1]);
			sank.lineTo(z[2], z[3]);
			sank.lineTo(z[4], z[5]);

			Point2D.Double pt = new Point2D.Double(z[6], z[7]);
			System.out.println(sank.contains(pt) ? "YES" : "NO");
		}
	}
}
