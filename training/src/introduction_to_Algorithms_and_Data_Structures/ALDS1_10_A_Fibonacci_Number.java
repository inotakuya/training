package introduction_to_Algorithms_and_Data_Structures;

/*
 * フィボナッチ数列
フィボナッチ数列の第 n 項の値を出力するプログラムを作成してください。ここではフィボナッチ数列を以下の再帰的な式で定義します：

入力
１つの整数 n が与えられます。

出力
フィボナッチ数列の第 n 項の値を出力してください。

制約
0 \leq n \leq 44
入力例 1
3
出力例 1
3
 */
import java.util.Scanner;

public class ALDS1_10_A_Fibonacci_Number {
	   public static void main(String[] args) {
	        new ALDS1_10_A_Fibonacci_Number().run();
	    }
	 
	    int[] num = new int[45];
	 
	    private void run() {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        num[0] = num[1] = 1;
	        for (int i = 2; i <= n; i++) {
	            num[i] = num[i - 1] + num[i - 2];
	        }
	        System.out.println(num[n]);
	    }
}
