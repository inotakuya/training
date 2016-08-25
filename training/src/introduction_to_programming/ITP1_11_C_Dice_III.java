package introduction_to_programming;
/*
サイコロ III

Dice I と同様の方法で、入力された数字から２つのサイコロをつくります。これらが同一のものか判定するプログラムを作成してください。Dice I の方法でサイコロを回転させ、２つのサイコロのそれぞれの６方向から見た数字が全て一致するとき、同一のサイコロとみなします。

Input
１行目に１つ目のサイコロの各面の数字が、ラベルの順番に空白区切りで与えられます。
２行目に２つ目のサイコロの各面の数字が、ラベルの順番に空白区切りで与えられます。

Output
２つのサイコロが同一ならば "Yes" と、異なるならば "No" と１行に出力してください。

Constraints
0≤0≤ 入力されるサイコロの面の数字 ≤100≤100
Sample Input 1
1 2 3 4 5 6
6 2 4 3 5 1
Sample Output 1
Yes

Sample Input 2
1 2 3 4 5 6
6 5 4 3 2 1
Sample Output 2
No
*/
import java.util.Arrays;
import java.util.Scanner;

public class ITP1_11_C_Dice_III {
	 static String[] a;
	    static String[] b;
	    static String temp;
	 
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        a = scanner.nextLine().split(" ");
	        b = scanner.nextLine().split(" ");
	        char[] c = { 'E', 'E', 'E', 'N', 'W', 'W', 'W', 'S' };
	         
	        boolean flag = false;
	        for(int i=0;i<3;i++){
	            for(char d:c){
	                roll(d);
	                if(Arrays.equals(a, b)){
	                    flag=true;
	                    break;
	                }
	            }
	        }
	        if(flag)
	            System.out.println("Yes");
	        else
	            System.out.println("No");
	    }
	 
	    public static void roll(char c) {
	        switch (c) {
	        case 'E':
	            temp = a[0];
	            a[0] = a[3];
	            a[3] = a[5];
	            a[5] = a[2];
	            a[2] = temp;
	            break;
	        case 'N':
	            temp = a[0];
	            a[0] = a[1];
	            a[1] = a[5];
	            a[5] = a[4];
	            a[4] = temp;
	            break;
	        case 'W':
	            temp = a[0];
	            a[0] = a[2];
	            a[2] = a[5];
	            a[5] = a[3];
	            a[3] = temp;
	            break;
	        default:
	            temp = a[0];
	            a[0] = a[4];
	            a[4] = a[5];
	            a[5] = a[1];
	            a[1] = temp;
	            break;
	        }
	    }
}
