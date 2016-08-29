package introduction_to_Algorithms_and_Data_Structures;

/*
最大公約数
２つの自然数 x, y を入力とし、それらの最大公約数を求めるプログラムを作成してください。

２つの整数 x と y について、x ÷ d と y ÷ d の余りがともに 0 となる d のうち最大のものを、x と y の最大公約数（Greatest Common Divisor）
と言います。例えば、35 と14 の最大公約数 gcd (35, 14) は 7 となります。これは、35 の約数{1, 5, 7, 35}、
14 の約数 {1, 2, 7, 14} の公約数 {1, 7} の最大値となります。

入力
x と y が１つの空白区切りで１行に与えられます。

出力
最大公約数を１行に出力してください。

制約
1 ≤ x, y ≤ 109
ヒント
整数 x, y について、x ≥ y ならば x と y の最大公約数は y と x % y の最大公約数に等しい。ここで x % y は x を y で割った余りである。　

入力例 1
147 105
入力例 1 に対する出力
21
 */
import java.util.Scanner;

public class ALDS1_01_B_Greatest_Common_Divisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(gcd(x, y));
    }
 
    public static int gcd(int x, int y) {
        if (x % y == 0)
            return y;
        else
            return gcd(y, x % y);
    }
}
