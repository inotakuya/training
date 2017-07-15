package volume00;

/**
 * アフィン暗号
簡単な暗号法の一つに、アフィン暗号というものがあります。まず、アルファベット a～z を a = 0, b = 1, c = 2,..., x = 23, y = 24, z = 25 と 0～25 の数字に置き換えます。そして、以下の式で、原文のアルファベットを置換します。

 F
(
γ
)
=
(
α
⋅
γ
+
β
)
F(γ)=(α⋅γ+β) mod 
26
26

ただし、mod 26 は 26 で割った余りを表します。例えば、
α
=
3
,
β
=
2
α=3,β=2 のとき、アルファベットの 'a' (=0) は、
F
(
0
)
=
(
3
⋅
0
+
2
)
F(0)=(3⋅0+2) mod 
26
=
2
26=2 で 'c' に、アルファベットの 'n' (=13) は 
F
(
13
)
=
(
3
⋅
13
+
2
)
F(13)=(3⋅13+2) mod 
26
=
15
26=15 で 'p' に置換されます。 このとき、
γ
γ に対する 
F
(
γ
)
F(γ) が必ず 1 対 1 で対応付けられるように、
α
α と 
β
β は慎重に選ばれているものとします（
α
α と 26 が互いに素であることが条件）。
α
=
4
,
β
=
7
α=4,β=7 のときのように、
F
(
′
a
′
)
=
7
,
F
(
′
n
′
)
=
7
F(′a′)=7,F(′n′)=7 と、'a' も 'n' も同じ 'h' に置換されるようなことはありません。また、アルファベット以外の文字は置換されません。

暗号化された文字列を元の文章に復号したものを出力するプログラムを作成してください。元の文章には、キーワードとして

that
this
のいずれかが必ず含まれているものとします。

Input
複数のデータセットが与えられます。１行目にデータセット数 
n
n (
n
≤
30
n≤30) が与えられます。続いて 
n
n 行のデータが与えられます。各データセットに英小文字と空白からなる 256 文字以内の暗号化された文章が１行に与えられます。

Output
各データセットに対して、復号した元の文章を１行に出力して下さい。

Sample Input
1
y eazqyp pnop pngtg ye obmpngt xmybp mr lygw
Output for the Sample Input
i submit that there is another point of view
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class V0040_Affine_Cipher {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int n = Integer.parseInt(reader.readLine());
		Pattern pattern = Pattern.compile("that|this");
		while (n-- > 0) {
			String result = reader.readLine();
			String a = result;
			loop: for (int i = 1; i < 26; i = i + 2) {
				for (int j = 0; j < 26; j++) {
					a = rep(result, i, j);

					if (pattern.matcher(a).find()) {
						builder.append(a).append('\n');
						break loop;
					}
				}
			}
		}
		System.out.print(builder);
	}

	private static String rep(String a, int i, int j) {
		char[] chs = a.toCharArray();
		for (int k = 0; k < a.length(); k++) {
			if ('a' <= chs[k] && chs[k] <= 'z') {
				int b = chs[k] - 'a';
				chs[k] = (char) ((b * i + j) % 26 + 'a');
			}
		}
		return String.valueOf(chs);
	}
}
