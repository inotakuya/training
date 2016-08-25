package introduction_to_programming;
/*
ミンコフスキー距離

２つのデータがどれだけ似ているかを、それらの距離で測る手法は、クラスタリングや分類など、様々なところで使われています。ここでは、２つの nn 次元ベクトル x={x1,x2,...,xn}x={x1,x2,...,xn} と y={y1,y2,...,yn}y={y1,y2,...,yn} の距離を計算してみましょう。

このようなデータの距離を測る指標のひとつとして、次のミンコフスキー距離が知られています。 
Dxy=(∑i=1n|xi−yi|p)1p
Dxy=(∑i=1n|xi−yi|p)1p

p=1p=1 のとき 
Dxy=|x1−y1|+|x2−y2|+...+|xn−yn|
Dxy=|x1−y1|+|x2−y2|+...+|xn−yn|

となり、これはマンハッタン距離とよばれます。 

p=2p=2 のとき 
Dxy=(|x1−y1|)2+(|x2−y2|)2+...+(|xn−yn|)2−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−√
Dxy=(|x1−y1|)2+(|x2−y2|)2+...+(|xn−yn|)2

となり、これは一般的に使われるユークリッド距離になります。 

p=∞p=∞ のとき 

Dxy=maxni=1(|xi−yi|)
Dxy=maxi=1n(|xi−yi|)


となり、これはチェビシェフ距離と呼ばれます。

２つの nn 次元ベクトルが与えられるので、pp がそれぞれ 1、2、3、∞∞ のミンコフスキー距離を求めるプログラムを作成してください。

Input
１行目に整数 nn が与えられます。２行目にベクトル xx の要素 {x1,x2,...xn}{x1,x2,...xn}、３行目にベクトル yy の要素 {y1,y2,...yn}{y1,y2,...yn} が空白区切りで与えられます。入力はすべて整数値です。

Output
pp がそれぞれ 1、2、3、∞∞ の順番にそれぞれ１行に距離を出力してください。ただし、0.00001 以下の誤差があってもよいものとします。

Constraints
1≤n≤1001≤n≤100
0≤xi,yi≤10000≤xi,yi≤1000
Sample Input
3
1 2 3
2 0 4
Sample Output
4.000000
2.449490
2.154435
2.000000
*/
import java.util.Scanner;

public class ITP1_10_D_Distance_II {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int a = scanner.nextInt();
	        int[] x = new int[a];
	        for (int i = 0; i < a; i++) {
	            x[i] = scanner.nextInt();
	        }
	        int[] y = new int[a];
	        for (int i = 0; i < a; i++) {
	            y[i] = scanner.nextInt();
	        }
	        double[] p = new double[4];
	        for (int i = 0; i < a; i++) {
	            double p0 = Math.abs(x[i] - y[i]);
	            p[1] += Math.pow(p0, 2);
	            p[2] += Math.pow(p0, 3);
	            p[3] = Math.max(p[3], p0);
	            p[0] += p0;
	        }
	        p[1] = Math.sqrt(p[1]);
	        p[2] = Math.cbrt(p[2]);
	        for (double aa : p)
	            System.out.println(aa);
	    }
}
