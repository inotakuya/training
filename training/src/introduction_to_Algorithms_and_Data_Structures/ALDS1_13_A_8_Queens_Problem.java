package introduction_to_Algorithms_and_Data_Structures;

/*
 * 8クイーン問題
8 クイーン問題とは、8 \times 8 のマスから成るチェス盤に、どのクイーンも他のクイーンを襲撃できないように、8 つのクイーンを配置する問題です。
チェスでは、クイーンは次のように８方向のマスにいるコマを襲撃することができます。



すでにクイーンが配置されている k 個のマスが指定されるので、それらを合わせて８つのクイーンを配置したチェス盤を出力するプログラムを作成してください。

入力
１行目に整数 k が与えられます。続く k 行にクイーンが配置されているマスが２つの整数 r, c で与えられます。
r, c はそれぞれ０から始まるチェス盤の行と列の番号を表します。

出力
出力は 8 \times 8 のチェス盤を表す文字列で、クイーンが配置されたマスを 'Q'、配置されていないマスを '.' で表します。

制約
入力に対する解はただ１つ存在する。
入力例 1
2
2 2
5 3
出力例 1
......Q.
Q.......
..Q.....
.......Q
.....Q..
...Q....
.Q......
....Q...
 */
import java.util.Arrays;
import java.util.Scanner;

public class ALDS1_13_A_8_Queens_Problem {
	public static void main(String[] args) {
		new ALDS1_13_A_8_Queens_Problem().run();
	}

	int N = 8;
	int[] row = new int[N];
	boolean[] col = new boolean[N];
	boolean[] dpos = new boolean[2 * N - 1];
	boolean[] dneg = new boolean[2 * N - 1];

	boolean[][] map = new boolean[N][N];

	void initialize() {
		Arrays.fill(row, -1);
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		initialize();
		int k = scanner.nextInt();
		for (int i = 0; i < k; i++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			row[r] = c;
			col[c] = dpos[r + c] = dneg[r - c + N - 1] = true;
		}
		recurisve(0);

	}

	private void recurisve(int i) {
		if (i == N) {
			printBoard();
			return;
		}
		if (row[i] != -1) {
			recurisve(i + 1);
		}
		for (int j = 0; j < N; j++) {
			if (col[j] || dpos[i + j] || dneg[i - j + N - 1] || row[i] != -1)
				continue;
			row[i] = j;
			col[j] = dpos[i + j] = dneg[i - j + N - 1] = true;
			recurisve(i + 1);
			row[i] = -1;
			col[j] = dpos[i + j] = dneg[i - j + N - 1] = false;
		}
	}

	private void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(row[i] == j ? "Q" : ".");
			}
			System.out.println();
		}
	}
}
