package volume00;

/**
 * 大文字変換
文字列に含まれる半角英小文字を半角英大文字に置き換えて、その文字列を出力するプログラムを作成して下さい。
半角英小文字以外の文字は置き換えないで下さい。

Input
半角英小文字、ピリオド、空白のみを含む文字列が１行に与えられます。文字列の長さは 200 を超えません。

Output
半角英小文字を半角英大文字に置き換えた文字列を出力して下さい。

Sample Input
this is a pen.
Output for the Sample Input
THIS IS A PEN.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0020_Capitalize {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		System.out.println(reader.readLine().toUpperCase());
	}
}
