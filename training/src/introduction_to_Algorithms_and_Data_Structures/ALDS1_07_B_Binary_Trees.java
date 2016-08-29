package introduction_to_Algorithms_and_Data_Structures;

/*
 * 二分木
与えられた根付き二分木 T の各節点 u について、以下の情報を出力するプログラムを作成してください。

u の節点番号
u の親
u の兄弟
u の子の数
u の深さ
u の高さ
節点の種類（根、内部節点または葉）
ここでは、与えられる二分木は n 個の節点を持ち、それぞれ 0 から n － 1 の番号が割り当てられているものとします。

入力
入力の最初の行に、節点の個数 n が与えられます。続く n 行目に、各節点の情報が以下の形式で１行に与えられます。

id left right

id は節点の番号、left は左の子の番号、right は右の子の番号を表します。子を持たない場合は left (right)は -1 で与えられます。

出力
次の形式で節点の情報を出力してください。

node id: parent = p , sibling = s , degree = deg, depth = dep, height = h, type

p は親の番号を表します。親を持たない場合は -1 とします。s は兄弟の番号を表します。兄弟を持たない場合は -1 とします。

deg、dep、h はそれぞれ節点の子の数、深さ、高さを表します。

type は根、内部節点、葉をそれぞれ表す root、internal node、leaf の文字列のいずれかです。
ただし、根が葉や内部節点の条件に該当する場合は root とします。

出力例にて、空白区切り等の出力形式を確認してください。

制約
1 \leq n \leq 25
入力例 1
9
0 1 4
1 2 3
2 -1 -1
3 -1 -1
4 5 8
5 6 7
6 -1 -1
7 -1 -1
8 -1 -1
出力例 1
node 0: parent = -1, sibling = -1, degree = 2, depth = 0, height = 3, root
node 1: parent = 0, sibling = 4, degree = 2, depth = 1, height = 1, internal node
node 2: parent = 1, sibling = 3, degree = 0, depth = 2, height = 0, leaf
node 3: parent = 1, sibling = 2, degree = 0, depth = 2, height = 0, leaf
node 4: parent = 0, sibling = 1, degree = 2, depth = 1, height = 2, internal node
node 5: parent = 4, sibling = 8, degree = 2, depth = 2, height = 1, internal node
node 6: parent = 5, sibling = 7, degree = 0, depth = 3, height = 0, leaf
node 7: parent = 5, sibling = 6, degree = 0, depth = 3, height = 0, leaf
node 8: parent = 4, sibling = 5, degree = 0, depth = 2, height = 0, leaf
 */
import java.io.IOException;
import java.util.Scanner;

public class ALDS1_07_B_Binary_Trees {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new ALDS1_07_B_Binary_Trees().run();
	}

	private void run() throws NumberFormatException, IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node();
		}
		for (int i = 0; i < n; i++) {
			int v = scanner.nextInt();
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			nodes[v].left = l;
			nodes[v].right = r;
			if (l != -1)
				nodes[l].parent = v;
			if (r != -1)
				nodes[r].parent = v;
		}
		int root = 0;
		for (int i = 0; i < n; i++) {
			if (nodes[i].parent == -1) {
				root = i;
				break;
			}
		}
		setDepth(root, 0, nodes);
		setHeight(root, nodes);
		for (int i = 0; i < n; i++) {
			print(i, nodes);
		}
	}

	private void print(int u, Node[] nodes) {
		System.out.printf("node %d: parent = %d, sibling = %d, ", u, nodes[u].parent, getSibling(u, nodes));
		int deg = 0;
		if (nodes[u].left != -1)
			deg++;
		if (nodes[u].right != -1)
			deg++;
		System.out.printf("degree = %d, depth = %d, height = %d, ", deg, nodes[u].d, nodes[u].h);
		if (nodes[u].parent == -1)
			System.out.println("root");
		else if (nodes[u].left == -1 && nodes[u].right == -1)
			System.out.println("leaf");
		else
			System.out.println("internal node");
	}

	private Object getSibling(int u, Node[] nodes) {
		int p = nodes[u].parent;
		if (nodes[u].parent == -1)
			return -1;
		if (nodes[p].left != u && nodes[p].left != -1)
			return nodes[p].left;
		if (nodes[p].right != u && nodes[p].right != -1)
			return nodes[p].right;
		return -1;
	}

	private int setHeight(int u, Node[] nodes) {
		int h1 = 0;
		int h2 = 0;
		if (nodes[u].left != -1)
			h1 = setHeight(nodes[u].left, nodes) + 1;
		if (nodes[u].right != -1)
			h2 = setHeight(nodes[u].right, nodes) + 1;
		return nodes[u].h = (h1 > h2 ? h1 : h2);
	}

	private void setDepth(int u, int d, Node[] nodes) {
		if (u == -1)
			return;
		nodes[u].d = d;
		setDepth(nodes[u].left, d + 1, nodes);
		setDepth(nodes[u].right, d + 1, nodes);

	}

	class Node {
		int parent = -1;
		int left = -1;
		int right = -1;
		int d;
		int h;
	}
}
