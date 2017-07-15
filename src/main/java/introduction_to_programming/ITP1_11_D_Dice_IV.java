package introduction_to_programming;
/*
サイコロ IV

Dice I と同様の方法で、入力された数字から nn 個のサイコロをつくります。これらのサイコロが、
全て異なるものかどうかを判定するプログラムを作成してください。同一かどうかの判定は Dice III の方法を用います。

Input
１行目にサイコロの個数 nn が与えられます。続く nn 行に各サイコロの面の数字が与えられます。

各サイコロについて各面の数字が、ラベルの順番に空白区切りで１行に与えられます。

Output
入力されたサイコロがすべて異なる場合 "Yes"、同じものが１組以上含まれる場合 "No" と１行に出力してください。

Constraints
2≤n≤1002≤n≤100
0≤0≤ 入力されるサイコロの面の数字 ≤100≤100
Sample Input 1
3
1 2 3 4 5 6
6 2 4 3 5 1
6 5 4 3 2 1
Sample Output 1
No

Sample Input 2
3
1 2 3 4 5 6
6 5 4 3 2 1
5 4 3 2 1 6
Sample Output 2
Yes
*/
import java.util.Arrays;
import java.util.Scanner;

public class ITP1_11_D_Dice_IV {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
 
        Dice[] dices = new Dice[num];
        boolean flag = true;
 
        loop: for (int i = 0; i < num; i++) {
            dices[i] = new Dice(scanner.nextLine());
            for (int j = 0; j < i; j++) {
                /*System.out.println(Arrays.toString(dices[i].a) + " -> "
                        + Arrays.toString(dices[j].a));*/
                if (dices[i].equals(dices[j])) {
                    flag = false;
                    break loop;
                }
            }
        }
        System.out.println(flag ? "Yes" : "No");
    }
}
 
class Dice {
    int[] a = new int[6];
 
    Dice(String s) {
        String[] b = s.split(" ");
        for (int i = 0; i < 6; i++) {
            a[i] = Integer.parseInt(b[i]);
        }
    }
 
    public void roll(char c) {
        int temp;
        switch (c) {
        case 'E':
            temp = a[0];
            a[0] = a[3];
            a[3] = a[5];
            a[5] = a[2];
            a[2] = temp;
            break;
        case 'N':
            temp = a[0];
            a[0] = a[1];
            a[1] = a[5];
            a[5] = a[4];
            a[4] = temp;
            break;
        case 'W':
            temp = a[0];
            a[0] = a[2];
            a[2] = a[5];
            a[5] = a[3];
            a[3] = temp;
            break;
        default:
            temp = a[0];
            a[0] = a[4];
            a[4] = a[5];
            a[5] = a[1];
            a[1] = temp;
            break;
        }
    }
 
    public boolean equals(Dice d) {
        char[] c = { 'E', 'E', 'E', 'N', 'W', 'W', 'W', 'S' };
        boolean flag = false;
        loop: for (int i = 0; i < 24; i++) {
            /*System.out.println(Arrays.toString(a) + "========"
                    + Arrays.toString(d.a));*/
            if (Arrays.equals(a, d.a)) {
                flag = true;
                break loop;
            }
            d.roll(c[i % 8]);
        }
        return flag;
    }
}
