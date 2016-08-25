package introduction_to_programming;
/*
大文字と小文字の入れ替え

与えられた文字列の小文字と大文字を入れ替えるプログラムを作成してください。

Input
文字列が1行に与えられます。

Output
与えられた文字列の小文字と大文字を入れ替えた文字列を出力して下さい。アルファベット以外の文字はそのまま出力して下さい。

Constraints
入力される文字列の長さ < 1200
Sample Input
fAIR, LATER, OCCASIONALLY CLOUDY.
Sample Output
Fair, later, occasionally cloudy.
*/
import java.util.Scanner;

public class ITP1_8_A_Toggling_Cases {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] list = scanner.nextLine().toCharArray();
        for(char a:list)
            if(Character.isLowerCase(a))
                System.out.print(Character.toUpperCase(a));
            else
                System.out.print(Character.toLowerCase(a));
        System.out.println();
    }
}
