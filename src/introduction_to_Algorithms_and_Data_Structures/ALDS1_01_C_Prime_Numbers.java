package introduction_to_Algorithms_and_Data_Structures;

/*
素数
約数が 1 とその数自身だけであるような自然数を素数と言います。例えば、最初の8 つの素数は2, 3, 5, 7, 11, 13, 17, 19 となります。
1 は素数ではありません。

n 個の整数を読み込み、それらに含まれる素数の数を出力するプログラムを作成してください。

入力
最初の行に n が与えられます。続く n 行に n 個の整数が与えられます。

出力
入力に含まれる素数の数を１行に出力してください。

制約
1 ≤ n ≤ 10,000
2 ≤ 与えられる整数 ≤ 108
入力例 1
6
2
3
4
5
6
7
入力例 1 に対する出力
4
 */
import java.util.Scanner;

public class ALDS1_01_C_Prime_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < x; i++) {
            if (isPrime(scanner.nextInt()))
                sum++;
        }
        System.out.println(sum);
    }
 
    public static boolean isPrime(int i) {
        if (i == 2)
            return true;
        if (i % 2 == 0)
            return false;
        int k = 3;
        while (k <= Math.sqrt(i)) {
            if (i % k == 0)
                return false;
            k += 2;
        }
        return true;
    }
}