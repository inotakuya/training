package volume00;

/**
 * 階乗
整数 n を入力し、n の階乗を出力するプログラムを作成して下さい。ただし、n は、1 以上 20 以下とします。

Input
整数 n (1 ≤ n ≤ 20) が１行に与えられます。

Output
n の階乗を１行に出力します。

Sample Input
5
Output for the Sample Input
120
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0019_Factorial {
	   public static void main(String[] args) throws NumberFormatException,
       IOException {
   BufferedReader reader = new BufferedReader(new InputStreamReader(
           System.in));
   StringBuilder builder = new StringBuilder();
   int num = Integer.parseInt(reader.readLine());
   System.out.println(factorial(num));

}

public static long factorial(int num) {
   if (num == 1)
       return num;
   else
       return num * factorial(num - 1);
}
}
