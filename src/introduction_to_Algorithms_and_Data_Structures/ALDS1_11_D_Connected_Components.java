package introduction_to_Algorithms_and_Data_Structures;

/*
 * 連結成分分解
SNS の友達関係を入力し、双方向の友達リンクを経由してある人からある人へたどりつけるかどうかを判定するプログラムを作成してください。

入力
１行目にSNS のユーザ数を表す整数 n と友達関係の数 m が空白区切りで与えられます。
SNS の各ユーザには 0 から n － 1 までのID が割り当てられています。

続く m 行に１つの友達関係が各行に与えられます。１つの友達関係は空白で区切られた２つの整数 s、t で与えられ、
s と t が友達であることを示します。

続く１行に、質問の数 q が与えられます。続くq 行に質問が与えられます。 各質問は空白で区切られた２つの整数 s、t で与えられ、
「s から t へたどり着けますか？」という質問を意味します。

出力
各質問に対して s から t にたどり着ける場合は yes と、たどり着けない場合は no と１行に出力してください。

制約
2 \leq n \leq 100,000
0 \leq m \leq 100,000
1 \leq q \leq 10,000
入力例
10 9
0 1
0 2
3 4
5 7
5 6
6 7
6 8
7 8
8 9
3
0 1
5 9
1 3
出力例
yes
yes
no
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class ALDS1_11_D_Connected_Components {
	public static void main(String[] args) {
		new ALDS1_11_D_Connected_Components().run();
	}

	List<List<Integer>> G;
	int n;
	int[] color;

	private void run() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int m = scanner.nextInt();
		G = new ArrayList<List<Integer>>();
		color = new int[n];
		for (int i = 0; i < n; i++) {
			G.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			G.get(s).add(t);
			G.get(t).add(s);
		}
		assiginColor();

		int q = scanner.nextInt();
		for (int i = 0; i < q; i++) {
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			if (color[s] == color[t]) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private void assiginColor() {
		Arrays.fill(color, -1);
		int id = 1;
		for (int i = 0; i < n; i++) {
			if (color[i] == -1)
				dfs(i, id++);
		}
	}

	private void dfs(int r, int c) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.push(r);
		color[r] = c;
		while (!deque.isEmpty()) {
			int u = deque.poll();
			for (int i = 0; i < G.get(u).size(); i++) {
				int v = G.get(u).get(i);
				if (color[v] == -1) {
					color[v] = c;
					deque.push(v);
				}
			}
		}
	}
}
