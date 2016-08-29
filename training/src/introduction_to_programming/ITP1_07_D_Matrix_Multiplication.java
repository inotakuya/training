package introduction_to_programming;
/*
行列の積

n×mn×m の行列 AA と m×lm×l の行列 BB を入力し、それらの積である n×ln×l の行列 CC を出力するプログラムを作成してください。
行列 CC の各要素 cijcij は次の式で得られます：

cij=∑k=1maikbkj
cij=∑k=1maikbkj
ここで、AA、BB、CC の各要素をそれぞれ aijaij、bijbij、cijcij とします。

Input
１行目に nn、mm、ll が空白区切りで与えられます。

続く行に n×mn×m の行列 AA と m×lm×l の行列 BB が与えられます。

Output
n×ln×l の行列 CC の要素 cijcij を出力してください。各行の隣り合う要素を１つの空白で区切ってください。

Constraints
1≤n,m,l≤1001≤n,m,l≤100
0≤aij,bij≤100000≤aij,bij≤10000
Sample Input
3 2 3
1 2
0 3
4 5
1 2 1
0 3 2
Sample Output
1 8 5
0 9 6
4 23 14
*/
import java.util.Scanner;

public class ITP1_07_D_Matrix_Multiplication {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
 
        int[][] list1 = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                list1[i][j] = scanner.nextInt();
            }
        }
        int[][] list2 = new int[b][c];
        for (int i = 0; i < b; i++)
            for (int j = 0; j < c; j++)
                list2[i][j] = scanner.nextInt();
 
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < c; j++) {
                long sum = 0;
                for (int k = 0; k < b; k++) {
                    sum += list1[i][k] * list2[k][j];
                }
                if (j == 0)
                    System.out.print(sum);
                else
                    System.out.print(" " + sum);
            }
            System.out.println();
        }
 
    }
}
