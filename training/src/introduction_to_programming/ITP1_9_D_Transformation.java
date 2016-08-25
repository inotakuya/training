package introduction_to_programming;
/*
文字列変換

文字列 strstr に対して、与えられた命令の列を実行するプログラムを作成してください。命令は以下の操作のいずれかです：

print a b: strstr の a 文字目から b 文字目までを出力する。
reverse a b: strstr の a 文字目から b 文字目までを逆順にする。
replace a b p: strstr の a 文字目から b 文字目までを p に置き換える。
ここでは、文字列 strstr の最初の文字を 0 文字目とします。

Input
1 行目に文字列 strstr が与えられます。strstr は英小文字のみ含みます。2 行目に命令の数 qq が与えられます。続く qq 行に各命令が上記の形式で与えられます。

Output
各 print 命令ごとに文字列を１行に出力してください。

Constraints
1≤strの長さ≤10001≤strの長さ≤1000
1≤q≤1001≤q≤100
0≤a≤b<strの長さ0≤a≤b<strの長さ
replace 命令では b−a+1=pの長さb−a+1=pの長さ
Sample Input 1
abcde
3
replace 1 3 xyz
reverse 0 2
print 1 4
Sample Output 1
xaze
Sample Input 2
xyz
3
print 0 2
replace 0 2 abc
print 0 2
Sample Output 2
xyz
abc
*/
import java.util.Scanner;

public class ITP1_9_D_Transformation {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        StringBuilder a = new StringBuilder(scanner.nextLine());
	        int b = Integer.parseInt(scanner.nextLine());
	        for (int i = 0; i < b; i++) {
	            String[] c = scanner.nextLine().split(" ");
	            int d = Integer.parseInt(c[1]);
	            int e = Integer.parseInt(c[2]) + 1;
	            if (c[0].equals("print")) {
	                System.out.println(a.substring(d, e));
	            } else if (c[0].equals("reverse")) {
	                StringBuilder builder = new StringBuilder(a.substring(d, e))
	                        .reverse();
	                a.replace(d, e, builder.toString());
	            } else {
	                a.replace(d, e, c[3]);
	            }
	 
	        }
	    }
}
