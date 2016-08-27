package introduction_to_programming;

/*長方形の中の円

長方形の中に円が含まれるかを判定するプログラムを作成してください。次のように、長方形は左下の頂点を原点とし、右上の頂点の座標 (W,H)(W,H) が与えられます。また、円はその中心の座標 (x,y)(x,y) と半径 rr で与えられます。


長方形の中の円 

Input
５つの整数 WW、HH、xx、yy、rr が空白区切りで１行に与えられます。

Output
円が長方形の内部に含まれるなら Yes と、一部でもはみ出るならば No と１行に出力してください。

Constraints
−100≤x,y≤100−100≤x,y≤100
0<W,H,r≤1000<W,H,r≤100
Sample Input 1
5 4 2 2 1
Sample Output 1
Yes
Sample Input 2
5 4 2 4 1
Sample Output 2
No*/

import java.util.Scanner;

public class ITP1_02_D_Circle_in_a_Rectangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		int num4 = scanner.nextInt();
		int num5 = scanner.nextInt();

		if (num3 - num5 < 0 || num4 - num5 < 0 || num3 + num5 > num1 || num4 + num5 > num2)
			System.out.println("No");
		else
			System.out.println("Yes");
	}
}
