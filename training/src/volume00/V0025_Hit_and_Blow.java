package volume00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ヒットアンドブロー
ヒットアンドブローというゲームがあります。A さんが異なる４個の数字を思い浮かべ、B さんがその数字を当てます。
B さんが選んだ４個の数字に対し、A さんは、

・場所が一致している数字の個数（ヒット）
・場所は違うが正解の中に含まれる数字の個数（ブロー）

を答えます。それを手がかりに、B さんは再び４個の数字を選んで A さんに伝えます。例えば、A さんが

9 1 8 2
という数字を思い浮かべたとします。このとき B さんが

4 1 5 9
という数字を選んだら、A さんは「１ヒット１ブロー」と答えます。

A さんの思い浮かべた４個の数字と、B さんが選んだ４個の数字を入力してヒットとブロー数の数を出力するプログラムを作成して下さい。
ただし、４個の数字は０から９の範囲で、すべて異なります。

Input
複数のデータセットが与えられます。各データセットは以下のような形式です。

a1 a2 a3 a4
b1 b2 b3 b4
ai は A さんの i 個目の数字を表す 0 から 9 までの整数、bi は B さんの i 個目の数字を表す 0 から 9 までの整数を表します。

入力の最後まで処理して下さい。データセットの数は 50 を超えません。

Output
各データセットに対して、ヒット数とブロー数を１行に出力して下さい。なお、ヒット数とブロー数は１つのスペースで区切って下さい。

Sample Input
9 1 8 2
4 1 5 9
4 6 8 2
4 6 3 2
Output for the Sample Input
1 1
3 0
 */
public class V0025_Hit_and_Blow {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String data;
		while ((data = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(data);
			StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());
			int[] nums = new int[4];
			int[] nums2 = new int[4];
			for (int i = 0; i < 4; i++) {
				nums[i] = Integer.parseInt(tokenizer.nextToken());
				nums2[i] = Integer.parseInt(tokenizer2.nextToken());
			}
			int hit = 0;
			int blow = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (nums[i] == nums2[j])
						if (i == j)
							hit++;
						else
							blow++;
				}
			}
			builder.append(hit).append(' ').append(blow).append('\n');
		}
		System.out.print(builder);
	}
}
