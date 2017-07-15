package introduction_to_Algorithms_and_Data_Structures;

/*
 * 優先順位キュー
優先度付きキュー (priority queue) は各要素がキーを持ったデータの集合 S を保持するデータ構造で、主に次の操作を行います：

insert(S, k): 集合 S に要素 k を挿入する
extractMax(S): 最大のキーを持つ S の要素を S から削除してその値を返す
優先度付きキュー S に対して insert(S, k)、extractMax(S)を行うプログラムを作成してください。ここでは、
キューの要素を整数とし、それ自身をキーとみなします。

入力
優先度付きキュー S への複数の命令が与えられます。各命令は、insert k、extractまたはendの形式で命令が１行に与えられます。
ここで k は挿入する整数を表します。

end命令が入力の終わりを示します。

出力
extract命令ごとに、優先度付きキュー Sから取り出される値を１行に出力してください。

制約
命令の数は2,000,000を超えない。
0 \leq k \leq 2,000,000,000
入力例 1
insert 8
insert 2
extract
insert 10
extract
insert 11
extract
extract
end
出力例 1
8
10
11
2
 */
import java.util.Scanner;

public class ALDS1_09_C_Priority_Queue {
	int MAX = 2000000;
	int H = 0;
	int A[] = new int[MAX + 1];
	int INF = -1;

	public static void main(String[] args) {
		new ALDS1_09_C_Priority_Queue().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.next();
			if (line.equals("end"))
				break;
			else if (line.equals("insert")) {
				insert(scanner.nextInt());
			} else {
				System.out.println(extract());
			}
		}
	}

	private int extract() {
		int maxv = A[1];
		A[1] = A[H--];
		maxHeapify(1);
		return maxv;
	}

	private void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = -1;
		if (l <= H && A[l] > A[i])
			largest = l;
		else
			largest = i;
		if (r <= H && A[r] > A[largest])
			largest = r;
		if (i != largest) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}

	private void insert(int key) {
		H++;
		A[H] = INF;
		inceraseKey(H, key);
	}

	private void inceraseKey(int i, int key) {
		if (A[H] > 0)
			return;
		A[H] = key;
		while (i > 1 && A[i] > A[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	private void swap(int i, int parent) {
		int t = A[i];
		A[i] = A[parent];
		A[parent] = t;
	}

	int parent(int i) {
		return i / 2;
	}

	int left(int i) {
		return i * 2;
	}

	int right(int i) {
		return i * 2 + 1;
	}
}
