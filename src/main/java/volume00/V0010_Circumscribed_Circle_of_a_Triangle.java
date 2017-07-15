package volume00;

/**
 * 外接円
平面上の点 (x1,y1), (x2,y2), (x3,y3) を頂点とした三角形の外接円の中心座標 (px,py) と
半径 r を出力するプログラムを作成して下さい。

Input
複数のデータセットが与えられます。最初にデータセット数 
n が１行に与えられます。各データセットは以下の形式です。

x1 y1 x2 y2 x3 y3

ここで、各値は実数とします。

Output
各データセットに対して、px,py,r を１つのスペースで区切って１行に出力して下さい。
小数点以下第３位まで出力し、小数点第４位を四捨五入して下さい。

Constraints

−100≤x1,y1,x2,y2,x3,y3≤100
n≤20
Sample Input
1
0.0 0.0 2.0 0.0 2.0 2.0
Output for the Sample Input
1.000 1.000 1.414
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0010_Circumscribed_Circle_of_a_Triangle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			double x1 = Double.parseDouble(tokenizer.nextToken());
			double y1 = Double.parseDouble(tokenizer.nextToken());
			double x2 = Double.parseDouble(tokenizer.nextToken());
			double y2 = Double.parseDouble(tokenizer.nextToken());
			double x3 = Double.parseDouble(tokenizer.nextToken());
			double y3 = Double.parseDouble(tokenizer.nextToken());

			double A = x1 * x1 - x2 * x2 + y1 * y1 - y2 * y2;
			double B = Math.pow(x1, 2) - Math.pow(x3, 2) + Math.pow(y1, 2) - Math.pow(y3, 2);
			double C = (y1 - y3) * (x1 - x2) - (y1 - y2) * (x1 - x3);
			double b = (B * (x1 - x2) - A * (x1 - x3)) / (2 * C);
			double a = (B * (y1 - y2) - A * (y1 - y3)) / (2 * (-C));
			double r = Math.sqrt((x1 - a) * (x1 - a) + (y1 - b) * (y1 - b));

			builder.append(String.format("%.3f %.3f %.3f\n", a, b, r));
		}
		System.out.print(builder);

	}
}
