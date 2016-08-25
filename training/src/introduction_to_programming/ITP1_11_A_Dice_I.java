package introduction_to_programming;
/*
サイコロ I

次の展開図から得られるサイコロを転がすシミュレーションを行うプログラムを作成してください。






サイコロの各面には図のとおりに 1 から 6 のラベルが割りあてられています。

入力としてサイコロの各面のラベルに対応する数字と、転がす命令の列が与えられるので、サイコロの上面の数字を出力してください。シミュレーションの初期状態は、図のとおりのラベルの位置でサイコロが置かれているものとします。

Input
１行目に各面の数字が、図に示すラベルの順番に空白区切りで与えられます。

２行目に命令を表す１つの文字列が与えられます。命令はそれぞれ図に示す４方向を表す文字 E、N、S、W を含む文字列です。

Output
すべての命令を実行した後のサイコロの上面の数を１行に出力してください。

Constraints
0≤0≤ 入力されるサイコロの面の数字 ≤100≤100
0≤0≤ 命令を表す文字列の長さ ≤100≤100
Note
続くシリーズ Dice III, Dice IV では、複数のサイコロを扱うので、サイコロをクラスや構造体で作成しておきましょう。

Sample Input 1
1 2 4 8 16 32
SE
Sample Output 1
8
各面に 1, 2, 4, 8, 16, 32 と書かれたサイコロを S の方向に転がした後、E の方向に転がすと、上面の数字が 8 になります。



Sample Input 2
1 2 4 8 16 32
EESWN
Sample Output 2
32
*/
import java.util.Scanner;

public class ITP1_11_A_Dice_I {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[7];
        for (int i = 1; i < 7; i++) {
            a[i] = scanner.nextInt();
        }
 
        char[] b = scanner.next().toCharArray();
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 'N') {
                a[0] = a[1];
                a[1] = a[2];
                a[2] = a[6];
                a[6] = a[5];
                a[5] = a[0];
            } else if (b[i] == 'S') {
                a[0] = a[1];
                a[1] = a[5];
                a[5] = a[6];
                a[6] = a[2];
                a[2] = a[0];
            } else if (b[i] == 'E') {
                a[0] = a[1];
                a[1] = a[4];
                a[4] = a[6];
                a[6] = a[3];
                a[3] = a[0];
            } else {
                a[0] = a[1];
                a[1] = a[3];
                a[3] = a[6];
                a[6] = a[4];
                a[4] = a[0];
            }
        }
        System.out.println(a[1]);
    }
}
