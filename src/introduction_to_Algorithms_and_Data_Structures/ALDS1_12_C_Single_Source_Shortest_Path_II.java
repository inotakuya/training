package introduction_to_Algorithms_and_Data_Structures;

/*
 * 単一始点最短経路 II
与えられた重み付き有向グラフ G = (V, E) について、単一始点最短経路のコストを求めるプログラムを作成してください。
G の頂点 0 を始点とし、0 から各頂点 v について、最短経路上の辺の重みの総和 d[v] を出力してください。

入力
最初の行に G の頂点数 n が与えられます。続く n 行で各頂点 u の隣接リストが以下の形式で与えられます：

u k v_1 c_1 v_2 c_2 ... v_k c_k

G の各頂点には 0 から n-1 の番号がふられています。u は頂点の番号であり、k は u の出次数を示します。
v_i (i = 1, 2, ... k) は u に隣接する頂点の番号であり、c_i は u と v_i をつなぐ有向辺の重みを示します。

出力
各頂点の番号 v と距離 d[v] を１つの空白区切りで順番に出力してください。

制約
1 \leq n \leq 10,000
0 \leq c_i \leq 100,000
|E| < 500,000
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ALDS1_12_C_Single_Source_Shortest_Path_II {
	public static void main(String[] args) {
		new ALDS1_12_C_Single_Source_Shortest_Path_II().run();
	}

	int n;
	boolean[] color;
	List<List<Edge>> adj = new ArrayList<List<Edge>>();
	int INF = 1 << 24;

	private void run() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < n; i++) {
			int v = scanner.nextInt();
			int k = scanner.nextInt();
			for (int j = 0; j < k; j++) {
				int f = scanner.nextInt();
				int s = scanner.nextInt();
				adj.get(v).add(new Edge(f, s));
			}
		}
		slove();
	}

	private void slove() {
		color = new boolean[n];
		int[] d = new int[n];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		Arrays.fill(d, INF);
		d[0] = 0;
		while (!pq.isEmpty()) {
			Edge f = pq.poll();
			int u = f.second;
			color[u] = true;
			if (d[u] < f.first)
				continue;
			for (int i = 0; i < adj.get(u).size(); i++) {
				int v = adj.get(u).get(i).first;
				if (color[v])
					continue;
				int a = adj.get(u).get(i).second;
				if (d[v] > d[u] + a) {
					d[v] = d[u] + a;
					pq.add(new Edge(d[v], v));
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("%d %d\n", i, d[i]);
		}

	}

	class Edge implements Comparable<Edge> {
		int first;
		int second;

		public Edge(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Edge o) {
			return this.first - o.first;
		}

	}
}
