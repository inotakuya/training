package introduction_to_programming;
/*
カードゲーム

太郎と花子がカードゲームをする。二人はそれぞれn枚のカードを持っており、nターンの勝負を行う。
各ターンではそれぞれ１枚ずつカードを出す。カードにはアルファベットからなる動物の名前が書かれており、
辞書順で大きいものがそのターンの勝者となる。勝者には３ポイント、引き分けの場合にはそれぞれ１ポイントが加算される。

太郎と花子の手持ちのカードの情報を読み込み、ゲーム終了後のそれぞれの得点を出力するプログラムを作成せよ。

Constraints
入力で与えられるｎが1000を超えることはない。
与えられる文字列の長さは100以下であり、アルファベットの小文字のみを含む。
Input
一行目にカードの数ｎが与えられる。続くn行に各ターンのカードの情報が与えられる。１つ目の文字列が太郎のカードに書かれている文字列、
２つ目の文字列が花子のカードに書かれている文字列である。

Output
１つ目の数字が太郎の得点、２つ目の数字が花子の得点として１行に出力せよ。２つの数字の間に１つの空白を出力せよ。

Sample Input
3
cat dog
fish fish
lion tiger
Sample Output
1 7
*/
import java.util.Scanner;

public class ITP1_09_C_Card_Game {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;
 
        for (int i = 0; i < a; i++) {
            String b = scanner.next();
            String c = scanner.next();
            if (b.compareTo(c) > 0)
                sum1 += 3;
            else if (b.compareTo(c) < 0)
                sum2 += 3;
            else {
                sum1 += 1;
                sum2 += 1;
            }
        }
        System.out.println(String.format("%d %d", sum1, sum2));
    }
}
