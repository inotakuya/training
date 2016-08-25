package introduction_to_programming;
/*
標準偏差

n 人の学生を含むクラスでプログラミングの試験を行った。それぞれの得点をs1, s2 ... snとしたときの、標準偏差を求めるプログラムを作成せよ。

得点の平均値をｍとすれば、分散α2は以下の式で得られる：

α2 = (∑ni=1(si - m)2)/n

分散の正の平方根が標準偏差αとなる。

Input
複数のデータセットが入力として与えられる。各データセットは以下の形式で与えられる：

学生の数 n
s1 s2 ... sn
n が 0 のとき入力の終わりとする。

Output
各データセットに対して、標準偏差を１行に出力せよ。ただし、0.0001以下の誤差があってもよい。

Constraints
入力で与えられる n が1000を超えることはない。
0 ≤ si ≤ 100
Sample Input
5
70 80 100 90 20
3
80 80 80
0
Sample Output
27.85677655
0.00000000
*/
import java.util.Scanner;

public class ITP1_10_C_Standard_Deviation {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            int a = scanner.nextInt();
	            if (a == 0)
	                break;
	            double sum = 0;
	            int[] b = new int[a];
	            for (int i = 0; i < a; i++) {
	                b[i] = scanner.nextInt();
	                sum += b[i];
	            }
	            double m = sum / a;
	            double aa = 0;
	            for (int i = 0; i < a; i++) {
	                aa += Math.pow(b[i] - m, 2) / a;
	            }
	            System.out.println(Math.sqrt(aa));
	 
	        }
	 
	    }
}
