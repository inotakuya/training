package introduction_to_Algorithms_and_Data_Structures;

/*
 * 双方向連結リスト
以下の命令を受けつける双方向連結リストを実装してください。

insert x: 連結リストの先頭にキー x を持つ要素を継ぎ足す
delete x: キー x を持つ最初の要素を連結リストから削除する
deleteFirst: リストの先頭の要素を削除する
deleteLast: リストの末尾の要素を削除する
入力
入力は以下の形式で与えられます。

n
command1
command2
...
commandn
最初の行に命令数 n が与えられます。続く n 行に命令が与えられる。命令は上記4つの命令のいずれかです。キーは整数とします。

出力
全ての命令が終了した後の、連結リスト内のキーを順番に出力してください。連続するキーは１つの空白文字で区切って出力してください。

制約
命令数は 2,000,000 を超えない
delete 命令の回数は 20 を超えない
0 ≤ キーの値 ≤ 109
命令の過程でリストの要素数は 106を超えない
入力例 1
7
insert 5
insert 2
insert 3
insert 1
delete 3
insert 6
delete 5
出力例 1
6 1 2
入力例 2
9
insert 5
insert 2
insert 3
insert 1
delete 3
insert 6
delete 5
deleteFirst
deleteLast
出力例 2
1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ALDS1_03_C_Doubly_Linked_List {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int n = Integer.parseInt(reader.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			String line = reader.readLine();
			if (line.charAt(0) == 'i')
				deque.push(Integer.parseInt(line.substring(7)));
			else if (line.charAt(6) == 'F')
				deque.removeFirst();
			else if (line.charAt(6) == 'L')
				deque.removeLast();
			else
				deque.remove(Integer.parseInt(line.substring(7)));
			/*
			 * System.out.println(deque.stream().map(String::valueOf)
			 * .collect(Collectors.joining(", ", "[", "]")));
			 */
		}
		builder.append(deque.poll());
		for (int num2 : deque)
			builder.append(" ").append(num2);
		System.out.println(builder);
	}
}
