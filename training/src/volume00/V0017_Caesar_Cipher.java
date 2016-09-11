package volume00;

/**
 * シーザー暗号
文字のアルファベットを、何文字かずらしたアルファベットに置き換えて作られる暗号をシーザー暗号といいます。
例えば、アルファベットを１文字ずらし、a を b に、b を c に、y を z に、z を a に置き換えることによって、文を暗号化することができます。
この場合、例えば

this is a pen
という文字列は

uijt jt b qfo
と暗号化されます。

シーザー暗号によって暗号化されたデータを入力として受け取り、復号されたデータを出力するプログラムを作成して下さい。
何文字ずらしたかは秘密で、各データによって異なります。ただし、暗号化する前のデータは
 the, this, that という単語のいずれかを含む英語の文章ですので、それを手がかりに復号して下さい。

１つの考えられるプログラムは、暗号化で１文字ずらしたと仮定して復号してみる、２文字ずらしたと仮定して復号してみる、という処理を繰り返し
、復号されたデータに the, this, that のいずれかが含まれるならばそれを出力して終了するというものでしょう。

Input
複数のデータセットが与えられます。各データセットに暗号化された文字列が１行に与えられます。入力の最後まで処理して下さい。

暗号化されたデータに含まれる文字は、アルファベットの小文字、ピリオド、空白、改行のみです。暗号化にあたり、
アルファベット以外の文字は置き換えられていません。暗号化されたデータは空白、ピリオド、改行を含めて 80 文字以下です。

データセットの数は 20 を超えません。

Output
各データセットに対して、復号した文を１行に出力して下さい。

Sample Input
xlmw mw xli tmgxyvi xlex m xsso mr xli xvmt.
Output for the Sample Input
this is the picture that i took in the trip.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class V0017_Caesar_Cipher {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;
		String line;
		String result;
		while ((line = reader.readLine()) != null) {

			int[] lines = new int[line.length()];
			for (int i = 0; i < line.length(); i++) {
				lines[i] = line.codePointAt(i);
			}
			int t = 0;
			while (true) {

				char[] cs = new char[lines.length];
				for (int i = 0; i < lines.length; i++) {
					cs[i] = (char) lines[i];
				}

				result = String.valueOf(cs);
				if (result.contains("the") || result.contains("this") || result.contains("that")) {
					break;
				}
				for (int i = 0; i < lines.length; i++) {
					if (lines[i] >= 'a') {
						lines[i] = lines[i] + 1;
						if (lines[i] > 'z')
							lines[i] -= 26;
					}
				}

			}
			System.out.println(result);

		}
	}
}
