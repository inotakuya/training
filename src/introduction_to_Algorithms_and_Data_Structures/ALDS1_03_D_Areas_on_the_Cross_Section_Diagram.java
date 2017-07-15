package introduction_to_Algorithms_and_Data_Structures;

/*
 * Areas on the Cross-Section Diagram
地域の治水対策として、洪水の被害状況をシミュレーションで仮想してみよう。

図のように 1 \times 1 (m^2) の区画からなる格子上に表された地域の模式断面図が与えられるので、地域にできる各水たまりの面積を報告してください。



与えられた地域に対して限りなく雨が降り、地域から溢れ出た水は左右の海に流れ出ると仮定します。
 例えば、図の断面図では、左から面積が 4、2、1、19、9 の水たまりができます。

入力
模式断面図における斜面を '/' と '\'、平地を '_' で表した文字列が１行に与えられます。
例えば、図の模式断面図は文字列 \\///\_/\/\\\\/_/\\///__\\\_\\/_\/_/\ で与えられます。

出力
次の形式で水たまりの面積を出力してください。

A
k L_1 L_2 ... L_k

１行目に地域にできる水たまりの総面積を表す整数 A を出力してください。

２行目に水たまりの数 k、各水たまりの面積 L_i (i = 1, 2, ..., k) を断面図の左から順番に空白区切りで出力してください。

制約
1 \leq 文字列の長さ \leq 20,000
ただし、得点の 50 点分は以下の条件を満たす。

水たまりの数は１つ以下であり (k \leq 1)、かつ文字列の長さは 100 以下である。
入力例 1
\\//
出力例 1
4
1 4

入力例 2
\\///\_/\/\\\\/_/\\///__\\\_\\/_\/_/\
出力例 2
35
5 4 2 1 19 9
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ALDS1_03_D_Areas_on_the_Cross_Section_Diagram {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder builder = new StringBuilder();
		Deque<Integer> S = new ArrayDeque<Integer>();
		Deque<int[]> L = new ArrayDeque<int[]>();

		char[] g = reader.readLine().toCharArray();
		int sum = 0;
		for (int i = 0; i < g.length; i++) {
			if (g[i] == '\\')
				S.add(i);
			else if (!S.isEmpty() && g[i] == '/') {
				int s = i - S.getLast();
				sum += s;
				while (!L.isEmpty() && S.getLast() < L.getLast()[0]) {
					s += L.getLast()[1];
					L.removeLast();
				}
				int[] data = { S.pollLast(), s };
				L.add(data);
			}
		}
		builder.append(sum).append('\n').append(L.size());
		for (int[] t : L) {
			builder.append(' ').append(t[1]);
		}
		System.out.println(builder);

	}
}
