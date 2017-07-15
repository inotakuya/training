package volume00;

/**
 * 阿弥陀くじ
下図のような阿弥陀くじがあります。この例では５本の縦線と４本の横線が引かれています。横線は縦線をまたいでもよいものとします。



図の上部に書かれた 1, 2, 3, 4, 5 の数字は、２番目と４番目の縦線の間で交換され（これを (2, 4) のように書きます）、
さらに、(3, 5) (1, 2) (3, 4) を通過し、最終的に 4, 1, 2, 5, 3 に変換されます。

最初の状態　1, 2, 3, 4... が、与えられた横棒のリスト（上の例では、(2, 4) (3, 5) (1, 2) (3, 4) ）を
通過したのち、どのような順番になるかを出力するプログラムを作成して下さい。

Input
入力は以下の形式で与えられる。

w
n
a1,b1
a2,b2
.
.
an,bn
w (整数：w ≤ 30) は縦線の本数、n (整数：n ≤ 30) は横棒の本数を表す。カンマで区切られた２つの整数 ai、bi の組が i 番目の横棒を表す。

Output
左から右の順番で 1 番目の棒に現れる数字、2 番目の棒に現れる数字、...、w 番目の棒に現れる数字をそれぞれ１行に出力する。

Sample Input
5
4
2,4
3,5
1,2
3,4
Output for the Sample Input
4
1
2
5
3

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0011_Drawing_Lots {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;
		int a = Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());
		int[] nums = new int[a];
		for (int i = 0; i < a; i++) {
			nums[i] = i + 1;
		}
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine(), ",");
			int x = Integer.parseInt(tokenizer.nextToken()) - 1;
			int y = Integer.parseInt(tokenizer.nextToken()) - 1;
			int tmp = nums[x];
			nums[x] = nums[y];
			nums[y] = tmp;
		}
		for (int i = 0; i < a; i++) {
			builder.append(nums[i]).append('\n');
		}
		System.out.print(builder);

	}
}
