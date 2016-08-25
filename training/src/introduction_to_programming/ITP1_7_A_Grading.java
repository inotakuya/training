package introduction_to_programming;
/*
成績

あなたの課題は、あるクラスの数学の成績を付けるプログラムを作成することです。

プログラムは複数の学生のテストの点数を読み込みます。

テストの点数は、中間試験の点数 m、期末試験の点数 f、再試験の点数 r で構成されています。

中間試験と期末試験は 50 点満点（m, f ≤ 50）、再試験は 100 点満点 （r ≤ 100）です。

試験を受けていない場合は点数を -1 とします。

以下の手順で成績が付けられます：

中間試験、期末試験のいずれかを欠席した場合成績は F。
中間試験と期末試験の合計点数が 80 以上ならば成績は A 。
中間試験と期末試験の合計点数が 65 以上 80 未満ならば成績は B。
中間試験と期末試験の合計点数が 50 以上 65 未満ならば成績は C。
中間試験と期末試験の合計点数が 30 以上 50 未満ならば成績は D。 ただし、再試験の点数が 50 以上ならば成績は C。
中間試験と期末試験の合計点数が 30 未満ならば成績は F。
Input
複数のデータセットが入力として与えられます。各データセットでは、空白で区切られた m、f、r が 1 行に与えられます。

m、f、r がすべて -1 のとき入力の終わりとします。

Output
各データセットについて、成績（A、B、C、D、または F）を１行に出力して下さい。

Sample Input
40 42 -1
20 30 -1
0 2 -1
-1 -1 -1
Sample Output
A
C
F
*/
import java.util.Scanner;

public class ITP1_7_A_Grading {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a == -1 && b == -1 && c == -1)
                break;
            if (a == -1 || b == -1)
                System.out.println("F");
            else if (a + b >= 80)
                System.out.println("A");
            else if (a + b >= 65)
                System.out.println("B");
            else if (a + b >= 50)
                System.out.println("C");
            else if (a + b >= 30)
                if (c >= 50)
                    System.out.println("C");
                else
                    System.out.println("D");
            else
                System.out.println("F");
        }
 
    }
}
