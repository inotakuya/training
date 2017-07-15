package introduction_to_Algorithms_and_Data_Structures;

/*
 * Reconstruction of a Tree
ある二分木に対して、それぞれ先行順巡回 (preorder tree walk) と中間順巡回 (inorder tree walk) を
行って得られる節点の列が与えられるので、その二分木の後行順巡回 (postorder tree walk) で得られる節点の
列を出力するプログラムを作成してください。

入力
１行目に二分木の節点の数 nn が与えられます。
２行目に先行順巡回で得られる節点の番号の列が空白区切りで与えられます。
３行目に中間順巡回で得られる節点の番号の列が空白区切りで与えられます。

節点には 11 から nn までの整数が割り当てられています。11 が根とは限らないことに注意してください。

出力
後行順巡回で得られる節点の番号の列を１行に出力してください。節点の番号の間に１つの空白を入れてください。

制約
1≤n≤401≤n≤40
入力例 1
5
1 2 3 4 5
3 2 4 1 5
出力例 1
3 4 2 5 1
入力例 2
4
1 2 3 4
1 2 3 4
出力例 2
4 3 2 1
 */
import java.io.IOException;
import java.util.Scanner;

public class ALDS1_07_D_Reconstruction_of_a_Tree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new ALDS1_07_D_Reconstruction_of_a_Tree().run();
	}

	private void run() throws NumberFormatException, IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] pre = new int[n][2];
		for (int i = 0; i < n; i++) {
			pre[i][0] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			int t = scanner.nextInt();
			for (int j = 0; j < n; j++) {
				if (pre[j][0] == t) {
					pre[j][1] = i;
				}
			}
		}
		rec(0, n, pre);

	}

	int pos = 0;

	private void rec(int l, int r, int[][] pre) {
		if (l >= r)
			return;
		int root = pre[pos][0];
		int m = pre[pos][1];
		pos++;
		rec(l, m, pre);
		rec(m + 1, r, pre);
		System.out.print(root);
		System.out.print(root == pre[0][0] ? '\n' : ' ');
	}
}
