package volume00;

/**
 * 借金
某国に住んでいる友達がお金に困って、あるヤミ金融業者から 10 万円の借金をしたまま、全く返済していないといいます。
この業者は、一週間ごとに 5% の利子を借金に加え、さらに借金の 1,000 円未満を切り上げます。

整数 n を入力し、n 週間後の借金の残高を出力するプログラムを作成して下さい。

Input
整数 n (0 ≤ n ≤ 100) が１行に与えられる。

Output
n 週間後の返済額を１行に出力する。

Sample Input
5
Output for the Sample Input
130000
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0007_Debt_Hell {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = 100000;
		for (int i = 0; i < a; i++) {
			b += (int) (Math.ceil(b * 0.05 / 1000) * 1000);
		}
		System.out.println(b);

	}
}
