package volume00;

/**
 * ５つの数の整列
５つの整数 a, b, c, d, e を入力し、降順に整列し出力するプログラムを作成して下さい。

Input
５つの整数 a, b, c, d, e (-100000 ≤ a, b, c, d, e ≤ 100000 ) が１つの空白で区切られて１行に与えられます。

Output
降順に整列した５つの整数を１行に出力して下さい。各整数の間に１つの空白を入れて下さい。

Sample Input
3 6 9 7 5
Output for the Sample Input
9 7 6 5 3

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class V0018_Sorting_Five_Numbers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			nums[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(nums);
		for (int i = 4; i >= 0; i--) {
			if (i != 4) {
				builder.append(' ');
			}
			builder.append(nums[i]);
		}
		System.out.println(builder);
	}
}
