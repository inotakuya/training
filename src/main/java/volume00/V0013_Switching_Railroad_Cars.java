package volume00;

/**
 * 電車車両入替え


上図のような電車車両入替え用の線路があります。この線路は、図の下側は行き止まりになっており、上側の左右それぞれの線路は、
左が入り口専用、右が出口専用になっています。ここを走る車両は 10 両あり、それぞれ 1 から 10 までの番号が付けられています。

この線路の左上から車両が入ってきて、行き止まりの線路に入ることを車両の番号で表し、
また行き止まりに入っている先頭の車両が出て行くことを 0 で表すと、これらを並べて車両の出入りの様子を表すことができます。例えば

1
6
0
8
10
は、「まず 1 番が入り、次いで 6 番が入り、次に先頭の 1 台（今入ってきた 6 番）が出てゆき、8 番が入り、
10 番が入る」という順序の出入りを示しています。

この形式の数字の列を入力データとして読み、出てゆく車両の番号をその順番に出力するプログラムを作成してください。
なお、最初は行き止まりの線路には車両は入っていないものとします。また、データは常に車両の出入りを正しく表すものが与えられます。
例えば、行き止まりの線路がカラにもかかわらず次の入力が「0」、などという間違ったデータは入力されません。

Input
入力は以下の形式で与えられる。

入ってくる車両の番号（整数）
入ってくる車両の番号または 0 （整数）
　　　　　　.
　　　　　　.
　　　　　　.
入ってくる車両の番号または 0 （整数）
入ってくる車両の番号または 0 （整数）
入力される整数の数は 100 を超えない。

Output
0 が入力されるたびに、出てゆく車両の番号を１行に出力する。

Sample Input
1
6
0
8
10
0
0
0
Output for the Sample Input
6
10
8
1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class V0013_Switching_Railroad_Cars {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		String s;
		while ((s = reader.readLine()) != null) {
			int num = Integer.parseInt(s);
			if (num == 0)
				System.out.println(deque.poll());
			else
				deque.push(num);
		}
	}
}
