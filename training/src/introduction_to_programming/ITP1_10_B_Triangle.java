package introduction_to_programming;
/*
三角形

三角形の２辺 a, b とその間の角 C から、その三角形の面積 S、周の長さ L, a を底辺としたときの高さ h を求めるプログラムを作成して下さい。

Input
a の長さ, b の長さ, Cの大きさ（度）（整数）が空白区切りで与えられます。

Output
S, L, h をそれぞれ1行に出力して下さい。0.0001以下の誤差があってもよいものとします。

Sample Input
4 3 90
Sample Output
6.00000000
12.00000000
3.00000000
*/
import java.util.Scanner;

public class ITP1_10_B_Triangle {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int a = scanner.nextInt();
	        int b = scanner.nextInt();
	        int c = scanner.nextInt();
	 
	        System.out.println(a * b / 2 * Math.sin(Math.toRadians(c)));
	        System.out.println(a
	                + b
	                + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b
	                        * Math.cos(Math.toRadians(c))));
	        System.out.println(b * Math.sin(Math.toRadians(c)));
	    }
}
