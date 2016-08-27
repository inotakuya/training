package introduction_to_programming;
/*
ベクトルと行列の積

n×mn×m の行列 AA と、m×1m×1 の列ベクトルbb を読み込み、AA と bb の積を出力するプログラムを作成してください。

次のように mm 個の数を縦に並べたものを m×1m×1の列ベクトルと呼びます。

b=⎛⎝⎜⎜⎜b1b2:bm⎞⎠⎟⎟⎟
b=(b1b2:bm)
次のように nn 個の数を含む列ベクトルを mm 個横に並べたものを n×mn×m の行列と呼びます。

A=⎛⎝⎜⎜⎜a11a21:an1a12a22:an2......:...a1ma2m:anm⎞⎠⎟⎟⎟
A=(a11a12...a1ma21a22...a2m::::an1an2...anm)
ベクトルまたは行列の中に含まれる数のことを要素と呼び、m×1m×1 の列ベクトル bb の上から ii 番目の要素は bi(i=1,2,...,m)bi(i=1,2,...,m)、n×mn×m の行列 AA には n×mn×m 個の要素が含まれ、ii 行 jj 列目の要素は aij(i=1,2,...,n,j=1,2,...,m)aij(i=1,2,...,n,j=1,2,...,m)で示されます。

n×mn×mの行列 AA とm×1m×1の列ベクトル bb の積は、n×1n×1の列ベクトル cc となり、cc の ii 番目の要素 cici は次の式で得られます：

ci=∑j=1maijbj=ai1b1+ai2b2+...+aimbm
ci=∑j=1maijbj=ai1b1+ai2b2+...+aimbm
Input
１行目に nn と mm が空白区切りで与えられます。続く nn 行に行列 AA の要素 aijaij が空白区切りで与えられます。続く mm 行にベクトル bb の要素 bibi がそれぞれ１行に与えられます。

Output
出力は nn 行からなります。ベクトル cc の要素 cici をそれぞれ１行に出力してください。

Constraints
1≤n,m≤1001≤n,m≤100
0≤bi,aij≤10000≤bi,aij≤1000
Sample Input
3 4
1 2 0 1
0 3 0 1
4 1 1 0
1
2
3
0
Sample Output
5
6
9
*/
import java.util.Scanner;

public class ITP1_06_D_Matrix_Vector_Multiplication {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int a = scanner.nextInt();
	        int b = scanner.nextInt();
	 
	        int[][] list = new int[a][b];
	        for (int i = 0; i < a; i++) {
	            for (int j = 0; j < b; j++) {
	                list[i][j] = scanner.nextInt();
	            }
	        }
	        int[] list2 = new int[b];
	        for (int i = 0; i < b; i++) {
	            list2[i] = scanner.nextInt();
	        }
	        int sum;
	        for (int i = 0; i < a; i++) {
	            sum = 0;
	            for (int j = 0; j < b; j++) {
	                sum += list[i][j] * list2[j];
	            }
	            System.out.println(sum);
	        }
	 
	    }
}
