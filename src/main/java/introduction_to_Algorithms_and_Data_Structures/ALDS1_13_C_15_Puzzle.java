package introduction_to_Algorithms_and_Data_Structures;

/*
 * １５パズル
15 パズルは１つの空白を含む 4 \times 4 のマス上に 15 枚のパネルが配置され、空白を使ってパネルを上下左右にスライドさせ、絵柄を揃えるパズルです。

この問題では、次のように空白を 0、各パネルを 1 から 15 の番号でパズルを表します。

1 2 3 4
6 7 8 0
5 10 11 12
9 13 14 15
1 回の操作で空白の方向に１つのパネルを移動することができ、ゴールは次のようなパネルの配置とします。

1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 0
15 パズルの初期状態が与えられるので、ゴールまでの最短手数を求めるプログラムを作成してください。

入力
入力はパネルの数字あるいは空白を表す 4 \times 4　個の整数です。空白で区切られた 4 つの整数が 4 行で与えられます。

出力
最短手数を１行に出力してください。

制約
与えられるパズルは 45 手以内で解くことができる。
入力例
1 2 3 4
6 7 8 0
5 10 11 12
9 13 14 15
出力例
8
 */
import java.util.Arrays;
import java.util.Scanner;

public class ALDS1_13_C_15_Puzzle {
	public static void main(String[] args) {

		new ALDS1_13_C_15_Puzzle().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		MDT = new int[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				MDT[i][j] = Math.abs(i / 4 - j / 4) + Math.abs(i % 4 - j % 4);
			}
		}
		int[] a = new int[16];
		int zero = -1;
		for (int i = 0; i < 16; i++) {
			a[i] = scanner.nextInt();
			if (a[i] == 0)
				zero = i;
		}
		int md = getMD(a);
		Puzzle in = new Puzzle(a, zero, md);

		for (limit = in.md; limit <= 45; limit++) {
			puzzle = in.clone();
			if (dfs(0, -100)) {
				System.out.println(limit);
				break;
			}
		}

	}

	Puzzle puzzle;

	private boolean dfs(int depth, int s) {
		if (puzzle.md == 0)
			return true;
		if (puzzle.md + depth > limit)
			return false;

		int y = puzzle.zero / 4;
		int x = puzzle.zero % 4;
		for (int r = 0; r < 4; r++) {

			int ny = y + move[r][0];
			int nx = x + move[r][1];
			if (ny < 0 || 4 <= ny || nx < 0 || 4 <= nx)
				continue;
			if (Math.max(s, r) - Math.min(s, r) == 2)
				continue;
			int nz = ny * 4 + nx;
			Puzzle p = puzzle.clone();

			puzzle.md -= MDT[nz][puzzle.map[nz] - 1];
			puzzle.md += MDT[puzzle.zero][p.map[nz] - 1];
			swap(puzzle.map, puzzle.zero, nz);
			puzzle.zero = nz;
			if (dfs(depth + 1, r))
				return true;
			puzzle = p;

		}
		return false;

	}

	int limit;

	private void swap(int[] tmpMap, int zero, int nz) {
		int tmp = tmpMap[zero];
		tmpMap[zero] = tmpMap[nz];
		tmpMap[nz] = tmp;
	}

	int[][] move = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	private int getMD(int[] a) {
		int sum = 0;
		for (int i = 0; i < 16; i++) {
			if (a[i] == 0)
				continue;
			sum += MDT[i][a[i] - 1];
		}
		return sum;
	}

	int[][] MDT;

	class Puzzle implements Cloneable {
		int[] map;
		int zero;
		int md;

		public Puzzle(int[] map, int zero, int md) {
			super();
			this.map = map;
			this.zero = zero;
			this.md = md;
		}

		@Override
		public Puzzle clone() {
			try {
				Puzzle clonePuzzle = (Puzzle) super.clone();
				clonePuzzle.map = Arrays.copyOf(this.map, 16);
				return clonePuzzle;
			} catch (CloneNotSupportedException e) {
				throw new InternalError();
			}
		}

		@Override
		public String toString() {
			return "Puzzle [map=" + Arrays.toString(map) + ", zero=" + zero + ", md=" + md + "]";
		}

	}
}
