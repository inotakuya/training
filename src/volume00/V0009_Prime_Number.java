package volume00;

/**
 * 素数
6 桁以下の正の整数 n を入力し、n 以下の素数がいくつあるかを出力するプログラムを作成して下さい。
ただし、素数とは 1 と自分自身でしか割り切れない正の整数のうち 1 をのぞいたものをいいます。例えば 10 以下の素数は、2, 3, 5, 7 です。

Input
複数のデータセットが与えられます。各データセットに n (1 ≤ n ≤ 999,999) が１行に与えられます。入力の最後まで処理して下さい。

データセットの数は 30 を越えません。

Output
各データセットごとに、n 以下の素数の個数を１行に出力して下さい。

Sample Input
10
3
11
Output for the Sample Input
4
2
5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0009_Prime_Number {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = 1000000;
		boolean[] primes = new boolean[num];
		int[] counts = new int[num];
		for (int i = 2; i < num / 2 + 1; i++) {
			if (!primes[i]) {
				for (int j = 2; j < 999999 / i + 1; j++) {
					primes[i * j] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < num; i++) {
			if (!primes[i]) {
				count++;
			}
			counts[i] = count;
		}
		String s;
		while ((s = reader.readLine()) != null) {
			System.out.println(counts[Integer.parseInt(s)]);
		}
	}
}
