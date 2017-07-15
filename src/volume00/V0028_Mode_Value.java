package volume00;

/**
 * 最頻値
1～100 の整数データを読みこんで、データの最頻値を出力するプログラムを作成してください。データの中で最も出現頻度の高い値を最頻値と呼びます。

Input
整数データが複数の行に与えられます。各行に１つの整数 ai (1 ≤ ai ≤ 100) が与えられます。整数の数は 100 件を超えません。

Output
整数データの最頻値を出力して下さい。複数ある場合は、値の小さい順に改行してすべて表示して下さい。

Sample Input
5
6
3
5
8
7
5
3
9
7
3
4
Output for the Sample Input
3
5
「5」という数値が3 つ、「3」という数値が3 つ、「7」は2 つ、他は1 つです。このとき、もっとも個数の多い「3」「5」が最頻値となります。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0028_Mode_Value {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String data;
		int[] nums = new int[101];
		while ((data = reader.readLine()) != null) {
			if (data.isEmpty())
				break;
			int num = Integer.parseInt(data);
			nums[num]++;
		}
		int max = 0;
		for (int i = 0; i < 101; i++) {
			max = Math.max(max, nums[i]);
		}
		for (int i = 0; i < 101; i++) {
			if (nums[i] == max) {
				System.out.println(i);
			}
		}
	}
}
