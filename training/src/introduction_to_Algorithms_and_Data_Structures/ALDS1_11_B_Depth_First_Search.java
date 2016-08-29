package introduction_to_Algorithms_and_Data_Structures;

/*
 * 深さ優先探索
深さ優先探索（Depth First Search: DFS）は、可能な限り隣接する頂点を訪問する、という戦略に基づくグラフの探索アルゴリズムです。
未探索の接続辺が残されている頂点の中で最後に発見した頂点 v の接続辺を再帰的に探索します。
v の辺をすべて探索し終えると、v を発見したときに通ってきた辺を後戻りして探索を続行します。

探索は元の始点から到達可能なすべての頂点を発見するまで続き、未発見の頂点が残っていれば、
その中の番号が一番小さい１つを新たな始点として探索を続けます。

深さ優先探索では、各頂点に以下のタイムスタンプを押します：

タイムスタンプ d[v]: v を最初に発見した発見時刻を記録します。
タイムスタンプ f[v]: v の隣接リストを調べ終えた完了時刻を記録します。
以下の仕様に基づき、与えられた有向グラフ G = (V, E) に対する深さ優先探索の動作を示すプログラムを作成してください：

G は隣接リスト表現の形式で与えられます。各頂点には 1 から n までの番号がふられています。
各隣接リストの頂点は番号が小さい順に並べられています。
プログラムは各頂点の発見時刻と完了時刻を報告します。
深さ優先探索の過程において、訪問する頂点の候補が複数ある場合は頂点番号が小さいものから選択します。
最初に訪問する頂点の開始時刻を 1 とします。
入力
最初の行に G の頂点数 n が与えられます。続く n 行で各頂点 u の隣接リストが以下の形式で与えられます：

u k v_1 v_2 ... v_k

u は頂点の番号、k は u の出次数、v_1\; v_2\; ...\; v_k 　は u に隣接する頂点の番号を示します。

出力
各頂点について id、 d、 fを空白区切りで１行に出力してください。id は頂点の番号、d はその頂点の発見時刻、
f はその頂点の完了時刻です。頂点の番号順で出力してください。

制約
1 \leq n \leq 100
入力例 1
4
1 1 2
2 1 4
3 0
4 1 3
出力例 1
1 1 8
2 2 7
3 4 5
4 3 6

入力例 2
6
1 2 2 3
2 2 3 4
3 1 5
4 1 6
5 1 6
6 0
出力例 2
1 1 12
2 2 11
3 3 8
4 9 10
5 4 7
6 5 6
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ALDS1_11_B_Depth_First_Search {
	public static void main(String[] args) {
		new ALDS1_11_B_Depth_First_Search().run();
	}

	boolean[][] M;
	int n;
	boolean color[];
	int d[];
	int f[];

	private void run() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		M = new boolean[n][n];
		color = new boolean[n];
		d = new int[n];
		f = new int[n];
		for (int i = 0; i < n; i++) {
			int u = scanner.nextInt();
			int k = scanner.nextInt();
			u--;
			for (int j = 0; j < k; j++) {
				int v = scanner.nextInt();
				v--;
				M[u][v] = true;
			}
		}
		dfs();
	}

	private void dfs() {
		for (int u = 0; u < n; u++) {
			if (!color[u])
				dfs_visit(u);
		}
		for (int u = 0; u < n; u++) {
			System.out.printf("%d %d %d\n", u + 1, d[u], f[u]);
		}
	}

	int tt = 1;

	private void dfs_visit(int u) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.push(u);
		loop: while (!deque.isEmpty()) {
			int t = deque.peek();
			if (!color[t]) {
				color[t] = true;
				d[t] = tt++;
			}
			for (int v = 0; v < n; v++) {
				if (M[t][v] && !color[v]) {
					deque.push(v);
					continue loop;
				}
			}
			deque.poll();
			f[t] = tt++;
		}

	}
}
