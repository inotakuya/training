package volume00;

/**
 * 和の最大値
与えられた整数の並び a1, a2, a3,... , an について、連続した項(1つ以上)の和の最大値を出力するプログラムを作成して下さい。

Input
複数のデータセットが与えられます。各データセットは以下のような形式です。

n
a1
a2
:
an
１行目に項数を表す整数 n (1 ≤ n 5000) が与えられます。続く n 行に第 i 項を表す整数 ai (-100000 ≤ ai ≤ 100000) が与えられます。

n が 0 のとき入力の最後とします（この場合は処理をしない）。

Output
各データセットに対して、連続した項の和の最大値を１行に出力して下さい。

Sample Input
7
-5
-1
6
4
9
-6
-7
13
1
2
3
2
-2
-1
1
2
3
2
1
-2
1
3
1000
-200
201
0
Output for the Sample Input
19
14
1001
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0022_Maximum_Sum_Sequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(reader.readLine());
			if (n == 0) {
				break;
			}
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(reader.readLine());
			}
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum = nums[i];
				for (int j = i; j < n; j++) {
					if (j != i)
						sum += nums[j];
					max = Math.max(max, sum);
				}
			}
			System.out.println(max);
		}
	}
}
