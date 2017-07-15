package introduction_to_Algorithms_and_Data_Structures;

/*
 * 最大の利益
FX取引では、異なる国の通貨を交換することで為替差の利益を得ることができます。例えば、１ドル100円の時に 1000ドル買い、
価格変動により 1ドル 108円になった時に売ると、(108円 - 100円) \times 1000ドル = 8000円の利益を得ることができます。

ある通貨について、時刻 t における価格 R_t (t = 0, 1, 2 ,,, n-1)が入力として与えられるので、
価格の差 R_j - R_i (ただし、j > i とする) の最大値を求めてください。

入力
最初の行に整数 n が与えられます。続く n 行に整数 R_t (t = 0, 1, 2 ,,, n-1) が順番に与えられます。

出力
最大値を１行に出力してください。

制約
2 \leq n \leq 200,000
1 \leq R_t \leq 10^9
入力例 1
6
5
3
1
3
4
3
入力例 1 に対する出力
3
入力例 2
3
4
3
2
入力例 2 に対する出力
-1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALDS1_01_D_Maximum_Profit {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int minv = Integer.MAX_VALUE;
		int maxv = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int j = Integer.parseInt(reader.readLine());
			maxv = Math.max(maxv, j - minv);
			minv = Math.min(minv, j);
		}
		System.out.println(maxv);
	}
}
