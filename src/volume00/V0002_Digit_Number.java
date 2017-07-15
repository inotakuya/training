package volume00;

/**
 * 桁数
与えられた２つの整数 a と b の和の桁数を出力するプログラムを作成して下さい。

Input
複数のデータセットが与えられます。各データセットは １ 行に与えられます。
各データセットは２つの整数 a と b が１つのスペースで区切られて与えられます。入力の終わりまで処理して下さい。

Constraints
0 ≤ a, b ≤ 1,000,000
データセットの数 ≤ 200
Output
各データセットごとに、a+b の桁数を出力して下さい。

Sample Input
5 7
1 99
1000 999
Output for the Sample Input
2
3
4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0002_Digit_Number {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String s;
		while ((s = reader.readLine()) != null) {
			String[] line = s.split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			builder.append(String.valueOf(a + b).length()).append('\n');

		}
		System.out.print(builder);

	}
}
