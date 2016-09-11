package volume00;

/**
 * 直角三角形
３つの正の整数を入力し、それぞれの長さを３辺とする三角形が直角三角形である場合には YES を、違う場合には NO と
出力するプログラムを作成して下さい。

Input
複数のデータセットが与えられます。１行目にデータセット数の N が与えられます。続いて N 行の入力が与えれます
。各行に３つの整数が１つのスペースで区切られて与えられます。

Constraints
1 ≤ 1辺の長さ ≤ 1,000
N ≤ 1,000
Output
各データセットごとに、YES または NO を１行に出力して下さい。

Sample Input
3
4 3 5
4 3 6
8 8 8
Output for the Sample Input
YES
NO
NO

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class V0003_Is_it_a_Right_Triangle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer to;
		int[] nums = new int[3];
		int a = Integer.parseInt(reader.readLine());
		for (int i = 0; i < a; i++) {
			to = new StringTokenizer(reader.readLine());
			for (int j = 0; j < 3; j++) {
				nums[j] = Integer.parseInt(to.nextToken());
			}
			Arrays.sort(nums);
			if (Math.pow(nums[0], 2) + Math.pow(nums[1], 2) == Math.pow(nums[2], 2))
				builder.append("YES\n");
			else
				builder.append("NO\n");
		}
		System.out.print(builder);

	}
}
