package volume00;

/**
 * ４つの整数の和
50 以下の正の整数 n を入力し、0 ～ 9 の範囲の整数 a,b,c,d の組で

a+b+c+d=n

を満たすものの組み合わせ数を出力するプログラムを作成して下さい。

例えば、n が 35 のとき、(a,b,c,d) の組み合わせは (8,9,9,9)、(9,8,9,9)、(9,9,8,9)、(9,9,9,8) の 4 通りとなります。

Input
複数のデータセットが与えられます。各データセットに n (1 ≤ n ≤ 50) が１行に与えられます。入力の最後まで処理して下さい。
データセットの数は 50 を超えません。

Output
各データセットごとに、a,b,c,d の組み合わせ個数を１行に出力して下さい。

Sample Input
35
1
Output for the Sample Input
4
4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0008_Sum_of_4_Integers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while ((s = reader.readLine()) != null) {
			int count = 0;
			int a = Integer.parseInt(s);
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					for (int k = 0; k < 10; k++)
						for (int l = 0; l < 10; l++)
							if (i + j + k + l == a)
								count++;
			System.out.println(count);
		}

	}
}
