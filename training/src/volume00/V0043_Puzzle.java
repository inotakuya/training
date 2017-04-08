package volume00;

/**
 * パズル
1 ～ 9 の数字を 14 個組み合わせて完成させるパズルがあります。与えられた 13 個の数字にもうひとつ数字を付け加えて完成させます。

パズルの完成条件は

同じ数字を２つ組み合わせたものが必ずひとつ必要です。
残りの12 個の数字は、３個の数字の組み合わせ４つです。
３個の数字の組み合わせ方は、同じ数字を３つ組み合わせたものか、または３つの連続する数字を組み合わせたものです。
ただし、9 1 2 のような並びは連続する数字とは認められません。
同じ数字は4 回まで使えます。
13 個の数字からなる文字列を読み込んで、パズルを完成することができる数字を昇順に全て出力するプログラムを作成してください。
なお、1～9 のどの数字を付け加えてもパズルを完成させることができないときは 0 を出力してください。

例えば与えられた文字列が 3456666777999 の場合

「2」があれば、　234 567 666 77 999
「3」があれば、　33 456 666 777 999
「5」があれば、　345 567 666 77 999
「8」があれば、　345 666 678 77 999

というふうに、2 3 5 8 のいずれかの数字が付け加えられるとパズルは完成します。「6」でも整いますが、5 回目の使用になるので、
この例では使えないことに注意してください。

Input
入力は複数のデータセットからなります。各データセットとして、13 個の数字が１行に与えられます。データセットの数は 50 を超えません。

Output
データセットごとに、パズルを完成させることができる数字を昇順に空白区切りで１行に出力します。

Sample Input
3649596966777
6358665788577
9118992346175
9643871425498
7755542764533
1133557799246
Output for the Sample Input
2 3 5 8
3 4
1 2 3 4 5 6 7 8 9
7 8 9
1 2 3 4 6 7 8
0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class V0043_Puzzle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}

			int[] a = new int[10];
			for (int i = 0; i < line.length(); i++) {
				a[line.charAt(i) - '0']++;
			}
			int[] result = new int[10];
			for (int i = 1; i < 10; i++) {
				if (a[i] == 4) {
					continue;
				}

				for (int j = 1; j < 10; j++) {
					int[] m = Arrays.copyOf(a, a.length);
					m[i]++;
					m[j] -= 2;
					for (int k = 1; k < 8; k++) {
						if (m[k] < 0) {
							m[9] = -1;
							break;
						}
						if (m[k] == 1 || m[k] == 4) {
							m[k]--;
							m[k + 1]--;
							m[k + 2]--;
						} else if (m[k] == 2) {
							m[k] -= 2;
							m[k + 1] -= 2;
							m[k + 2] -= 2;
						}
					}
					if ((m[8] == 0 || m[8] == 3) && (m[9] == 0 || m[9] == 3)) {
						result[i]++;
						break;
					}
				}
			}
			int count = 0;
			boolean flag = false;
			for (int i = 1; i < 10; i++) {
				if (result[i] == 1) {
					flag = true;
					if (count != 0) {
						builder.append(' ');

					}
					builder.append(i);
					count++;
				}
			}

			if (!flag) {
				builder.append(0);
			}
			builder.append('\n');
		}
		System.out.print(builder);
	}
}
