package introduction_to_programming;
/*
距離

２点 P1(x1, y1), P2(x2, y2) の距離を求めるプログラムを作成せよ。

Input
x1, y1, x2, y2 （実数）が空白区切りで与えられます。

Output
P1とP2の距離を実数で１行に出力して下さい。0.0001以下の誤差があってもよいものとします。

Sample Input
0 0 1 1
Sample Output
1.41421356
*/
import java.util.Scanner;

public class ITP1_10_A_Distance {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
 
        System.out.println(Math.sqrt(Math.pow(y1 - x1, 2)
                + Math.pow(y2 - x2, 2)));
    }
}
