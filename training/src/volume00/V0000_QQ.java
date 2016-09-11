package volume00;

/**
 * 九九
以下のような表記で、九九を出力して終了するプログラムを作成してください。×記号の代わりに、小文字の x を使用してください。

1x1=1
1x2=2
.
.
9x8=72
9x9=81
Input
この問題に入力はありません。

Output
1x1=1
1x2=2
.
.
9x8=72
9x9=81
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0000_QQ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				builder.append(i).append('x').append(j).append('=').append(i * j).append('\n');
			}
		}
		System.out.print(builder);
	}
}
