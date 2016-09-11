package volume00;

/**
 * 連立方程式
連立方程式

ax+by=c
dx+ey=f

の解、x, y を出力するプログラムを作成して下さい。a, b, c, d, e, f はそれぞれ、 -1,000 以上 1,000 以下の実数とし、
連立方程式の解が一意に存在するように与えられるものとします。

Input
複数のデータセットが与えられます。入力の最後まで処理して下さい。１つのデータセットが１行に与えられます。１つのデータセットに 
a, b, c, d, e, f が１つのスペースで区切られて与えられます。

Output
各データセットに対して、x, y を１つのスペースで区切って１行に出力して下さい。各値は小数点以下第３位まで出力して下さい。
小数点以下第４位を四捨五入して下さい。

Sample Input 1
1 2 3 4 5 6
2 -1 -2 -1 -1 -5
Output for the Sample Input 1
-1.000 2.000
1.000 4.000
Sample Input 2
2 -1 -3 1 -1 -3
2 -1 -3 -9 9 27
Output for the Sample Input 2
0.000 3.000
0.000 3.000

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0004_Simultaneous_Equation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer to;
		double[] nums = new double[6];
		String s;
		while ((s = reader.readLine()) != null) {
			to = new StringTokenizer(s);
			for (int i = 0; i < 6; i++) {
				nums[i] = Double.parseDouble(to.nextToken());
			}
			double det = nums[0] * nums[4] - nums[1] * nums[3];
			double x = (nums[4] * nums[2] - nums[1] * nums[5]) / det;
			double y = (-nums[3] * nums[2] + nums[0] * nums[5]) / det;

			if (x == -0.0)
				x = 0.0;
			if (y == -0.0)
				y = 0.0;
			builder.append(String.format("%.3f %.3f\n", x, y));

		}
		System.out.print(builder);
	}
}
