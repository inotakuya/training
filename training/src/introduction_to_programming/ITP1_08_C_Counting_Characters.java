package introduction_to_programming;
/*
文字のカウント

与えられた英文に含まれる、各アルファベットの数を数えるプログラムを作成して下さい。 なお、小文字と大文字は区別しません。

Input
複数の行にまたがる１つの英文が与えられます。

Output
与えられた英文に含まれる各アルファベットの数を以下に示す形式で出力して下さい：

a : aの個数
b : bの個数
c : cの個数
  .
  .
z : zの個数
Constraints
英文が含む文字の数 < 1200
Sample Input
This is a pen.
Sample Output
a : 1
b : 0
c : 0
d : 0
e : 1
f : 0
g : 0
h : 1
i : 2
j : 0
k : 0
l : 0
m : 0
n : 1
o : 0
p : 1
q : 0
r : 0
s : 2
t : 1
u : 0
v : 0
w : 0
x : 0
y : 0
z : 0
*/
import java.util.Scanner;

public class ITP1_08_C_Counting_Characters {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int[] list = new int[26];
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
             
            for (int i = 0; i < a.length(); i++) {
                int c = a.toLowerCase().codePointAt(i) - 97;
                if (c >= 0)
                    list[c]++;
            }
        }
 
        for (int i = 0; i < list.length; i++) {
            System.out.println(String.format("%s : %d", (char) (i + 97),
                    list[i]));
        }
 
    }
}
