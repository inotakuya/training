package introduction_to_Algorithms_and_Data_Structures;

/*
 * 最小全域木
与えられた重み付きグラフ G = (V, E) に対する最小全域木の辺の重みの総和を計算するプログラムを作成してください。

入力
最初の行に G の頂点数 n が与えられます。続く n 行で G を表す n \times n の隣接行列 A が与えられます。
A の要素 a_{ij} は、頂点 i と頂点 j を結ぶ辺の重みを表します。ただし、辺がなければ-1 で示されます。

出力
G の最小全域木の辺の重みの総和を１行に出力してください。

制約
1 \leq n \leq 100
0 \leq a_{ij} \leq 2,000 (a_{ij} \neq -1 のとき)
a_{ij} = a_{ji}
グラフ G は連結である。
入力例 1
5
 -1 2 3 1 -1
 2 -1 -1 4 -1
 3 -1 -1 1 1
 1 4 1 -1 3
 -1 -1 1 3 -1
出力例 1
5
 */
import java.util.Arrays;
import java.util.Scanner;

public class ALDS1_12_A_Minimum_Spanning_Tree {
	public static void main(String[] args) {
		new ALDS1_12_A_Minimum_Spanning_Tree().run();
	}

	int n;
	boolean[] color;
	int[][] map;
	int INF = 1 << 24;

	private void run() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int e = scanner.nextInt();
				map[i][j] = e == -1 ? INF : e;
			}
		}
		System.out.println(prim());
	}

	private int prim() {
		int u;
		int minv;
		int[] d = new int[n];
		int[] p = new int[n];
		color = new boolean[n];
		Arrays.fill(d, INF);
		Arrays.fill(p, -1);
		d[0] = 0;
		while (true) {
			minv = 1 << 24;
			u = -1;
			for (int i = 0; i < n; i++) {
				if (minv > d[i] && !color[i]) {
					u = i;
					minv = d[i];
				}
			}
			if (u == -1)
				break;
			color[u] = true;
			for (int v = 0; v < n; v++) {
				if (!color[v] && map[u][v] != INF) {
					if (d[v] > map[u][v]) {
						d[v] = map[u][v];
						p[v] = u;
					}
				}

			}

		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (p[i] != -1)
				sum += map[i][p[i]];
		}
		return sum;

	}
}
