package introduction_to_programming;
/*
サイコロ II

Dice I と同様の方法で、入力された数字の列からサイコロをつくります。

このサイコロを Dice I の方法で回転させた後の上面と前面の数字が質問として与えられるので、右側の面の数字を答えるプログラムを作成してください。





Input
１行目に各面の数字が、ラベルの順番に空白区切りで与えられます。
２行目に質問の数 qq が与えられます。

続く qq 行に質問が与えられます。各質問では上面と前面の数字を表す２つの整数が空白区切りで１行に与えられます。

Output
各質問ごとに、サイコロの右側の面の数字を１行に出力してください。

Constraints
0≤0≤ 入力されるサイコロの面の数字 ≤100≤100
入力されるサイコロの面の数字はすべて異なる
1≤q≤241≤q≤24
Sample Input
1 2 3 4 5 6
3
6 5
1 3
3 2
Sample Output
3
5
6
*/
import java.util.Scanner;

public class ITP1_11_B_Dice_II {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String[] line = scanner.nextLine().split(" ");
	        int a1 = Integer.parseInt(line[0]);
	        int a2 = Integer.parseInt(line[1]);
	        int a3 = Integer.parseInt(line[2]);
	        int a4 = Integer.parseInt(line[3]);
	        int a5 = Integer.parseInt(line[4]);
	        int a6 = Integer.parseInt(line[5]);
	 
	        int b = Integer.parseInt(scanner.nextLine());
	        for (int i = 0; i < b; i++) {
	            int c = scanner.nextInt();
	            int d = scanner.nextInt();
	            int result = 0;
	            if (c == a1 || c == a6)
	                if (d == a2)
	                    result = 3;
	                else if (d == a3)
	                    result = 5;
	                else if (d == a4)
	                    result = 2;
	                else
	                    result = 4;
	            else if (c == a2 || c == a5)
	                if (d == a1)
	                    result = 4;
	                else if (d == a3)
	                    result = 1;
	                else if (d == a4)
	                    result = 6;
	                else
	                    result = 3;
	            else {
	                if (d == a1)
	                    result = 2;
	                else if (d == a2)
	                    result = 6;
	                else if (d == a5)
	                    result = 1;
	                else
	                    result = 5;
	            }
	            if (c == a4 || c == a5 || c == a6)
	                result = 7 - result;
	            System.out.println(line[result - 1]);
	        }
	    }
}
