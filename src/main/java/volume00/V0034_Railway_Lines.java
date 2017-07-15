package volume00;

/**
 * 鉄道路線
複線（上りと下りが別の線路になっていてどこででもすれ違える）の鉄道路線があります。
この路線には終端駅を含めて11 の駅があり、それぞれの駅と駅の間は図で示す区間番号で呼ばれています。



この路線の両方の終端駅から列車が同時に出発して、途中で停まらずに走ります。
各区間の長さと2 本の列車の速度を読み込んで、それぞれの場合について列車がすれ違う区間の番号を出力するプログラムを作成してください。
ただし、ちょうど駅のところですれ違う場合は、両側の区間番号のうち小さいほうの数字を出力します。
また、列車の長さ、駅の長さは無視できるものとします。

Input
複数のデータセットが与えられる。各データセットは以下のような形式で与えられる。

l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,v1,v2
li (1 ≤ li ≤ 2,000) は区間 i の長さ(km)を表す整数である。v1 は区間 1 側の終端駅を出発した列車の速度(km/h)、
v2 は区間 10 側の終端駅を出発した列車の速度(km/h)を表す整数である (1 ≤ v1, v2 ≤ 2,000)。

データセットの数は 50 を超えない。

Output
データセットごとに、列車がすれちがう区間の番号を１行に出力する。

Sample Input
1,1,1,1,1,1,1,1,1,1,40,60
1,1,1,1,1,3,3,3,3,3,50,50
10,10,10,10,10,10,10,10,10,10,50,49
Output for the Sample Input
4
7
6
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0034_Railway_Lines {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			int sum = 0;
			int[] nums = new int[10];
			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(tokenizer.nextToken());
				nums[i] = sum;
			}
			double a = Double.parseDouble(tokenizer.nextToken());
			double b = Double.parseDouble(tokenizer.nextToken());

			double c = sum / (a + b) * a;

			for (int i = 0; i < 10; i++) {
				if (nums[i] >= c) {
					System.out.println(i + 1);
					break;
				}

			}
		}
	}
}
