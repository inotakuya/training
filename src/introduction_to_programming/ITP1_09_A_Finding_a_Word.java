package introduction_to_programming;
/*
単語の検索

１つの単語 W と文章 T が与えられます。T の中にある W の数を出力するプログラムを作成して下さい。

文章 T に含まれるスペースまたは改行で区切られた文字列を単語 Ti とします。すべての Ti において単語 W と同じになるものを数えて下さい。

なお、大文字と小文字は区別しません。

Constraints
Wの文字列の長さは10を超えません。
Tの１行あたりの文字列の長さは1000を超えません。
Input
１行目に単語 W が与えられます。

続いて、複数の行にまたがった文章与えられます。END_OF_TEXT という文字列が文章の終わりを示します。

Output
単語 W の数を出力して下さい。

Sample Input
computer
Nurtures computer scientists and highly-skilled computer engineers
who will create and exploit "knowledge" for the new era.
Provides an outstanding computer environment.
END_OF_TEXT
Sample Output
3
*/
import java.util.Scanner;

public class ITP1_09_A_Finding_a_Word {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String d = scanner.nextLine();
	        int sum = 0;
	        while (true) {
	            String a = scanner.nextLine();
	            if (a.equals("END_OF_TEXT"))
	                break;
	            for (String s : a.split(" ")) {
	                if (s.equalsIgnoreCase(d))
	                    sum++;
	            }
	        }
	        System.out.println(sum);
	 
	    }
}
