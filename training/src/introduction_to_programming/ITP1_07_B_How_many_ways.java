package introduction_to_programming;
/*
組み合わせの数

1 から n までの数の中から、重複無しで３つの数を選びそれらの合計が x となる組み合わせの数を求めるプログラムを作成して下さい。

例えば、1 から 5 までの数から３つを選んでそれらの合計が 9 となる組み合わせは、

1 + 3 + 5 = 9
2 + 3 + 4 = 9
の２通りがあります。

Input
複数のデータセットが入力として与えられます。各データセットでは、空白で区切られた n、x が 1 行に与えられます。

n、x がともに 0 のとき入力の終わりとします。

n は 3 以上 100　以下とします。

Output
各データセットについて、組み合わせの数を１行に出力して下さい。

Sample Input
5 9
0 0
Sample Output
2
*/
import java.util.Scanner;

public class ITP1_07_B_How_many_ways {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            int a = scanner.nextInt();
	            int b = scanner.nextInt();
	            if (a == 0 && b == 0)
	                break;
	            int sum = 0;
	            for (int i = 1; i <= a - 2; i++) {
	                for (int j = i + 1; j <= a - 1; j++) {
	                    if (i + j > b)
	                        break;
	                    for (int k = j + 1; k <= a; k++) {
	                        if (i + j + k > b)
	                            break;
	                        if (i + j + k == b)
	                            sum++;
	                    }
	                }
	            }
	            System.out.println(sum);
	        }
	    }
}
