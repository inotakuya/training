package volume00;

/**
 * ポーカー
ポーカーの手札データを読み込んで、それぞれについてその役を出力するプログラムを作成してください。ただし、この問題では、以下のルールに従います。

ポーカーはトランプ 5 枚で行う競技です。
同じ数字のカードは 5 枚以上ありません。
ジョーカーは無いものとします。
以下のポーカーの役だけを考えるものとします。(番号が大きいほど役が高くなります。)
役なし(以下に挙げるどれにも当てはまらない)
ワンペア（2 枚の同じ数字のカードが1 組ある）
ツーペア（2 枚の同じ数字のカードが2 組ある）
スリーカード（3 枚の同じ数字のカードが1 組ある）
ストレート（5 枚のカードの数字が連続している）
ただし、A を含むストレートの場合、A で終わる並びもストレートとします。
つまり、A を含むストレート は、A 2 3 4 5 　と　10 J Q K A 　の２種類です。
J Q K A 2 などのように、A をまたぐ並び はストレートではありません。（この場合、「役なし」になります）。
フルハウス（3 枚の同じ数字のカードが1 組と、残りの2 枚が同じ数字のカード）
フォーカード（4 枚の同じ数字のカードが1 組ある）
Input
入力は複数のデータセットからなります。各データセットは以下の形式で与えられます。

手札1,手札2,手札3,手札4,手札5
手札は、トランプのJ(ジャック) を11、Q(クイーン) を12、K(キング) を13、A（エース）を 1、その他はそれぞれの数字で表すこととします。

データセットの数は 50 を超えません。

Output
データセットごとに、手札によってできる最も高い役をひとつ出力してください。役の表記については出力例に従ってください。

Sample Input
1,2,3,4,1
2,3,2,3,12
12,13,11,12,12
7,6,7,6,7
3,3,2,3,3
6,7,8,9,10
11,12,10,1,13
11,12,13,1,2
Output for the Sample Input
one pair
two pair
three card
full house
four card
straight
straight
null
3 3 2 3 3 という手札であったときは、two pair ではなく four card です。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class V0038_Poker_Hand {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();

		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			int[] num = new int[5];
			for (int i = 0; i < 5; i++) {
				num[i] = Integer.parseInt(tokenizer.nextToken());
			}

			Arrays.sort(num);
			int sum = 0;
			boolean straight = true;
			for (int i = 0; i < 4; i++) {
				int j = num[i + 1] - num[i];
				if (i == 0) {
					if (j != 1 && j != 9) {
						straight = false;
					}
				} else {
					if (j != 1) {
						straight = false;
					}
				}
				if (j == 0) {
					sum += (i + 1) * (i + 2) + 1;
				}

			}

			if (straight) {
				System.out.println("straight");
			} else {
				switch (sum) {
				case 23:
				case 41:
					System.out.println("four card");
					break;
				case 31:
				case 37:
					System.out.println("full house");
					break;
				case 10:
				case 20:
				case 34:
					System.out.println("three card");
					break;
				case 16:
				case 24:
				case 28:
					System.out.println("two pair");
					break;
				case 0:
					System.out.println("null");
					break;
				default:
					System.out.println("one pair");
					break;
				}
			}
		}
	}
}
