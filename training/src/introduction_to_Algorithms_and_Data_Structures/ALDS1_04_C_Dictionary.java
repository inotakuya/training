package introduction_to_Algorithms_and_Data_Structures;

/*
 * 以下の命令を実行する簡易的な「辞書」を実装してください。

insert str: 辞書に str を追加する。
find str: 辞書に str が含まれる場合 'yes'と、含まれない場合 'no'と出力する。
入力
最初の行に命令の数 n が与えられます。続く n 行に n 件の命令が順番に与えられます。命令の形式は上記のとおりである。

出力
各 find 命令について、yes または no を１行に出力してください。

制約
与えられる文字列は、'A', 'C', 'G', 'T' の４種類の文字から構成される。
1 \leq 文字列の長さ \leq 12
n \leq 1,000,000
入力例 1
6
insert AAA
insert AAC
find AAA
find CCC
insert CCC
find CCC
出力例 1
yes
no
yes
入力例 2
13
insert AAA
insert AAC
insert AGA
insert AGG
insert TTT
find AAA
find CCC
find CCC
insert CCC
find CCC
insert T
find TTT
find T
出力例 2
yes
no
no
yes
yes
yes
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ALDS1_04_C_Dictionary {
	public static void main(String[] args) {
		new ALDS1_04_C_Dictionary().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Set<String> set = new HashSet<String>();
		while (n-- > 0) {
			String a = scanner.next();
			String b = scanner.next();
			if (a.equals("insert")) {
				set.add(b);
			} else {
				System.out.println(set.contains(b) ? "yes" : "no");
			}
		}
	}
}
