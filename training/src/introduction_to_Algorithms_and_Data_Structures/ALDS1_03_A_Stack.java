package introduction_to_Algorithms_and_Data_Structures;

/*
 * スタック
逆ポーランド記法は、演算子をオペランドの後に記述する数式やプログラムを記述する記法です。
例えば、一般的な中間記法で記述された数式 (1+2)*(5+4) は、逆ポーランド記法では 1 2 + 5 4 + * と記述されます。
逆ポーランド記法では、中間記法で必要とした括弧が不要である、というメリットがあります。

逆ポーランド記法で与えられた数式の計算結果を出力してください。

入力
１つの数式が１行に与えられます。連続するシンボル（オペランドあるいは演算子）は１つの空白で区切られて与えられます。

出力
計算結果を１行に出力してください。

制約
2 ≤ 式に含まれるオペランドの数 ≤ 100
1 ≤ 式に含まれる演算子の数 ≤ 99
演算子は +、-、* のみを含み、１つのオペランドは106 以下の正の整数
-1 × 109 ≤ 計算途中の値 ≤ 109
入力例 1
1 2 +
出力例 1
3
入力例 2
1 2 + 3 4 - *
出力例 2
-3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class ALDS1_03_A_Stack {
    public static void main(String[] args) throws NumberFormatException,
    IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(
        System.in));

String[] strs = reader.readLine().split(" ");
int[] nums = new int[strs.length];
int top = 0;
for (int i = 0; i < strs.length; i++) {
    switch (strs[i].charAt(0)) {
    case '+':
        top--;
        nums[top-1] = nums[top - 1] + nums[top];
        break;
    case '-':
        top--;
        nums[top-1] = nums[top - 1] - nums[top];
        break;
    case '*':
        top--;
        nums[top-1] = nums[top - 1] * nums[top];
        break;
    default:
         
        nums[top] = Integer.parseInt(strs[i]);
        top++;
        break;
    }
    /*System.out.println(Arrays.toString(nums));*/
}
System.out.println(nums[0]);

}
}
