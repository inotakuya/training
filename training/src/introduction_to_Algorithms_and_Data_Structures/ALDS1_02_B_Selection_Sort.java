package introduction_to_Algorithms_and_Data_Structures;

/*
 * 選択ソート
選択ソートは、各計算ステップで１つの最小値を「選択」していく、直観的なアルゴリズムです。

1 selectionSort(A, N) // N個の要素を含む0-オリジンの配列A
2   for i が 0 から N-1 まで
3     minj = i
4     for j が i から N-1 まで
5       if A[j] < A[minj]
6         minj = j
7     A[i] と A[minj] を交換
数列Aを読み込み、選択ソートのアルゴリズムで昇順に並び替え出力するプログラムを作成してください。上の疑似コードに従いアルゴリズムを実装してください。

疑似コード 7 行目で、i と minj が異なり実際に交換が行われた回数も出力してください。

入力
入力の最初の行に、数列の長さを表す整数 N が与えられます。２行目に、N 個の整数が空白区切りで与えられます。

出力
出力は 2 行からなります。１行目に整列された数列を 1 行に出力してください。数列の連続する要素は１つの空白で区切って出力してください。
2 行目に交換回数を出力してください。

制約
1 ≤ N ≤ 100
0 ≤ A の要素 ≤ 100
入力例 1
6
5 6 4 2 1 3
出力例 1
1 2 3 4 5 6
4

入力例 2
6
5 2 4 6 1 3
出力例 2
1 2 3 4 5 6
3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ALDS1_02_B_Selection_Sort {
    public static void main(String[] args) throws NumberFormatException,
    IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(
        System.in));
int n = Integer.parseInt(reader.readLine());
String[] s = reader.readLine().split(" ");
int[] a = new int[n];
for (int i = 0; i < n; i++) {
    a[i] = Integer.parseInt(s[i]);
}
int sum = 0;

for (int i = 0; i < n; i++) {
    int minj = i;
    for (int j = i + 1; j < n; j++) {
        if (a[j] < a[minj]) {
            minj = j;
        }

    }
    if (i != minj) {
        int tmp = a[i];
        a[i] = a[minj];
        a[minj] = tmp;
        sum++;
    }
}

StringBuilder builder = new StringBuilder();
for (int k = 0; k < n; k++) {
    if (k > 0)
        builder.append(" ");
    builder.append(a[k]);
}
builder.append("\n").append(sum);
System.out.println(builder);

}
}
