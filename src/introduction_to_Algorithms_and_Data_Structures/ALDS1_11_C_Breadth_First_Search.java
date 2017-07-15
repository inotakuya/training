package introduction_to_Algorithms_and_Data_Structures;

/*
 * 幅優先探索
与えられた有向グラフ G = (V, E) について、頂点 1 から各頂点への最短距離 d（パス上の辺の数の最小値）を求めるプログラムを作成してください。
各頂点には 1 から n までの番号がふられているものとします。頂点 1 からたどり着けない頂点については、距離として-1 を出力してください。

入力
最初の行に G の頂点数 n が与えられます。続く n 行で各頂点 u の隣接リストが以下の形式で与えられます：

u k v_1 v_2 ... v_k

u は頂点の番号、k は u の出次数、v_1\; v_2\; ...\; v_k　は u に隣接する頂点の番号を示します。

制約
1 \leq n \leq 100
出力
各頂点について id、d を１行に出力してください。id は頂点の番号、d は頂点 1 からその頂点までの距離を示します。頂点番号順に出力してください。

入力例 1
4
1 2 2 4
2 1 4
3 0
4 1 3
出力例 1
1 0
2 1
3 2
4 1
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ALDS1_11_C_Breadth_First_Search {
	public static void main(String[] args) {
		new ALDS1_11_C_Breadth_First_Search().run();
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
		bfs(0);
	}

	private void bfs(int s) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.offer(s);
		int count = 0;
		Arrays.fill(d, -1);
		d[0] = 0;
		color[0] = true;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				int q = deque.poll();
				d[q] = count;
				for (int j = 0; j < n; j++) {
					if (M[q][j] && !color[j]) {
						color[j] = true;
						deque.offer(j);
					}
				}
			}
			count++;

		}
		for (int u = 0; u < n; u++) {
			System.out.printf("%d %d\n", u + 1, d[u]);
		}
	}

	int tt = 1;
}
