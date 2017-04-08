package volume00;

/**
 * 英語の文章
英語の文章に出現する単語の中で、出現頻度が最も高い単語と、文字数が最も多い単語を出力するプログラムを作成してください。
入力データには英文字、スペースのみが含まれているものとします。単語とは、スペースで区切られた連続する英文字の列です。

Input
英語の文章を表現する文字列（半角の英文字、スペース）が１行に与えられます。

文章の文字数は 1000 文字以下です。一つの単語の文字数は 32 文字以下です。出現頻度が最も高い単語、
最長の文字数を持つ単語はそれぞれ文中にただ一つだけ存在するものとします。

Output
最も出現頻度が高い単語と、最も文字数が多い単語を１つのスペースで区切って１行に出力して下さい。

Sample Input
Thank you for your mail and your lectures
Output for the Sample Input
your lectures
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class V0029_English_Sentence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String[] lines = reader.readLine().split(" ");

		Map<String, Integer> memo = new HashMap<String, Integer>();
		int max = 0;
		int maxLength = 0;
		String maxName = "";
		String maxLengthName = "";
		for (int i = 0; i < lines.length; i++) {
			Integer num = memo.get(lines[i]);
			if (num == null) {
				memo.put(lines[i], 1);
				if (maxLength < lines[i].length()) {
					maxLength = lines[i].length();
					maxLengthName = lines[i];
				}
			} else {
				int result = memo.put(lines[i], num + 1) + 1;
				if (max < result) {
					max = result;
					maxName = lines[i];
				}
			}

		}
		System.out.println(maxName + " " + maxLengthName);

	}
}
