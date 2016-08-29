package introduction_to_Algorithms_and_Data_Structures;

/*
 * 二分探索木II
A: Binary Search Tree I に、find 命令を追加し、二分探索木 T に対し、以下の命令を実行するプログラムを作成してください。

insert k: Tにキー k を挿入する。
find k: Tにキー k が存在するか否かを報告する。
print: キーを木の中間順巡回(inorder tree walk)と先行順巡回(preorder tree walk)アルゴリズムで出力する。
入力
入力の最初の行に、命令の数 m が与えられます。続くm 行目に、insert k、find k またはprintの形式で命令が１行に与えられます。

出力
find k 命令ごとに、T に k が含まれる場合 yes と、含まれない場合 no と１行に出力してください。

さらに print 命令ごとに、中間順巡回アルゴリズム、先行順巡回アルゴリズムによって得られるキーの順列をそれぞれ１行に出力してください。
各キーの前に１つの空白を出力してください。

制約
命令の数は 500,000 を超えない。
print 命令の数は 10 を超えない。
-2,000,000,000 \leq キー \leq 2,000,000,000
上記の疑似コードのアルゴリズムに従う場合、木の高さは 100 を超えない。
２分探索木中のキーに重複は発生しない。
入力例 1
10
insert 30
insert 88
insert 12
insert 1
insert 20
find 12
insert 17
insert 25
find 16
print
出力例 1
yes
no
 1 12 17 20 25 30 88
 30 12 1 20 17 25 88
 */
import java.util.Scanner;

public class ALDS1_08_B_Binary_Search_Tree_II {
	class Node {
		int key;
		Node left;
		Node right;

		public Node(int key) {
			this.key = key;
		}

	}

	Node root;

	public static void main(String[] args) {
		new ALDS1_08_B_Binary_Search_Tree_II().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while (n-- > 0) {
			char s = scanner.next().charAt(0);
			if (s == 'i') {
				insert(scanner.nextInt());
			} else if (s == 'p') {
				inorder(root);
				System.out.println();
				preorder(root);
				System.out.println();
			} else {
				Node node = find(scanner.nextInt());
				System.out.println(node != null ? "yes" : "no");
			}
		}
	}

	private Node find(int key) {
		Node x = root;
		while (x != null && x.key != key) {
			if (x.key > key)
				x = x.left;
			else
				x = x.right;
		}
		return x;
	}

	private void preorder(Node u) {
		if (u == null)
			return;
		System.out.print(" " + u.key);
		preorder(u.left);
		preorder(u.right);
	}

	private void inorder(Node u) {
		if (u == null)
			return;
		inorder(u.left);
		System.out.print(" " + u.key);
		inorder(u.right);
	}

	private void insert(int key) {
		Node y = null;
		Node x = root;
		Node z = new Node(key);

		while (x != null) {
			y = x;
			if (x.key > z.key)
				x = x.left;
			else
				x = x.right;
		}
		if (y == null)
			root = z;
		else if (y.key > z.key)
			y.left = z;
		else
			y.right = z;
	}
}
