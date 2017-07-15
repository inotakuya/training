package volume00;
/**
 * 山の高さ
山の高さをメートル単位の整数で表した 10 個のデータがあります。その 10 個のデータを読み込み、その中で、
高い順から３つ出力するプログラムを作成して下さい。

Input
山の高さ1
山の高さ2
     .
     .
山の高さ10
Constraints
0 ≤ 山の高さ ≤ 10,000
Output
１番目に高い山の高さ
２番目に高い山の高さ
３番目に高い山の高さ
Sample Input 1
1819
2003
876
2840
1723
1673
3776
2848
1592
922
Output for the Sample Input 1
3776
2848
2840
Sample Input 2
100
200
300
400
500
600
700
800
900
900
Output for the Sample Input 2
900
900
800
高さが同じ山が複数ある場合でも、異なる順位を付けるものとします。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class V0001_List_of_Top_3_Hills {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int[] yama = new int[10];
		for (int i = 0; i < 10; i++) {
			yama[i] = Integer.parseInt(reader.readLine());
		}
		Arrays.sort(yama);
		for (int i = 9; i > 6; i--) {
			builder.append(yama[i]).append('\n');
		}
		System.out.print(builder);
	}
}