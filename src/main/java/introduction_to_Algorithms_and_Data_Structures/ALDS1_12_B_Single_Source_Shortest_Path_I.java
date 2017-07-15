package introduction_to_Algorithms_and_Data_Structures;

/*
 * 単一始点最短経路
与えられた重み付き有向グラフ G = (V, E) について、単一始点最短経路のコストを求めるプログラムを作成してください。G の頂点 0 を始点とし、
0 から各頂点 v について、最短経路上の辺の重みの総和 d[v] を出力してください。

入力
最初の行に G の頂点数 n が与えられます。続く n 行で各頂点 u の隣接リストが以下の形式で与えられます：

u k v_1 c_1 v_2 c_2 ... v_k c_k

G の各頂点には 0 から n-1 の番号がふられています。u は頂点の番号であり、k は u の出次数を示します。v_i (i = 1, 2, ... k) は 
u に隣接する頂点の番号であり、c_i は u と v_i をつなぐ有向辺の重みを示します。

出力
各頂点の番号 v と距離 d[v] を１つの空白区切りで順番に出力してください。

制約
1 \leq n \leq 100
0 \leq c_i \leq 100,000
|E| \leq 10,000
0 から各ノードへは必ず経路が存在する
入力例 1
5
0 3 2 3 3 1 1 2
1 2 0 2 3 4
2 3 0 3 3 1 4 1
3 4 2 1 0 1 1 4 4 3
4 2 2 1 3 3
出力例 1
0 0
1 2
2 2
3 1
4 3
 */
import java.util.Arrays;
import java.util.Scanner;

public class ALDS1_12_B_Single_Source_Shortest_Path_I {
	public static void main(String[] args) {
		new ALDS1_12_B_Single_Source_Shortest_Path_I().run();
	}

	int n;
	boolean[] color;
	int[][] map;
	int INF = 1 << 24;

	private void run() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		for (int[] a : map)
			Arrays.fill(a, INF);
		for (int i = 0; i < n; i++) {
			int u = scanner.nextInt();
			int k = scanner.nextInt();
			for (int j = 0; j < k; j++) {
				int v = scanner.nextInt();
				int c = scanner.nextInt();
				map[u][v] = c;
			}

		}
		dijkstra();
	}

	private void dijkstra() {
		int minv;
		int[] d = new int[n];
		color = new boolean[n];
		Arrays.fill(d, INF);
		d[0] = 0;
		while (true) {
			minv = INF;
			int u = -1;
			for (int i = 0; i < n; i++) {
				if (minv > d[i] && !color[i]) {
					u = i;
					minv = d[i];
				}
			}
			if (u == -1)
				break;
			color[u] = true;
			for (int i = 0; i < n; i++) {
				if (!color[i] && d[i] > d[u] + map[u][i]) {
					d[i] = d[u] + map[u][i];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("%d %d\n", i, d[i] == INF ? -1 : d[i]);
		}

	}
}
