package introduction_to_programming;
/*
リング

図のようなリング状の文字列 ss の任意の位置から、時計回りに連続した文字をいくつか選んで、
文字列 pp が作れるかを判定するプログラムを作成してください。




Input
１行目に文字列 ss が与えられます。
２行目に文字列 pp が与えられます。

Output
pp が作れる場合は Yes と、作れない場合は No と１行に出力してください。

Constraints
1≤pの長さ≤sの長さ≤1001≤pの長さ≤sの長さ≤100
文字列は英小文字からなる
Sample Input 1
vanceknowledgetoad
advance
Sample Output 1
Yes

Sample Input 2
vanceknowledgetoad
advanced
Sample Output 2
No
*/
import java.util.Scanner;

public class ITP1_08_D_Ring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a =scanner.nextLine();
        String b = a+a;
        String c = scanner.nextLine();
        if(b.contains(c))
            System.out.println("Yes");
        else
            System.out.println("No");
         
    }
}
