package volume00;

/**
 * 円の交差判定
中心が (xa,ya) で半径 ra の円A と、中心が (xb,yb) で半径 rb の円 B が与えられます。
B が A の中にあるとき 2、A が B の中にあるとき -2、A の円周と B の円周が交わっている場合 1、A と 
B が重なっていないとき 0 を出力するプログラムを作成して下さい。なお A と B は同じものではないとします。

Input
複数のデータセットが与えられます。１行目にデータセットの数 N (N≤50) が与えられます。
つづいてN 行の入力が与えられます。各データセットの形式は以下のとおりです。

xa ya ra xb yb rb
入力の値はすべて実数です。

Output
各データセットに対して、2, -2, 1, 0 のいずれかの数値を１行に出力して下さい。

Sample Input
2
0.0 0.0 5.0 0.0 0.0 4.0
0.0 0.0 2.0 4.1 0.0 2.0
Output for the Sample Input
2
0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0023_Circles_Intersection {
	   public static void main(String[] args) throws NumberFormatException,
       IOException {
   BufferedReader reader = new BufferedReader(new InputStreamReader(
           System.in));
   int n = Integer.valueOf(reader.readLine());
   double[] x = new double[6];

   for (int i = 0; i < n; i++) {
       StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
       for (int j = 0; j < 6; j++) {
           x[j] = Double.parseDouble(tokenizer.nextToken());
       }
       double AB = Math.sqrt(Math.pow(x[3] - x[0], 2)
               + Math.pow(x[4] - x[1], 2));
       if (AB <= (x[2] + x[5])) {
           if (AB < x[2] - x[5]) {
               System.out.println(2);
           } else if (AB < x[5] - x[2]) {
					System.out.println(-2);
				} else
					System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
