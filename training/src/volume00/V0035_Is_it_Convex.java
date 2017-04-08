package volume00;

/**
 * 凸？
平面上の異なる 4 点　A(xa,ya), B(xb,yb), C(xc,yc), D(xd,yd) の座標を読み込んで、それら 4 点を頂点とした四角形 
ABCD に凹みがなければ YES、凹みがあれば NO と出力するプログラムを作成してください。

凹みのある四角形とは図 1 のような四角形です。



Input
複数のデータセットが与えられます。各データセットの形式は以下のとおりです。

xa,ya,xb,yb,xc,yc,xd,yd

xa,ya,xb,yb,xc,yc,xd,yd はそれぞれ -100 以上 100 以下であり、実数で与えられます。

1 直線上に 3 つ以上点が並ぶことはないものとします。また、入力順に点を結んでいけば、四角形になる順番に点の座標が入力されるものとします。
（つまり、図 2 のような形になる順番で点が与えられることはありません。)

データセットの数は 100 を超えません。

Output
各データセットごとに、YES または NO を１行に出力します。

Sample Input
0.0,0.0,1.0,0.0,1.0,1.0,0.0,1.0
0.0,0.0,3.0,0.0,1.0,1.0,1.0,3.0
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

public class V0035_Is_it_Convex {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			double[] x = new double[4];
			double[] y = new double[4];
			for (int i = 0; i < 4; i++) {
				x[i] = java.lang.Double.parseDouble(tokenizer.nextToken());
				y[i] = java.lang.Double.parseDouble(tokenizer.nextToken());
			}
			Point2D.Double a = new Point2D.Double(x[0], y[0]);
			Point2D.Double b = new Point2D.Double(x[1], y[1]);
			Point2D.Double c = new Point2D.Double(x[2], y[2]);
			Point2D.Double d = new Point2D.Double(x[3], y[3]);

			if (isTrue(a, b, c, d) || isTrue(a, b, d, c) || isTrue(a, d, c, b) || isTrue(d, b, c, a)) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}

	public static boolean isTrue(Point2D.Double a, Point2D.Double b, Point2D.Double c, Point2D.Double d) {
		Path2D.Double sank = new Path2D.Double();
		sank.moveTo(a.getX(), a.getY());
		sank.lineTo(b.getX(), b.getY());
		sank.lineTo(c.getX(), c.getY());
		if (sank.contains(d))
			return true;
		else
			return false;
	}
}
