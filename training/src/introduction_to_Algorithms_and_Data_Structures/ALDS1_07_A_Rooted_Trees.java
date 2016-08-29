package introduction_to_Algorithms_and_Data_Structures;

/*
 * 根付き木
与えられた根付き木 T の各節点 u について、以下の情報を出力するプログラムを作成してください。

u の節点番号
u の親の節点番号
u の深さ
u の節点の種類（根、内部節点または葉）
u の子のリスト
ここでは、与えられる木は n 個の節点を持ち、それぞれ 0 から n － 1 の番号が割り当てられているものとします。

入力
入力の最初の行に、節点の個数 n が与えられます。続く n 行目に、各節点の情報が次の形式で１行に与えられます。

id k c_1 c_2 ... c_k

id は節点の番号、k は次数を表します。c_1 c_2 ...c_k は 1 番目の子の節点番号、... k 番目の子の節点番号を示します。

出力
次の形式で節点の情報を出力してください。節点の情報はその番号が小さい順に出力してください。

node id: parent = p , depth = d, type, [c_1...c_k]

p は親の番号を示します。ただし、親を持たない場合は -1 とします。d は節点の深さを示します。

typeは根、内部節点、葉をそれぞれあらわす root、internal node、leaf の文字列のいずれかです。
ただし、根が葉や内部節点の条件に該当する場合は root とします。

c_1...c_k は子のリストです。順序木とみなし入力された順に出力してください。カンマ空白区切りに注意してください。
出力例にて出力形式を確認してください。

制約
1 \leq n \leq 100,000
節点の深さは 20 を超えない。
任意の２つの節点間には必ず経路が存在する。
入力例 1
13
0 3 1 4 10
1 2 2 3
2 0
3 0
4 3 5 6 7
5 0
6 0
7 2 8 9
8 0
9 0
10 2 11 12
11 0
12 0
出力例 1
node 0: parent = -1, depth = 0, root, [1, 4, 10]
node 1: parent = 0, depth = 1, internal node, [2, 3]
node 2: parent = 1, depth = 2, leaf, []
node 3: parent = 1, depth = 2, leaf, []
node 4: parent = 0, depth = 1, internal node, [5, 6, 7]
node 5: parent = 4, depth = 2, leaf, []
node 6: parent = 4, depth = 2, leaf, []
node 7: parent = 4, depth = 2, internal node, [8, 9]
node 8: parent = 7, depth = 3, leaf, []
node 9: parent = 7, depth = 3, leaf, []
node 10: parent = 0, depth = 1, internal node, [11, 12]
node 11: parent = 10, depth = 2, leaf, []
node 12: parent = 10, depth = 2, leaf, []
入力例 2
4
1 3 3 2 0
0 0
3 0
2 0
出力例 2
node 0: parent = 1, depth = 1, leaf, []
node 1: parent = -1, depth = 0, root, [3, 2, 0]
node 2: parent = 1, depth = 1, leaf, []
node 3: parent = 1, depth = 1, leaf, []
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class ALDS1_07_A_Rooted_Trees {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new ALDS1_07_A_Rooted_Trees().run();
	}

	private void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Node[] T = new Node[n];

		for (int i = 0; i < n; i++) {
			T[i] = new Node();
		}
		int l = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int v = Integer.parseInt(tokenizer.nextToken());
			T[v].id = v;
			int d = Integer.parseInt(tokenizer.nextToken());
			for (int j = 0; j < d; j++) {
				int c = Integer.parseInt(tokenizer.nextToken());
				if (j == 0) {
					T[v].l = c;
				} else {
					T[l].r = c;
				}
				l = c;
				T[c].p = v;
			}
		}
		int r = -1;
		for (int i = 0; i < n; i++) {
			if (T[i].p == -1) {
				r = i;
				break;
			}
		}
		int[] D = new int[n];
		rec(r, 0, D, T);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			print(i, T, D, builder);
		}
		System.out.print(builder);
	}

	private void print(int u, Node[] T, int[] D, StringBuilder builder) {
		builder.append("node ").append(u).append(": parent = ").append(T[u].p).append(", depth = ").append(D[u])
				.append(", ");
		if (T[u].p == -1)
			builder.append("root, ");
		else if (T[u].l == -1)
			builder.append("leaf, ");
		else
			builder.append("internal node, ");
		builder.append("[");
		for (int i = 0, c = T[u].l; c != -1; i++, c = T[c].r) {
			if (i != 0)
				builder.append(", ");
			builder.append(c);
		}
		builder.append("]\n");
	}

	private void rec(int u, int p, int[] D, Node[] T) {
		Deque<Node> deque = new ArrayDeque<Node>();
		deque.offer(T[u]);
		while (!deque.isEmpty()) {
			int t = deque.size();
			for (int i = 0; i < t; i++) {
				Node node = deque.poll();
				D[node.id] = p;
				if (node.l != -1) {
					node = T[node.l];
					while (true) {
						deque.offer(T[node.id]);
						if (node.r != -1) {
							node = T[node.r];
						} else {
							break;
						}
					}
				}
			}
			p++;
		}
	}

	class Node {
		int id = -1;
		int p = -1;
		int l = -1;
		int r = -1;
	}
}
