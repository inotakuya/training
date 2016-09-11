package volume00;

/**
 * 文字列反転 文字列 str を入力し、その文字列を逆順に出力するプログラムを作成して下さい。文字は半角英数字のみで、20 文字以内とします。
 * 
 * Input 文字列 str が１行に与えられる。
 * 
 * Output str を逆順にした文字列を１行に出力する。
 * 
 * Sample Input w32nimda Output for the Sample Input admin23w
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0006_Reverse_Sequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer to;
		char[] cs = reader.readLine().toCharArray();
		for (int i = cs.length - 1; i >= 0; i--) {
			builder.append(cs[i]);
		}
		System.out.println(builder);

	}
}
