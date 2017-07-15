package introduction_to_Algorithms_and_Data_Structures;

/*
 * キュー
名前 namei と必要な処理時間 timei を持つ n 個のプロセスが順番に一列に並んでいます。ラウンドロビンスケジューリングと呼ばれる処理方法では、CPU がプロセスを順番に処理します。各プロセスは最大 q ms（これをクオンタムと呼びます）だけ処理が実行されます。q ms だけ処理を行っても、まだそのプロセスが完了しなければ、そのプロセスは列の最後尾に移動し、CPU は次のプロセスに割り当てられます。

例えば、クオンタムを 100 msとし、次のようなプロセスキューを考えます。

A(150) - B(80) - C(200) - D(200)
まずプロセス A が 100 ms だけ処理され残りの必要時間 50 ms を保持しキューの末尾に移動します。

B(80) - C(200) - D(200) - A(50)
次にプロセス B が 80 ms だけ処理され、時刻 180 ms で終了し、キューから削除されます。

C(200) - D(200) - A(50)
次にプロセス C が 100 ms だけ処理され、残りの必要時間 100 ms を保持し列の末尾に移動します。

D(200) - A(50) - C(100)
このように、全てのプロセスが終了するまで処理を繰り返します。

ラウンドロビンスケジューリングをシミュレートするプログラムを作成してください。

入力
入力の形式は以下の通りです。

n q
name1 time1
name2 time2
...
namen timen
最初の行に、プロセス数を表す整数 n とクオンタムを表す整数 q が１つの空白区切りで与えられます。

続く n 行で、各プロセスの情報が順番に与えられます。文字列 namei と整数 timei は１つの空白で区切られています。

出力
プロセスが完了した順に、各プロセスの名前と終了時刻を空白で区切って１行に出力してください。

制約
1 ≤ n ≤ 100,000
1 ≤ q ≤ 1,000
1 ≤ timei ≤ 50,000
1 ≤ 文字列 namei の長さ ≤ 10
1 ≤ timei の合計 ≤ 1,000,000
入力例 1
5 100
p1 150
p2 80
p3 200
p4 350
p5 20
出力例 1
p2 180
p5 400
p1 450
p3 550
p4 800
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class ALDS1_03_B_Queue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String[] line = reader.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int q = Integer.parseInt(line[1]);
		Queue<String[]> queue = new ArrayDeque<String[]>();
		for (int i = 0; i < n; i++) {
			queue.add(reader.readLine().split(" "));
		}
		String[] work = new String[2];
		int elapse = 0;
		while ((work = queue.poll()) != null) {
			int time = Integer.parseInt(work[1]);
			if (time <= q) {
				elapse += time;
				builder.append(work[0]).append(" ").append(elapse).append("\n");
			} else {
				time -= q;
				elapse += q;
				work[1] = String.valueOf(time);
				queue.add(work);
			}

		}
		System.out.print(builder);
	}
}
