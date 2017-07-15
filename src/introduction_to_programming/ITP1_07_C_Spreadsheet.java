package introduction_to_programming;
/*
表計算

表計算を行う簡単なプログラムを作成します。

表の行数rと列数c、r × c の要素を持つ表を読み込んで、各行と列の合計を挿入した新しい表を出力するプログラムを作成して下さい。

Input
最初の行にrとcが空白区切りで与えられます。続くr行にそれぞれc個の整数が空白区切りで与えられます。

Output
(r+1) × (c+1) の新しい表を出力して下さい。各行の隣り合う整数は１つの空白で区切って下さい。各行の最後の列としてその行の合計値を、
各列の最後の行としてその列の合計値を、最後の行・列に表全体の合計値を挿入して下さい。

Constraints
1 ≤ r, c ≤ 100
0 ≤ 要素 ≤ 100
Sample Input
4 5
1 1 3 4 5
2 2 2 4 5
3 3 0 1 1
2 3 4 4 6
Sample Output
1 1 3 4 5 14
2 2 2 4 5 15
3 3 0 1 1 8
2 3 4 4 6 19
8 9 9 13 17 56
*/
import java.util.Scanner;

public class ITP1_07_C_Spreadsheet {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] list = new int[a + 1][b + 1];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                list[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < a; i++) {
            int sum = 0;
            for (int j = 0; j < b; j++) {
                sum += list[i][j];
            }
            list[i][b] = sum;
        }
        for (int i = 0; i < b + 1; i++) {
            int sum = 0;
            for (int j = 0; j < a; j++) {
                sum += list[j][i];
            }
            list[a][i] = sum;
 
        }
 
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (j == 0)
                    System.out.print(list[i][j]);
                else
                    System.out.print(" " + list[i][j]);
 
            }
            System.out.println();
        }
    }
}
